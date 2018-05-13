package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * The implementation of the algorithm must be in-place!
 */
public class GnomeSort<T extends Comparable<T>> extends AbstractSorting<T> {
	
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		boolean valid = inputValidation(array, leftIndex, rightIndex);

		if (valid) {

			int pivotIndex = leftIndex + 1;

			while (pivotIndex <= rightIndex) {

				if (array[pivotIndex].compareTo(array[pivotIndex - 1]) >= 0) {
					pivotIndex++;
				} else {
					Util.swap(array, pivotIndex, pivotIndex - 1);

					if (pivotIndex > leftIndex + 1)
						pivotIndex--;
					else
						pivotIndex++;
				}
			}
		}
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
