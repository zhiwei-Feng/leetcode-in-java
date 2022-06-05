package org.example.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class n0129 {
    private int res = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    void dfs(TreeNode node, int curNum) {
        curNum = curNum*10+node.val;
        if (node.left==null&&node.right==null) res+=curNum;
        if (node.left!=null) dfs(node.left, curNum);
        if (node.right!=null) dfs(node.right, curNum);
    }
}
