package sorting.linearSorting;

import util.Util;

public class TernaryArraySortingHome<T extends Comparable<T>> implements TernaryArraySorting<T> {

	@Override
	public void sort(T[] ternaryArray) {

		int leftIndex = 0;
		int rightIndex = ternaryArray.length - 1;

		boolean valid = inputValidation(ternaryArray, leftIndex, rightIndex);

		if (valid) {

			int cont = 0;
			int maximo = leftIndex;
			int minimo = leftIndex;
			int medio = leftIndex;

			int i = 0;
			while (cont < 2) {
				if (ternaryArray[i].compareTo(ternaryArray[maximo]) > 0) {
					if (cont == 1)
						medio = maximo;

					maximo = i;
					cont++;

				} else if (ternaryArray[i].compareTo(ternaryArray[minimo]) < 0) {
					if (cont == 1)
						medio = minimo;

					minimo = i;
					cont++;
				}
				i++;
			}

			Util.swap(ternaryArray, medio, leftIndex);

			T objMedio = ternaryArray[leftIndex];

			int index = partition(ternaryArray, leftIndex, rightIndex);

			i = 0;
			boolean guard = true;
			while (guard) {
				if (objMedio.compareTo(ternaryArray[i]) > 0) {
					Util.swap(ternaryArray, i, leftIndex);
					guard = false;
				}
				i++;
			}

			partition(ternaryArray, leftIndex, index - 1);
		}
	}

	private int partition(T[] ternaryArray, int leftIndex, int rightIndex) {

		int inicio = leftIndex + 1;
		int fim = rightIndex;

		while (inicio <= fim) {

			if (ternaryArray[inicio].compareTo(ternaryArray[leftIndex]) <= 0)
				inicio++;
			else if (ternaryArray[fim].compareTo(ternaryArray[leftIndex]) > 0)
				fim--;
			else {
				Util.swap(ternaryArray, inicio, fim);
				inicio++;
				fim--;
			}
		}

		Util.swap(ternaryArray, leftIndex, fim);
		return fim;
	}

	private boolean inputValidation(T[] array, int leftIndex, int rightIndex) {

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
