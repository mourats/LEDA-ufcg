package binarysearch.test;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import binarysearch.FloorCeil;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	@SuppressWarnings("unused")
	private Integer[] vetorTamImpar;
	@SuppressWarnings("unused")
	private Integer[] vetorVazio = {};
	@SuppressWarnings("unused")
	private Integer[] vetorValoresIguais;
	@SuppressWarnings("unused")
	private Integer[] vetorValoresNegativos;

	public FloorCeil implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 4, 6, 8, 10 });
		populaVetorTamanhoImpar(new Integer[] { 4, 6, 7, 11, 18, 26, 32, 36, 37, 41, 49 });
		populaValoresNegativos(new Integer[] { -17, -9, -2, 0, 4, 6, 7, 8, 12, 16, 25, 31 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		getImplementation();
	}

	private void getImplementation() {

		this.implementation = new FloorCeil();

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
		

		System.out.println(implementation.floor(array, x));
		System.out.println(implementation.ceil(array, x));

	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar, 7);
	}
/*
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
*/
}
