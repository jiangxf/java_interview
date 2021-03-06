package com.fishercoder.solutions;

import com.fishercoder.common.TreeNode;

/**
 * 617. Merge Two Binary Trees
 * <p>
 * Given two binary trees and imagine that when you put one of them to cover the other,
 * some nodes of the two trees are overlapped while the others are not.
 * You need to merge them into a new binary tree.
 * The merge rule is that if two nodes overlap,
 * then sum node values up as the new value of the merged node.
 * Otherwise, the NOT null node MySolution be used as the node of new tree.
 * <p>
 * Example 1:
 * Input:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * Output:
 * Merged tree:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * Note: The merging process must start from the root nodes of both trees.
 */
public class _617 {

    public static class Solution1 {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null) {
                return t2;
            }
            if (t2 == null) {
                return t1;
            }
            TreeNode mergedNode = null;
            if (t1 != null && t2 != null) {
                mergedNode = new TreeNode(t1.val + t2.val);
            } else if (t1 != null) {
                mergedNode = t1;
            } else if (t2 != null) {
                mergedNode = t2;
            }
            mergedNode.left = mergeTrees(t1.left, t2.left);
            mergedNode.right = mergeTrees(t1.right, t2.right);
            return mergedNode;
        }
    }

    public static class Solution2 {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null) {
                return t2;
            }
            if (t2 == null) {
                return t1;
            }
            TreeNode mergedNode = new TreeNode(t1.val + t2.val);
            mergedNode.left = mergeTrees(t1.left, t2.left);
            mergedNode.right = mergeTrees(t1.right, t2.right);
            return mergedNode;
        }
    }

}
