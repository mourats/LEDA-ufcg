package sorting.divideAndConquer.threeWayQuicksort;

import sorting.AbstractSorting;
import util.Util;

public class ThreeWayQuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

   /**
    * No algoritmo de quicksort, selecionamos um elemento como pivot, particionamos
    * o array colocando os menores a esquerda do pivot e os maiores a direita do
    * pivot, e depois aplicamos a mesma estrategia recursivamente na particao a
    * esquerda do pivot e na particao a direita do pivot.
    * 
    * Considerando um array com muitoe elementos repetidos, a estrategia do
    * quicksort pode ser otimizada para lidar de forma mais eficiente com isso.
    * Essa melhoria eh conhecida como quicksort tree way e consiste da seguinte
    * ideia: - selecione o pivot e particione o array de forma que * arr[l..i]
    * contem elementos menores que o pivot * arr[i+1..j-1] contem elementos iguais
    * ao pivot. * arr[j..r] contem elementos maiores do que o pivot.
    * 
    * Obviamente, ao final do particionamento, existe necessidade apenas de ordenar
    * as particoes contendo elementos menores e maiores do que o pivot. Isso eh
    * feito recursivamente.
    **/
   @Override
   public void sort(T[] array, int leftIndex, int rightIndex) {

      boolean valid = inputValidation(array, leftIndex, rightIndex);

      if (valid) {

         int[] indexPivots = quick(array, leftIndex, rightIndex);
         int indexPivot = indexPivots[0];
         int samesPivot = indexPivots[1];

         sort(array, leftIndex, indexPivot - samesPivot - 1);
         sort(array, indexPivot + 1, rightIndex);
      }

   }

   private int[] quick(T[] array, int leftIndex, int rightIndex) {

      int begin = leftIndex + 1;
      int end = rightIndex;
      int same = 0;

      while (begin <= end) {
         if (array[begin].compareTo(array[leftIndex]) <= 0) {
            begin++;
         } else if (array[begin].compareTo(array[leftIndex]) == 0) {
            Util.swap(array, begin, begin - 1);
            begin++;
            same++;
         } else if (array[leftIndex].compareTo(array[end]) < 0)
            end--;
         else {
            Util.swap(array, begin, end);
            begin++;
            end--;
         }

      }

      Util.swap(array, leftIndex, end);
      return new int[] {end, same};

   }

   private boolean inputValidation(T[] array, int leftIndex, int rightIndex) {

      if (array == null)
         return false;
      if (array.length == 0)
         return false;
      if (leftIndex < 0 || rightIndex < 0)
         return false;
      if (leftIndex >= rightIndex)
         return false;
      if (rightIndex >= array.length)
         return false;

      return true;
   }

}
