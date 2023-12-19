package com.whiteknightz.demo.leetCode.binaryTreeBFS;

import com.whiteknightz.demo.leetCode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/*
    Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

    Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 */
public class MaximumLevelSumOfABinaryTree {
    public static int maxLevelSum(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.singletonList(root.val));
        bfs(root, result, 1);
        int maxLevel = 0, maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < result.size(); i++) {
            List<Integer> list = result.get(i);
            if (list.size()>0){
                int currSum = 0;
                for(int val: list){
                    currSum+=val;
                }
                if (currSum>maxVal){
                    maxLevel=i;
                    maxVal=currSum;
                }
            }
        }
        return maxLevel+1;
    }

    private static void bfs(TreeNode root, List<List<Integer>> result, int currentHeight) {
        if (root==null){
            return;
        }
        List<Integer> list = new ArrayList<>();
        if (result.size()>currentHeight){
            list.addAll(result.get(currentHeight));
        }
        if (root.left!=null){
            list.add(root.left.val);
        }
        if (root.right!=null){
            list.add(root.right.val);
        }
        if (result.size()>currentHeight){
            result.set(currentHeight, list);
        } else {
            result.add(list);
        }
        bfs(root.left, result, currentHeight+1);
        bfs(root.right, result, currentHeight+1);
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(7);
//        root.right = new TreeNode(0);
//
//        root.left.left = new TreeNode(7);
//        root.left.right = new TreeNode(-8);


        TreeNode root = new TreeNode(-100);
        root.left = new TreeNode(-200);
        root.right = new TreeNode(-300);

        root.left.left = new TreeNode(-20);
        root.left.right = new TreeNode(-5);
        root.right.left = new TreeNode(-10);

        int result = maxLevelSum(root);

        System.out.println("Result is:"+result);
    }
}
