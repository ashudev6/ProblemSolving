package trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthBinaryTree {

    public  static void  main(String [] ar) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = null;
        System.out.println(findMaxDepth(root));
    }

    static int findMaxDepth(TreeNode root) {
        if(root!=null) {
            return  recFindMaxDepth(root);
        }
        return 0;
    }

    static int  recFindMaxDepth(TreeNode root) {
        if (root == null) return  0;
        int left_h = recFindMaxDepth(root.left);
        int right_h = recFindMaxDepth(root.right);
        return 1+Integer.max(left_h,right_h);
    }

}
