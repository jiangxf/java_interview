package com.will.tree;

/**
 * Created by gouthamvidyapradhan on 18/10/2017.
 * <p>
 * Given a binary com.will.tree, you need to compute the length of the diameter of the com.will.tree. The diameter of a binary com.will.tree is
 * the length of the longest path between any two nodes in a com.will.tree. This path may or may not pass through the root.
 * <p>
 * Example:
 * Given a binary com.will.tree
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p>
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBinaryTree {

    private int max = 0;

    /**
     * Main method
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(root));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node != null) {
            int left = dfs(node.left);
            int right = dfs(node.right);
            max = Math.max(max, left + right);
            return left > right ? left + 1 : right + 1;
        }
        return 0;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
