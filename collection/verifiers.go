package collection

// Methods (collection) (verifiers)

func (c *Collection) Verify(proof Proof) bool {
	if c.root.transaction.inconsistent {
		panic("Verify() called on inconsistent root.")
	}

	if (proof.root.Label != c.root.label) || !(proof.consistent()) {
		return false
	}

	if !(c.root.known) {
		proof.root.to(c.root)
	}

	path := sha256(proof.key)
	cursor := c.root

	for depth := 0; depth < len(proof.steps); depth++ {
		if !(cursor.children.left.known) {
			proof.steps[depth].Left.to(cursor.children.left)
		}

		if !(cursor.children.right.known) {
			proof.steps[depth].Right.to(cursor.children.right)
		}

		if bit(path[:], depth) {
			cursor = cursor.children.right
		} else {
			cursor = cursor.children.left
		}
	}

	return true
}
