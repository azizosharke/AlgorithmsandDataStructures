import java.util.Arrays;
public class Collinear {

// -------------------------------------------------------------------------
/**
 *  This class contains only two static methods that search for points on the
 *  same line in three arrays of integers.
 *
 *  @author
 *  @version 18/09/18 12:21:09
 */


    // ----------------------------------------------------------

    /**
     * Counts for the number of non-horizontal lines that go through 3 points in arrays a1, a2, a3.
     * This method is static, thus it can be called as Collinear.countCollinear(a1,a2,a3)
     *
     * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.
     * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain.
     * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain.
     * @return the number of points which are collinear and do not lie on a horizontal line.
     * <p>
     * Array a1, a2 and a3 contain points on the horizontal line y=1, y=2 and y=3, respectively.
     * A non-horizontal line will have to cross all three of these lines. Thus
     * we are looking for 3 points, each in a1, a2, a3 which lie on the same
     * line.
     * <p>
     * Three points (x1, y1), (x2, y2), (x3, y3) are collinear (i.e., they are on the same line) if
     * <p>
     * x1(y2âˆ’y3)+x2(y3âˆ’y1)+x3(y1âˆ’y2)=0
     * <p>
     * In our case y1=1, y2=2, y3=3.
     * <p>
     * You should implement this using a BRUTE FORCE approach (check all possible combinations of numbers from a1, a2, a3)
     * <p>
     * ----------------------------------------------------------
     * <p>
     * <p>
     * Order of Growth
     * -------------------------
     * <p>
     * Calculate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     * You should adequately explain your answer. Answers without adequate explanation will not be counted.
     * <p>
     * Order of growth: N^3
     * <p>
     * Explanation: 3 linear for loops as it checks all the possible combinations of numbers from the 3 arrays.
     */
    static int countCollinear(int[] a1, int[] a2, int[] a3) {

        final int FIRST_NUMBER = 3 - 1;
        final int SECOND_NUMBER = 2 - 3;
        final int THIRD_NUMBER = 1 - 2;

        int countLoop = 0;// to count the number of points which are collinear and do not lie on a horizontal line.
        for (int k : a1) {   // loop to go all the first array which is a1
            for (int j : a2) { // loop to go for the 2nd array which is a2
                for (int m : a3) { // loop to go for the 3rd array which is a3
                    if ((k * (SECOND_NUMBER)) + ((j * (FIRST_NUMBER))) + (m * (THIRD_NUMBER)) == 0) {
                        //  x1(y2-y3)+x2(y3-y1)+x3(y1-y2)=0
                        countLoop++; // to count the number of points which are collinear and do not lie on a horizontal line.

                    }


                }
            }

        }
        return countLoop;
    }

    // ----------------------------------------------------------
    /**
     * Counts for the number of non-horizontal lines that go through 3 points in arrays a1, a2, a3.
     * This method is static, thus it can be called as Collinear.countCollinearFast(a1,a2,a3)
     * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.
     * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain.
     * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain.
     * @return the number of points which are collinear and do not lie on a horizontal line.
     *
     * In this implementation you should make non-trivial use of InsertionSort and Binary Search.
     * The performance of this method should be much better than that of the above method.
     *
     *
     *  Order of Growth
     *  -------------------------
     *
     *  Calculate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of Growth: n^2 * logN
     *
     *  Explanation: this method contains 2 for loops for the 1st and the 2nd array in which it checks all the
     *  possible combination of numbers of these 2 arrays  then it uses the binary search method which
     *  I implemented to check and look if the number we are looking for is in the 3rd array
     *
     *
     */


    static int countCollinearFast(int[] a1, int[] a2, int[] a3) {
        final int ONE = -1;
        final int TWO = 2;
        Collinear.sort(a1);
        Collinear.sort(a2);
        Collinear.sort(a3);

        int countTimes = 0;
        for (int m : a1) {
            for (int n : a2) {
                int thirdArray = ONE*(m) + n * TWO; // x3*(y1−y2) = -x1*(y2−y3) - x2*(y3−y1)
                if (Collinear.binarySearch(a3, thirdArray)) {
                    countTimes++;
                }
            }
        }
        return countTimes;
    }


    // ----------------------------------------------------------
    /**
     * Sorts an array of integers according to InsertionSort.
     * This method is static, thus it can be called as Collinear.sort(a)
     * @param a: An UNSORTED array of integers.
     * @return after the method returns, the array must be in ascending sorted order.
     *
     * ----------------------------------------------------------
     *
     *  Order of Growth
     *  -------------------------
     *
     *  Calculate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of Growth: N^2
     *
     *  Explanation: Two linear for-loops.
     *
     */
    static void sort ( int[] a)
    {
        for (int j = 1; j < a.length; j++) {
            int i = j - 1;
            while (i >= 0 && a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
                i--;
            }
        }
    }

    // ----------------------------------------------------------
    /**
     * Searches for an integer inside an array of integers.
     * This method is static, thus it can be called as Collinear.binarySearch(a,x)
     * @param a: A array of integers SORTED in ascending order.
     * @param x: An integer.
     * @return true if 'x' is contained in 'a'; false otherwise.
     *
     * ----------------------------------------------------------
     *
     *  Order of Growth
     *  -------------------------
     *
     *  Calculate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of Growth: O(logN)
     *
     *  Explanation: binary search continuously reduces the array till find the number as each time it runs
     *  via the loop the elements would halve which causes the time complexity to be Log2N
     *
     */
    static boolean binarySearch ( int[] a, int x)
    {
        int lo =0 ;
        int hi = a.length-1;
        while ( lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (x < a[mid]) {
                hi = mid - 1;
            }
            else if (x > a[mid]) {
                lo = mid + 1;
            }
            else {
                return true;
            }
        }
        return false;
    }


}





