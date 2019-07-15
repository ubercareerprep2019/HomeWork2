public class BinarySearchTree {
    private Node root;

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
        if (find(key)) {
            return;
        }
        Node curr = new Node(key, null, null);
        if (curr.key > root.key) {
            insertHelper(curr.right, key);
        } else if (curr.key < root.key) {
            insertHelper(curr.left, key);
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
        Node current = new Node(key, null, null);
        if (root.key == current.key) {
            return true;
        } else if (current.key > root.key) {
            findHelper(current.right, key);
        } else if (current.key < root.key) {
            findHelper(current.left, key);
        }
        return false;
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
    public static void main(String[] args) {
        Node leftLeft = new Node(7, null, null);
        Node leftRight = new Node(13, null, null);
        Node left = new Node(10, leftLeft, leftRight);
        Node rightRightRight = new Node(99, null, null);
        Node rightLeft = new Node(18, null, null);
        Node rightRight = new Node(29, null, rightRightRight);
        Node right = new Node(21, rightLeft, rightRight);
        Node root = new Node(16, left, right);

    }


}


