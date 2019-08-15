public class BinarySearchTreePhoneBook  implements  PhoneBook{
    private Node<PhoneRecord> root;
    private int size;
    public BinarySearchTreePhoneBook(){
        root = null;
    }
    public static class Node<T> {
        public int key;
        public Node<T> left;
        public Node<T> right;
        public Node(int key, Node<T> left, Node<T> right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public void insert(String name, long phoneNumber) {
        PhoneRecord pr = new PhoneRecord(name, phoneNumber);
        insertHelper(root, pr);
    }

    public void insertHelper(Node<PhoneRecord> root, PhoneRecord pr) {
        if (root == null) {
            root = new Node<>(root.key, null, null);
            size++;
        } else if (pr.name.compareTo(String.valueOf(root.key)) > 0) {
            insertHelper(root.right, pr);
        } else if (pr.name.compareTo(String.valueOf(root.key)) < 0) {
            insertHelper(root.left, pr);
        }
    }

    @Override
    public long find(String name) {
        return findHelper(root, name);
    }
    public long findHelper(Node<PhoneRecord> root, String name) {
        if (root == null) {
            return 0;
        } else if (name == (String.valueOf(root.key))) {
            return root.key;
        } else if (name.compareTo(String.valueOf(root.key)) > 0) {
            return findHelper(root.right, name);
        } else {
            return findHelper(root.left, name);
        }
    }

    public static class PhoneRecord {
        public String name;
        public long number;
        public PhoneRecord(String name, long number) {
            this.name = name;
            this.number = number;
        }
    }

    public static void main(String[] args) {
        BinarySearchTreePhoneBook bst = new BinarySearchTreePhoneBook();
        bst.insert("ABC", 1111111111);
        bst.insert("XYZ", 999999999);
        bst.insert("DEF", 222222222);

        System.out.println(bst.size);
    }

}
