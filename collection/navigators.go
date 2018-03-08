package collection

import "errors"

type navigator struct {
	collection *Collection
	field      int
	query      []byte
}

// Constructors

func (c *Collection) Navigate(field int, value interface{}) navigator {
	if (field < 0) || (field >= len(c.fields)) {
		panic("Field unknown.")
	}

	return navigator{c, field, c.fields[field].Encode(value)}
}

// Methods

func (n navigator) Record() (Record, error) {
	cursor := n.collection.root

	for {
		if !(cursor.known) {
			return Record{}, errors.New("record lies in an unknown subtree")
		}

		if cursor.leaf() {
			return recordquerymatch(n.collection, n.field, n.query, cursor), nil
		}
		if !(cursor.children.left.known) || !(cursor.children.right.known) {
			return Record{}, errors.New("record lies in an unknown subtree")
		}

		navigation, err := n.collection.fields[n.field].Navigate(n.query, cursor.values[n.field], cursor.children.left.values[n.field], cursor.children.right.values[n.field])
		if err != nil {
			return Record{}, err
		}

		if navigation == Right {
			cursor = cursor.children.right
		} else {
			cursor = cursor.children.left
		}
	}
}
