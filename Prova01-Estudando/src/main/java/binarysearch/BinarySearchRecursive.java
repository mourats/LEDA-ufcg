package binarysearch;

public class BinarySearchRecursive {
	
	public boolean buscaBinaria(Integer[] array, int x) {

		boolean valid = inputValidation(array);

		if (valid) {

			return buscaBinariaRec(array, x, 0, array.length-1);
		}

		return false;
	}

	private boolean buscaBinariaRec(Integer[] array, int x, int begin, int end) {
		
		int middle = (begin + end)/2;
		
		if(x == array[middle])
			return true;
		
		if(x < array[middle])
			return buscaBinariaRec(array, x, begin, middle);
		else
			return buscaBinariaRec(array, x, middle, end);
		
	}

	private boolean inputValidation(Integer[] array) {

		if (array == null)
			return false;
		if (array.length == 0)
			return false;

		return true;
	}

}