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
				setData(element);
				setPrevious(new RecursiveDoubleLinkedListImpl<T>(null, this, null));
				if (getNext() == null)
					setNext(new RecursiveDoubleLinkedListImpl<T>(null, null, this));
			} else {
				getPrevious().insertFirst(element);
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

	@Override
	public int size() {
		if (isEmpty())
			return 0;
		else
			return right() + left() - 1;
	}

	private int right() {
		if (isEmpty())
			return 0;
		else
			return 1 + ((RecursiveDoubleLinkedListImpl<T>) getNext()).right();
	}

	private int left() {
		if (isEmpty())
			return 0;
		else
			return 1 + getPrevious().left();
	}

	@Override
	public T[] toArray() {
		
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[this.size()];
		
		if(getPrevious() == null || getPrevious().isEmpty()) {
		
		toArrayRecursive(result, this, 0);
		return result;
		
		} else
			return getPrevious().toArray();
		
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
