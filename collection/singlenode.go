package collection

import "errors"

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

	c.update(node)
}

func (c *Collection) update(node *node) error {
	if !(node.known) {
		return errors.New("updating an unknown node")
	}

	if node.leaf() {
		node.label = sha256(true, node.key, node.values)
		return nil
	}

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

	node.label = sha256(false, node.values, node.children.left.label[:], node.children.right.label[:])

	return nil
}
