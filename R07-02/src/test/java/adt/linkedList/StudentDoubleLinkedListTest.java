package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentDoubleLinkedListTest extends StudentLinkedListTest {

	private DoubleLinkedList<Integer> lista3;

	@Before
	public void setUp() throws Exception {

		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

		// Lista com 1 elemento.
		lista3.insert(1);
	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		lista1 = new RecursiveDoubleLinkedListImpl<Integer>();
		lista2 = new RecursiveDoubleLinkedListImpl<Integer>();
		lista3 = new RecursiveDoubleLinkedListImpl<Integer>();
	}

	// Métodos de DoubleLinkedList

	@Test
	public void testInsertFirst() {
		((DoubleLinkedList<Integer>) lista1).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4, 3, 2, 1 }, lista1.toArray());
	}

	@Test
	public void testRemoveFirst() {
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 2, 1 }, lista1.toArray());
	}

	@Test
	public void testRemoveLast() {
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { 3, 2 }, lista1.toArray());
	}

	@Test
	public void testGeral() {
		((DoubleLinkedList<Integer>) lista1).insertFirst(10);
		Assert.assertEquals(4, lista1.size());

		lista1.insert(12);
		Assert.assertArrayEquals(new Integer[] { 10, 3, 2, 1, 12 }, lista1.toArray());
		Assert.assertEquals(5, lista1.size());

		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { 10, 3, 2, 1 }, lista1.toArray());
		Assert.assertEquals(4, lista1.size());
		
		lista1.remove(10);
		Assert.assertArrayEquals(new Integer[] { 3, 2, 1 }, lista1.toArray());
		Assert.assertEquals(3, lista1.size());
		
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 2, 1 }, lista1.toArray());
		Assert.assertEquals(2, lista1.size());
		
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 1 }, lista1.toArray());
		Assert.assertEquals(1, lista1.size());
		
		
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { }, lista1.toArray());
		Assert.assertEquals(0, lista1.size());
		
		((DoubleLinkedList<Integer>) lista1).removeLast();
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		lista1.remove(1);
		
		((DoubleLinkedList<Integer>) lista1).insertFirst(10);
		Assert.assertEquals(1, lista1.size());

	}
}