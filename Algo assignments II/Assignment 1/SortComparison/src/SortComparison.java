// -------------------------------------------------------------------------

import java.io.File;
import java.util.Arrays;

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author Aziz
 *  @version HT 2022
 */

class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */

    static double [] insertionSort (double a[]){
        int m;
        for ( int n =1 ; n< a.length ; n++){
            m=n;
            while(m>0 && a[m-1]>a[m]){
                double temp = a[m];
                a[m]=a[m-1];   // swap
                a[m-1]=temp;
                m =m -1;

            }

        }
        return a;
    }

    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
        for ( int m = 0;m< a.length-1 ; m++){
            int min = m;
            for(int n = m+1 ; n < a.length ; n++){
                if ( a[n] < a[min])
                    min = n;
                double temp = a[min];  // swap
                a[min] =a[m];
                a[m]= temp;
            }
        }

        return  a;
    }
    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double[] quickSort(double a[]) {

        recursivequickSort(a, 0, a.length - 1);
        return a;
    }

    static void recursivequickSort(double[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int pivotPos = partition(a, lo, hi);
        recursivequickSort(a, lo, pivotPos - 1);
        recursivequickSort(a, pivotPos + 1, hi);
    }

    static int partition(double[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        double pivot = a[lo];
        while (true) {
            while (a[++i] < pivot) {
                if (i == hi)
                    break;
            }
            while (a[--j] >= pivot) {
                if (j == lo)
                    break;
            }
            if (i >= j)
                break;
            double temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        a[lo] = a[j];
        a[j] = pivot;
        return j;
    }


    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    public static double[] mergeSortIterative(double[] a) {
        int N = a.length;
        double[] aux = new double[N];
        for (int j = 1; j < N; j = j+j){
            for(int low = 0; low < N - j; low += j + j){
                merge(a, aux,low,low + j - 1, Math.min(low + j + j - 1, N-1));
            }
        }
        return a;
    }

    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     *
     */
    static double[] mergeSortRecursive (double[] a) {
        double[] aux = new double[a.length];
        recursivemergeSort(a, aux, 0, a.length - 1);
        return a;
    }

    private static void recursivemergeSort (double[] a, double[] aux, int lo, int hi) {
        if(hi <= lo)
            return;
        int mid = lo + (hi-lo)/2;
        recursivemergeSort(a, aux, lo, mid);
        recursivemergeSort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static void merge (double[] a, double[] aux, int lo, int mid, int hi) {
        for (int x = lo; x <= hi; x++)
            aux[x] = a[x];

        int i = lo, j = mid+1;
        for(int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] =aux[i++];
            else if (aux[j] < aux[i])
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
    }


   /* public static void main(String[] args) {
        File f = new File("numbers1000.txt");
        double[] a = new double[1000];

        //insertionSort
        double [] array = Arrays.copyOf(a, a.length);
        double startTime = System.nanoTime();
        SortComparison.insertionSort(array);
        double endTime = System.nanoTime();
        double timePassed = endTime - startTime;
        System.out.println("Insertion sort : " + timePassed / 1000000 + " ms");

        //selectionSort()
        double[] array1 = Arrays.copyOf(a, a.length);
        double startTime1 = System.nanoTime();
        SortComparison.selectionSort(array1);
        double endTime1 = System.nanoTime();
        double timePassed1 = endTime1 - startTime1;
        System.out.println("selection sort : " + timePassed1 / 1000000 + " ms");

        //mergeSort() recursive and iterative
        double[] array2 = Arrays.copyOf(a, a.length);
        double startTime2 = System.nanoTime();
        SortComparison.mergeSortRecursive(array2);
        double endTime2 = System.nanoTime();
        double timePassed2 = endTime2 - startTime2;
        System.out.println("merge sort recursive  : " + timePassed2 / 1000000 + " ms");

        double[] array6 = Arrays.copyOf(a, a.length);
        double startTime6 = System.nanoTime();
        SortComparison.mergeSortRecursive(array2);
        double endTime6 = System.nanoTime();
        double timePassed6 = endTime6 - startTime6;
        System.out.println("merge sort iterative : " + timePassed2 / 1000000 + " ms");

        //QuickSort
        double[] array3 = Arrays.copyOf(a, a.length);
        double startTime3 = System.nanoTime();
        SortComparison.quickSort(array3);
        double endTime3 = System.nanoTime();
        double timePassed3 = endTime3 - startTime3;
        System.out.println("quick sort : " + timePassed3 / 1000000 + " ms");
    }*/
}//end class

