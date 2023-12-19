package com.whiteknightz.demo.leetCode.binarySearchTree;

/*
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
 */

import com.whiteknightz.demo.leetCode.TreeNode;

import java.util.Objects;

public class DeleteNodeInABST {
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // Search for the node to be deleted
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children, get the in-order successor (smallest in the right subtree)
            root.val = findMinValue(root.right);

            // Delete the in-order successor
            root.right = deleteNode(root.right, root.val);
        }

        return root;
    }

    private static int findMinValue(TreeNode node) {
        int minValue = node.val;
        while (node.left != null) {
            minValue = node.left.val;
            node = node.left;
        }
        return minValue;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode treeNode = deleteNode(root, 3);

        System.out.println(Objects.nonNull(treeNode)?treeNode.val:"N/A");
    }
}
