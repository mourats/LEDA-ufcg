package adt.bst.extended;

import java.util.ArrayList;

import adt.bst.BST;

/**
 * IMplementacao de BST completamente recursiva. Os metodos maximum, minimum, predecessor 
 * e sucessor qu eantes foram implementados de forma iterativa tem que ser implementados 
 * de forma recursiva.
 * @author Adalberto
 *
 * @param <T>
 */
public interface FullRecursiveBST<T extends Comparable<T>> extends BST<T> {
	/**
	 * Retorna um array de elementos distantes de k da raiz. A raiz tem distancia 
	 * 0 para ela mesmo. os filhos da raiz tem distancia 1 para a raiz. Os netos da
	 * raiz tem distancia 2 para a raiz , e assim por diante. Por exemplo, 
	 * com k = 0, tem-se [RAIZ]. Com k = 1 tem-se: [RAIZ.left,RAIZ.right]
	 * Os elementos devem ser listados da esquerda para a direita.
	 * Na construção do array, procure usar o método ArrayList.toArray(T[]) 
	 * como no seguinte snippet:
	 *  ArrayList<T> result = new ArrayList<T>();
	 *	// preencher a list e depois converter para T[]
	 *	return (T[]) result.toArray(new Comparable[0]);
	 * 
	 * Obs:
	 *  - implementacao deve usar recursao
	 *  - nao pode utilizar nenhum outro metodo existente da BST
	 *  - voce pode utilizar a classe ArrayList para guardar os elementos
	 *    e o metodo toArray(new Comparable[0]) para retornar um T[] no final.
	 * @param k
	 * @return
	 */
	public T[] elementsAtDistance(int k);
}
