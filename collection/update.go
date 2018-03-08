package collection

import "errors"
import csha256 "crypto/sha256"

// Interfaces

type userupdate interface {
	Records() []Proof
	Check(ReadOnly) bool
	Apply(ReadWrite)
}

type ReadOnly interface {
	Get([]byte) Record
}

type ReadWrite interface {
	Get([]byte) Record
	Add([]byte, ...interface{}) error
	Set([]byte, ...interface{}) error
	SetField([]byte, int, interface{}) error
	Remove([]byte) error
}

// Structs

type Update struct {
	transaction uint64
	update      userupdate
	proxy       proxy
}

type proxy struct {
	collection *Collection
	paths      map[[csha256.Size]byte]bool
}

// proxy

// Constructors

func (c *Collection) proxy(keys [][]byte) (proxy proxy) {
	proxy.collection = c
	proxy.paths = make(map[[csha256.Size]byte]bool)

	for index := 0; index < len(keys); index++ {
		proxy.paths[sha256(keys[index])] = true
	}

	return
}

// Methods

func (p proxy) Get(key []byte) Record {
	if !(p.has(key)) {
		panic("accessing undeclared key from update")
	}

	record, _ := p.collection.Get(key).Record()
	return record
}

func (p proxy) Add(key []byte, values ...interface{}) error {
	if !(p.has(key)) {
		panic("accessing undeclared key from update")
	}

	return p.collection.Add(key, values...)
}

func (p proxy) Set(key []byte, values ...interface{}) error {
	if !(p.has(key)) {
		panic("accessing undeclared key from update")
	}

	return p.collection.Set(key, values...)
}

func (p proxy) SetField(key []byte, field int, value interface{}) error {
	if !(p.has(key)) {
		panic("accessing undeclared key from update")
	}

	return p.collection.SetField(key, field, value)
}

func (p proxy) Remove(key []byte) error {
	if !(p.has(key)) {
		panic("accessing undeclared key from update")
	}

	return p.collection.Remove(key)
}

// Private methods

func (p proxy) has(key []byte) bool {
	path := sha256(key)
	return p.paths[path]
}

// collection

// Methods (collection) (update)

func (c *Collection) Prepare(update userupdate) (Update, error) {
	if c.root.transaction.inconsistent {
		panic("prepare() called on inconsistent root")
	}

	proofs := update.Records()
	keys := make([][]byte, len(proofs))

	for index := 0; index < len(proofs); index++ {
		if !(c.Verify(proofs[index])) {
			return Update{}, errors.New("invalid update: proof invalid")
		}

		keys[index] = proofs[index].Key()
	}

	return Update{c.transaction.id, update, c.proxy(keys)}, nil
}

func (c *Collection) Apply(object interface{}) error {
	switch update := object.(type) {
	case Update:
		return c.applyupdate(update)
	case userupdate:
		return c.applyuserupdate(update)
	}

	panic("apply() only accepts Update objects or objects that implement the update interface")
}

// Private methods (collection) (update)

func (c *Collection) applyupdate(update Update) error {
	if update.transaction != c.transaction.id {
		panic("update was not prepared during the current transaction")
	}

	if !(update.update.Check(update.proxy)) {
		return errors.New("update check failed")
	}

	if c.transaction.ongoing {
		update.update.Apply(update.proxy)
	} else {
		c.Begin()
		update.update.Apply(update.proxy)
		c.End()
	}

	return nil
}

func (c *Collection) applyuserupdate(update userupdate) error {
	preparedupdate, err := c.Prepare(update)
	if err != nil {
		return err
	}

	return c.Apply(preparedupdate)
}
