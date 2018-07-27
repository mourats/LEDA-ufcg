package adt.bt.symetric;

import adt.bt.BTNode;

public class SymetricBTImpl<T> implements SymetricBT<T> {

	protected BTNode<T> root;
	private int cont;

	public SymetricBTImpl() {
		root = new BTNode<T>();
		cont = 1;
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
	
	
	public void insert(T element) {
		if (cont == 1) {
			this.root.setData(element);
			this.root.setLeft(new BTNode<T>(this.root));
			this.root.setRight(new BTNode<T>(this.root));
		}
		if (cont == 2) {
			this.root.getLeft().setData(element);
			this.root.getLeft().setLeft(new BTNode<T>(this.root.getLeft()));
			this.root.getLeft().setRight(new BTNode<T>(this.root.getLeft()));

			this.root.getRight().setData(element);
			this.root.getRight().setLeft(new BTNode<T>(this.root.getRight()));
			this.root.getRight().setRight(new BTNode<T>(this.root.getRight()));
		}

		if (cont == 3) {
			BTNode<T> aux1 = this.root.getLeft().getLeft();
			BTNode<T> aux2 = this.root.getRight().getRight();
			aux1.setData(element);
			aux1.setLeft(new BTNode<T>(aux1));
			aux1.setRight(new BTNode<T>(aux1));

			aux2.setData(element);
			aux2.setLeft(new BTNode<T>(aux2));
			aux2.setRight(new BTNode<T>(aux2));
		}

		if (cont == 4) {
			BTNode<T> aux1 = this.root.getLeft().getRight();
			BTNode<T> aux2 = this.root.getRight().getLeft();
			aux1.setData(element);
			aux1.setLeft(new BTNode<T>(aux1));
			aux1.setRight(new BTNode<T>(aux1));

			aux2.setData(element);
			aux2.setLeft(new BTNode<T>(aux2));
			aux2.setRight(new BTNode<T>(aux2));
		}

		if (cont == 5) {
			BTNode<T> aux1 = this.root.getLeft().getLeft().getLeft();
			BTNode<T> aux2 = this.root.getRight().getRight().getRight();
			aux1.setData(element);
			aux1.setLeft(new BTNode<T>(aux1));
			aux1.setRight(new BTNode<T>(aux1));

			aux2.setData(element);
			aux2.setLeft(new BTNode<T>(aux2));
			aux2.setRight(new BTNode<T>(aux2));
		}

		if (cont == 6) {
			BTNode<T> aux1 = this.root.getLeft().getRight().getRight();
			BTNode<T> aux2 = this.root.getRight().getLeft().getLeft();
			aux1.setData(element);
			aux1.setLeft(new BTNode<T>(aux1));
			aux1.setRight(new BTNode<T>(aux1));

			aux2.setData(element);
			aux2.setLeft(new BTNode<T>(aux2));
			aux2.setRight(new BTNode<T>(aux2));
		}
		cont++;
	}

	public void printTree() {
		System.out.println("          " + this.root);
		System.out.println("     " + this.root.getLeft() + "        " + this.root.getRight());
		System.out.println("   " + this.root.getLeft().getLeft() + "   " + this.root.getLeft().getRight() + "    "
				+ this.root.getRight().getLeft() + "   " + this.root.getRight().getRight());
		System.out.println("  " + this.root.getLeft().getLeft().getLeft() + "     " + this.root.getLeft().getRight().getRight() + "  " + this.root.getRight().getRight().getRight() + "     " + this.root.getRight().getLeft().getLeft());
	}

}
