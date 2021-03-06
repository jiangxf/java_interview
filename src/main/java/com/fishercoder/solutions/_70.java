package com.fishercoder.solutions;

/**
 * 70. Climbing Stairs
 * <p>
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n MySolution be a positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output:  2
 * Explanation:  There are two ways to climb to the top.
 * <p>
 * 1. 1 step + 1 step
 * 2. 2 steps
 * <p>
 * Example 2:
 * <p>
 * Input: 3
 * Output:  3
 * Explanation:  There are three ways to climb to the top.
 * <p>
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */

public class _70 {
    public static class Solution1 {
        //classical dp problem
        public int climbStairs(int n) {
            if (n < 1) {
                return 0;
            } else if (n < 4) {
                return n;
            } else {
                int[] dp = new int[n + 1];
                //the number of ways to reach step n could be calculated from n-1 and n-2
                dp[1] = 1;
                dp[2] = 2;
                for (int i = 3; i <= n; i++) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
                return dp[n];
            }
        }
    }
}
