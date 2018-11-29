package com.fishercoder.solutions;

import com.fishercoder.common.TreeNode;

import java.util.*;


/**
 * 662. Maximum Width of Binary Tree
 * <p>
 * Given a binary tree, write a function to get the maximum width of the given tree.
 * The width of a tree is the maximum width among all levels.
 * The binary tree has the same structure as a full binary tree, but some nodes are null.
 * The width of one level is defined as the length between the end-nodes
 * (the leftmost and right most non-null nodes in the level,
 * where the null nodes between the end-nodes are also counted into the length calculation.
 * <p>
 * Example 1:
 * Input:
 * <p>
 * 1
 * /   \
 * 3     2
 * / \     \
 * 5   3     9
 * <p>
 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 * <p>
 * Example 2:
 * Input:
 * <p>
 * 1
 * /
 * 3
 * / \
 * 5   3
 * <p>
 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2 (5,3).
 * <p>
 * Example 3:
 * Input:
 * <p>
 * 1
 * / \
 * 3   2
 * /
 * 5
 * <p>
 * Output: 2
 * Explanation: The maximum width existing in the second level with the length 2 (3,2).
 * Example 4:
 * Input:
 * <p>
 * 1
 * / \
 * 3   2
 * /     \
 * 5       9
 * /         \
 * 6           7
 * <p>
 * Output: 8
 * Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
 * <p>
 * Note: Answer MySolution in the range of 32-bit signed integer.
 */
public class _662 {
    /**
     * Use a map to store the node to value map,
     * we use root as index 1, then its left child is 2*i-1 and right child is 2*i
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<Map.Entry<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new AbstractMap.SimpleEntry<>(root, 1));
        int max = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Map.Entry<TreeNode, Integer>> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Map.Entry<TreeNode, Integer> curr = queue.poll();
                if (curr.getKey().left != null) {
                    Map.Entry<TreeNode, Integer> newEntry = new AbstractMap.SimpleEntry<>(curr.getKey().left, curr.getValue() * 2 - 1);
                    queue.offer(newEntry);
                    list.add(newEntry);
                }
                if (curr.getKey().right != null) {
                    Map.Entry<TreeNode, Integer> newEntry = new AbstractMap.SimpleEntry<>(curr.getKey().right, curr.getValue() * 2);
                    queue.offer(newEntry);
                    list.add(newEntry);
                }
            }
            if (list.size() > 1) {
                max = Math.max(list.get(list.size() - 1).getValue() - list.get(0).getValue() + 1, max);
            }
        }
        return max;
    }
}
