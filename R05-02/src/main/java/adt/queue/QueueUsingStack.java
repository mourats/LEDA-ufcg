package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {

		if (this.isFull())
			throw new QueueOverflowException();

		try {
			this.stack1.push(element);
		} catch (StackOverflowException e) {
			e.printStackTrace();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {

		if (this.isEmpty())
			throw new QueueUnderflowException();

		T element = null;

		try {
			this.invertStacks();
			element = stack2.pop();
			this.invertStacks();

		} catch (StackUnderflowException | StackOverflowException e) {
			e.printStackTrace();
		}

		return element;
	}

	@Override
	public T head() {

		T element = null;

		try {
			this.invertStacks();
			element = stack2.top();
			this.invertStacks();

		} catch (StackOverflowException | StackUnderflowException e) {
			e.printStackTrace();
		}

		return element;

	}

	private void invertStacks() throws StackOverflowException, StackUnderflowException {

		if (this.stack2.isEmpty()) {
			while (!this.stack1.isEmpty()) {

				this.stack2.push(stack1.pop());
			}
		} else {

			while (!this.stack2.isEmpty()) {

				this.stack1.push(stack2.pop());
			}
		}
	}

	@Override
	public boolean isEmpty() {
		return this.stack1.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.stack1.isFull();
	}

}
