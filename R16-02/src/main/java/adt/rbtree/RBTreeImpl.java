package adt.rbtree;

import java.util.ArrayList;
import java.util.List;

import adt.bst.BSTImpl;
import adt.bt.Util;
import adt.rbtree.RBNode.Colour;

public class RBTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements RBTree<T> {

	public RBTreeImpl() {
		this.root = new RBNode<T>();
	}

	protected int blackHeight() {
		return blackHeightLeft((RBNode<T>) root);
	}

	private int blackHeightLeft(RBNode<T> node) {
		int result;
		if (node.isEmpty()) {
			result = 0;
		} else if (node.getColour().equals(Colour.RED)) {
			result = blackHeightLeft((RBNode<T>) node.getLeft());
		} else {
			result = 1 + blackHeightLeft((RBNode<T>) node.getLeft());
		}
		return result;
	}

	private int blackHeightRight(RBNode<T> node) {
		int result;
		if (node.isEmpty())
			result = 0;
		else if (node.getColour().equals(Colour.RED))
			result = blackHeightRight((RBNode<T>) node.getRight());
		else
			result = 1 + blackHeightRight((RBNode<T>) node.getRight());

		return result;
	}

	protected boolean verifyProperties() {
		boolean resp = verifyNodesColour() && verifyNILNodeColour() && verifyRootColour() && verifyChildrenOfRedNodes()
				&& verifyBlackHeight();

		return resp;
	}

	/**
	 * The colour of each node of a RB tree is black or red. This is guaranteed by
	 * the type Colour.
	 */
	private boolean verifyNodesColour() {
		return true; // already implemented
	}

	/**
	 * The colour of the root must be black.
	 */
	private boolean verifyRootColour() {
		return ((RBNode<T>) root).getColour() == Colour.BLACK; // already
																// implemented
	}

	/**
	 * This is guaranteed by the constructor.
	 */
	private boolean verifyNILNodeColour() {
		return true; // already implemented
	}

	/**
	 * Verifies the property for all RED nodes: the children of a red node must be
	 * BLACK.
	 */
	private boolean verifyChildrenOfRedNodes() {
		if (verifyChildrenOfRedNodesRec((RBNode<T>) root))
			return true;
		else
			return false;
	}

	private boolean verifyChildrenOfRedNodesRec(RBNode<T> node) {

		if (!node.isEmpty()) {
			if (node.getColour().equals(Colour.RED)) {
				if (((RBNode<T>) node.getLeft()).getColour().equals(Colour.RED)
						|| ((RBNode<T>) node.getRight()).getColour().equals(Colour.RED))
					return false;
			}
			return verifyChildrenOfRedNodesRec((RBNode<T>) node.getLeft())
					&& verifyChildrenOfRedNodesRec((RBNode<T>) node.getRight());
		}
		return true;
	}

	/**
	 * Verifies the black-height property from the root. The method blackHeight
	 * returns an exception if the black heights are different.
	 */
	private boolean verifyBlackHeight() {
		if (verifyBlackHeightRec((RBNode<T>) root))
			return true;
		else
			return false;
	}

	private boolean verifyBlackHeightRec(RBNode<T> node) {

		boolean result;
		if (node.isEmpty()) {
			result = true;
		} else if (blackHeightLeft(node) != blackHeightRight(node)) {
			result = false;
		} else
			result = (verifyBlackHeightRec((RBNode<T>) node.getLeft()))
					&& (verifyBlackHeightRec((RBNode<T>) node.getRight()));

		return result;
	}

	@Override
	public void insert(T value) {

		insertRec((RBNode<T>) root, value);
	}

	private void insertRec(RBNode<T> node, T element) {

		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new RBNode<T>());
			node.setRight(new RBNode<T>());

			node.getLeft().setParent(node);
			node.getRight().setParent(node);

			node.setColour(Colour.RED);
			this.fixUpCase1(node);
		} else {
			if (element.compareTo(node.getData()) > 0)
				insertRec((RBNode<T>) node.getRight(), element);
			else if (element.compareTo(node.getData()) < 0)
				insertRec((RBNode<T>) node.getLeft(), element);
		}
	}

	@Override
	public RBNode<T>[] rbPreOrder() {

		@SuppressWarnings("unchecked")
		RBNode<T>[] preOrder = new RBNode[this.size()];
		List<RBNode<T>> arrayAux = new ArrayList<RBNode<T>>();

		rbPreOrderRec(arrayAux, (RBNode<T>) this.root);

		for (int i = 0; i < arrayAux.size(); i++)
			preOrder[i] = arrayAux.get(i);

		return preOrder;
	}

	private void rbPreOrderRec(List<RBNode<T>> arrayAux, RBNode<T> node) {

		if (!node.isEmpty()) {
			arrayAux.add(node);
			rbPreOrderRec(arrayAux, (RBNode<T>) node.getLeft());
			rbPreOrderRec(arrayAux, (RBNode<T>) node.getRight());
		}
	}

	// FIXUP methods
	protected void fixUpCase1(RBNode<T> node) {

		if (node.equals((RBNode<T>) root))
			node.setColour(Colour.BLACK);
		else
			this.fixUpCase2(node);
	}

	protected void fixUpCase2(RBNode<T> node) {

		if (((RBNode<T>) node.getParent()).getColour().equals(Colour.RED))
			this.fixUpCase3(node);
	}

	protected void fixUpCase3(RBNode<T> node) {

		RBNode<T> uncle = this.getUncle(node);
		RBNode<T> parent = (RBNode<T>) node.getParent();
		RBNode<T> grandFather = (RBNode<T>) parent.getParent();
		
		if (uncle.getColour().equals(Colour.RED)) {
			uncle.setColour(Colour.BLACK);
			parent.setColour(Colour.BLACK);
			grandFather.setColour(Colour.RED);
			this.fixUpCase1(grandFather);
		} else
			this.fixUpCase4(node);
	}

	protected void fixUpCase4(RBNode<T> node) {

		RBNode<T> next = node;
		RBNode<T> parent = (RBNode<T>) node.getParent();

		if (!isLeftChild(node) && isLeftChild(parent)) {
			Util.leftRotation(parent);
			next = (RBNode<T>) node.getLeft();
		} else if (isLeftChild(node) && !isLeftChild(parent)) {
			Util.rightRotation(parent);
			next = (RBNode<T>) node.getRight();
		}

		this.fixUpCase5(next);
	}

	protected void fixUpCase5(RBNode<T> node) {

		RBNode<T> parent = (RBNode<T>) node.getParent();
		RBNode<T> grandFather = (RBNode<T>) parent.getParent();

		parent.setColour(Colour.BLACK);
		grandFather.setColour(Colour.RED);
		if (isLeftChild(node)) {
			Util.rightRotation(grandFather);
		} else
			Util.leftRotation(grandFather);
	}

	private boolean isLeftChild(RBNode<T> node) {

		return node.getParent().getLeft().equals(node);
	}

	private RBNode<T> getUncle(RBNode<T> node) {

		RBNode<T> parent = (RBNode<T>) node.getParent();
		RBNode<T> uncle;
		if (isLeftChild(parent))
			uncle = (RBNode<T>) parent.getParent().getRight();
		else
			uncle = (RBNode<T>) parent.getParent().getLeft();

		return uncle;
	}
}
