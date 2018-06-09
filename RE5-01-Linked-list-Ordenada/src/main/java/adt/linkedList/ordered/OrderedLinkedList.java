package adt.linkedList.ordered;

import adt.linkedList.LinkedList;

/**
 * Representa um a lista ordenada (ascendente ou descendente) de elementos,
 * usando um comparador. Dependendo do comparador usado a lista pode ser
 * ascendente ou descendente.
 * 
 * Naturalmente, numa lista ordenada é possível encontrar o elemento maximo e o
 * elemento minimo da lista. Tambem, a execução das operacoes mantem a
 * propriedade de ordem da lista e usam o comparator para isso.
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public interface OrderedLinkedList<T extends Comparable<T>> extends LinkedList<T> {

	/**
	 * Retorna o elemento de menor valor da lista ou null se a lista form vazia.
	 * Note que, se sua lista esta sempre ordenada, o minimum sera o primeiro 
	 * elemento da lista.
	 * 
	 * @return
	 */
	public T minimum();

	/**
	 * Retorna o elemento de maior valor da lista ou null se a lista form vazia.
	 * Note que, se sua lista esta sempre ordenada, o maximum sera sempre o ultimo
	 * elemento da lista.
	 * 
	 * @return
	 */
	public T maximum();
}
