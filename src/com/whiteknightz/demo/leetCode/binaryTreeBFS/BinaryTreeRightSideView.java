package com.whiteknightz.demo.leetCode.binaryTreeBFS;

import com.whiteknightz.demo.leetCode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes
    you can see ordered from top to bottom.
 */
public class BinaryTreeRightSideView {

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int rightmostValue = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                rightmostValue = current.val;

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            result.add(rightmostValue);
        }

        return result;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = null;
//        root.left.right = new TreeNode(5);
//        root.right.left = null;
//        root.right.right = new TreeNode(4);


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        List<Integer> integers = rightSideView(root);

        System.out.println("Result:");
        for (int i: integers){
            System.out.println(i);
        }
    }
}
