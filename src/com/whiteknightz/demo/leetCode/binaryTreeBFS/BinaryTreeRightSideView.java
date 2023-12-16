package com.whiteknightz.demo.leetCode.binaryTreeBFS;

import com.whiteknightz.demo.leetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
    Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes
    you can see ordered from top to bottom.
 */
public class BinaryTreeRightSideView {

    public static List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root==null){
            return result;
        }
        bfs(root, result);
        return result;
    }

    private static void bfs(TreeNode root, ArrayList<Integer> values) {
        if (root==null){
            return;
        }
        values.add(root.val);
        if (root.right!=null){
            bfs(root.right, values);
        } else if (root.left!=null){
            bfs(root.left, values);
        }
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
