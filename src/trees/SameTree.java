package trees;

import java.util.*;

public class SameTree {


    public static void main(String[] ar) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(1);
        //root1.right = new TreeNode(3);


        TreeNode root2 = new TreeNode(1);
        root2.left = null;
        //root2.left = new TreeNode(1);
        root2.right = new TreeNode(1);

        System.out.println(isSameTree(root1, root2));


    }

    static public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Character> treeOrder1 = new ArrayList<>();
        List<Character> treeOrder2 = new ArrayList<>();
        List<Integer> list1 = inorderTraversal(p, treeOrder1);
        List<Integer> list2 = inorderTraversal(q, treeOrder2);
        int count = 0;
        if (list1.size() == list2.size()) {
            if (allElementsListInt(list1) && allElementsListInt(list2) && list1.get(0) == list2.get(0)) {
                return compareCharLists(treeOrder1, treeOrder2);
            }
            return compareIntegerLists(list1, list2);
        }
        return false;


    }

    static boolean allElementsListInt(List<Integer> list) {
        return list.stream().allMatch(e -> e.equals(list.get(0)));
    }

    static boolean compareCharLists(List<Character> list1, List<Character> list2) {
        int count = 0;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).equals(list2.get(i))) {
                count++;
            } else {
                break;
            }
        }
        return count == list1.size() ? true : false;

    }

    static boolean compareIntegerLists(List<Integer> list1, List<Integer> list2) {
        int count = 0;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).equals(list2.get(i))) {
                count++;
            } else {
                break;
            }
        }
        return count == list1.size() ? true : false;

    }

    static public List<Integer> inorderTraversal(TreeNode root, List<Character> treeOrder) {
        List<Integer> list = new ArrayList<>();
        recInOrder(list, root, treeOrder, 'n');
        return list;

    }

    static void recInOrder(List<Integer> list, TreeNode root, List<Character> treeOrder, Character c) {
        if (root == null) {
            return;
        }
        recInOrder(list, root.left, treeOrder, 'l');
        list.add(root.val);
        treeOrder.add(c);
        recInOrder(list, root.right, treeOrder, 'r');

    }


}
