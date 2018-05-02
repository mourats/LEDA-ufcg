package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This algorithm applies two selection sorts simultaneously. In a same
 * iteration, a selection sort pushes the greatest elements to the right and
 * another selection sort pushes the smallest elements to the left. At the end
 * of the first iteration, the smallest element is in the first position (index
 * 0) and the greatest element is the last position (index N-1). The next
 * iteration does the same from index 1 to index N-2. And so on. The execution
 * continues until the array is completely ordered.
 */
public class SimultaneousSelectionsort<T extends Comparable<T>> extends AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (rightIndex > leftIndex && leftIndex >= 0 && rightIndex < array.length) {

			while (leftIndex < rightIndex) {

				int minimo = leftIndex;
				int maximo = rightIndex;

				for (int j = leftIndex; j <= rightIndex; j++) {

					if (array[j].compareTo(array[minimo]) < 0) {
						minimo = j;
					}

					if (array[j].compareTo(array[maximo]) > 0) {
						maximo = j;
					}
				}

				if (minimo == rightIndex) {
					Util.swap(array, leftIndex, minimo);
					Util.swap(array, rightIndex, maximo);

				} else {
					Util.swap(array, rightIndex, maximo);
					Util.swap(array, leftIndex, minimo);
				}

				leftIndex++;
				rightIndex--;
			}

		}
	}

}
