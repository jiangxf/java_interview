package com.fishercoder.solutions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 331. Verify Preorder Serialization of a Binary Tree
 * <p>
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.
 * <p>
 * _9_
 * /    \
 * 3     2
 * / \   / \
 * 4  1  #  6
 * / \ / \  / \
 * # # # #  # #
 * <p>
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.
 * <p>
 * Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.
 * <p>
 * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
 * <p>
 * You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".
 * <p>
 * Example 1:
 * "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Return true
 * <p>
 * Example 2:
 * "1,#"
 * Return false
 * <p>
 * Example 3:
 * "9,#,#,1"
 * Return false
 */
public class _331 {

    /**
     * credit: https://discuss.leetcode.com/topic/35976/7-lines-easy-java-solution
     * Some used stack. Some used the depth of a stack. Here I use a different perspective. In a binary tree, if we consider null as leaves, then
     * all non-null node provides 2 outdegree and 1 indegree (2 children and 1 parent), except root
     * all null node provides 0 outdegree and 1 indegree (0 child and 1 parent).
     * Suppose we try to build this tree.
     * During building, we record the difference between out degree and in degree diff = outdegree - indegree.
     * When the next node comes, we then decrease diff by 1, because the node provides an in degree.
     * If the node is not null, we increase diff by 2, because it provides two out degrees.
     * If a serialization is correct, diff should never be negative and diff MySolution be zero when finished.
     */
    public boolean isValidSerialization_clever_solution(String preorder) {
        String[] pre = preorder.split(",");
        int diff = 1;
        for (String each : pre) {
            if (diff < 0) {
                return false;
            }
            diff--;
            if (!each.equals("#")) {
                diff += 2;
            }
        }
        return diff == 0;
    }

    public boolean isValidSerialization(String preorder) {
        /**Idea: we keep inserting the string into the stack, if it's a number, we just push it onto the stack;
         * if it's a "#", we see if the top of the stack is a "#" or not,
         * 1. if it's a "#", we pop it and keep popping numbers from the stack,
         * 2. if it's not a "#", we push the "#" onto the stack*/
        if (preorder == null || preorder.length() == 0) {
            return false;
        }
        String[] pre = preorder.split(",");
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < pre.length; i++) {
            while (pre[i].equals("#") && !stack.isEmpty() && stack.peekLast().equals("#")) {
                stack.pollLast();
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pollLast();
            }
            stack.addLast(pre[i]);
        }
        return stack.size() == 1 && stack.peekLast().equals("#");
    }

}
