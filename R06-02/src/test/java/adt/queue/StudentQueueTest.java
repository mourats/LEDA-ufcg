package adt.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class StudentQueueTest {

	public Queue<Integer> queue1;
	public Queue<Integer> queue2;
	public Queue<Integer> queue3;
	public Queue<Integer> queue4;

	@Before
	public void setUp() throws QueueOverflowException {

		getImplementations();

		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);

		queue2.enqueue(1);
		queue2.enqueue(2);
	}

	private void getImplementations() {

		queue1 = new QueueDoubleLinkedListImpl<Integer>(5);
		queue2 = new QueueDoubleLinkedListImpl<Integer>(5);
		queue3 = new QueueDoubleLinkedListImpl<Integer>(5);
		queue4 = new QueueDoubleLinkedListImpl<Integer>(1);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testHead() {
		assertEquals(new Integer(1), queue1.head());
		assertEquals(new Integer(1), queue2.head());
		assertEquals(null, queue4.head());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(queue1.isEmpty());
		assertTrue(queue3.isEmpty());
	}

	@Test
	public void testIsFull() throws QueueOverflowException {
		assertFalse(queue1.isFull());
		assertFalse(queue2.isFull());
		assertFalse(queue3.isFull());
		assertFalse(queue4.isFull());

		queue1.enqueue(6);
		queue1.enqueue(7);
		assertTrue(queue1.isFull());
		
		queue4.enqueue(4);
		assertTrue(queue4.isFull());
	}

	@Test
	public void testEnqueue() throws QueueOverflowException {

		assertEquals(new Integer(1), queue2.head());

		queue3.enqueue(new Integer(15));
		assertEquals(new Integer(15), queue3.head());
		queue3.enqueue(new Integer(42));
		assertEquals(new Integer(15), queue3.head());

	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComErro() throws QueueOverflowException {
		queue1.enqueue(new Integer(5));
		queue1.enqueue(new Integer(4));

		// Exception aqui!
		queue1.enqueue(new Integer(12));

	}

	@Test
	public void testDequeue() throws QueueUnderflowException, QueueOverflowException {

		assertEquals(new Integer(1), queue1.dequeue());
		assertEquals(new Integer(1), queue2.dequeue());
		
		queue3.enqueue(7);
		
		assertEquals(new Integer(7), queue3.dequeue());
		

	}

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueComErro() throws QueueUnderflowException {
		assertEquals(new Integer(1), queue1.dequeue());
		assertEquals(new Integer(2), queue1.dequeue());
		assertEquals(new Integer(3), queue1.dequeue());
		
		//Exception aqui!
		assertEquals("irineu", queue1.dequeue());
	}
}