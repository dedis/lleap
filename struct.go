package sicpa

/*
This holds the messages used to communicate with the service over the network.
*/

import (
	"github.com/dedis/cothority/skipchain"
	"github.com/dedis/onet"
	"github.com/dedis/onet/network"
)

// We need to register all messages so the network knows how to handle them.
func init() {
	network.RegisterMessages(
		&CreateSkipchain{}, &CreateSkipchainResponse{},
		&AddKeyValue{}, &AddKeyValueResponse{},
		&GetValue{}, &GetValueResponse{},
	)
}

const (
	// ErrorParse indicates an error while parsing the protobuf-file.
	ErrorParse = iota + 4000
)

// Version indicates what version this client runs. In the first development
// phase, each next version will break the preceeding versions. Later on,
// new versions might correctly interpret earlier versions.
type Version int

// CreateSkipchain asks the cisc-service to set up a new skipchain.
type CreateSkipchain struct {
	// Version of the protocol
	Version Version
	// Roster defines which nodes participate in the skipchain.
	Roster *onet.Roster
	// Writers represent keys that are allowed to add new key/value pairs to the skipchain.
	Writers *[][]byte
	// Signature, if available, will have to include the nonce sent by cisc.
	Signature []byte
}

// CreateSkipcainResponse holds the genesis-block of the new skipchain.
type CreateSkipchainResponse struct {
	// Version of the protocol
	Version Version
	// Skipblock of the created skipchain or empty if there was an error.
	Skipblock *skipchain.SkipBlock
}

// AddKeyValue asks for inclusion for a new key/value pair. The value needs
// to be signed by one of the Writers from the createSkipchain call.
type AddKeyValue struct {
	// Version of the protocol
	Version Version
	// SkipchainID is the hash of the first skipblock
	SkipchainID skipchain.SkipBlockID
	// Key where the value is stored
	Key []byte
	// Value, if Writers were present in CreateSkipchain, the value should be
	// signed by one of the keys.
	Value []byte
}

// AddKeyValueReturn gives the timestamp and the skipblock-id
type AddKeyValueResponse struct {
	// Version of the protocol
	Version Version
	// Timestamp is milliseconds since the unix epoch (1/1/1970, 12am UTC)
	Timestamp *int64
	// Skipblock ID is the hash of the block where the value is stored
	SkipblockID *skipchain.SkipBlockID
}

// GetValue looks up the value in the given skipchain and returns the
// stored value, or an error if either the skipchain or the key doesn't exist.
type GetValue struct {
	// Version of the protocol
	Version Version
	// SkipchainID represents the skipchain where the value is stored
	SkipchainID skipchain.SkipBlockID
	// Key to retrieve
	Key []byte
}

// GetValueResponse returns the value or an error if the key hasn't been found.
type GetValueResponse struct {
	//Version of the protocol
	Version Version
	// Value of the key
	Value *[]byte
}
