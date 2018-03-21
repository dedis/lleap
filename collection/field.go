package collection

import "errors"
import "encoding/binary"

// Enums

// Navigation is a boolean representing whether a Navigator
// should go to the right or to the left while going down a tree.
type Navigation bool

const (
	// Left is a constant representing the case where the Navigator should go to the left child.
	Left  Navigation = false
	// Right is a constant representing the case where the Navigator should go to the right child.
	Right Navigation = true
)

// Field describes a type.
// It describes how the type is encoded, how it is decoded,
// how it propagates up the tree and other needed functionality.
type Field interface {
	Encode(interface{}) []byte
	Decode([]byte) (interface{}, error)
	Placeholder() []byte
	Parent([]byte, []byte) ([]byte, error)
	Navigate([]byte, []byte, []byte, []byte) (Navigation, error)
}

// Structs

// Data

// Data is the generic type of Field.
// It can contain any interface convertible to bytes, for example string or []uint8.
type Data struct {
}

// Encode returns the basic conversion into a byte array of the parameter.
func (d Data) Encode(generic interface{}) []byte {
	value := generic.([]byte)
	return value
}

// Decode returns the bytes without modifying them.
// It can never returns an error
func (d Data) Decode(raw []byte) (interface{}, error) {
	return raw, nil
}

// Placeholder defines the placeholder value as an empty array of byte.
func (d Data) Placeholder() []byte {
	return []byte{}
}

// Parent returns an empty array of byte.
// Indeed with this generic type, the tree doesn't need a propagation up the tree.
func (d Data) Parent(left []byte, right []byte) ([]byte, error) {
	return []byte{}, nil
}

// Navigate will return an error as the Data values cannot be navigated
func (d Data) Navigate(query []byte, parent []byte, left []byte, right []byte) (Navigation, error) {
	return false, errors.New("data values cannot be navigated")
}

// Stake64 represents stakes.
// Each stake is stored in a final leaf and the intermediary nodes contain the sum of its children.
// This structure allows an easy random selection of a stake from the root proportionally to the stake size.
type Stake64 struct {
}

// Encode returns array of bytes representation of the the uint64 value of the stake, in big endian.
func (s Stake64) Encode(generic interface{}) []byte {
	value := generic.(uint64)
	raw := make([]byte, 8)

	binary.BigEndian.PutUint64(raw, value)
	return raw
}

// Decode is the inverse of Encode. It returns the uint64 value of the encoded bytes.
// It may return an error if the parameter raw has a number of bytes different from four.
func (s Stake64) Decode(raw []byte) (interface{}, error) {
	if len(raw) != 8 {
		return 0, errors.New("wrong buffer length")
	}
	return binary.BigEndian.Uint64(raw), nil
}

// Placeholder returns the placeholder value for stakes.
// It is represented by the number 0 encoded into bytes, which represents an empty stake.
func (s Stake64) Placeholder() []byte {
	return s.Encode(uint64(0))
}

// Parent returns the value each non-leaf node should hold.
// The returned value is the sum of stakes of its children or an error if a decoding error occurred.
func (s Stake64) Parent(left []byte, right []byte) ([]byte, error) {
	leftvalue, lefterror := s.Decode(left)

	if lefterror != nil {
		return []byte{}, lefterror
	}

	rightvalue, righterror := s.Decode(right)

	if righterror != nil {
		return []byte{}, righterror
	}

	return s.Encode(leftvalue.(uint64) + rightvalue.(uint64)), nil
}

// Navigate returns a navigation boolean indicating the direction a Navigator should go to with a given query.
// The first parameter is the query, representing a unsigned integer between 0 and the value of the parent parameter.
// the function will see if the query value is greater or equal than the left value and return a left navigation boolean if so
// and a right navigation boolean otherwise.
// This behavior allows to find a stake randomly and proportionally to the stake value of each leaf.
// To do this, one must select a random stake between 0 and the value of the root and input it repeatedly to the function to navigate down the tree.
func (s Stake64) Navigate(query []byte, parent []byte, left []byte, right []byte) (Navigation, error) {
	queryvalue, queryerror := s.Decode(query)

	if queryerror != nil {
		return false, queryerror
	}

	parentvalue, parenterror := s.Decode(parent)

	if parenterror != nil {
		return false, parenterror
	}

	if queryvalue.(uint64) >= parentvalue.(uint64) {
		return false, errors.New("query exceeds parent stake")
	}

	leftvalue, lefterror := s.Decode(left)

	if lefterror != nil {
		return false, lefterror
	}

	if queryvalue.(uint64) >= leftvalue.(uint64) {
		copy(query, s.Encode(queryvalue.(uint64)-leftvalue.(uint64)))
		return Right, nil
	}
	return Left, nil
}
