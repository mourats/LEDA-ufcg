package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	public RecursiveDoubleLinkedListImpl(T data, RecursiveSingleLinkedListImpl<T> next,
			RecursiveDoubleLinkedListImpl<T> previous) {
		super(data, next);
		this.previous = previous;
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			if (isEmpty()) {
				this.insert(element);
			} else {
				RecursiveDoubleLinkedListImpl<T> newNode = new RecursiveDoubleLinkedListImpl<T>(getData(), getNext(),
						this);
				((RecursiveDoubleLinkedListImpl<T>) getNext()).setPrevious(newNode);
				setNext(newNode);
				setData(element);
			}
		}
	}

	@Override
	public void removeFirst() {

		if (!isEmpty()) {
			if (getPrevious().isEmpty()) {

				setData(getNext().getData());
				setNext(getNext().getNext());
				if (getNext() != null)
					((RecursiveDoubleLinkedListImpl<T>) getNext()).setPrevious(this);

			} else
				getPrevious().removeFirst();
		}
	}

	@Override
	public void removeLast() {
		if (!isEmpty()) {
			if (getNext().isEmpty()) {

				setData(null);
				setNext(null);
				if (getPrevious().isEmpty())
					setPrevious(null);

			} else
				((RecursiveDoubleLinkedListImpl<T>) getNext()).removeLast();
		}
	}

	@Override
	public void insert(T element) {

		if (element != null) {
			if (isEmpty()) {
				setData(element);
				setNext(new RecursiveDoubleLinkedListImpl<T>(null, null, this));
				if (getPrevious() == null)
					setPrevious(new RecursiveDoubleLinkedListImpl<T>(null, this, null));
			} else {
				next.insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			if (!isEmpty()) {
				if (getData().equals(element)) {
					if (getPrevious().isEmpty() && getNext().isEmpty()) {
						setData(null);
						setNext(null);
						setPrevious(null);
					} else {
						setData(next.getData());
						setNext(next.next);
						if (getNext() != null)
							((RecursiveDoubleLinkedListImpl<T>) getNext()).setPrevious(this);
					}
				} else
					next.remove(element);
			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
