package org.example.leetcode;

public class n0538 {
    public TreeNode convertBST(TreeNode root) {
        traversal(root, 0);
        return root;
    }

    int traversal(TreeNode node, int prevSum) {
        if (node == null) {
            return prevSum;
        }

        prevSum = traversal(node.right, prevSum);
        prevSum += node.val;
        node.val = prevSum;
        return traversal(node.left, prevSum);
    }
}
