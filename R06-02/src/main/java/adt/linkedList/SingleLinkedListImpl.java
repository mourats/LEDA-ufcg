package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> aux = this.head;

		while (!aux.isNIL()) {
			size++;
			aux = aux.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		T node = null;
		SingleLinkedListNode<T> aux = this.head;

		while (!aux.isNIL()) {
			if (aux.getData().equals(element))
				node = aux.getData();

			aux = aux.getNext();
		}
		return node;
	}

	@Override
	public void insert(T element) {

		if (element != null) {

			if (this.isEmpty()) {
				this.head.setData(element);
				this.head.setNext(new SingleLinkedListNode<T>());
			} else {
				SingleLinkedListNode<T> aux = this.head;

				while (!aux.isNIL()) {
					aux = aux.getNext();
				}
				aux.setData(element);
				aux.setNext(new SingleLinkedListNode<T>());
			}
		}
	}

	@Override
	public void remove(T element) {

		if (element != null && !this.isEmpty()) {

			SingleLinkedListNode<T> aux = this.head;

			boolean removed = false;
			while (!aux.isNIL() && !removed) {
				if (aux.getNext().getData().equals(element)) {
					aux.setNext(aux.getNext().getNext());
					removed = true;
				}
				aux = aux.getNext();
			}
		}
	}

	@Override
	public T[] toArray() {
		SingleLinkedListNode<T> aux = this.head;

		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Comparable[this.size()];

		int i = 0;
		if (!this.isEmpty()) {
			while (!aux.isNIL()) {
				result[i] = aux.getData();
				aux = aux.getNext();
				i++;
			}
		}
		return result;

	}

	public int indexOf(T element) {
		if (element != null) {

			SingleLinkedListNode<T> aux = this.head;
			int cont = 0;

			while (!aux.isNIL() && !aux.getData().equals(element)) {
				aux = aux.next;
				cont++;
			}

			if (aux.isNIL())
				return -1;

			return cont;
		}
		return -1;
	}

	public int lastIndexOf(T element) {
		if (element != null) {

			SingleLinkedListNode<T> aux = this.head;
			int cont = 0;
			int pos = -1;

			while (!aux.isNIL()) {
				if (aux.getData().equals(element))
					pos = cont;

				aux = aux.next;
				cont++;
			}

			return pos;
		}
		return -1;

	}

	@Override
	public void removeIndex(int index) {

		if (index < this.size() && !this.isEmpty()) {

			if (index == 0) {
				head = head.next;
			} else {

				SingleLinkedListNode<T> aux = this.head.next;
				SingleLinkedListNode<T> auxBack = this.head;

				index--;
				while (!aux.isNIL() && index > 0) {
					auxBack = aux;
					aux = aux.getNext();
					index--;
				}
				
				if(index == 0)
					auxBack.next = aux.next;
			}
		}

	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
