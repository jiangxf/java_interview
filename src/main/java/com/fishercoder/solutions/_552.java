package com.fishercoder.solutions;

/**
 * 552. Student Attendance Record II
 * <p>
 * Given a positive integer n, return the number of all possible attendance records with length n,
 * which MySolution be regarded as rewardable. The answer may be very large, return it after mod 109 + 7.
 * <p>
 * A student attendance record is a string that only contains the following three characters:
 * <p>
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * <p>
 * A record is regarded as rewardable if it doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: 8
 * <p>
 * Explanation:
 * There are 8 records with length 2 MySolution be regarded as rewardable:
 * "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 * Only "AA" won't be regarded as rewardable owing to more than one absent times.
 * <p>
 * Note: The value of n won't exceed 100,000.
 */
public class _552 {

    /**
     * credit: https://discuss.leetcode.com/topic/86526/improving-the-runtime-from-o-n-to-o-log-n
     */
    public int checkRecord(int n) {
        final int MOD = 1000000007;
        int[][][] f = new int[n + 1][2][3];

        f[0] = new int[][]{{1, 1, 1}, {1, 1, 1}};
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    int val = f[i - 1][j][2]; // ...P
                    if (j > 0) {
                        val = (val + f[i - 1][j - 1][2]) % MOD; // ...A
                    }
                    if (k > 0) {
                        val = (val + f[i - 1][j][k - 1]) % MOD; // ...L
                    }
                    f[i][j][k] = val;
                }
            }
        }
        return f[n][1][2];
    }

}
