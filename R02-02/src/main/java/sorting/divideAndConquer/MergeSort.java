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
		
		if (rightIndex > leftIndex && leftIndex >= 0 && rightIndex < array.length) {
		
			int middle = (leftIndex + rightIndex) / 2;
			System.out.println("divisao : " + middle);
			sort(array, leftIndex, middle);
			sort(array, middle + 1, rightIndex);
			merge(array, leftIndex, middle, rightIndex);
		}
	}

	private void merge(T[] array, int leftIndex, int rightIndex, int middle) {
		
		System.out.println(Arrays.toString(array));
		System.out.println(leftIndex);
		System.out.println(middle);
		System.out.println(rightIndex);
		
		
	}
}
