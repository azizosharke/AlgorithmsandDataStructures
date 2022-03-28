// results are in microseconds :


// Insertion :
// 1000 random : 709.6
// 1000 Duplicates : 700
// 1000 nearly ordered :631.6
// 1000 reverse order :673.6
// 1000 sorted :521.3
// 10000 random :3214
// ___________________________________________________________________________
// Selection :
// 1000 random : 4073.3
// 1000 Duplicates :4384.3
// 1000 nearly ordered :4526
// 1000 reverse order :3857.3
// 1000 sorted : 1200
// 10000 random :110459.6
//------------------------------------------------------------------------------
// Quick :
// 1000 random :2573
// 1000 Duplicates :2256
// 1000 nearly ordered :2340
// 1000 reverse order :2587.3
// 1000 sorted : 2100
// 10000 random :30971.3
// ___________________________________________________________________________
// Merge Iterative  :
// 1000 random :159.3
// 1000 Duplicates :  148.3
// 1000 nearly ordered :158.6
// 1000 reverse order :153
// 1000 sorted : 55.2
// 10000 random :1490
// ___________________________________________________________________________
// Merge Recursive  :
// 1000 random :483.6
// 1000 Duplicates :486.3
// 1000 nearly ordered :567
// 1000 reverse order :574.3
// 1000 sorted :225.2
// 10000 random :2280.3
// ___________________________________________________________________________

//       a. Which of these sorting algorithms does the order of input have an impact on? Why?
//        Insertion sort as  it takes the min time ( Order of N ) when elements are already sorted and max time
//        when elements are sorted randomly or in reverse order
//
//
//        b. Which algorithm has the biggest difference between the best and worst performance, based
//        on the type of input, for the input of size 1000? Why?
//        Selection sort as it ( 1000 nearly ordered :4526 ) - (1000 sorted : 1200) = 3326
//        as when you increase the input size , the performance decreases
//
//
//        c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
//        based on the input size? Please consider only input files with random order for this answer.
//         Best - Merge Recursive
//         Worst - Selection

//        d. Did you observe any difference between iterative and recursive implementations of merge
//        sort?
//        yes , merge iterative was quicker than recursive

//        iterative was faster as it is simpler version of recursive and iteration implies less instructions
//        e. Which algorithm is the fastest for each of the 7 input files?
//        Merge Iterative for all 7 inputs
//
//



import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2020
 */
