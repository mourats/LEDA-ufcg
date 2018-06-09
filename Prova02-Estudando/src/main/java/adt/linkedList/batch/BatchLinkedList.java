package adt.linkedList.batch;

import adt.linkedList.DoubleLinkedList;
import util.GenericException;

/**
 * 
 * Manipula elementos da LinkedList em bloco (batch).
 * 
 * @author campelo
 * @author adalberto
 *
 * @param <T>
 */
public interface BatchLinkedList<T> extends DoubleLinkedList<T> {
	
	
	
	/**
	 * Insere todos do array elementos a partir de uma posicao na lista. As posicoes
	 * da lista são consideradas entre 0 (primeiro) e N-1 (ultimo).
	 * 
	 * Ex: lista = [3,9,4,2].
	 * inserirEmBatch(2,[15,28,7,11]) modifica a lista para [3,9,15,28,7,11,4,2].
	 * 
	 * Note que eh possivel inserir os novos elementos em qualquer posicao da lista. 
	 * Por exemplo, a partir de uma lista com dois elementos [A,B] e de um array com um 
	 * elemento [Z], deve ser possivel obter a listas [A,B], [A,Z,B] ou [A,B,Z].
	 *   
	 * 
	 * @param posicao - a posicao onde inserir o primeiro elemento do array
	 * @param elementos - os elementos a serem inseridos na lista.
	 * 
	 * Restricoes
	 * - nao eh permitido usar os metodos insercao disponiveis na lista.
	 * 
	 * Validacoes:
	 * - caso a posicao seja invalida ou o array elementos for null, o metodo deve lancar uma adt.util.GenericException.
	 * - voce nao precisa se preocupar com possiveis elementos null no array
	 * 
	 */
	public void inserirEmBatch(int posicao, T[] elementos) throws GenericException;
	
	
	
	/**
	 * Remove uma quantidade de elementos da lista a partir de determinada posicao (inclusive).
	 * Ex: lista = lista = [3,9,4,2].
	 * removerEmBatch(1,3)  modifica lista para [3].
	 * 
	 * @param posicao
	 * @param quantidade
	 * 
	 * Validacoes:
	 * - caso a posicao seja invalida na lista ou a quantidade a ser removida ultrapasse
	 *   o final da lista, o metodo deve lancar uma adt.util.GenericException.
	 *   
	 * Restricoes:
	 * - nao eh permitido usar os metodos de remocao disponiveis na lista
	 */
	public void removerEmBatch(int posicao,int quantidade) throws GenericException;
}
