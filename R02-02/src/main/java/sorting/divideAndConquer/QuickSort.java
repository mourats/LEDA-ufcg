package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		boolean valid = inputValidation(array, leftIndex, rightIndex);

		if (valid) {

			int indexPivot = quick(array, leftIndex, rightIndex);
			sort(array, leftIndex, indexPivot - 1);
			sort(array, indexPivot + 1, rightIndex);
		}

	}

	private int quick(T[] array, int leftIndex, int rightIndex) {

		T pivot = array[leftIndex];

		int begin = leftIndex + 1;
		int end = rightIndex;

		while (begin <= end) {
			if (array[begin].compareTo(pivot) <= 0)
				begin++;
			else if (pivot.compareTo(array[end]) < 0)
				end--;
			else {
				Util.swap(array, begin, end);
				begin++;
				end--;
			}
		}
		array[leftIndex] = array[end];
		array[end] = pivot;
		return end;

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
