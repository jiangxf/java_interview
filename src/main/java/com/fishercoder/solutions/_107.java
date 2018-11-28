package com.fishercoder.solutions;

import com.fishercoder.common.TreeNode;

import java.util.*;

/**
 * 107. Binary Tree Level Order Traversal II
 * <p>
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * return its bottom-up level order traversal as:
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */

public class _107 {
    public static class Solution1 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList();
            if (root == null) {
                return result;
            }

            Queue<TreeNode> q = new LinkedList();
            q.offer(root);
            while (!q.isEmpty()) {
                List<Integer> thisLevel = new ArrayList<Integer>();
                int qSize = q.size();
                for (int i = 0; i < qSize; i++) {
                    TreeNode curr = q.poll();
                    thisLevel.add(curr.val);
                    if (curr.left != null) {
                        q.offer(curr.left);
                    }
                    if (curr.right != null) {
                        q.offer(curr.right);
                    }
                }
                result.add(thisLevel);
            }
            Collections.reverse(result);
            return result;
        }
    }
}
