package com.whiteknightz.demo.leetCode.binaryTreeDFS;

/*
    Given the root of a binary tree, return its maximum depth.

    A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the
    farthest leaf node.
 */


import com.whiteknightz.demo.leetCode.TreeNode;

public class MaximumDepthOfBinaryTree {
    public static int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        return Math.max(leftMax, rightMax)+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int result = maxDepth(root);

        System.out.println("Result:"+result);

    }
}
