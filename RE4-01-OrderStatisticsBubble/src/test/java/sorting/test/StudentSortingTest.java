package sorting.test;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import orderStatistic.OrderStatistics;
import orderStatistic.OrderStatisticsSelectionImpl;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresNegativos;

	public OrderStatistics<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 26, 4, 23, 22, 11 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49, 11, 18, 36 });
		populaVetorRepetido(new Integer[] {  9, 3, 4, 0, 5, 1 });
		populaValoresNegativos(new Integer[] { 16, 6, 4, 8, 31, -17, 25, 12, -9, 7, -2, 0 });

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação do
	 * aluno
	 */
	private void getImplementation() {

		this.implementation = new OrderStatisticsSelectionImpl<Integer>();

	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	private void populaValoresNegativos(Integer[] arrayPadrao) {
		this.vetorValoresNegativos = Arrays.copyOf(arrayPadrao, arrayPadrao.length);

	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO
	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array, int key) {
		
		//int value2 = Arrays.binarySearch(array, key) + 1;
		

		System.out.println("result: " + implementation.getOrderStatistics(array, key));

		//assertEquals(value1, value2);

	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar, 4);
		//
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar, 4);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio, 0);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresRepetidos, 1);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresNegativos, 5);
	}

}
