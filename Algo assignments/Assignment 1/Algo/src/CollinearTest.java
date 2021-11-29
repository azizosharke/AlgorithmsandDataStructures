import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

//-------------------------------------------------------------------------
/**
 *  Test class for Collinear.java
 *
 *  @author
 *  @version 18/09/18 12:21:26
 */
@RunWith(JUnit4.class)
public class CollinearTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new Collinear();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the two methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
        int expectedResult = 0;

        assertEquals("countCollinear failed with 3 empty arrays",
                expectedResult, Collinear.countCollinear(new int[0], new int[0], new int[0]));
        assertEquals("countCollinearFast failed with 3 empty arrays",
                expectedResult, Collinear.countCollinearFast(new int[0], new int[0], new int[0]));
    }

    // ----------------------------------------------------------
    /**
     * Check for no false positives in a single-element array
     */
    @Test
    public void testSingleFalse()
    {
        int[] a3 = { 15 };
        int[] a2 = { 5 };
        int[] a1 = { 10 };

        int expectedResult = 0;

        assertEquals("countCollinear({10}, {5}, {15})",
                expectedResult, Collinear.countCollinear(a1, a2, a3) );
        assertEquals("countCollinearFast({10}, {5}, {15})",
                expectedResult, Collinear.countCollinearFast(a1, a2, a3) );
    }

    // ----------------------------------------------------------
    /**
     * Check for no false positives in a single-element array
     */
    @Test
    public void testSingleTrue()
    {
        int[] a3 = { 15, 5 };
        int[] a2 = { 5 };
        int[] a1 = { 10, 15, 5 };

        int expectedResult = 1;

        assertEquals("countCollinear(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," +
                        Arrays.toString(a3) + ")",
                expectedResult, Collinear.countCollinear(a1, a2, a3));
        assertEquals("countCollinearFast(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," +
                        Arrays.toString(a3) + ")",
                expectedResult, Collinear.countCollinearFast(a1, a2, a3));
    }

    @Test
    public void testCollinearTwoIfEmpty() {
        int[] a3 = {};
        int[] a2 = { 55, 20 };
        int[] a1 = { 20, 40 };

        int expectedResult = 0;

        assertEquals("countCollinear failed with 1 empty array and 2 non-empty arrays", expectedResult,
                Collinear.countCollinear(a1, a2, a3));
        assertEquals("countCollinearFast failed with 1 empty array and 2 non-empty arrasy", expectedResult,
                Collinear.countCollinearFast(a1, a2, a3));
    }

    @Test
    public void testCollinearForMultipleFalse()
    {
        int[] a1 = { 35 ,20};
        int[] a2 = { 45 ,15};
        int[] a3 = { 55 ,30};
        int expectedResult = 1;

        assertEquals("countCollinear({10}, {5}, {15})",
                expectedResult, Collinear.countCollinear(a1, a2, a3) );
        assertEquals("countCollinearFast({10}, {5}, {15})",
                expectedResult, Collinear.countCollinearFast(a1, a2, a3) );
    }
    @Test
    public void testCountCollinearForMultipleTrue()
    {
        int[] a1 = { 10, 15, 5 };
        int[] a2 = { 5 , 10};
        int[] a3 = { 20,40 };

        int expectedResult = 0;

        assertEquals("countCollinear(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," +
                        Arrays.toString(a3) + ")",
                expectedResult, Collinear.countCollinear(a1, a2, a3));
        assertEquals("countCollinearFast(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," +
                        Arrays.toString(a3) + ")",
                expectedResult, Collinear.countCollinearFast(a1, a2, a3));
    }


    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.
// I added the MultipleFalse and MultipleTrue as well as the TestOneEmpty again
}
