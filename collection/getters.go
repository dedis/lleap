package collection

import "errors"

type getter struct {
	collection *Collection
	key        []byte
}

// Constructors

func (c *Collection) Get(key []byte) getter {
	return getter{c, key}
}

// Methods

func (g getter) Record() (Record, error) {
	path := sha256(g.key)

	depth := 0
	cursor := g.collection.root

	for {
		if !(cursor.known) {
			return Record{}, errors.New("record lies in an unknown subtree")
		}

		if cursor.leaf() {
			if equal(cursor.key, g.key) {
				return recordkeymatch(g.collection, cursor), nil
			}
			return recordkeymismatch(g.collection, g.key), nil
		}
		if bit(path[:], depth) {
			cursor = cursor.children.right
		} else {
			cursor = cursor.children.left
		}

		depth++
	}
}

func (g getter) Proof() (Proof, error) {
	var proof Proof

	proof.collection = g.collection
	proof.key = g.key

	proof.root = dumpnode(g.collection.root)

	path := sha256(g.key)

	depth := 0
	cursor := g.collection.root

	if !(cursor.known) {
		return proof, errors.New("record lies in unknown subtree")
	}

	for {
		if !(cursor.children.left.known) || !(cursor.children.right.known) {
			return proof, errors.New("record lies in unknown subtree")
		}

		proof.steps = append(proof.steps, step{dumpnode(cursor.children.left), dumpnode(cursor.children.right)})

		if bit(path[:], depth) {
			cursor = cursor.children.right
		} else {
			cursor = cursor.children.left
		}

		depth++

		if cursor.leaf() {
			break
		}
	}

	return proof, nil
}
