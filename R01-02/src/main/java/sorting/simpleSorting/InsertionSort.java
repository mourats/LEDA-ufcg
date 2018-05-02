package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (rightIndex > leftIndex && leftIndex >= 0 && rightIndex < array.length) {

			for (int i = leftIndex + 1; i <= rightIndex; i++) {

				for (int j = i - 1; j >= leftIndex && array[j + 1].compareTo(array[j]) < 0; j--) {
					Util.swap(array, j + 1, j);
				}
			}
		}
	}
}
