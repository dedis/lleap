package collection

import "errors"

type Record struct {
	collection *Collection

	field int
	query []byte
	match bool

	key    []byte
	values [][]byte
}

// Constructors

func recordkeymatch(collection *Collection, node *node) Record {
	return Record{collection, 0, []byte{}, true, node.key, node.values}
}

func recordquerymatch(collection *Collection, field int, query []byte, node *node) Record {
	return Record{collection, field, query, true, node.key, node.values}
}

func recordkeymismatch(collection *Collection, key []byte) Record {
	return Record{collection, 0, []byte{}, false, key, [][]byte{}}
}

// Getters

func (r Record) Query() (interface{}, error) {
	if len(r.query) == 0 {
		return nil, errors.New("no query specified")
	}

	if len(r.values) <= r.field {
		return nil, errors.New("field out of range")
	}

	value, err := r.collection.fields[r.field].Decode(r.query)

	if err != nil {
		return nil, err
	}

	return value, nil
}

func (r Record) Match() bool {
	return r.match
}

func (r Record) Key() []byte {
	return r.key
}

func (r Record) Values() ([]interface{}, error) {
	if !(r.match) {
		return []interface{}{}, errors.New("no match found")
	}

	if len(r.values) != len(r.collection.fields) {
		return []interface{}{}, errors.New("wrong number of values")
	}

	var values []interface{}

	for index := 0; index < len(r.values); index++ {
		value, err := r.collection.fields[index].Decode(r.values[index])

		if err != nil {
			return []interface{}{}, err
		}

		values = append(values, value)
	}

	return values, nil
}
