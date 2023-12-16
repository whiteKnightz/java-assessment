package com.whiteknightz.demo.leetCode.binaryTreeDFS;

/*
    Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as
    the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */

import com.whiteknightz.demo.leetCode.TreeNode;

public class LowestCommonAncestorOfABinaryTree {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null || p==root || q==root){
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        if (leftNode!=null && rightNode!=null){
            return root;
        }

        return leftNode!=null?leftNode:rightNode;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode result = lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1));

        System.out.println(result);

    }
}
