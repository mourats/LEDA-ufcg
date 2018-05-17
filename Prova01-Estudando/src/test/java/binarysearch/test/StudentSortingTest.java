package binarysearch.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import binarysearch.BinarySearch;
import binarysearch.BinarySearchRecursive;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresIguais;
	private Integer[] vetorValoresNegativos;

	public BinarySearch implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 4, 7, 11, 11, 22, 22, 26, 28, 29, 30 });
		populaVetorTamanhoImpar(new Integer[] { 4, 6, 7, 11, 18, 26, 32, 36, 37, 41, 49 });
		populaValoresNegativos(new Integer[] { -17, -9, -2, 0, 4, 6, 7, 8, 12, 16, 25, 31 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		getImplementation();
	}

	private void getImplementation() {

		this.implementation = new BinarySearchRecursive();

	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	private void populaValoresNegativos(Integer[] arrayPadrao) {
		this.vetorValoresNegativos = Arrays.copyOf(arrayPadrao, arrayPadrao.length);

	}

	public void genericTest(Integer[] array, int x) {
		
		if(array.length > 0)
			assertTrue(implementation.buscaBinaria(array, x));

		assertFalse(implementation.buscaBinaria(array, x + 100));

	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar, 26);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar, 32);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio, 0);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais, 6);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresNegativos, -17);
	}

}
