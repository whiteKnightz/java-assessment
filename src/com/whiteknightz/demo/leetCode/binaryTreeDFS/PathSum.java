package com.whiteknightz.demo.leetCode.binaryTreeDFS;

import com.whiteknightz.demo.leetCode.TreeNode;

import java.util.ArrayList;

public class PathSum {
    public static int pathSum(TreeNode root, int targetSum) {
        return solve(root, targetSum, new ArrayList<>(), 0);
    }

    private static int solve(TreeNode root, int targetSum, ArrayList<TreeNode> path, long currentSum) {
        if (root == null) {
            return 0;
        }

        path.add(root);
        currentSum += root.val;

        int count = 0;
        long sum = 0;

        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i).val;
            if (sum == targetSum) {
                count++;
            }
        }

        count += solve(root.left, targetSum, path, currentSum);
        count += solve(root.right, targetSum, path, currentSum);

        path.remove(path.size() - 1);
        currentSum -= root.val;

        return count;

    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(10);
//        root.left = new TreeNode(5);
//        root.right = new TreeNode(-3);
//
//        root.left.right = new TreeNode(2);
//        root.left.left = new TreeNode(3);
//
//        root.left.left.left = new TreeNode(3);
//        root.left.left.right = new TreeNode(-2);
//        root.left.right.right = new TreeNode(1);
//
//        root.right.right = new TreeNode(11);


        TreeNode root = new TreeNode(1000000000);

        root.left = new TreeNode(1000000000);

        root.left.left = new TreeNode(294967296);
        root.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left.left = new TreeNode(1000000000);

        int result = pathSum(root, 0);

        System.out.println("Result:"+result);

    }
}
