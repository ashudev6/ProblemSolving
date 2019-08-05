package trees;

import java.util.ArrayList;
import java.util.List;

public class PreInPostOrderTraversalBinaryTree {

    public static void main(String[] ar) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = null;
        System.out.println("pre : " + preorderTraversal(root).toString());
        System.out.println("post : " + postorderTraversal(root).toString());
        System.out.println("in : " + inorderTraversal(root).toString());


    }

    static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recPreOrder(list, root);
        return list;
    }

    static void recPreOrder(List<Integer> list, TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        recPreOrder(list, root.left);
        recPreOrder(list, root.right);

    }

    static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recInOrder(list, root);
        return list;

    }

    static void recInOrder(List<Integer> list, TreeNode root) {
        if (root == null) return;
        recInOrder(list, root.left);
        list.add(root.val);
        recInOrder(list, root.right);

    }

    static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recPostOrder(list, root);
        return list;

    }

    static void recPostOrder(List<Integer> list, TreeNode root) {
        if (root == null) return;
        recPostOrder(list, root.left);
        recPostOrder(list, root.right);
        list.add(root.val);

    }


}
