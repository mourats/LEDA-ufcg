package adt.linkedList.ordered;

import java.util.Comparator;

import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

/**
 * Para testar essa classe voce deve implementar seu comparador. Primeiro
 * implemente todos os métodos requeridos. Depois implemente dois comparadores
 * (com idéias opostas) e teste sua classe com eles. Dependendo do comparador
 * que você utilizar a lista funcionar como ascendente ou descendente, mas a
 * implemntação dos métodos é a mesma.
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public class OrderedSingleLinkedListImpl<T extends Comparable<T>> extends SingleLinkedListImpl<T>
		implements OrderedLinkedList<T> {

	private Comparator<T> comparator;

	public OrderedSingleLinkedListImpl(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	@Override
	public T minimum() {
		if (!isEmpty()) {
			return head.getData();

		} else
			return null;
	}

	@Override
	public T maximum() {
		if (!isEmpty()) {
			SingleLinkedListNode<T> aux = this.head;

			while (!aux.isNIL()) {
				aux = aux.getNext();
			}
			return aux.getData();
		} else
			return null;
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	@Override
	public void insert(T element) {

		if (element != null) {

			if (this.isEmpty()) {
				this.head.setData(element);
				this.head.setNext(new SingleLinkedListNode<T>());
			} else {
				SingleLinkedListNode<T> aux = this.head;

				boolean guard = false;
				while (!aux.isNIL() && !guard) {
					if (aux.getData().compareTo(element) > 0) {
						SingleLinkedListNode<T> newNode = new SingleLinkedListNode<T>(aux.getData(), aux.getNext());
						aux.setData(element);
						aux.setNext(newNode);
						guard = true;
					}
					aux = aux.getNext();
				}
				if (!guard) {
					aux.setData(element);
					aux.setNext(new SingleLinkedListNode<T>());
				}
			}
		}
	}
}
