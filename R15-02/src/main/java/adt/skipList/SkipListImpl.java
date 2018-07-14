package adt.skipList;

public class SkipListImpl<T> implements SkipList<T> {

	protected SkipListNode<T> root;
	protected SkipListNode<T> NIL;

	protected int maxHeight;

	protected double PROBABILITY = 0.5;

	public SkipListImpl(int maxHeight) {
		this.maxHeight = maxHeight;
		root = new SkipListNode(Integer.MIN_VALUE, maxHeight, null);
		NIL = new SkipListNode(Integer.MAX_VALUE, maxHeight, null);
		connectRootToNil();
	}

	/**
	 * Faz a ligacao inicial entre os apontadores forward do ROOT e o NIL Caso
	 * esteja-se usando o level do ROOT igual ao maxLevel esse metodo deve conectar
	 * todos os forward. Senao o ROOT eh inicializado com level=1 e o metodo deve
	 * conectar apenas o forward[0].
	 */
	private void connectRootToNil() {
		for (int i = 0; i < maxHeight; i++) {
			root.forward[i] = NIL;
		}
	}

	@Override
	public void insert(int key, T newValue, int height) {

		SkipListNode<T>[] update = new SkipListNode[this.maxHeight];

		SkipListNode<T> aux = this.root;
		for (int i = this.maxHeight - 1; i >= 0; i--) {
			while (aux.forward[i] != null && aux.forward[i].getKey() < key) {
				aux = aux.forward[i];
			}
			update[i] = aux;
		}
		aux = aux.forward[0];

		if (aux.getKey() == key) {
			aux.setValue(newValue);
		} else {

			aux = new SkipListNode<T>(key, height, newValue);
			for (int i = 0; i < height; i++) {
				aux.forward[i] = update[i].forward[i];
				update[i].forward[i] = aux;
			}
		}
	}

	@Override
	public void remove(int key) {

		SkipListNode<T>[] update = new SkipListNode[this.maxHeight];
		SkipListNode<T> aux = this.root;

		for (int i = this.maxHeight - 1; i >= 0; i--) {
			while (aux.forward[i] != null && aux.forward[i].getKey() < key) {
				aux = aux.forward[i];
			}
			update[i] = aux;
		}
		aux = aux.forward[0];

		if (aux.getKey() == key) {

			int index = 0;
			while (index < this.maxHeight && update[index].forward[index] != aux) {
				update[index].forward[index] = aux.forward[index];
			}
		}
	}

	@Override
	public int height() {

		int result = 0;
		if (this.size() != 0) {
			SkipListNode<T> aux = this.root.forward[0];
			while (!aux.equals(NIL)) {
				if (aux.height() > result) {
					result = aux.height();
				}
				aux = aux.forward[0];
			}
		}
		return result;
	}

	@Override
	public SkipListNode<T> search(int key) {

		SkipListNode<T> aux = this.root;
		for (int i = this.maxHeight - 1; i >= 0; i--) {
			while (aux.forward[i] != null && aux.forward[i].getKey() < key)
				aux = aux.forward[i];
		}

		aux = aux.forward[0];

		if (aux.getKey() == key)
			return aux;
		else
			return null;
	}

	@Override
	public int size() {

		SkipListNode<T> aux = this.root;
		int result = 0;
		while (aux.forward[0] != NIL) {
			aux = aux.forward[0];
			result++;
		}
		return result;
	}

	@Override
	public SkipListNode<T>[] toArray() {

		SkipListNode<T>[] array = new SkipListNode[this.size() + 2];
		SkipListNode<T> aux = this.root;
		int index = 0;
		while (index != this.size() + 2) {
			array[index] = aux;
			aux = aux.forward[0];
			index++;
		}

		return array;
	}

}
