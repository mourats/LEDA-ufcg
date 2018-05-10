package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		int maior = 0;
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i] > maior)
				maior = array[i];
		}
		maior++;

		Integer[] arrayAuxiliar = new Integer[maior];

		for (int i = 0; i < maior; i++) {
			arrayAuxiliar[i] = 0;
		}

		for (int i = leftIndex; i < rightIndex; i++) {
			arrayAuxiliar[array[i]]++;
		}

		int sum = 0;
		for (int i = 1; i < maior; i++) {
			int dum = arrayAuxiliar[i];
			arrayAuxiliar[i] = sum;
			sum += dum;
		}

		Integer[] arrayOrdenado = new Integer[array.length];
		
		System.out.println(Arrays.toString(arrayAuxiliar));
		System.out.println(Arrays.toString(arrayOrdenado));
		System.out.println(Arrays.toString(array));
		
		for (int i = leftIndex; i <= rightIndex; i++) {
			arrayOrdenado[arrayAuxiliar[array[i]]] = array[i];
			arrayAuxiliar[array[i]]++;
		}

		for (int i = leftIndex; i <= rightIndex; i++) {
			array[i] = arrayOrdenado[i];
		}
		
		System.out.println(Arrays.toString(array));

	}

}
