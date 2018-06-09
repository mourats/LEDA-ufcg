package adt.linkedList.batch;

import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.DoubleLinkedListNode;
import adt.linkedList.SingleLinkedListNode;
import util.GenericException;

/**
 * Manipula elementos da LinkedList em bloco (batch).
 * 
 * @author campelo
 * @author adalberto
 *
 * @param <T>
 */
public class BatchLinkedListImpl<T> extends DoubleLinkedListImpl<T> implements BatchLinkedList<T> {

	/*
	 * Nao modifique nem remova este metodo.
	 */
	public BatchLinkedListImpl() {
		head = new DoubleLinkedListNode<T>();
		last = (DoubleLinkedListNode<T>) head;
	}

	/**
	 * Insere todos do array elementos a partir de uma posicao na lista. As posicoes
	 * da lista são consideradas entre 0 (primeiro) e N-1 (ultimo).
	 * 
	 * Ex: lista = [3,9,4,2]. inserirEmBatch(2,[15,28,7,11]) modifica a lista para
	 * [3,9,15,28,7,11,4,2].
	 * 
	 * Note que eh possivel inserir os novos elementos em qualquer posicao da lista.
	 * Por exemplo, a partir de uma lista com dois elementos [A,B] e de um array com
	 * um elemento [Z], deve ser possivel obter a listas [A,B], [A,Z,B] ou [A,B,Z].
	 * 
	 * 
	 * @param posicao
	 *            - a posicao onde inserir o primeiro elemento do array
	 * @param elementos
	 *            - os elementos a serem inseridos na lista.
	 * 
	 *            Restricoes - nao eh permitido usar os metodos insercao disponiveis
	 *            na lista.
	 * 
	 *            Validacoes: - caso a posicao seja invalida ou o array elementos
	 *            for null, o metodo deve lancar uma adt.util.GenericException. -
	 *            voce nao precisa se preocupar com possiveis elementos null no
	 *            array
	 * 
	 */
	@Override
	public void inserirEmBatch(int posicao, T[] elementos) throws GenericException {

	}

	/**
	 * Remove uma quantidade de elementos da lista a partir de determinada posicao
	 * (inclusive). Ex: lista = lista = [3,9,4,2]. removerEmBatch(1,3) modifica
	 * lista para [3].
	 * 
	 * @param posicao
	 * @param quantidade
	 * 
	 *            Validacoes: - caso a posicao seja invalida na lista ou a
	 *            quantidade a ser removida ultrapasse o final da lista, o metodo
	 *            deve lancar uma adt.util.GenericException.
	 * 
	 *            Restricoes: - nao eh permitido usar os metodos de remocao
	 *            disponiveis na lista
	 */
	@Override
	public void removerEmBatch(int posicao, int quantidade) throws GenericException {

	}

	/*
	 * NAO MODIFIQUE NEM REMOVA ESTE METODO!!!
	 * 
	 * Use este metodo para fazer seus testes
	 * 
	 * Este metodo monta uma String contendo os elementos do primeiro ao ultimo,
	 * comecando a navegacao pelo Head
	 */
	public String toStringFromHead() {

		String result = "";
		DoubleLinkedListNode<T> aNode = (DoubleLinkedListNode<T>) getHead();

		while (!aNode.isNIL()) {

			if (!result.isEmpty()) {
				result += " ";
			}

			result += aNode.getData();
			aNode = (DoubleLinkedListNode<T>) aNode.getNext();

		}

		return result;
	}

	/*
	 * NAO MODIFIQUE NEM REMOVA ESTE METODO!!!
	 * 
	 * Use este metodo para fazer seus testes
	 * 
	 * Este metodo monta uma String contendo os elementos do primeiro ao ultimo,
	 * porem comecando a navegacao pelo Last
	 * 
	 * Este metodo produz o MESMO RESULTADO de toStringFromHead()
	 * 
	 */
	public String toStringFromLast() {

		String result = "";
		DoubleLinkedListNode<T> aNode = getLast();

		while (!aNode.isNIL()) {

			if (!result.isEmpty()) {
				result = " " + result;
			}

			result = aNode.getData() + result;
			aNode = (DoubleLinkedListNode<T>) aNode.getPrevious();

		}

		return result;
	}

	@Override
	public String toString() {
		return toStringFromHead();
	}

}
