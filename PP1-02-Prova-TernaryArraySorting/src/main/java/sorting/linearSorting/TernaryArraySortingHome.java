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
					else
						maximo = i;
					
					cont++;

				} else if (ternaryArray[i].compareTo(ternaryArray[minimo]) < 0) {
					if (cont == 1)
						medio = minimo;
					else
						minimo = i;
					
					cont++;
				}
				i++;
			}

			Util.swap(ternaryArray, medio, leftIndex);
			
			int index = leftIndex + 1;

			int pivotIndex = leftIndex;
			T pivotValue = ternaryArray[pivotIndex];

			while (index <= rightIndex) {

				if (ternaryArray[index].compareTo(pivotValue) < 0) {
					Util.swap(ternaryArray, index, leftIndex);
					leftIndex++;
					index++;
				} else if (pivotValue.compareTo(ternaryArray[index]) < 0) {
					Util.swap(ternaryArray, index, rightIndex);
					rightIndex--;
				} else {
					index++;
				}
			}
		}
	}

	private boolean inputValidation(T[] array, int leftIndex, int rightIndex) {

		if (array == null)
			return false;
		if (array.length == 0)
			return false;
		
		return true;
	}
}
