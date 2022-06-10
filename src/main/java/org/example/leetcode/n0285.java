package org.example.leetcode;

public class n0285 {


    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode cur = root;
        TreeNode next = null;
        while (cur != null) {
            if (cur.val > p.val) {
                next = cur;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return next;
    }
}
