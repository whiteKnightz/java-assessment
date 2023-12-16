package com.whiteknightz.demo.leetCode.binaryTreeDFS;

/*
    Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with
    a value greater than X.


    Return the number of good nodes in the binary tree.
 */


import com.whiteknightz.demo.leetCode.TreeNode;

public class CountGoodNodesInBinaryTree {
    public static int goodNodes(TreeNode root) {
        if (root==null){
            return 0;
        }

        return dfs(root, Integer.MIN_VALUE);
    }

    private static int dfs(TreeNode root, int maxVal) {
        if (root==null){
            return 0;
        }
        int count = maxVal<=root.val?1:0;

        maxVal = Math.max(maxVal, root.val);

        count += dfs(root.left, maxVal);
        count += dfs(root.right, maxVal);
        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        int result = goodNodes(root);

        System.out.println("Result:"+result);

    }
}
