/*************************************************************************
 *  Binary Search Tree class.
 *  Adapted from Sedgewick and Wayne.
 *
 *
 *
 *  @author Abdelaziz Abushark
 *
 *************************************************************************/

import java.security.Key;
import java.text.MessageFormat;
import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST

    /**
     * Private node class.
     */
    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int N;             // number of nodes in subtree

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    // is the symbol table empty?
    public boolean isEmpty() { return size() == 0; }

    // return number of key-value pairs in BST
    public int size() { return size(root); }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    /**
     *  Search BST for given key.
     *  Does there exist a key-value pair with given key?
     *
     *  @param key the search key
     *  @return true if key is found and false otherwise
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    /**
     *  Search BST for given key.
     *  What is the value associated with given key?
     *
     *  @param key the search key
     *  @return value associated with the given key if found, or null if no such key exists.
     */
    public Value get(Key key) { return get(root, key); }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }

    /**
     *  Insert key-value pair into BST.
     *  If key already exists, update with new value.
     *
     *  @param key the key to insert
     *  @param val the value associated with key
     */
    public void put(Key key, Value val) {
        if (val == null) { delete(key); return; }
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    /**
     * Tree height.
     *
     * Asymptotic worst-case running time using Theta notation:Theta(N) as the operations are running in a constant time
     * which is O(1) and the method will have to look through the nodes of the tree as it starts from the top to the
     * bottom which later returns height of the tree as it will go through the edges and return the larger side
     * between right and left nodes
     * so that is why it is = Theta(N) as it is Theta(N)*Theta(1) = Theta(N)
     *
     * @return the number of links from the root to the deepest leaf.
     *
     * Example 1: for an empty tree this should return -1.
     * Example 2: for a tree with only one node it should return 0.
     * Example 3: for the following tree it should return 2.
     *   B
     *  / \
     * A   C
     *      \
     *       D
     */
    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node != null) {
            return 1 + Math.max(height(node.left), height(node.right));
        }
        return -1;
    }
    /**
     * Median key.
     * If the tree has N keys k1 < k2 < k3 < ... < kN, then their median key 
     * is the element at position (N+1)/2 (where "/" here is integer division)
     *
     * @return the median key, or null if the tree is empty.
     */

    public Key median() {
        if (isEmpty())
            return null;
        return median(this.root, (this.root.N + 1) / 2);
    }
    private Key median(Node nodeTree, int integer) {
        int position = size(nodeTree.left) + 1;
        if (position != integer) {
            if (position > integer)
                return median(nodeTree.left, integer);
            else
                return median(nodeTree.right, integer - position);
        } else {
            return nodeTree.key;
        }
    }




    /**
     * Print all keys of the tree in a sequence, in-order.
     * That is, for each node, the keys in the left subtree should appear before the key in the node.
     * Also, for each node, the keys in the right subtree should appear before the key in the node.
     * For each subtree, its keys should appear within a parenthesis.
     *
     * Example 1: Empty tree -- output: "()"
     * Example 2: Tree containing only "A" -- output: "(()A())"
     * Example 3: Tree:
     *   B
     *  / \
     * A   C
     *      \
     *       D
     *
     * output: "((()A())B(()C(()D())))"
     *
     * output of example in the assignment: (((()A(()C()))E((()H(()M()))R()))S(()X()))
     *
     * @return a String with all keys in the tree, in order, parenthesized.
     */

    public String printKeysInOrder() {
        if (isEmpty())
            return "()";
        return printKeysInOrder(this.root);
    }

    private String printKeysInOrder(Node nodeTree) {
        if (nodeTree != null) {
            return "(" + printKeysInOrder(nodeTree.left) + nodeTree.key +
                    printKeysInOrder(nodeTree.right) + ")";
        } else {
            return "()";
        }
    }



    /**
     * Pretty Printing the tree. Each node is on one line -- see assignment for details.
     *
     * @return a multi-line string with the pretty ascii picture of the tree.
     */
    public String prettyPrintKeys() {
        StringBuilder add;
        add = new StringBuilder();
        prettyPrint(root, "", add);
        String s = add.toString();
        return s;
    }

    private void prettyPrint(Node nodeTree, String prefix, StringBuilder add) {
        if (nodeTree != null) {
            add.append(prefix);
            StringBuilder append;
            append = add.append("-");
            StringBuilder append1;
            append1 = add.append(nodeTree.key);
            StringBuilder append2;
            append2 = add.append("\n");
            prettyPrint(nodeTree.left, prefix + " |", add);
            prettyPrint(nodeTree.right, prefix + "  ", add);
        } else {
            StringBuilder append;
            append = add.append(prefix).append("-null\n");
        }
    }
    /**
     * Deteles a key from a tree (if the key is in the tree).
     * Note that this method works symmetrically from the Hibbard deletion:
     * If the node to be deleted has two child nodes, then it needs to be
     * replaced with its predecessor (not its successor) node.
     *
     * @param key the key to delete
     */
    public void delete(Key key) {

            root = delete(root, key);

    }


    private Node delete(Node thenode, Key key) {
        if (thenode != null) {
            int input = key.compareTo(thenode.key);
            if (input > 0)
                thenode.right = delete(thenode.right, key);
            else if  (input < 0)
                thenode.left = delete(thenode.left, key);
            else {
                if (thenode.right == null)
                    return thenode.left;


                Node node = thenode;
                thenode = setMax(node.left);
                thenode.left = deleteMax(node.left);
                thenode.right = node.right;
            }
            thenode.N = size(thenode.left) + size(thenode.right) + 1;
            return thenode;
        } else {
            return null;
        }
    }


    private Node setMax(Node node) {
        if (node.right != null) {
            return setMax(node.right);
        } else {
            return node;
        }
    }

    private Node deleteMax(Node node) {
        if (node.right != null) {
            node.right = deleteMax(node.right);
            node.N = 1 + size(node.left) + size(node.right);
            return node;
        } else {
            return node.left;
        }
    }
}