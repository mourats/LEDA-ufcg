package adt.bt;

import org.junit.Before;
import org.junit.Test;

import adt.bt.BTNode;
import adt.bt.symetric.SymetricBTImpl;

public class SymetricBTTest {

	private SymetricBTImpl<Integer> tree;

	private void fillTree() {
		Integer[] array = { 3, 1, 0, 2, 3, 4 };
		for (int i : array) {
			tree.insert(i);
		}
	}

	@Before
	public void setUp() {
		tree = new SymetricBTImpl<Integer>();
	}
	
	@Test
	public void testIsSymetric() {

		fillTree(); 
		tree.printTree();
		System.out.println(tree.isSymetric());
	}
}
