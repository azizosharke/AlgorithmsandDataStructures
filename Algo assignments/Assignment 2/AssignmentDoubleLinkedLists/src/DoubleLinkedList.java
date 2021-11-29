import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author
 *  @version 09/10/18 11:13:22
 */

/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 *
 * @param <T> This is a type parameter. T is used as a class name in the
 *            definition of this class.
 *
 *            When creating a new DoublyLinkedList, T should be instantiated
 *            with an actual class name that extends the class Comparable. Such
 *            classes include String and Integer.
 *
 *            For example to create a new DoublyLinkedList class containing
 *            String data: DoublyLinkedList<String> myStringList = new
 *            DoublyLinkedList<String>();
 *
 *            The class offers a toString() method which returns a
 *            comma-separated sting of all elements in the data structure.
 *
 *            This is a bare minimum class you would need to completely
 *            implement. You can add additional methods to support your code.
 *            Each method will need to be tested by your jUnit tests -- for
 *            simplicity in jUnit testing introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>> {

    /**
     * private class DLLNode: implements a *generic* Doubly Linked List node.
     */
    private class DLLNode {
        public final T data; // this field should never be updated. It gets its
        // value once from the constructor DLLNode.
        public DLLNode next;
        public DLLNode prev;

        /**
         * Constructor
         *
         * @param theData  : data of type T, to be stored in the node
         * @param prevNode : the previous Node in the Doubly Linked List
         * @param nextNode : the next Node in the Doubly Linked List
         * @return DLLNode
         */
        public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) {
            data = theData;
            prev = prevNode;
            next = nextNode;
        }
    }

    // Fields head and tail point to the first and last nodes of the list.
    private DLLNode head, tail;

    /**
     * Constructor of an empty DLL
     *
     * @return DoublyLinkedList
     */
    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Tests if the doubly linked list is empty
     *
     * @return true if list is empty, and false otherwise
     *
     *         Worst-case asymptotic running time cost: O(1)
     *
     *         Justification:   for this method it requires looking and checking the head once which give us Theta(1)
     */
    public boolean isEmpty() {
        if (head == null)
            return true;
        else
            return false;
    }

    /**
     * Inserts an element in the doubly linked list
     *
     * @param pos  : The integer location at which the new data should be inserted
     *             in the list. We assume that the first position in the list is 0
     *             (zero). If pos is less than 0 then add to the head of the list.
     *             If pos is greater or equal to the size of the list then add the
     *             element at the end of the list.
     * @param data : The new data of class T that needs to be added to the list
     * @return none
     *
     *         Worst-case asymptotic running time cost: O(N)
     *
     *         Justification: for this method we scan via the whole list one time as it is the worst case running
     */
    public void insertBefore(int pos, T data) {
        DLLNode insertion;
        insertion = new DLLNode(data, null, null);
        if (isEmpty()) {  // as here if it is empty it will be directed to make a new one **
            head =  insertion;
            tail =  insertion;
        } else {
            if (pos < 0) {                          // <0 to add the head of the list
                insertion.next = head;
                head.prev =  insertion;
                head =  insertion;
            } else {                           // to find the new position in the data and loop until it reaches the pos
                int j = 0;
                DLLNode node = head;
                while (j < pos && node.next != null) {
                    node = node.next;
                    j++;
                }
                if (j == pos) {
                    if (pos == 0) {
                        insertion.next = head;
                        head.prev =  insertion;
                        head =  insertion;
                    } else {
                        insertion.prev = node.prev;
                        node.prev.next =  insertion;
                        node.prev =  insertion;
                        insertion.next = node;

                    }
                } else {
                    insertion.prev = tail;
                    tail.next =  insertion;
                    tail = insertion;
                }
            }
        }
        return;
    }

    /**
     * Returns the data stored at a particular position
     *
     * @param pos : the position
     * @return the data at pos, if pos is within the bounds of the list, and null
     *         otherwise.
     *
     *         Worst-case asymptotic running time cost: O(N)
     *
     *         Justification: as the worst case time Theta(N) as we have is else statements and a for loop in which is
     *         required for the data to be back and returned that is why this method as a worst case asymptotic running
     *         time cost of O(N)
     */
    public T get(int pos)                     // two cases if <0 or >0 and loop to  reach the node
    {

        if(pos < 0) {
            return null;
        }

        T doubleList = null;
        DLLNode node = head;
        for(int posFinder=0; posFinder < pos; posFinder++) {
            if( node != null && node.next != null) {
                node = node.next;
            }
            else {
                return null;
            }
        }
        if (node == null) {
            return null;
        }
        doubleList  = node.data;
        return  doubleList ;
    }


    /**
     * Deletes the element of the list at position pos. First element in the list
     * has position 0. If pos points outside the elements of the list then no
     * modification happens to the list.
     *
     * @param pos : the position to delete in the list.
     * @return true : on successful deletion, false : list has not been modified.
     *
     *         Worst-case asymptotic running time cost: O(N)
     *
     *         Justification:  as I have a linear do while loop in which tail = pos and it will go through the whole
     *         list
     */
    public boolean deleteAt(int pos) {      // loop to find the position so it can be deleted
        boolean deletedNode = false;       // in the list if head = tail , we have one element
        boolean nodeFound  =true;          // sometimes the elements that are removed are neither head nor tail
                                          // so I should make sure of that
        if (isEmpty()) {
            return deletedNode;
        } else {
            if (pos < 0) {
                return deletedNode;
            } else {
                int positionDelete = 0;
                DLLNode newNode = head;
                if (positionDelete < pos && newNode.next != null) {
                    do {
                        newNode = newNode.next;
                        positionDelete++;
                    } while (positionDelete < pos && newNode.next != null);
                }
                if (positionDelete == pos) {
                    if (head.next == null) {
                        head = null;
                        tail = null;
                    } else if (newNode == head) {
                        head.next.prev = null;
                        head = head.next;
                    } else if (newNode == tail) {
                        tail.prev.next = null;
                        tail = tail.prev;
                    } else {
                        newNode.next.prev = newNode.prev;
                        newNode.prev.next = newNode.next;
                    }
                    return  nodeFound;
                } else {
                    return deletedNode;
                }
            }
        }
    }

    /**
     * Reverses the list. If the list contains "A", "B", "C", "D" before the method
     * is called Then it should contain "D", "C", "B", "A" after it returns.
     *
     * Worst-case asymptotic running time cost: O(N)
     *
     * Justification:  in which I did a linear while loop which iterates the whole list and reveres it
     * in which this linear while loop has as asymptotic running time of O(N)
     */
    public void reverse() {
        DLLNode prevReverse;
        prevReverse = null;
        DLLNode nextReverse;
        nextReverse = head;
        DLLNode node;
        node = tail;
        tail = head;
        head = node;
        while (nextReverse != null) {
            DLLNode nextNode = nextReverse.next;
            nextReverse.next = prevReverse;
            nextReverse.prev = nextNode;
            prevReverse = nextReverse;
            nextReverse = nextNode;
        }
    }

    /**
     * Removes all duplicate elements from the list. The method should remove the
     * _least_number_ of elements to make all elements unique. If the list contains
     * "A", "B", "C", "B", "D", "A" before the method is called Then it should
     * contain "A", "B", "C", "D" after it returns. The relative order of elements
     * in the resulting list should be the same as the starting list.
     *
     * Worst-case asymptotic running time cost: O(N^2)
     *
     * Justification: I used a do while loop to compare the data between the 2 elements in a DLL.
     * and iterate via all the elements and this gives the rise to a worst case running time of O(N^2)
     *
     */
    public void makeUnique() {
        if (isEmpty()) {
        } else {
            DLLNode uniqueA = head;
            if (uniqueA != null && uniqueA.next != null) {
                do {
                    DLLNode uniqueB = uniqueA.next;
                    while (uniqueB != null) {
                        if (uniqueB.data.equals(uniqueA.data)) {
                            if (uniqueB.next == null) {
                                uniqueB.prev.next = null;
                                tail = uniqueB.prev;
                                uniqueB = uniqueB.next;
                            } else {
                                DLLNode node = uniqueB;
                                uniqueB = uniqueB.next;
                                node.next.prev = node.prev;
                                node.prev.next = node.next;
                            }
                        } else {
                            uniqueB = uniqueB.next;
                        }
                    }
                    uniqueA = uniqueA.next;
                } while (uniqueA != null && uniqueA.next != null);
            }
        }
    }






    /*----------------------- STACK API
     * If only the push and pop methods are called the data structure should behave like a stack.
     */

    /**
     * This method adds an element to the data structure. How exactly this will be
     * represented in the Doubly Linked List is up to the programmer.
     *
     * @param item : the item to push on the stack
     *
     *             Worst-case asymptotic running time cost: O(1)
     *
     *             Justification: it will add the element to the end of the list as this method will run once
     *             regardless of the input size
     */
    public void push(T item) {
        DLLNode pushNode = new DLLNode(item, null, null); // constructor
        if (isEmpty()) {
            head =  pushNode;
            tail =  pushNode;
        } else {
            tail.next =  pushNode;
            pushNode.prev = tail;
            tail = pushNode;
        }
    }

    /**
     * This method returns and removes the element that was most recently added by
     * the push method.
     *
     * @return the last item inserted with a push; or null when the list is empty.
     *
     *         Worst-case asymptotic running time cost: O(1)
     *
     *         Justification: this method deletes the last element
     */
    public T pop() {
        if (tail == null || tail.prev != null) {
            if (tail != null) {
                DLLNode node = tail;
                tail = tail.prev;
                tail.next = null;
                return node.data;
            } else {
                return null;
            }
        } else {
            DLLNode nodePop = tail;
            head = null;
            tail = null;
            return nodePop.data;
        }
    }

    /*----------------------- QUEUE API
     * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
     */

    /**
     * This method adds an element to the data structure. How exactly this will be
     * represented in the Doubly Linked List is up to the programmer.
     *
     * @param item : the item to be enqueued to the stack
     *
     *             Worst-case asymptotic running time cost: O(1)
     *
     *             Justification: it will only run one time as it will add the element to the end of the list.
     */
    public void enqueue(T item) {
        DLLNode node;
        node = new DLLNode(item, null, null);
        if (!isEmpty()) {
            tail.next = node;
            node.prev = tail;
            tail = node;
        } else {
            head = node;
            tail = node;
        }
    }

    /**
     * This method returns and removes the element that was least recently added by
     * the enqueue method.
     *
     * @return the earliest item inserted with an enqueue; or null when the list is
     *         empty.
     *
     *         Worst-case asymptotic running time cost: O(1)
     *
     *         Justification: it will only run one time as it will delete the element to the end of the list.
     */

    public T dequeue() {
        if (head == null || head.next != null) {
            if (head != null) {
                DLLNode node = head;
                head = head.next;
                head.prev = null;
                return node.data;
            } else {
                return null;
            }
        } else {
            DLLNode node = head;
            head = null;
            tail = null;
            return node.data;
        }
    }

    /**
     * @return a string with the elements of the list as a comma-separated list,
     *         from beginning to end
     *
     *         Worst-case asymptotic running time cost: Theta(n)
     *
     *         Justification: We know from the Java documentation that
     *         StringBuilder's append() method runs in Theta(1) asymptotic time. We
     *         assume all other method calls here (e.g., the iterator methods above,
     *         and the toString method) will execute in Theta(1) time. Thus, every
     *         one iteration of the for-loop will have cost Theta(1). Suppose the
     *         doubly-linked list has 'n' elements. The for-loop will always iterate
     *         over all n elements of the list, and therefore the total cost of this
     *         method will be n*Theta(1) = Theta(n).
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        boolean isFirst = true;

        // iterate over the list, starting from the head
        for (DLLNode iter = head; iter != null; iter = iter.next) {
            if (!isFirst) {
                s.append(",");
            } else {
                isFirst = false;
            }
            s.append(iter.data.toString());
        }

        return s.toString();
    }

}
