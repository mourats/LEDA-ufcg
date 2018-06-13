package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentLinkedListTest {

	protected LinkedList<Integer> lista1;
	protected LinkedList<Integer> lista2;

	@Before
	public void setUp() throws Exception {

		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

	}

	private void getImplementations() {

		lista1 = new SingleLinkedListImpl<Integer>();
		lista2 = new SingleLinkedListImpl<Integer>();
	}

	@Test
	public void testIsEmpty() {
		Assert.assertFalse(lista1.isEmpty());
		Assert.assertTrue(lista2.isEmpty());
	}

	@Test
	public void testSize() {
		Assert.assertEquals(3, lista1.size());
		Assert.assertEquals(0, lista2.size());
	}

	@Test
	public void testSearch() {
		Assert.assertTrue(2 == lista1.search(2));
		Assert.assertNull(lista1.search(4));
		Assert.assertFalse(3 == lista1.search(2));
	}

	@Test
	public void testInsert() {
		Assert.assertEquals(3, lista1.size());
		lista1.insert(5);
		lista1.insert(7);
		Assert.assertEquals(5, lista1.size());

		Assert.assertEquals(0, lista2.size());
		lista2.insert(4);
		lista2.insert(7);
		Assert.assertEquals(2, lista2.size());
	}

	@Test
	public void testIndexOf() {
		Assert.assertEquals(2, lista1.indexOf(1));
		lista1.insert(5);
		Assert.assertEquals(3, lista1.indexOf(5));
		lista1.insert(7);
		Assert.assertEquals(4, lista1.indexOf(7));
		Assert.assertEquals(0, lista1.indexOf(3));
		Assert.assertEquals(-1, lista1.indexOf(10));
	}

	@Test
	public void testLastIndexOf() {
		lista1.insert(3);
		Assert.assertEquals(3, lista1.lastIndexOf(3));
		lista1.insert(5);
		Assert.assertEquals(4, lista1.lastIndexOf(5));
		lista1.insert(2);
		Assert.assertEquals(5, lista1.lastIndexOf(2));
		Assert.assertEquals(-1, lista1.lastIndexOf(10));
	}

	@Test
	public void testRemove() {
		Assert.assertEquals(3, lista1.size());
		lista1.remove(2);
		lista1.remove(1);
		Assert.assertEquals(1, lista1.size());

	}

	@Test
	public void testRemoveIndex() {
		Assert.assertArrayEquals(new Integer[] { 3, 2, 1 }, lista1.toArray());
		lista1.removeIndex(0);
		Assert.assertArrayEquals(new Integer[] { 2, 1 }, lista1.toArray());
		lista1.removeIndex(1);
		Assert.assertArrayEquals(new Integer[] { 2 }, lista1.toArray());
		lista1.removeIndex(0);
		Assert.assertArrayEquals(new Integer[] {}, lista1.toArray());
		lista1.insert(10);
		lista1.insert(12);
		Assert.assertArrayEquals(new Integer[] { 10, 12 }, lista1.toArray());
		lista1.removeIndex(1);
		Assert.assertArrayEquals(new Integer[] { 10 }, lista1.toArray());

	}

	@Test
	public void testToArray() {
		Assert.assertArrayEquals(new Integer[] {}, lista2.toArray());
		Assert.assertArrayEquals(new Integer[] { 3, 2, 1 }, lista1.toArray());
	}
}