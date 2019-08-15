import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<C> {
    private Node root;

    BinarySearchTree() {

        Node root = null;
    }
    public static class Node {
        public int key;
        public Node left;
        public Node right;
        public Node(int key, Node left, Node right) {
            this.key = key;
            this.left = left;
            this.right = right;

        }
    }
    /**
     * Inserts a key into this binary search tree.
     * If there are n nodes in the tree, then the average runtime of this method should be log(n).
     *
     * @param key The key to insert.
     */
    public void insert(int key) {
        // Please implement this method.
        insertHelper(root, key);
    }
    public void insertHelper(Node root, int key) {
        if (root.right == null && root.left == null) {
            if (key > root.key) {
                root.right = new Node(key, null, null);
            } else if (key < root.key) {
               root.left = new Node(key, null, null);
            }
        } else {
            if (key > root.key) {
                insertHelper(root.right, key);
            } else if (key < root.key) {
                insertHelper(root.left, key);
            }
        }
    }

    /**
     * Checks whether or not a key exists in this binary search tree.
     * If there are n nodes in the tree, then the average runtime of this method should be log(n).
     *
     * @param key The key to check for.
     * @return true if the key is present in this binary search tree, false otherwise.
     */
    public boolean find(int key) {
        // Please implement this method.
        return findHelper(root, key);
    }
    public boolean findHelper(Node root, int key) {
        if (root == null) {
            return false;
        } else if (key == root.key) {
            return true;
        } else if (key > root.key) {
            return findHelper(root.right, key);
        } else {
            return findHelper(root.left, key);
        }
    }

    public static void main(String[] args) {
        Node leftLeft = new Node(7, null, null);
        Node leftRight= new Node(13, null, null);
        Node left = new Node(10, leftLeft, leftRight);

        Node rightRightRight = new Node(99, null, null);
        Node rightRight = new Node(29, null, rightRightRight);
        Node rightLeft = new Node(18, null, null);
        Node right = new Node(21, rightLeft, rightRight);

        Node  root = new Node(16, left, right);

        BinarySearchTree bst = new BinarySearchTree();
        bst.root = root;



        System.out.println(bst.find(99));
    }
    public static List<Integer> printPreOrderTraversal(Node root) {
        List<Integer> treeList = new ArrayList<>();
        printHelperPreOrderTraversal(treeList, root);
        return treeList;
    }
    public static void printHelperPreOrderTraversal(List<Integer> treeList, Node root){
        if (root == null) {
            return;
        }
        treeList.add(root.key);
        printHelperPreOrderTraversal(treeList, root.left);
        printHelperPreOrderTraversal(treeList, root.right);
    }

}


