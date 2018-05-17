package sorting.linearSorting;

import util.Util;

public class TernaryArraySortingImpl<T extends Comparable<T>> implements TernaryArraySorting<T> {

	public void sort(T[] ternaryArray) {

		quickSort(ternaryArray, 0, ternaryArray.length - 1);

	}

	private void quickSort(T[] ternaryArray, int leftIndex, int rightIndex) {

		if (leftIndex < rightIndex) {

			int pivotIndex = partition(ternaryArray, leftIndex, rightIndex);

			quickSort(ternaryArray, leftIndex, pivotIndex - 1);
			quickSort(ternaryArray, pivotIndex + 1, rightIndex);
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
}
