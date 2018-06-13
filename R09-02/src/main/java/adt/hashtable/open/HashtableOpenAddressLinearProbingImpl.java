package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;
import adt.hashtable.hashfunction.HashFunctionOpenAddress;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size, HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {

		if (isFull())
			throw new HashtableOverflowException();

		if (element != null) {

			int cont = 0;
			boolean guard = true;
			int index = -1;

			while (guard && cont < capacity()) {
				index = ((HashFunctionOpenAddress<T>) this.hashFunction).hash(element, cont++);
				if (this.table[index] == null || this.table[index].equals(new DELETED())) {
					this.table[index] = element;
					this.elements++;
					guard = false;
				} else
					this.COLLISIONS++;
			}
		}
	}

	@Override
	public void remove(T element) {

		if (element != null) {

			int cont = 0;
			boolean guard = true;
			int index;

			while (guard && cont < capacity()) {
				index = ((HashFunctionOpenAddress<T>) this.hashFunction).hash(element, cont++);
				if (this.table[index] != null && this.table[index].equals(element)) {
					this.table[index] = new DELETED();
					this.elements--;
					guard = false;
				}
			}
		}
	}

	@Override
	public T search(T element) {
		if (element != null) {

			int cont = 0;
			boolean guard = true;
			int index;
			T result = null;

			while (guard && cont < capacity()) {
				index = ((HashFunctionOpenAddress<T>) this.hashFunction).hash(element, cont++);
				if (this.table[index] != null && this.table[index].equals(element)) {
					result = (T) this.table[index];
					guard = false;
				}
			}
			return result;
		}
		return null;
	}

	@Override
	public int indexOf(T element) {

		int cont = 0;
		boolean guard = true;
		int index;
		int result = -1;

		while (guard && cont < capacity()) {
			index = ((HashFunctionOpenAddress<T>) this.hashFunction).hash(element, cont++);
			if (this.table[index] != null && this.table[index].equals(element)) {
				result = index;
				guard = false;
			}
		}
		return result;
	}

}
