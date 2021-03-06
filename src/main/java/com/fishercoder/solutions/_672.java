package com.fishercoder.solutions;

import com.fishercoder.utils.CommonUtils;

/**
 * 672. Bulb Switcher II
 * There is a room with n lights which are turned on initially and 4 buttons on the wall.
 * After performing exactly m unknown operations towards buttons,
 * you need to return how many different kinds of status of the n lights could be.
 * Suppose n lights are labeled as number [1, 2, 3 ..., n], function of these 4 buttons are given below:
 * <p>
 * Flip all the lights.
 * Flip lights with even numbers.
 * Flip lights with odd numbers.
 * Flip lights with (3k + 1) numbers, k = 0, 1, 2, ...
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1, m = 1.
 * Output: 2
 * Explanation: Status can be: [on], [off]
 * <p>
 * Example 2:
 * <p>
 * Input: n = 2, m = 1.
 * Output: 3
 * Explanation: Status can be: [on, off], [off, on], [off, off]
 * <p>
 * Example 3:
 * <p>
 * Input: n = 3, m = 1.
 * Output: 4
 * Explanation: Status can be: [off, on, off], [on, off, on], [off, off, off], [off, on, on].
 * <p>
 * Note: n and m both fit in range [0, 1000].
 */
public class _672 {
    public static class Solution1 {
        public int flipLights(int n, int m) {
            if (m < 1) {
                return 1;
            }
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (j == 0) {
                        dp[i][j] = 2;
                    } else if (i == 0 && j == 1) {
                        dp[i][j] = 3;
                    } else if (i == 0) {
                        dp[i][j] = 4;
                    } else if (i == 1 && j == 1) {
                        dp[i][j] = 4;
                    } else if (i == 1 && j > 1) {
                        dp[i][j] = 7;
                    } else if (j == 1) {
                        dp[i][j] = 4;
                    } else if (i == 1) {
                        dp[i][j] = 7;
                    } else {
                        dp[i][j] = 8;
                    }
                }
            }
            CommonUtils.print2DIntArray(dp);
            return dp[m - 1][n - 1];
        }
    }

    public static class Solution2 {
        public int flipLights(int n, int m) {
            if (n == 1 && m > 0) {
                return 2;
            } else if (n == 2 && m == 1) {
                return 3;
            } else if ((n > 2 && m == 1) || (n == 2 && m > 1)) {
                return 4;
            } else if (n > 2 && m == 2) {
                return 7;
            } else if (n > 2 && m > 2) {
                return 8;
            } else {
                return 1;
            }
        }
    }
}
