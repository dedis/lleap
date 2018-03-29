package collection

import (
	"errors"
	"crypto/sha256"
)

// Same is used as a placeholder for the individual values that don't need to be updated
// when a modification of the values is requested.
// All the values set to Same will stay the same, for example in a Set.
type Same struct {
}

// Add adds a given key/value pair to the collection.
// The key must not currently exist in the tree, otherwise, an error is thrown.
// Use set to modify an already existing key/value pair.
// The key location must also be in the known tree, otherwise an error is thrown.
func (c *Collection) Add(key []byte, values ...interface{}) error {
	if len(values) != len(c.fields) {
		panic("wrong number of values provided")
	}

	rawValues := make([][]byte, len(c.fields))
	for index, field := range c.fields {
		rawValues[index] = field.Encode(values[index])
	}

	path := sha256.Sum256(key)

	depth := 0
	cursor := c.root

	if !(cursor.known) {
		return errors.New("applying update to unknown subtree. Proof needed")
	}

	for {
		if !(cursor.children.left.known) || !(cursor.children.right.known) {
			return errors.New("applying update to unknown subtree. Proof needed")
		}

		step := bit(path[:], depth)
		depth++

		if step == Right {
			cursor = cursor.children.right
		} else {
			cursor = cursor.children.left
		}

		if cursor.placeholder() {
			if c.transaction.ongoing {
				cursor.backup()
			}

			cursor.key = key
			cursor.values = rawValues
			c.update(cursor)

			break
		} else if cursor.leaf() {
			if equal(key, cursor.key) {
				return errors.New("key collision")
			}

			collision := *cursor
			collisionPath := sha256.Sum256(collision.key)
			collisionStep := bit(collisionPath[:], depth)

			if c.transaction.ongoing {
				cursor.backup()
			}

			cursor.key = []byte{}
			cursor.branch()

			if collisionStep {
				cursor.children.right.known = true
				cursor.children.right.label = collision.label
				cursor.children.right.key = collision.key
				cursor.children.right.values = collision.values

				c.placeholder(cursor.children.left)
			} else {
				cursor.children.left.known = true
				cursor.children.left.label = collision.label
				cursor.children.left.key = collision.key
				cursor.children.left.values = collision.values

				c.placeholder(cursor.children.right)
			}
		}
	}

	for {
		if cursor.parent == nil {
			break
		}

		cursor = cursor.parent

		if c.transaction.ongoing {
			cursor.transaction.inconsistent = true
		} else {
			c.update(cursor)
		}
	}

	if !(c.transaction.ongoing) {
		c.Collect()
	}

	return nil
}

// Set updates a given key with a new value.
// The key must already be present in the known collection, otherwise, an error is thrown.
func (c *Collection) Set(key []byte, values ...interface{}) error {
	if len(values) != len(c.fields) {
		panic("wrong number of values provided")
	}

	path := sha256.Sum256(key)

	depth := 0
	cursor := c.root

	if !(cursor.known) {
		return errors.New("applying update to unknown subtree. Proof needed")
	}

	for {
		if !(cursor.children.left.known) || !(cursor.children.right.known) {
			return errors.New("applying update to unknown subtree. Proof needed")
		}

		step := bit(path[:], depth)
		depth++

		if step {
			cursor = cursor.children.right
		} else {
			cursor = cursor.children.left
		}

		if cursor.leaf() {
			if !(equal(cursor.key, key)) {
				return errors.New("key not found")
			}
			if c.transaction.ongoing {
				cursor.backup()
			}

			for index := 0; index < len(c.fields); index++ {
				_, same := values[index].(Same)

				if !same {
					cursor.values[index] = c.fields[index].Encode(values[index])
				}
			}

			c.update(cursor)

			break
		}
	}

	for {
		if cursor.parent == nil {
			break
		}

		cursor = cursor.parent

		if c.transaction.ongoing {
			cursor.transaction.inconsistent = true
		} else {
			c.update(cursor)
		}
	}

	if !(c.transaction.ongoing) {
		c.Collect()
	}

	return nil
}

// SetField updates one of the the value associated with a key to a new value.
// It updates the field with the index given by the parameter field to a new value.
func (c *Collection) SetField(key []byte, field int, value interface{}) error {
	if field >= len(c.fields) {
		panic("field does not exist")
	}

	values := make([]interface{}, len(c.fields))
	for index := 0; index < len(c.fields); index++ {
		if index == field {
			values[index] = value
		} else {
			values[index] = Same{}
		}
	}

	return c.Set(key, values...)
}

// Remove removes a given key and its associated value from the collection.
// It then rebuilds the tree, to always have a tree with no placeholder,
// except if the collection contains no more data.
// Note that the removed key/pair value must be present in the known tree, otherwise an error is thrown.
func (c *Collection) Remove(key []byte) error {
	path := sha256.Sum256(key)

	depth := 0
	cursor := c.root

	if !(cursor.known) {
		return errors.New("applying update to unknown subtree. Proof needed")
	}

	for {
		if !(cursor.children.left.known) || !(cursor.children.right.known) {
			return errors.New("applying update to unknown subtree. Proof needed")
		}

		step := bit(path[:], depth)
		depth++

		if step {
			cursor = cursor.children.right
		} else {
			cursor = cursor.children.left
		}

		if cursor.leaf() {
			if !(equal(cursor.key, key)) {
				return errors.New("key not found")
			}
			if c.transaction.ongoing {
				cursor.backup()
			}

			c.placeholder(cursor)
			break
		}
	}

	for {
		if cursor.parent == nil {
			break
		}

		cursor = cursor.parent

		if (cursor.parent != nil) && ((cursor.children.left.placeholder() && cursor.children.right.leaf()) || (cursor.children.right.placeholder() && cursor.children.left.leaf())) {
			if c.transaction.ongoing {
				cursor.backup()
			}

			if cursor.children.left.placeholder() {
				cursor.label = cursor.children.right.label
				cursor.key = cursor.children.right.key
				cursor.values = cursor.children.right.values
			} else {
				cursor.label = cursor.children.left.label
				cursor.key = cursor.children.left.key
				cursor.values = cursor.children.left.values
			}

			cursor.prune()
		} else {
			if c.transaction.ongoing {
				cursor.transaction.inconsistent = true
			} else {
				c.update(cursor)
			}
		}
	}

	if !(c.transaction.ongoing) {
		c.Collect()
	}

	return nil
}
