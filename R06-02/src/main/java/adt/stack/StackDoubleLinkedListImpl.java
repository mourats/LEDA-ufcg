package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {

		if (this.isFull())
			throw new StackOverflowException();
		else {
			top.insert(element);
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		T element;
		if (this.isEmpty()) {
			throw new StackUnderflowException();

		} else {
			element = top.toArray()[top.size() - 1];
			top.removeLast();
			return element;
		}
	}

	@Override
	public T top() {
		T valor;
		if (this.isEmpty())
			valor = null;
		else {
			valor = top.toArray()[top.size() - 1];
		}
		return valor;
	}

	@Override
	public boolean isEmpty() {
		return top.isEmpty();
	}

	@Override
	public boolean isFull() {
		return top.size() == this.size;
	}

}
