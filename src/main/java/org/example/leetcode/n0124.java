package org.example.leetcode;

public class n0124 {
    private int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return this.maxPath;
    }

    int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        var leftGain = Math.max(maxGain(node.left), 0);
        var rightGain = Math.max(maxGain(node.right), 0);
        var curGain = Math.max(leftGain, rightGain) + node.val;

        var curPath = leftGain + node.val + rightGain;
        this.maxPath = Math.max(this.maxPath, curPath);

        return curGain;
    }
}
