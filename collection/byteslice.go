package collection

import "crypto/sha256"

// utility functions for slices of bytes

func equal(lho []byte, rho []byte) bool {
	if len(lho) != len(rho) {
		return false
	}

	for index := 0; index < len(lho); index++ {
		if lho[index] != rho[index] {
			return false
		}
	}

	return true
}

func bit(buffer []byte, index int) bool {
	byteidx := uint(index) / 8
	bitidx := 7 - (uint(index) % 8)

	return ((buffer[byteidx] & (uint8(1) << bitidx)) != 0)
}

func setbit(buffer []byte, index int, value bool) {
	byteidx := uint(index) / 8
	bitidx := 7 - (uint(index) % 8)

	if value {
		buffer[byteidx] |= (uint8(1) << bitidx)
	} else {
		buffer[byteidx] &^= (uint8(1) << bitidx)
	}
}

// identical up to some bits
func match(lho []byte, rho []byte, bits int) bool {
	for index := 0; index < bits; {
		if index < bits-8 {
			if lho[index/8] != rho[index/8] {
				return false
			}

			index += 8
		} else {
			if bit(lho, index) != bit(rho, index) {
				return false
			}

			index++
		}
	}

	return true
}

func digest(buffer []byte) [sha256.Size]byte {
	if len(buffer) != sha256.Size {
		panic("Wrong slice length.")
	}

	var digest [sha256.Size]byte

	for index := 0; index < sha256.Size; index++ {
		digest[index] = buffer[index]
	}

	return digest
}
