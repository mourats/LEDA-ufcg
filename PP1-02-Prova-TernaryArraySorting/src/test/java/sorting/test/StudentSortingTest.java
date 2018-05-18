package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.linearSorting.TernaryArraySorting;
import sorting.linearSorting.TernaryArraySortingHome;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresUnico;

	public TernaryArraySorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 12, 1, 1, 12, 30, 1, 12, 12, 1 });
		populaVetorTamanhoImpar(new Integer[] { 60, 40, 40, 10, 60, 10, 10, 60, 40, 40, 40 });
		populaVetorUnico(new Integer[] { 1,2,3 });

		getImplementation();
	}

	private void getImplementation() {

		this.implementation = new TernaryArraySortingHome<Integer>();

	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorUnico(Integer[] arrayPadrao) {
		this.vetorValoresUnico = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if (array.length > 0) {
			copy1 = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		
		Assert.assertArrayEquals(copy1, array);

	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresUnico);
	}
}
