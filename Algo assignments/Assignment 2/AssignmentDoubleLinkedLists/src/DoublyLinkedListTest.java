import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *
 *
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */
    @Test
    public void testInsertBefore()
    {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
    }

    // TODO: add more tests here. Each line of code in DoublyLinkedList.java should
    // be executed at least once from at least one test.

    @Test
    public void testDeleteAt() {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        assertEquals("Checking deleteAt to a list containing zero elements at position 0 ", false,
                testDLL.deleteAt(0));
        testDLL.insertBefore(0, 1);
        assertEquals("Checking deleteAt to a list containing one elements at position 0", true,
                testDLL.deleteAt(0));
        testDLL.insertBefore(0, 1);
        testDLL.insertBefore(1, 2);
        assertEquals("Checking deleteAt to a list containing two elements at position 0 ", true,
                testDLL.deleteAt(0));
        assertEquals("Checking deleteAt to a list containing one elements at position 0 ", true,
                testDLL.deleteAt(0));
        testDLL.insertBefore(0, 1);
        testDLL.insertBefore(1, 2);
        testDLL.insertBefore(2, 3);
        testDLL.insertBefore(3, 4);
        assertEquals("Checking deleteAt to a list containing four elements at position -1 ", false,
                testDLL.deleteAt(-1));
        assertEquals("Checking deleteAt to a list containing four elements at position 1 ", true,
                testDLL.deleteAt(1));
        assertEquals("Checking deleteAt to a list containing three elements at position 2 ", true,
                testDLL.deleteAt(2));
        assertEquals("Checking deleteAt to a list containing two elements at position 9", false,
                testDLL.deleteAt(9));
        assertEquals("Checking deleteAt to a list containing one elements 1", "1,3", testDLL.toString());
    }
    @Test
    public void testGet() {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        assertEquals("Checking get to a list containing zero elements at position 0 ", null,
                testDLL.get(0));
        testDLL.insertBefore(0, 1);
        testDLL.insertBefore(1, 2);
        testDLL.insertBefore(2, 3);
        assertEquals("Checking get to a list containing three elements at position -1", null,
                testDLL.get(-1));
        assertEquals("Checking get to a list containing three elements at position 0 ", Integer.valueOf(1),
                testDLL.get(0));
        assertEquals("Checking get to a list containing three elements at position 2 ", Integer.valueOf(3),
                testDLL.get(2));
        assertEquals("Checking get to a list containing three elements at position 8 ", null,
                testDLL.get(8));
    }
    @Test
    public void testPush() {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.push(6);
        testDLL.push(7);
        testDLL.push(8);
        assertEquals("Checking push to a list containing three elements ", "6,7,8", testDLL.toString());
    }

    @Test
    public void testEnqueue() {
        DoublyLinkedList<Character> testDLL = new DoublyLinkedList<Character>();
        testDLL.enqueue('X');
        testDLL.enqueue('Y');
        testDLL.enqueue('Z');
        assertEquals("Checking enqueue to a list containing three elements ", "X,Y,Z",
                testDLL.toString());
    }


    @Test
    public void testReverse() {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0, 1);
        testDLL.insertBefore(1, 2);
        testDLL.reverse();
        assertEquals("Checking reverse to a list containing two elements ", "2,1", testDLL.toString());
    }
    @Test
    public void testDequeue() {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();

        testDLL.enqueue(1);
        testDLL.enqueue(2);
        testDLL.enqueue(3);
        testDLL.enqueue(4);
        testDLL.enqueue(5);
        testDLL.enqueue(6);


        testDLL.dequeue();
        assertEquals( "Checking dequeue with 6 elements", "2,3,4,5,6", testDLL.toString() );
        testDLL.dequeue();
        assertEquals( "Checking dequeue with 5 elements", "3,4,5,6", testDLL.toString() );
        testDLL.dequeue();
        assertEquals( "Checking dequeue with 4 elements", "4,5,6", testDLL.toString() );
        testDLL.dequeue();
        assertEquals( "Checking dequeue with 3 elements", "5,6", testDLL.toString() );
        testDLL.dequeue();
        assertEquals( "Checking dequeue with 2 element", "6", testDLL.toString() );
        testDLL.dequeue();
        assertEquals( "Checking dequeue with 1 elements", "", testDLL.toString() );


        testDLL.dequeue();
        assertEquals( "Checking dequeue with 0 elements", "", testDLL.toString() );

    }




    @Test
    public void testPopA() {  // one element
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.push(1);
        assertEquals("Checking pop to a list containing one elements ", Integer.valueOf(1), testDLL.pop());
        assertEquals("Checking pop to a list containing one elements ", "", testDLL.toString());
    }


    @Test
    public void testMakeUniqueB() {  // zero elements and six elements (1,2,3,4,5,6)
        DoublyLinkedList<Character> testDLL = new DoublyLinkedList<Character>();
        testDLL.makeUnique();
        assertEquals("Checking makeUnique to a list containing zero elements ", "", testDLL.toString());
        testDLL.insertBefore(0, 'A');
        testDLL.insertBefore(1, 'B');
        testDLL.insertBefore(2, 'C');
        testDLL.insertBefore(3, 'B');
        testDLL.insertBefore(4, 'D');
        testDLL.insertBefore(5, 'A');
        testDLL.makeUnique();
        assertEquals("Checking makeUnique to a list containing six elements ", "A,B,C,D",
                testDLL.toString());
    }
    @Test
    public void testPopB() {  // 0 elements and 3 elements (3,2,1)
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        assertEquals("Checking pop to a list containing zero elements ", null, testDLL.pop());
        testDLL.push(4);
        testDLL.push(5);
        testDLL.push(6);
        assertEquals("Checking pop to a list containing three elements", Integer.valueOf(6), testDLL.pop());
        assertEquals("Checking pop to a list containing three elements ", "4,5", testDLL.toString());
    }
    @Test
    public void testMakeUniqueA() {  // 1 element
        DoublyLinkedList<String> testDLL = new DoublyLinkedList<String>();
        testDLL.insertBefore(0, "test");
        testDLL.insertBefore(1, "test");
        testDLL.makeUnique();
        assertEquals("Checking makeUnique to a list containing two elements ", "test", testDLL.toString());
    }
    @Test
    public void testReverseB() {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(2, 3);
        testDLL.insertBefore(4, 5);
        testDLL.reverse();
        assertEquals("Checking reverse to a list containing two elements ", "5,3", testDLL.toString());
    }

}
