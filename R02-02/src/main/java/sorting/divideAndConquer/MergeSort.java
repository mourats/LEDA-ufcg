package sorting.divideAndConquer;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (array == null)
			return;
		if (array.length == 0)
			return;
		if (leftIndex < 0 || rightIndex < 0)
			return;
		if (leftIndex >= rightIndex)
			return;
		if (rightIndex >= array.length)
			return;

		int middle = (rightIndex + leftIndex) / 2;

		sort(array, leftIndex, middle);
		sort(array, middle + 1, rightIndex);

		merge(array, leftIndex, rightIndex, middle);

	}

	private void merge(T[] array, int leftIndex, int rightIndex, int middleIndex) {

		T[] arrayAux = Arrays.copyOf(array, array.length);

		int begin = leftIndex;
		int middle = middleIndex + 1;
		int first = leftIndex;
		
		while (begin <= middleIndex && middle <= rightIndex) {

			if (arrayAux[middle].compareTo(arrayAux[begin]) > 0) {
				array[first] = arrayAux[begin];
				begin++;
			} else {
				array[first] = arrayAux[middle];
				middle++;
			}
			first++;
		}

		while (begin <= middleIndex) {
			array[first] = arrayAux[begin];
			begin++;
			first++;
		}

		while (middle <= rightIndex) {
			array[first] = arrayAux[middle];
			middle++;
			first++;
		}

	}

}
