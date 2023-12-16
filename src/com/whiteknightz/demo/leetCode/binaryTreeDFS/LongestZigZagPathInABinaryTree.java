package com.whiteknightz.demo.leetCode.binaryTreeDFS;

import com.whiteknightz.demo.leetCode.TreeNode;

public class LongestZigZagPathInABinaryTree {
    int maxHeight = 0;

    public int longestZigZag(TreeNode root) {
        if (root==null){
            return 0;
        }
        longestDfs(root.left, 1, false);
        longestDfs(root.right, 1, true);
        return maxHeight;
    }

    private void longestDfs(TreeNode root, int currentHeight, boolean isRight) {
        if (root==null){
            return;
        }
        maxHeight = Math.max(maxHeight, currentHeight);

        if (isRight){
            longestDfs(root.left, currentHeight+1, false);
            longestDfs(root.right, 1, true);
        } else {
            longestDfs(root.right, currentHeight+1, true);
            longestDfs(root.left, 1, false);
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(1);

        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);

        root.right.left.left = new TreeNode(1);
        root.right.left.right = null;

        root.right.right.left = null;
        root.right.right.right = new TreeNode(1);

        root.right.left.left.left = new TreeNode(1);
        root.right.left.left.right = null;


        LongestZigZagPathInABinaryTree path = new LongestZigZagPathInABinaryTree();
        int result = path.longestZigZag(root);

        System.out.println(result);
    }
}
