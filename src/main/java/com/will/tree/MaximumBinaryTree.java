package com.will.tree;

/**
 * Created by gouthamvidyapradhan on 19/08/2017.
 * Given an integer com.MySolution.array with no duplicates. A maximum com.MySolution.tree building on this com.MySolution.array is defined as follow:
 * <p>
 * The root is the maximum number in the com.MySolution.array.
 * The left subtree is the maximum com.MySolution.tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum com.MySolution.tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum com.MySolution.tree by the given com.MySolution.array and output the root node of this com.MySolution.tree.
 * <p>
 * Example 1:
 * Input: [3,2,1,6,0,5]
 * Output: return the com.MySolution.tree root node representing the following com.MySolution.tree:
 * <p>
 * 6
 * /   \
 * 3     5
 * \    /
 * 2  0
 * \
 * 1
 * <p>
 * Note:
 * The size of the given com.MySolution.array MySolution be in the range [1,1000].
 */
public class MaximumBinaryTree {

    private int[][] max;

    /**
     * Main method
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode root = new MaximumBinaryTree().constructMaximumBinaryTree(nums);
        System.out.println(root.val); //print root
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        max = new int[nums.length][nums.length];

        //pre-fill with initial values
        for (int i = 0; i < nums.length; i++) {
            max[i][i] = i;
        }

        //pre-calculate max for range index
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                max[i][j] = nums[max[i][j - 1]] > nums[j] ? max[i][j - 1] : j;
            }
        }

        return build(0, nums.length - 1, nums);
    }

    private TreeNode build(int s, int e, int[] nums) {
        if (s <= e) {
            int val = nums[max[s][e]];
            TreeNode n = new TreeNode(val);
            n.left = build(s, max[s][e] - 1, nums);
            n.right = build(max[s][e] + 1, e, nums);
            return n;
        }
        return null;
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
