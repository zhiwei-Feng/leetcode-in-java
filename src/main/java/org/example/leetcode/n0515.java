package org.example.leetcode;

import java.util.*;

public class n0515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if (root!=null) q.add(root);
        while (!q.isEmpty()) {
            var levelSize = q.size();
            var curMax = Integer.MIN_VALUE;
            for (int i = 0; i < levelSize; i++) {
                var curNode = q.poll();
                curMax = Math.max(curMax, curNode.val);
                if (curNode.left != null) q.add(curNode.left);
                if (curNode.right != null) q.add(curNode.right);
            }
            res.add(curMax);
        }
        return res;
    }
}