@RunWith(JUnit4.class)
public class SortComparisonTest {
    //~ Constructor ........................................................
    @Test
    public void testConstructor() {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------

    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty() {
        double[] emptyArray = {};
        assertEquals("Checking insertionSort for an empty array", emptyArray, SortComparison.insertionSort(emptyArray));
        assertEquals("Checking selectionSort for an empty array", emptyArray, SortComparison.selectionSort(emptyArray));
        assertEquals("Checking quickSort for an empty array", emptyArray, SortComparison.quickSort(emptyArray));
        assertEquals("Checking mergeSort for an empty array", emptyArray, SortComparison.mergeSortIterative(emptyArray));
        assertEquals("Checking mergeSort for an empty array", emptyArray, SortComparison.mergeSortRecursive(emptyArray));

    }

    @Test
    public void checkArray() {
        double[] a = {7, 4, 6, 3, 2, 8};
        assertEquals(" insertion sort ", "[2.0, 3.0, 4.0, 6.0, 7.0, 8.0]",
                Arrays.toString(SortComparison.insertionSort(a)));
        double[] a1 = {1, 2, 3, 4, 5, 6};
        assertEquals(" insertion sort ", "[1.0, 2.0, 3.0, 4.0, 5.0, 6.0]",
                Arrays.toString(SortComparison.insertionSort(a1)));
        double[] a2 = {6};
        assertEquals(" insertion sort ", "[6.0]",
                Arrays.toString(SortComparison.insertionSort(a2)));
        double[] a3 = {8, 2};
        assertEquals(" insertion sort ", "[2.0, 8.0]",
                Arrays.toString(SortComparison.insertionSort(a3)));


        double[] b = {9, 8, 7, 6, 5};
        assertEquals("selection sort ", "[5.0, 6.0, 7.0, 8.0, 9.0]",
                Arrays.toString(SortComparison.selectionSort(b)));
        double[] b1 = {1, 2, 3, 4, 5, 6};
        assertEquals(" insertion sort ", "[1.0, 2.0, 3.0, 4.0, 5.0, 6.0]",
                Arrays.toString(SortComparison.selectionSort(b1)));
        double[] b2 = {6};
        assertEquals(" insertion sort ", "[6.0]",
                Arrays.toString(SortComparison.selectionSort(b2)));
        double[] b3 = {8, 2};
        assertEquals(" insertion sort ", "[2.0, 8.0]",
                Arrays.toString(SortComparison.selectionSort(b3)));

        double[] c = {8, 4, 5, 5, 7, 9, 2, 8, 2, 1};
        assertEquals(" quick sort  ", "[1.0, 2.0, 2.0, 4.0, 5.0, 5.0, 7.0, 8.0, 8.0, 9.0]",
                Arrays.toString(SortComparison.quickSort(c)));
        double[] c1 = {1, 2, 3, 4, 5, 6};
        assertEquals(" insertion sort ", "[1.0, 2.0, 3.0, 4.0, 5.0, 6.0]",
                Arrays.toString(SortComparison.quickSort(c1)));
        double[] c2 = {6};
        assertEquals(" insertion sort ", "[6.0]",
                Arrays.toString(SortComparison.quickSort(c2)));
        double[] c3 = {8, 2};
        assertEquals(" insertion sort ", "[2.0, 8.0]",
                Arrays.toString(SortComparison.quickSort(c3)));


        double[] d = {6, 5, 4, 6, 9, 3, 3, 1, 2, 1};
        assertEquals(" merge sort iterative ", "[1.0, 1.0, 2.0, 3.0, 3.0, 4.0, 5.0, 6.0, 6.0, 9.0]",
                Arrays.toString(SortComparison.mergeSortIterative(d)));
        double[] d1 = {1, 2, 3, 4, 5, 6};
        assertEquals(" insertion sort ", "[1.0, 2.0, 3.0, 4.0, 5.0, 6.0]",
                Arrays.toString(SortComparison.mergeSortIterative(d1)));
        double[] d2 = {6};
        assertEquals(" insertion sort ", "[6.0]",
                Arrays.toString(SortComparison.mergeSortIterative(d2)));
        double[] d3 = {8, 2};
        assertEquals(" insertion sort ", "[2.0, 8.0]",
                Arrays.toString(SortComparison.mergeSortIterative(d3)));

        double[] e = {8, 8, 6, 6, 9, 7, 7, 1, 2, 1};
        assertEquals(" merge sort recursive ", "[1.0, 1.0, 2.0, 6.0, 6.0, 7.0, 7.0, 8.0, 8.0, 9.0]",
                Arrays.toString(SortComparison.mergeSortRecursive(e)));
        double[] e1 = {1, 2, 3, 4, 5, 6};
        assertEquals(" insertion sort ", "[1.0, 2.0, 3.0, 4.0, 5.0, 6.0]",
                Arrays.toString(SortComparison.mergeSortIterative(e1)));
        double[] e2 = {6};
        assertEquals(" insertion sort ", "[6.0]",
                Arrays.toString(SortComparison.mergeSortIterative(e2)));
        double[] e3 = {8, 2};
        assertEquals(" insertion sort ", "[2.0, 8.0]",
                Arrays.toString(SortComparison.mergeSortIterative(e3)));


    }
}



    // ----------------------------------------------------------

    /**
     * Main Method.
     * Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     */

   /*public static void main(String[] args) {
        File f = new File("numbersSorted10000.txt");
        double[] a = new double[1000];

      //insertionSort
       double[] array = Arrays.copyOf(a, a.length);
       long startTime = System.nanoTime();
       SortComparison.insertionSort(array);
       long endTime = System.nanoTime();
       long timePassed = endTime - startTime;
        System.out.println("Insertion sort : " + timePassed / 1000 + " ms");

       //selectionSort()
       double[] arraya = Arrays.copyOf(a, a.length);
       long startTimea = System.nanoTime();
       SortComparison.selectionSort(arraya);
       long endTimea = System.nanoTime();
       long timePassed1 = endTimea - startTimea;
        System.out.println("selection sort : " + timePassed1 / 1000 + " ms");

        //QuickSort
        double[] arrayc = Arrays.copyOf(a, a.length);
       long startTimec = System.nanoTime();
        SortComparison.quickSort(arrayc);
        long endTime3 = System.nanoTime();
        long timePassed3 = endTime3 - startTimec;
        System.out.println("quick sort : " + timePassed3 / 1000 + " ms");

        //mergeSort()
        double[] arrayb = Arrays.copyOf(a, a.length);
        long startTimeb = System.nanoTime();
        SortComparison.mergeSortRecursive(arrayb);
        long endTime2 = System.nanoTime();
        long timePassed2 = endTime2 - startTimeb;
        System.out.println("merge sort R : " + timePassed2 / 1000 + " ms");


        double[] arrayd = Arrays.copyOf(a, a.length);
        long startTimed = System.nanoTime();
        SortComparison.mergeSortIterative(arrayd);
        long endTime4 = System.nanoTime();
        long timePassed4 = endTime4 - startTimed;
       System.out.println("merge sort I : " + timePassed4 / 1000 + " ms");


 }
}*/