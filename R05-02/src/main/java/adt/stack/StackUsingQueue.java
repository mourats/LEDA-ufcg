package adt.stack;

import adt.queue.Queue;
import adt.queue.QueueImpl;
import adt.queue.QueueOverflowException;
import adt.queue.QueueUnderflowException;

public class StackUsingQueue<T> implements Stack<T> {

	private Queue<T> queue1;
	private Queue<T> queue2;

	public StackUsingQueue(int size) {
		this.queue1 = new QueueImpl<T>(size);
		this.queue2 = new QueueImpl<T>(size);
	}

	@Override
	public void push(T element) throws StackOverflowException {

		if (this.isFull())
			throw new StackOverflowException();

		try {
			while (!this.queue1.isEmpty()) 	
				this.queue2.enqueue(queue1.dequeue());

			this.queue1.enqueue(element);
			
			while (!this.queue2.isEmpty()) 
				this.queue1.enqueue(queue2.dequeue());	
			
		} catch (QueueOverflowException | QueueUnderflowException e) {
			e.printStackTrace();
		}

	}

	@Override
	public T pop() throws StackUnderflowException {

		if (this.isEmpty())
			throw new StackUnderflowException();

		T result = null;

		try {
			result = queue1.dequeue();
		} catch (QueueUnderflowException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public T top() {

		if (this.isEmpty())
			return null;

		return queue1.head();

	}

	@Override
	public boolean isEmpty() {
		return this.queue1.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.queue1.isFull();
	}

}
