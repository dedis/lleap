package collection

import "testing"
import csha256 "crypto/sha256"

// testctxstruct

type testctxstruct struct {
	file string
	test *testing.T

	verify testctxverifier
}

// Constructors

func testctx(file string, test *testing.T) testctxstruct {
	return testctxstruct{file, test, testctxverifier{file, test}}
}

// Methods

func (t testctxstruct) shouldPanic(prefix string, function func()) {
	defer func() {
		if recover() == nil {
			t.test.Error(t.file, prefix, "function provided did not panic")
		}
	}()

	function()
}

// testctxverifier

type testctxverifier struct {
	file string
	test *testing.T
}

// Methods

func (t testctxverifier) node(prefix string, collection *Collection, node *node) {
	if !(node.known) {
		return
	}

	if node.leaf() {
		if (node.children.left != nil) || (node.children.right != nil) {
			t.test.Error(t.file, prefix, "leaf node has one or more children")
			return
		}

		if node.label != sha256(true, node.key, node.values) {
			t.test.Error(t.file, prefix, "wrong leaf node label")
			return
		}
	} else {
		if (node.children.left == nil) || (node.children.right == nil) {
			t.test.Error(t.file, prefix, "internal node is missing one or more children")
			return
		}

		if (node.children.left.parent != node) || (node.children.right.parent != node) {
			t.test.Error(t.file, prefix, "children of internal node don't have its parent correctly set")
			return
		}

		if node.label != sha256(false, node.values, node.children.left.label[:], node.children.right.label[:]) {
			t.test.Error(t.file, prefix, "wrong internal node label")
			return
		}

		if node.children.left.known && node.children.right.known {
			for index := 0; index < len(collection.fields); index++ {
				parentvalue, parenterror := collection.fields[index].Parent(node.children.left.values[index], node.children.right.values[index])

				if parenterror != nil {
					t.test.Error(t.file, prefix, "malformed children values")
				}

				if !equal(parentvalue, node.values[index]) {
					t.test.Error(t.file, prefix, "one or more internal node values conflict with the corresponding children values")
					return
				}
			}
		}
	}
}

func (t testctxverifier) treerecursion(prefix string, collection *Collection, node *node, path []bool) {
	t.node(prefix, collection, node)

	if node.leaf() {
		if !(node.placeholder()) {
			for index := 0; index < len(path); index++ {
				keyhash := sha256(node.key)
				if path[index] != bit(keyhash[:], index) {
					t.test.Error(t.file, prefix, "leaf node on wrong path")
				}
			}
		}
	} else {
		leftpath := make([]bool, len(path))
		rightpath := make([]bool, len(path))

		copy(leftpath, path)
		copy(rightpath, path)

		leftpath = append(leftpath, false)
		rightpath = append(rightpath, true)

		t.treerecursion(prefix, collection, node.children.left, leftpath)
		t.treerecursion(prefix, collection, node.children.right, rightpath)
	}
}

func (t testctxverifier) tree(prefix string, collection *Collection) {
	t.treerecursion(prefix, collection, collection.root, []bool{})
}

func (t testctxverifier) scoperecursion(prefix string, collection *Collection, node *node, path []bool) {
	if !(node.known) {
		return
	}

	var pathbuf [csha256.Size]byte

	for index := 0; index < len(path); index++ {
		setbit(pathbuf[:], index, path[index])
	}

	if node.known && len(path) > 1 && !(collection.scope.match(pathbuf, len(path)-2)) {
		t.test.Error(t.file, prefix, "out-of-scope node was not pruned from tree")
	} else {
		if !(node.leaf()) {
			leftpath := make([]bool, len(path))
			rightpath := make([]bool, len(path))

			copy(leftpath, path)
			copy(rightpath, path)

			leftpath = append(leftpath, false)
			rightpath = append(rightpath, true)

			t.scoperecursion(prefix, collection, node.children.left, leftpath)
			t.scoperecursion(prefix, collection, node.children.right, rightpath)
		}
	}
}

func (t testctxverifier) scope(prefix string, collection *Collection) {
	var pathbuf [csha256.Size]byte
	none := true

	setbit(pathbuf[:], 0, false)
	if collection.scope.match(pathbuf, 0) {
		none = false
	}

	setbit(pathbuf[:], 0, true)
	if collection.scope.match(pathbuf, 0) {
		none = false
	}

	if none {
		if collection.root.known {
			t.test.Error(t.file, prefix, "none-scope collection has known root")
		}
	} else {
		if collection.root.known {
			t.scoperecursion(prefix, collection, collection.root.children.left, []bool{false})
			t.scoperecursion(prefix, collection, collection.root.children.right, []bool{true})
		}
	}
}

func (t testctxverifier) keyrecursion(key []byte, node *node) *node {
	if node.leaf() {
		if equal(node.key, key) {
			return node
		}
		return nil
	}
	left := t.keyrecursion(key, node.children.left)
	right := t.keyrecursion(key, node.children.right)

	if left != nil {
		return left
	}
	return right
}

func (t testctxverifier) key(prefix string, collection *Collection, key []byte) {
	if t.keyrecursion(key, collection.root) == nil {
		t.test.Error(t.file, prefix, "node not found")
	}
}

func (t testctxverifier) nokey(prefix string, collection *Collection, key []byte) {
	if t.keyrecursion(key, collection.root) != nil {
		t.test.Error(t.file, prefix, "unexpected node found")
	}
}

func (t testctxverifier) values(prefix string, collection *Collection, key []byte, values ...interface{}) {
	node := t.keyrecursion(key, collection.root)

	if node == nil {
		t.test.Error(t.file, prefix, "node not found")
	}

	for index := 0; index < len(collection.fields); index++ {
		rawvalue := collection.fields[index].Encode(values[index])
		if !(equal(rawvalue, node.values[index])) {
			t.test.Error(t.file, prefix, "wrong values")
		}
	}
}
