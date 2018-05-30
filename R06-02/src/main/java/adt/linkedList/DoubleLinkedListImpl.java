package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
        last = new DoubleLinkedListNode<T>();
        head = new DoubleLinkedListNode<T>();
    }

	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> newHeadNode = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<T>(), new DoubleLinkedListNode<T>());
		newHeadNode.next = head;
		((DoubleLinkedListNode<T>) head).previous = newHeadNode;

		if (head.isNIL()) {
			last = newHeadNode;
		}

		head = newHeadNode;

	}

	@Override
	public void removeFirst() {
		if (!head.isNIL()) {
			head = head.next;

			if (head.isNIL()) {
				last = (DoubleLinkedListNode<T>) head;
			}

			((DoubleLinkedListNode<T>) head).previous = new DoubleLinkedListNode<T>();
		}

	}
	@Override
	public void insert(T element) {
		if (element != null) {

			if (this.isEmpty()) {
				this.head.setData(element);
				this.head.setNext(new DoubleLinkedListNode<T>());
				this.last.setNext(new DoubleLinkedListNode<T>());
			} else {
				DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) this.head;

				while (!aux.getNext().isNIL()) {
					aux = (DoubleLinkedListNode<T>) aux.getNext();
				}
				
				((DoubleLinkedListNode<T>) aux.getNext()).setPrevious(aux);
				this.last = (DoubleLinkedListNode<T>) aux.getNext();
				aux.getNext().setData(element);
				aux.getNext().setNext(new DoubleLinkedListNode<T>());
			}
		}
	}

	@Override
	public void removeLast() {
		if (!last.isNIL()) {
			last = last.getPrevious();

			if (last.isNIL()) {
				head = last;
			}
			last.next = new DoubleLinkedListNode<T>();
		}

	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
