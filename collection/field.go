package collection

import "errors"
import "encoding/binary"

// Enums

type Navigation bool

const (
	Left  Navigation = false
	Right Navigation = true
)

// Interfaces

type Field interface {
	Encode(interface{}) []byte
	Decode([]byte) (interface{}, error)
	Placeholder() []byte
	Parent([]byte, []byte) ([]byte, error)
	Navigate([]byte, []byte, []byte, []byte) (Navigation, error)
}

// Structs

// Data

type Data struct {
}

// Interface

func (d Data) Encode(generic interface{}) []byte {
	value := generic.([]byte)
	return value
}

func (d Data) Decode(raw []byte) (interface{}, error) {
	return raw, nil
}

func (d Data) Placeholder() []byte {
	return []byte{}
}

func (d Data) Parent(left []byte, right []byte) ([]byte, error) {
	return []byte{}, nil
}

func (d Data) Navigate(query []byte, parent []byte, left []byte, right []byte) (Navigation, error) {
	return false, errors.New("data values cannot be navigated")
}

// Stake64

type Stake64 struct {
}

// Interface

func (s Stake64) Encode(generic interface{}) []byte {
	value := generic.(uint64)
	raw := make([]byte, 8)

	binary.BigEndian.PutUint64(raw, value)
	return raw
}

func (s Stake64) Decode(raw []byte) (interface{}, error) {
	if len(raw) != 8 {
		return 0, errors.New("wrong buffer length")
	}
	return binary.BigEndian.Uint64(raw), nil
}

func (s Stake64) Placeholder() []byte {
	return s.Encode(uint64(0))
}

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
