package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * The combsort algoritm.
 */
public class CombSort<T extends Comparable<T>> extends AbstractSorting<T> {
	
	private static final double FATOR = 1.25;

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		boolean valid = inputValidation(array, leftIndex, rightIndex);

		if (valid) {

			int tamSort = (rightIndex - leftIndex) + 1;

			int gap = tamSort;

			boolean swapped = true;

			while (gap > 1 || swapped) {

				gap = getNextGap(gap);
				swapped = false;

				int i = leftIndex;
				while (i + gap <= rightIndex) {

					if (array[i].compareTo(array[i + gap]) > 0) {
						Util.swap(array, i, i + gap);
						swapped = true;
					}
					i++;
				}
			}
		}

	}

	private int getNextGap(int gap) {

		gap = (int) (gap / FATOR);

		if (gap < 1)
			return 1;
		else
			return gap;
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
