package com.fishercoder.solutions;

/**
 * Created by fishercoder on 4/23/17.
 */

import com.fishercoder.common.TreeNode;

/**
 * Binary Tree Tilt
 * <p>
 * Given a binary tree, return the tilt of the whole tree.
 * <p>
 * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values.
 * Null node has tilt 0.
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 * <p>
 * Example:
 * Input:
 * 1
 * /   \
 * 2     3
 * <p>
 * Output: 1
 * <p>
 * Explanation:
 * Tilt of node 2 : 0
 * Tilt of node 3 : 0
 * Tilt of node 1 : |2-3| = 1
 * Tilt of binary tree : 0 + 0 + 1 = 1
 * <p>
 * Note:
 * The sum of node values in any subtree won't exceed the range of 32-bit integer.
 * All the tilt values won't exceed the range of 32-bit integer.
 */
public class _563 {

    int tilt = 0;

    public int findTilt(TreeNode root) {
        findTiltDfs(root);
        return tilt;
    }

    public int findTiltDfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftTilt = 0;
        if (root.left != null) {
            leftTilt = findTiltDfs(root.left);
        }
        int rightTilt = 0;
        if (root.right != null) {
            rightTilt = findTiltDfs(root.right);
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        tilt += Math.abs(leftTilt - rightTilt);
        return leftTilt + rightTilt + root.val;
    }

}
