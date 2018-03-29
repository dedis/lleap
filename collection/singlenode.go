package collection

import (
	"errors"
	"crypto/sha256"
	"github.com/dedis/protobuf"
)

type toHash struct{
	IsLeaf bool
	Key []byte
	Values [][]byte

	LeftLabel [sha256.Size]byte
	RightLabel [sha256.Size]byte
}

// Private methods (collection) (single node operations)

func (c *Collection) placeholder(node *node) {
	node.known = true
	node.key = []byte{}
	node.values = make([][]byte, len(c.fields))

	for index := 0; index < len(c.fields); index++ {
		node.values[index] = c.fields[index].Placeholder()
	}

	node.children.left = nil
	node.children.right = nil

	err := c.update(node)
	if err != nil {
		//TODO: forward error
	}
}

func (c *Collection) update(node *node) error {
	if !(node.known) {
		return errors.New("updating an unknown node")
	}

	if !node.leaf() {
		if !(node.children.left.known) || !(node.children.right.known) {
			return errors.New("updating internal node with unknown children")
		}

		node.values = make([][]byte, len(c.fields))

		for index := 0; index < len(c.fields); index++ {
			parentValue, parentError := c.fields[index].Parent(node.children.left.values[index], node.children.right.values[index])

			if parentError != nil {
				return parentError
			}

			node.values[index] = parentValue
		}
	}

	label, err := node.generateHash()
	if err != nil {
		return err
	}
	node.label = label

	return nil
}

func (n *node) generateHash() ([sha256.Size]byte, error) {

	var toEncode toHash
	if n.leaf() {
		toEncode = toHash{false, n.key, n.values, [sha256.Size]byte{}, [sha256.Size]byte{}}
	} else {
		toEncode = toHash{true, []byte{}, n.values, n.children.left.label, n.children.right.label}
	}

	return toEncode.hash()
}

func (data *toHash) hash() ([sha256.Size]byte, error) {
	buff, err := protobuf.Encode(data)
	if err != nil {
		return [sha256.Size]byte{}, err
	}

	return sha256.Sum256(buff), nil
}