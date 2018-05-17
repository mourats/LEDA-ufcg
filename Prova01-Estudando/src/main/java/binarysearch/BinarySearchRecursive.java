package binarysearch;

public class BinarySearchRecursive implements BinarySearch {

	public boolean buscaBinaria(Integer[] array, int x) {

		boolean valid = inputValidation(array);

		if (valid) {

			return buscaBinariaRec(array, x, 0, array.length - 1);
		}

		return false;
	}

	private boolean buscaBinariaRec(Integer[] array, int x, int begin, int end) {

		int middle = (begin + end) / 2;

		if (x == array[middle])
			return true;
		
		if(begin > end)
			return false;

		if (x < array[middle])
			return buscaBinariaRec(array, x, begin, middle - 1);
		else
			return buscaBinariaRec(array, x, middle + 1, end);

	}

	private boolean inputValidation(Integer[] array) {

		if (array == null)
			return false;
		if (array.length == 0)
			return false;

		return true;
	}

}