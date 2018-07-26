package adt.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import util.Util;

/**
 * O comportamento de qualquer heap é definido pelo heapify. Neste caso o
 * heapify dessa heap deve comparar os elementos e colocar o maior sempre no
 * topo. Ou seja, admitindo um comparador normal (responde corretamente 3 > 2),
 * essa heap deixa os elementos maiores no topo. Essa comparação não é feita
 * diretamente com os elementos armazenados, mas sim usando um comparator. Dessa
 * forma, dependendo do comparator, a heap pode funcionar como uma max-heap ou
 * min-heap.
 */
public class HeapImpl<T extends Comparable<T>> implements Heap<T> {

	protected T[] heap;
	protected int index = -1;
	/**
	 * O comparador é utilizado para fazer as comparações da heap. O ideal é mudar
	 * apenas o comparator e mandar reordenar a heap usando esse comparator. Assim
	 * os metodos da heap não precisam saber se vai funcionar como max-heap ou
	 * min-heap.
	 */
	protected Comparator<T> comparator;

	private static final int INITIAL_SIZE = 20;
	private static final int INCREASING_FACTOR = 10;

	/**
	 * Construtor da classe. Note que de inicio a heap funciona como uma min-heap.
	 */
	@SuppressWarnings("unchecked")
	public HeapImpl(Comparator<T> comparator) {
		this.heap = (T[]) (new Comparable[INITIAL_SIZE]);
		this.comparator = comparator;
	}

	// /////////////////// METODOS IMPLEMENTADOS
	private int parent(int i) {
		return (i - 1) / 2;
	}

	/**
	 * Deve retornar o indice que representa o filho a esquerda do elemento indexado
	 * pela posicao i no vetor
	 */
	private int left(int i) {
		return (i * 2 + 1);
	}

	/**
	 * Deve retornar o indice que representa o filho a direita do elemento indexado
	 * pela posicao i no vetor
	 */
	private int right(int i) {
		return (i * 2 + 1) + 1;
	}

	@Override
	public boolean isEmpty() {
		return (index == -1);
	}

	@Override
	public T[] toArray() {
		ArrayList<T> resp = new ArrayList<T>();
		for (T elem : this.heap) {
			if (elem != null)
				resp.add(elem);
		}
		return (T[]) resp.toArray(new Comparable[0]);
	}

	// ///////////// METODOS A IMPLEMENTAR
	/**
	 * Valida o invariante de uma heap a partir de determinada posicao, que pode ser
	 * a raiz da heap ou de uma sub-heap. O heapify deve colocar os maiores
	 * (comparados usando o comparator) elementos na parte de cima da heap.
	 */
	private void heapify(int position) {
		int left = this.left(position);
		int right = this.right(position);
		int bigger = position;

		if (left < this.size() && this.comparator.compare(this.heap[left], this.heap[position]) > 0)
			bigger = left;
		if (right < this.size() && this.comparator.compare(this.heap[right], this.heap[bigger]) > 0)
			bigger = right;

		if (bigger != position) {
			Util.swap(this.heap, position, bigger);

			heapify(parent(position));

			if (this.left(bigger) < this.size() || this.right(bigger) < this.size())
				heapify(bigger);
		}
	}

	@Override
	public void insert(T element) {
		// ESSE CODIGO E PARA A HEAP CRESCER SE FOR PRECISO. NAO MODIFIQUE
		if (index == heap.length - 1) {
			heap = Arrays.copyOf(heap, heap.length + INCREASING_FACTOR);
		}
		// /////////////////////////////////////////////////////////////////
		if (element != null) {
			index++;
			this.heap[index] = element;
			this.heapify(parent(index));
		}
	}

    @Override
    public void buildHeap(T[] array) {
        if (array == null)
            return;
 
        this.heap = array;
        this.index = array.length - 1;
 
        for (int i = this.index; i >= 0; i--) {
            this.heapify(i);
        }
    }

	@Override
	public T extractRootElement() {
		if (!this.isEmpty()) {

			T element = this.heap[0];
			this.heap[0] = null;
			Util.swap(this.heap, 0, this.index);
			index--;

			this.heapify(0);
			return element;

		} else
			return null;
	}

	@Override
	public T rootElement() {
		if (!this.isEmpty())
			return this.heap[0];
		else
			return null;
	}

	@Override
	public T[] heapsort(T[] array) {

		Comparator<T> comparatorAux = getComparator();
		this.setComparator((o1, o2) -> o2.compareTo(o1));

		this.buildHeap(array);

		@SuppressWarnings("unchecked")
		T[] arrayAux = (T[]) (new Comparable[this.size()]);

		for (int index = 0; index < arrayAux.length; index++) {
			arrayAux[index] = this.extractRootElement();
		}

		resetHeap(comparatorAux);
		return arrayAux;
	}

	private void resetHeap(Comparator<T> comparatorAux) {
		this.setComparator(comparatorAux);
		this.heap = (T[]) (new Comparable[INITIAL_SIZE]);
	}

	@Override
	public int size() {
		return index + 1;
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public T[] getHeap() {
		return heap;
	}
}
