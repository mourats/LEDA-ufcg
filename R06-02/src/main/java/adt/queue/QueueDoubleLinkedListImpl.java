package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (this.isFull())
			throw new QueueOverflowException();
		else {
			list.insert(element);
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T element;
		if (this.isEmpty())
			throw new QueueUnderflowException();
		else {
			element = list.toArray()[0];
			list.removeFirst();
		}
		return element;
	}

	@Override
	public T head() {
		T valor;
		if (this.isEmpty())
			valor = null;
		else {
			valor = list.toArray()[0];
		}
		return valor;
	
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean isFull() {
		return list.size() == this.size;
	}

}
