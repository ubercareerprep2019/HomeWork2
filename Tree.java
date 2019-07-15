import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Tree {
    public TreeNode root;

    public Tree(TreeNode root) {
        this.root = root;
    }
    public static void main(String[] args) {
        TreeNode leftChild = new TreeNode(6, null, null);
        TreeNode rightChild = new TreeNode(3, null, null);
        TreeNode left = new TreeNode(7, null, null);
        TreeNode right = new TreeNode(17, leftChild, rightChild);
        TreeNode root = new TreeNode(1, left, right);
        Tree tree = new Tree(root);

        System.out.println(printPreOrderTraversal(root));
        System.out.println(printInOrderTraversal(root));
        System.out.println(printPostOrderTraversal(root));

    }
    public static class TreeNode {
        public int data;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static List<Integer> printPreOrderTraversal(TreeNode root) {
        List<Integer> treeList = new ArrayList<>();
        printHelperPreOrderTraversal(treeList, root);
        return treeList;
    }
    public static void printHelperPreOrderTraversal(List<Integer> treeList, TreeNode root){
        if (root == null) {
            return;
        }
        treeList.add(root.data);
        printHelperPreOrderTraversal(treeList, root.left);
        printHelperPreOrderTraversal(treeList, root.right);
    }

    public static List<Integer> printInOrderTraversal(TreeNode root) {
        List<Integer> treeList = new ArrayList<>();
        printHelperInOrderTraversal(treeList, root);
        return treeList;
    }
    public static void printHelperInOrderTraversal(List<Integer> treeList, TreeNode root){
        if (root == null) {
            return;
        }
        printHelperInOrderTraversal(treeList, root.left);
        treeList.add(root.data);
        printHelperInOrderTraversal(treeList, root.right);
    }

    public static List<Integer> printPostOrderTraversal(TreeNode root) {
        List<Integer> treeList = new ArrayList<>();
        printHelperPostOrderTraversal(treeList, root);
        return treeList;
    }
    public static void printHelperPostOrderTraversal(List<Integer> treeList, TreeNode root){
        if (root == null) {
            return;
        }
        printHelperPostOrderTraversal(treeList, root.left);
        printHelperPostOrderTraversal(treeList, root.right);
        treeList.add(root.data);

    }
}
