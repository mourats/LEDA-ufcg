package adt.bt.symetric;

import adt.bt.BTNode;

public class SymetricBTImpl<T> implements SymetricBT<T> {

	protected BTNode<T> root;

	public SymetricBTImpl() {
		root = new BTNode<T>();
	}

	@Override
	public boolean isSymetric() {
		if (!this.root.isEmpty()) {
			BTNode<T> aux1 = this.root.getLeft();
			BTNode<T> aux2 = this.root.getRight();

			return isSymetricRec(aux1, aux2);
		}
		return false;
	}

	private boolean isSymetricRec(BTNode<T> aux1, BTNode<T> aux2) {

		if (aux1 != null && aux2 != null && aux1.equals(aux2)) {

			if (aux1.isLeaf() && aux2.isLeaf())
				return true;

			if (aux1.isEmpty() && aux2.isEmpty())
				return true;

			if (subsIsSymetric(aux1, aux2))
				return isSymetricRec(aux1.getLeft(), aux2.getRight()) && isSymetricRec(aux1.getRight(), aux2.getLeft());
		}

		return false;
	}

	private boolean subsIsSymetric(BTNode<T> subtree1, BTNode<T> subtree2) {
		if (subtree1.getLeft().equals(subtree2.getRight()))
			if (subtree1.getRight().equals(subtree2.getLeft()))
				return true;

		return false;
	}

	@Override
	public BTNode<T> getRoot() {
		return root;
	}

}
