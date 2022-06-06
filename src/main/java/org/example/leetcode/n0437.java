package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

public class n0437 {

    private Map<Integer, Integer> prevSum;
    private int total = 0;
    private int targetSum;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        this.targetSum = targetSum;
        this.prevSum = new HashMap<>();
        prevSum.put(0, 1);
        backtrace(root, 0);
        return total;
    }

    void backtrace(TreeNode node, int curr) {
        if (node == null) {
            return;
        }
        curr += node.val;
        total += prevSum.getOrDefault(curr - this.targetSum, 0);
        prevSum.put(curr, prevSum.getOrDefault(curr, 0) + 1);
        backtrace(node.left, curr);
        backtrace(node.right, curr);
        prevSum.put(curr, prevSum.get(curr) - 1);
    }
}
