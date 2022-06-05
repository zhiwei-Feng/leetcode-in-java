package org.example.leetcode;

public class n0814 {
    public TreeNode pruneTree(TreeNode root) {
        var isOneInRoot = dfs(root);
        if (!isOneInRoot) return null;
        else return root;
    }

    boolean dfs(TreeNode node) {
        if (node == null) return false;
        var isOneInLeft = dfs(node.left);
        var isOneInRight = dfs(node.right);

        if (!isOneInLeft) node.left = null;
        if (!isOneInRight) node.right = null;

        return !(node.left == null && node.right == null && node.val == 0);
    }
}
