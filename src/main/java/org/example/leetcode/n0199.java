package org.example.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class n0199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if (root != null) q.add(root);
        while (!q.isEmpty()) {
            var levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                var curNode = q.poll();
                if (i == levelSize - 1) res.add(curNode.val);
                if (curNode.left != null) q.add(curNode.left);
                if (curNode.right != null) q.add(curNode.right);
            }
        }
        return res;
    }
}
