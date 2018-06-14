package adt.linkedList.special;

import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class SpecialLinkedListImpl<T> extends SingleLinkedListImpl<T> implements SpecialLinkedList<T> {

	@Override
	public void swap(T elem1, T elem2) {

		if (!isEmpty() && elem1 != null && elem2 != null) {

			SingleLinkedListNode<T> aux = this.head;

			SingleLinkedListNode<T> nodeElemt1 = null;
			SingleLinkedListNode<T> nodeElemt2 = null;

			while (!aux.isNIL()) {
				if (aux.getData().equals(elem1))
					nodeElemt1 = aux;
				else if (aux.getData().equals(elem2))
					nodeElemt2 = aux;

				aux = aux.getNext();
			}

			if (nodeElemt1 != null && nodeElemt2 != null) {
				T auxValue = nodeElemt1.getData();
				nodeElemt1.setData(nodeElemt2.getData());
				nodeElemt2.setData(auxValue);
			}
		}
	}

	@Override
	public T elementFromTheEnd(int k) {

		if (!isEmpty()) {

			SingleLinkedListNode<T> aux = this.head;
			SingleLinkedListNode<T> auxResult = this.head;
			T valueElement = null;
			int contador = 1;
			
			while (!aux.isNIL()) {
				if (contador >= k) {
					valueElement  = auxResult.getData();
					auxResult = auxResult.getNext();
				}
				aux = aux.getNext();
				contador++;
			}
			return valueElement;

		} else
			return null;
	}
}
