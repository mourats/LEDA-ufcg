package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

public class OddEvenBubblesort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		boolean valid = inputValidation(array, leftIndex, rightIndex);

		if (valid) {

			boolean trocas = true, volta = false;
			int begin = leftIndex;
			

			while (trocas || !volta) {
				trocas = false;
				for (int i = begin; i < rightIndex; i += 2) {
					if (array[i].compareTo(array[i + 1]) > 0) {
						Util.swap(array, i, i + 1);
						trocas = true;
					}
				}
				
				if (begin == leftIndex) {
					begin = leftIndex + 1;
				}
				else {
					begin = leftIndex;
					volta = true;
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
