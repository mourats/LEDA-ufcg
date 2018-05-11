package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		boolean valid = inputValidation(array, leftIndex, rightIndex);

		if (valid) {

			int maximoValue = 0;
			int minimoValue = Integer.MAX_VALUE;
			for (int i = leftIndex; i <= rightIndex; i++) {
				if (array[i] > maximoValue)
					maximoValue = array[i];
				if (array[i] < minimoValue)
					minimoValue = array[i];
			}
			maximoValue++;
			
			if(minimoValue < 0)
				minimoValue = Math.abs(minimoValue);
			else
				minimoValue = -minimoValue;

			
			maximoValue += minimoValue;

			int[] arrayAuxiliar = new int[maximoValue];

			for (int i = leftIndex; i <= rightIndex; i++) {
				arrayAuxiliar[array[i] + minimoValue] += 1;
			}

			arrayAuxiliar[0] += leftIndex;
			for (int i = 1; i < arrayAuxiliar.length; i++) {
				arrayAuxiliar[i] += arrayAuxiliar[i - 1];
			}

			int[] arrayOrdenado = new int[array.length];

			for (int i = rightIndex; i >= leftIndex; i--) {

				arrayOrdenado[arrayAuxiliar[array[i] + minimoValue] - 1] = array[i];
				arrayAuxiliar[array[i] + minimoValue] -= 1;
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
