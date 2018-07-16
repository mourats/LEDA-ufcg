package adt.bst.extended;

import adt.bst.BSTNode;

public class MethodRemove<T extends Comparable<T>> {

	protected BSTNode<T> treeMinimum(BSTNode<T> node) {
		BSTNode<T> minimum = node;
		while (!minimum.getLeft().isEmpty()) {
			minimum = castNode(minimum.getLeft());
		}
		return minimum;
	}

	protected BSTNode<T> treeMaximum(BSTNode<T> node) {
		BSTNode<T> maximum = node;
		while (!maximum.getRight().isEmpty()) {
			maximum = castNode(maximum.getRight());
		}
		return maximum;
	}

	protected BSTNode<T> castNode(Object node) {
		BSTNode<T> rtn = null;
		if (node instanceof BSTNode<?>) {
			rtn = ((BSTNode<T>) node);
		}
		return rtn;
	}

	public void remove(T element) {
		if (element != null) {
			//BSTNode<T> node = search(element);
			//if (!node.isEmpty()) {
			//	remove(node);
			//}
		}
	}

	private void remove(BSTNode<T> node) {
		if (node.isLeaf()) {
			node.setData(null);
			node.setLeft(null);
			node.setRight(null);
		} else {
			BSTNode<T> aux = null;
			if (!node.getRight().isEmpty()) {
				aux = treeMinimum(castNode(node.getRight()));
			} else {
				aux = treeMaximum(castNode(node.getLeft()));
			}
			node.setData(aux.getData());
			remove(aux);
		}
	}

}
