package com.whiteknightz.demo.leetCode.binaryTreeDFS;

import com.whiteknightz.demo.leetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
    Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value
    sequence.



    For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

    Two binary trees are considered leaf-similar if their leaf value sequence is the same.

    Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.


 */
public class LeafSimilarTrees {
    private static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1==null && root2==null){
            return true;
        }

        List<Integer> firstLeaves = dfs(root1, new ArrayList<>());
        List<Integer> secondLeaves = dfs(root2, new ArrayList<>());

        return firstLeaves.equals(secondLeaves);
    }

    private static List<Integer> dfs(TreeNode root, List<Integer> leaves) {
        if (root.left==null && root.right==null){
            leaves.add(root.val);
            return leaves;
        }
        if (root.left!=null){
            dfs(root.left, leaves);
        }
        if (root.right!=null){
            dfs(root.right, leaves);
        }
        return leaves;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);

        boolean result = leafSimilar(root1, root2);

        System.out.println("Result:"+result);

    }
}
