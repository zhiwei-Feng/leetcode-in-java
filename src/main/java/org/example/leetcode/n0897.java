package org.example.leetcode;

public class n0897 {
    class LinkList {
        TreeNode head;
        TreeNode tail;
    }

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        return dfs(root).head;
    }

    LinkList dfs(TreeNode node) {
        LinkList list = new LinkList();
        if (node.left == null) {
            list.head = node;
            list.tail = node;
        } else {
            var leftList = dfs(node.left);
            list.head = leftList.head;
            leftList.tail.right = node;
            list.tail = node;
            node.left = null;
        }
        if (node.right == null) {
            return list;
        } else {
            var rightList = dfs(node.right);
            node.right = rightList.head;
            list.tail = rightList.tail;
            return list;
        }
    }
}
