package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		boolean valid = inputValidation(array, leftIndex, rightIndex);

		if (valid) {

			int maior = 0;
			for (int i = leftIndex; i <= rightIndex; i++) {
				if (array[i] > maior)
					maior = array[i];
			}
			maior++;

			int[] arrayAuxiliar = new int[maior];

			for (int i = leftIndex; i <= rightIndex; i++) {
				arrayAuxiliar[array[i]] += 1;
			}

			arrayAuxiliar[0] += leftIndex;
			for (int i = 1; i < arrayAuxiliar.length; i++) {
				arrayAuxiliar[i] += arrayAuxiliar[i - 1];
			}

			int[] arrayOrdenado = new int[array.length];

			for (int i = rightIndex; i >= leftIndex; i--) {

				arrayOrdenado[arrayAuxiliar[array[i]] - 1] = array[i];
				arrayAuxiliar[array[i]] -= 1;
			}

			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = arrayOrdenado[i];
			}
		}

	}

	private boolean inputValidation(Integer[] array, int leftIndex, int rightIndex) {

		if (array == null)
			return false;
		if (array.length == 0)
			return false;
		if (leftIndex < 0 || rightIndex < 0)
			return false;
		if (leftIndex >= rightIndex)
			return false;
		if (rightIndex >= array.length)
			return false;

		return true;
	}

}
