package com.whiteknightz.demo.leetCode.binarySearchTree;

import com.whiteknightz.demo.leetCode.TreeNode;

import java.util.Objects;

/*
    You are given the root of a binary search tree (BST) and an integer val.

    Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a
    node does not exist, return null.
 */
public class SearchABinarySearchTree {
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root==null){
            return null;
        } else if (root.val==val){
            return root;
        }
        if (root.val>val){
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode treeNode = searchBST(root, 2);

        System.out.println(Objects.nonNull(treeNode)?treeNode.val:"N/A");
    }
}
