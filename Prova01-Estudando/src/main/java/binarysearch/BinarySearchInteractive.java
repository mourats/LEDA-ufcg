package binarysearch;

public class BinarySearchInteractive {

	public boolean buscaBinaria(Integer[] array, int x) {

		boolean valid = inputValidation(array);

		if (valid) {

			int middle;
			int begin = 0;
			int end = array.length;

			while (begin <= end) {
				middle = (begin + end) / 2;

				if (x == array[middle])
					return true;

				if (x < array[middle])
					end = middle;
				else
					begin = middle;

			}
		}

		return false;
	}

	private boolean inputValidation(Integer[] array) {

		if (array == null)
			return false;
		if (array.length == 0)
			return false;

		return true;
	}

}
