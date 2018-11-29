/*
Description
Given a m x n grid filled with non-negative numbers,
find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Notice
You can only move either down or right at any point in time.

Example:
[[1,3,1],
 [1,5,1],
 [4,2,1]]
Given the above grid map, return 7. Because the path 1��3��1��1��1 minimizes the sum.

Tags
Dynamic Programming
 */

/**
 * Approach 1: Matrix DP
 * �� Unique Paths ���ƣ������� ����DP �Ļ����⡣
 * ���վ���̬�滮˼·���н��⡣
 * ���Ƚ���һ����ά����dp[].
 * State: dp[i][j]��ʾ�� ��� �� ����(i, j) ����С·����
 * Function: ͬһʱ���ڿ�������������ƶ�һ��
 * dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + A[i][j];
 * Initialize:	����ɵ����Ϊ���Ͻǣ���������һ����ά���飬�ɵ�����㵽�������ϲ��Ե�����·����Ϊ��
 * dp[0][0] = A[0][0]
 * dp[i][0] = sum(0,0 -> i,0)
 * dp[0][i] = sum(0,0 -> 0,i)
 * Answer:	���½�Ϊ�յ��Ϊ dp[rows - 1][cols - 1].
 * <p>
 * ʱ�临�Ӷȣ�O(mn)�� �ռ临�Ӷȣ�O(mn)
 */
public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0
                || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];

        //  Initialize
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < cols; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        //  Function
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        //  Answer
        return dp[rows - 1][cols - 1];
    }
}

/**
 * Approach 2: Matrix DP (Optimized by Sliding Array)
 * �� Approach 1 �еķ����ɵã�
 * dp[i][j] ������ ��һ�е�Ԫ��ֵ �� ǰһ��Ԫ��ֵ����ࣩ ��������
 * ������ǿ������� �������� ���� �ռ临�Ӷ� �����Ż���
 * ����״̬���̷����ɵã�����ֻ��Ҫ�洢 ���еĽ�� ���ɡ�
 * <p>
 * ʱ�临�Ӷȣ�O(mn)�� �ռ临�Ӷȣ�O(n)
 */
public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0
                || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[2][cols];

        //  Initialize the first row of dp array
        dp[0][0] = grid[0][0];
        for (int i = 1; i < cols; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        //  Function
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Initialize the first col of dp array
                if (j == 0) {
                    dp[i & 1][j] = dp[(i - 1) & 1][j] + grid[i][j];
                    continue;
                }
                dp[i & 1][j] = Math.min(dp[(i - 1) & 1][j], dp[i & 1][j - 1]) + grid[i][j];
            }
        }

        //  Answer
        return dp[(rows - 1) & 1][cols - 1];
    }
}