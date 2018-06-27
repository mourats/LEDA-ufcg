package adt.bst.extended;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Implementacao de SortComparatorBST, uma BST que usa um comparator interno em
 * suas funcionalidades e possui um metodo de ordenar um array dado como
 * parametro, retornando o resultado do percurso desejado que produz o array
 * ordenado.
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public class SortComparatorBSTImpl<T extends Comparable<T>> extends BSTImpl<T> implements SortComparatorBST<T> {

	private Comparator<T> comparator;

	public SortComparatorBSTImpl(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}

	@Override
	protected void insertRec(BSTNode<T> node, T element) {

		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode.Builder().parent(node).build());
			node.setRight(new BSTNode.Builder().parent(node).build());
		} else {
			if (this.comparator.compare(element, node.getData()) > 0)
				insertRec((BSTNode<T>) node.getRight(), element);

			else if (this.comparator.compare(element, node.getData()) < 0)
				insertRec((BSTNode<T>) node.getLeft(), element);
		}
	}

	@Override
	protected BSTNode<T> searchRec(BSTNode<T> node, T element) {

		BSTNode<T> nodeResult;

		if (node.isEmpty())
			nodeResult = new BSTNode.Builder().build();

		else if (this.comparator.compare(element, node.getData()) == 0)
			nodeResult = node;
		else if (this.comparator.compare(element, node.getData()) > 0)
			nodeResult = searchRec((BSTNode<T>) node.getRight(), element);
		else
			nodeResult = searchRec((BSTNode<T>) node.getLeft(), element);

		return nodeResult;
	}

	@Override
	public BSTNode<T> sucessor(T element) {

		BSTNode<T> node = this.search(element);
		if (!node.isEmpty()) {
			if (!node.getRight().isEmpty())
				return minimumRec((BSTNode<T>) node.getRight());
			else {
				BSTNode<T> parentNode = (BSTNode<T>) node.getParent();

				while (parentNode != null && this.comparator.compare(parentNode.getData(), node.getData()) < 0) {
					node = parentNode;
					parentNode = (BSTNode<T>) node.getParent();
				}
				return parentNode;
			}
		}
		return null;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = this.search(element);
		if (!node.isEmpty()) {
			if (!node.getLeft().isEmpty())
				return maximumRec((BSTNode<T>) node.getLeft());
			else {
				BSTNode<T> parentNode = (BSTNode<T>) node.getParent();

				while (parentNode != null && this.comparator.compare(parentNode.getData(), node.getData()) > 0) {
					node = parentNode;
					parentNode = (BSTNode<T>) node.getParent();
				}
				return parentNode;
			}
		}
		return null;
	}

	@Override
	public T[] sort(T[] array) {

		while (!this.isEmpty())
			this.remove(this.root.getData());

		for (T element : array) {
			this.insert(element);
		}

		return this.order();
	}

	@Override
	public T[] reverseOrder() {

		@SuppressWarnings("unchecked")
		T[] arrayResult = (T[]) new Comparable[this.size()];
		List<T> aux = new ArrayList<T>();

		if (!this.isEmpty()) {
			reverseOrderRec(this.root, aux);

			aux.toArray(arrayResult);
		}
		return arrayResult;
	}

	private void reverseOrderRec(BSTNode<T> node, List<T> array) {
		if (!node.isEmpty()) {
			reverseOrderRec((BSTNode<T>) node.getRight(), array);
			array.add(node.getData());
			reverseOrderRec((BSTNode<T>) node.getLeft(), array);
		}
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}

}
