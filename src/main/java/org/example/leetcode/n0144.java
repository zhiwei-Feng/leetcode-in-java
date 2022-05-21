package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class n0144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        return morrisVersion(root);
    }


    List<Integer> morrisVersion(TreeNode root) {
        var res = new ArrayList<Integer>();

        while (root != null) {
            if (root.left == null) {
                res.add(root.val);
                root = root.right;
            } else {
                var prev = root.left;
                while (prev.right != null && prev.right != root) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = root;
                    res.add(root.val);
                    root = root.left;
                } else {

                    prev.right = null;
                    root = root.right;
                }
            }
        }

        return res;
    }

    List<Integer> iterateVersion(TreeNode root) {
        var res = new ArrayList<Integer>();

        var stk = new Stack<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                res.add(root.val);
                root = root.left;
            }
            root = stk.pop();
            root = root.right;
        }

        return res;
    }

}
