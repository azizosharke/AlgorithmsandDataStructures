import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *
 *  @author  Abdelaziz Abushark
 */

@RunWith(JUnit4.class)
public class BSTTest
{

    @Test
    public void testHeight() {
        BST<Integer, Integer> bst = new BST<Integer, Integer>();
        assertEquals("Getting the height of the tree",-1, bst.height());
        bst.put(4, 4);
        assertEquals("Getting the height of the tree",0, bst.height());
        bst.put(5, 5);
        bst.put(8, 8);
        bst.put(13,13);
        bst.put(6, 6);
        assertEquals(3, bst.height());
        bst.put(18, 18);
        bst.put(14, 14);
        bst.put(13, 13);
        assertEquals("Getting the height of the tree",5, bst.height());
    }


    @Test
    public void testMedian() {
        BST<Integer, Integer> bst = new BST<Integer, Integer>();
        assertNull(bst.median());
        assertEquals("Checking median of constructed tree", null, bst.median());
        bst.put(7, 7);
        assertTrue(bst.median().equals(7));
        bst.put(8, 8);
        bst.put(5, 5);
        bst.put(14, 14);
        bst.put(12, 12);
        assertTrue(bst.median().equals(8));
        bst = new BST<Integer, Integer>();
        bst.put(17, 17);
        bst.put(28, 28);
        bst.put(14, 14);
        bst.put(8, 8);
        bst.put(7, 7);
        bst.put(10, 10);
        assertTrue(bst.median().equals(10));
    }



    /** <p>Test {@link BST#prettyPrintKeys()}.</p> */

    @Test
    public void testPrettyPrint() {
        BST<Integer, Integer> bst = new BST<Integer, Integer>();
        assertEquals("Checking pretty printing of empty tree",
                "-null\n", bst.prettyPrintKeys());

        //  -7
        //   |-3
        //   | |-1
        //   | | |-null
        bst.put(7, 7);       //   | |  -2
        bst.put(8, 8);       //   | |   |-null
        bst.put(3, 3);       //   | |    -null
        bst.put(1, 1);       //   |  -6
        bst.put(2, 2);       //   |   |-4
        bst.put(6, 6);       //   |   | |-null
        bst.put(4, 4);       //   |   |  -5
        bst.put(5, 5);       //   |   |   |-null
        //   |   |    -null
        //   |    -null
        //    -8
        //     |-null
        //      -null

        String result =
                "-7\n" +
                        " |-3\n" +
                        " | |-1\n" +
                        " | | |-null\n" +
                        " | |  -2\n" +
                        " | |   |-null\n" +
                        " | |    -null\n" +
                        " |  -6\n" +
                        " |   |-4\n" +
                        " |   | |-null\n" +
                        " |   |  -5\n" +
                        " |   |   |-null\n" +
                        " |   |    -null\n" +
                        " |    -null\n" +
                        "  -8\n" +
                        "   |-null\n" +
                        "    -null\n";
        assertEquals("Checking pretty printing of non-empty tree", result, bst.prettyPrintKeys());
    }


    /** <p>Test {@link BST#delete(Comparable)}.</p> */
    @Test
    public void testDelete() {
        BST<Integer, Integer> bst = new BST<Integer, Integer>();
        bst.delete(1);
        assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());

        bst.put(7, 7);   //        _7_
        bst.put(8, 8);   //      /     \
        bst.put(3, 3);   //    _3_      8
        bst.put(1, 1);   //  /     \
        bst.put(2, 2);   // 1       6
        bst.put(6, 6);   //  \     /
        bst.put(4, 4);   //   2   4
        bst.put(5, 5);   //        \
        //         5

        assertEquals("Checking order of constructed tree",
                "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());

        bst.delete(9);
        assertEquals("Deleting non-existent key",
                "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());

        bst.delete(8);
        assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());

        bst.delete(6);
        assertEquals("Deleting node with single child",
                "(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());

        bst.delete(3);
        assertEquals("Deleting node with two children",
                "(((()1())2(()4(()5())))7())", bst.printKeysInOrder());
    }

    @Test
    public void testPrintKeysInOrder() {
        BST<Integer, Integer> bst = new BST<Integer, Integer>();
        assertEquals("Checking pretty printing of empty tree","()", bst.printKeysInOrder());
        bst.put(5, 5);
        assertEquals("Checking pretty printing of non empty tree\"","(()5())", bst.printKeysInOrder());
        bst.put(9, 9);
        bst.put(17, 17);
        bst.put(6,6);
        bst.put(20, 20);
        bst.put(10, 10);
        assertEquals("Checking pretty printing of non empty tree\"","(()5((()6())9((()10())17(()20()))))", bst.printKeysInOrder());
        bst = new BST<Integer, Integer>();
        bst.put(7, 7);
        bst.put(6, 6);
        bst.put(5, 5);
        assertEquals("Checking pretty printing of non empty tree\"","(((()5())6())7())", bst.printKeysInOrder());
        bst = new BST<Integer, Integer>();
        bst.put(60, 60);
        bst.put(80, 80);
        bst.put(30, 30);
        assertEquals("Checking pretty printing of non empty tree\"","((()30())60(()80()))", bst.printKeysInOrder());
    }



    @Test
    public void testGet() {
        BST<Integer, Integer> bst = new BST<Integer, Integer>();

        bst.put(10, 10);
        bst.put(30, 30);
        bst.put(15, 15);
        bst.put(35, 35);
        bst.put(20, 20);
        bst.put(40, 40);
        bst.put(25, 25);
        bst.put(45, 45);


        assertEquals("what is the value of the node associated with key 30 ? ", "30", bst.get(30).toString());
        assertEquals("what is the value of the node associated with key 25 ? ", "25", bst.get(25).toString());
        assertEquals("what is the value of the node associated with key 45 ? ", "45", bst.get(45).toString());
        assertNull(  "what is the value of the node associated with key 14 ? ", bst.get(14));
    }

    @Test
    public void testPut() {
        BST<Integer, Integer> bst = new BST<Integer, Integer>();

        bst.put(30, null);
        assertEquals("what is the outcome for put when the value is NULL ? ", "()",  bst.printKeysInOrder());
        bst.put(30, 30);
        bst.put(30, 30);
        assertEquals("what is the outcome for put when the value is 30  and it was added twice  ? ", "(()30())",  bst.printKeysInOrder());
        bst.put(20, 20);
        assertEquals("what is the outcome for put when the value is 20  and it was added once   ? ", "((()20())30())",  bst.printKeysInOrder());
        bst.put(50, 50);
        assertEquals("what is the outcome for put when the value is 50  and it was added once   ? ", "((()20())30(()50()))",  bst.printKeysInOrder());

    }


    @Test
    public void testContains() {
        BST<Integer, Integer> bst = new BST<Integer, Integer>();

        bst.put(9, 9);
        bst.put(3, 3);
        bst.put(1, 1);
        bst.put(5, 5);
        bst.put(0, 0);


        assertFalse("Does tree has element  9 ? ", bst.contains(10));
        assertTrue("Does tree has element  9  ?", bst.contains(9));
    }


}
