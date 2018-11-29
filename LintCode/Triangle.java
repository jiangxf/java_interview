��̬�滮(DP)�ľ�����������
        Traverse/DFS O(2^N)=>Divide and Conquer O(2^N)=>ʹ�ü��仯���������Ż� O(N^2)=>  ��̬�滮���Ե����� / �Զ����£�
        ͨ�����ϵĹ������ǿ�����ʶ��DPʵ���Ͼ��ǽ���ظ�����������㷨��
        ������ͨ�����仯������loop��ʵ�֡�
        ���������3�нⷨ��
        1.Divide and Conquer optimized by Memorize Search(ʹ��һ����ά�������洢�Ѿ��������ֵ�������ظ�����)
        2.Dynamic Programming �Ե�����
        3.Dynamic Programming �Զ�����

/*

Description

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

Notice

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

Have you met this question in a real interview? Yes

Example
Given the following triangle:

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Tags 
Dynamic Programming

*/

//	Version 1 : Divide and Conquer optimized by Memorize Search
//	Use minSum to save the nums, so we can avoid calculate them repeatly.
public class Solution {
    private int n;
    private int[][] minSum;
    private int[][] triangle;

    private int search(int x, int y) {
        if (x >= n) {
            return 0;
        }

        if (minSum[x][y] != Integer.MAX_VALUE) {
            return minSum[x][y];
        }
        //	Divide 
        int leftSum = search(x + 1, y);
        int rightSum = search(x + 1, y + 1);
        //	Merge
        minSum[x][y] = Math.min(leftSum, rightSum) + triangle[x][y];

        return minSum[x][y];
    }

    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }

        this.n = triangle.length;
        this.triangle = triangle;
        this.minSum = new int[n][n];

        //	Initial the minSum
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                minSum[i][j] = Integer.MAX_VALUE;
            }
        }

        return search(0, 0);
    }
}

//	Version 2: Bottom-Up

public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }

        // state: f[x][y] = minimum path value from x,y to bottom
        int n = triangle.length;
        int[][] f = new int[n][n];

        // initialize 
        for (int i = 0; i < n; i++) {
            f[n - 1][i] = triangle[n - 1][i];
        }

        // bottom up
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                f[i][j] = Math.min(f[i + 1][j], f[i + 1][j + 1]) + triangle[i][j];
            }
        }

        // answer
        return f[0][0];
    }
}

// version 3: top-down
public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }

        // state: f[x][y] = minimum path value from 0,0 to x,y
        int n = triangle.length;
        int[][] f = new int[n][n];

        // initialize 
        // ע�⣺�Զ�����ʱ�����̬�滮�Ƕ�ά�����飬����Ҫ��f[i][0]��f[0][i]�����г�ʼ��
        // ��������ı�Ե����һ�γ�ʼ������Ϊ���ǻ�������Ҫ�õ���Щֵ�ġ�
        // ������Ϊ�����Σ���������Ҫ��ʼ����Ϊ����ĶԽ��ߣ���f[i][i]
        f[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            f[i][0] = f[i - 1][0] + triangle[i][0];
            f[i][i] = f[i - 1][i - 1] + triangle[i][i];
        }

        // top down
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i - 1][j - 1]) + triangle[i][j];
            }
        }

        // answer
        int best = f[n - 1][0];
        for (int i = 1; i < n; i++) {
            best = Math.min(best, f[n - 1][i]);
        }
        return best;
    }
}
