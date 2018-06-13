package adt.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class StudentStackTest {

	public Stack<Integer> stack1;
	public Stack<Integer> stack2;
	public Stack<Integer> stack3;

	@Before
	public void setUp() throws StackOverflowException {

		getImplementations();

		stack1.push(1);
		stack1.push(2);
		stack1.push(3);

		stack2.push(1);
		stack2.push(2);

	}

	private void getImplementations() {

		stack1 = new StackUsingQueue<Integer>(5);
		stack2 = new StackUsingQueue<Integer>(5);
		stack3 = new StackUsingQueue<Integer>(5);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testTop() {
		assertEquals(new Integer(3), stack1.top());
		assertEquals(new Integer(2), stack2.top());
	}

	@Test
	public void testIsEmpty() throws StackUnderflowException {
		assertFalse(stack1.isEmpty());
		assertTrue(stack3.isEmpty());

		stack2.pop();
		stack2.pop();
		assertTrue(stack2.isEmpty());

	}

	@Test
	public void testIsFull() throws StackOverflowException {
		assertFalse(stack1.isFull());
		stack1.push(4);
		stack1.push(5);
		assertTrue(stack1.isFull());
	}

	@Test
	public void testPush() throws StackOverflowException {

		stack1.push(new Integer(5));
		assertEquals(new Integer(5), stack1.top());

		stack2.push(new Integer(10));
		assertEquals(new Integer(10), stack2.top());

		stack3.push(new Integer(15));
		assertEquals(new Integer(15), stack3.top());

	}

	@Test(expected = StackOverflowException.class)
	public void testPushComErro() throws StackOverflowException {
		stack1.push(new Integer(5));
		stack1.push(new Integer(5));
		
		// Erro aqui!
		stack1.push(new Integer(5));
	}

	@Test
	public void testPop() throws StackUnderflowException {

		assertEquals(new Integer(3), stack1.pop());
		assertEquals(new Integer(2), stack1.pop());

		assertEquals(new Integer(2), stack2.pop());

	}

	@Test(expected = StackUnderflowException.class)
	public void testPopComErro() throws StackUnderflowException {

		assertEquals(new Integer(3), stack1.pop());
		assertEquals(new Integer(2), stack1.pop());
		assertEquals(new Integer(1), stack1.pop());
		
		// Erro aqui!
		assertEquals("irineu", stack1.pop());
	}
}