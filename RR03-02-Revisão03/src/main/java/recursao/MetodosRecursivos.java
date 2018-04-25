package recursao;

public class MetodosRecursivos {

	public int calcularSomaArray(int[] array){
		int result = 0;
		
		result = array.length > 0? calcularSomaArrayRec(array, 0): 0;
		
		return result;
	}
	
	private int calcularSomaArrayRec(int[] array, int index) {
		if(index+1 == array.length) {
			return array[index];
		}else {
			return array[index] + calcularSomaArrayRec(array, index+1);
		}
	}
	
	//TAIL CALL
	public long calcularFatorial(int n) {
	
		return calcularFatorialRec(1, n);
	}
	private long calcularFatorialRec(int sum, int n) {
		if(n == 0) {
			return sum;
		}else {
			return calcularFatorialRec(sum*n, n-1);
		}
	}
	
	

	public int calcularFibonacci(int n) {
		
		return calcularFibonacciRec(1, 1, n);
	}
	private int calcularFibonacciRec(int sum, int termo, int n) {
		
		if(n > 0) {
			return calcularFibonacciRec(termo, sum+termo, n-1);
		}else {
			return sum;
		}
	}

	public int countNotNull(Object[] array) {
		int result = 0;
		// TODO IMPLEMENTE AQUI O CODIGO QUE CONTA (USANDO RECURSAO) A
		// QUANTIDADE DE ELEMENTOS NAO NULOS
		// DE UM ARRAY DE OBJETOS RECEBIDO COMO PARAMETRO
		return result;
	}

	public long potenciaDe2(int expoente) {
		int result = 1;
		// TODO IMPLEMENTE (USANDO RECURSAO) O CODIGO PARA PRODUZIR A N-ESIMA
		// POTENCIA
		// DE 2
		return result;
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		double result = 0;
		// TODO IMPLEMENTE SEU CODIGO (USANDO RECURSAO) DE ENCONTRAR O n-ESIMO
		// TERMO
		// DA PROGRESSAO ARITMETICA, DADO O TERMO INICIAL E A RAZAO
		return result;
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		double result = 1;
		// TODO IMPLEMENTE SEU CODIGO (USANDO RECURSAO) DE ENCONTRAR O n-ESIMO
		// TERMO
		// DA PROGRESSAO GEOMETRICA, DADO O TERMO INICIAL E A RAZAO
		return result;
	}
	
	/*
	 * LOCAL PARA TESTES PROPRIOS
	 */
	
	public static void main(String[] args) {
		
		MetodosRecursivos recusivos  = new MetodosRecursivos();
		
		int[] array = {};
		
		int soma = recusivos.calcularSomaArray(array);
		
		long fat = recusivos.calcularFatorial(150);
		
		int fib = recusivos.calcularFibonacci(9);
		
		System.out.println(fib);
	}
	
	
}
