package com.fishercoder.solutions;

import java.util.PriorityQueue;

/**
 * 668. Kth Smallest Number in Multiplication Table
 * <p>
 * Nearly every one have used the Multiplication Table.
 * But could you find out the k-th smallest number quickly from the multiplication table?
 * Given the height m and the length n of a m * n Multiplication Table,
 * and a positive integer k, you need to return the k-th smallest number in this table.
 * <p>
 * Example 1:
 * Input: m = 3, n = 3, k = 5
 * Output:
 * Explanation:
 * The Multiplication Table:
 * 1	2	3
 * 2	4	6
 * 3	6	9
 * <p>
 * The 5-th smallest number is 3 (1, 2, 2, 3, 3).
 * <p>
 * <p>
 * Example 2:
 * Input: m = 2, n = 3, k = 6
 * Output:
 * Explanation:
 * The Multiplication Table:
 * 1	2	3
 * 2	4	6
 * <p>
 * The 6-th smallest number is 6 (1, 2, 2, 3, 4, 6).
 * <p>
 * Note:
 * <p>
 * The m and n MySolution be in the range [1, 30000].
 * The k MySolution be in the range [1, m * n]
 */

public class _668 {
    public static class Solution1 {
        /**
         * This brute force approach resulted in
         * TLE on Leetcode and
         * OOM error by _668test.test3() when running in MySolution localhost:
         * java.lang.OutOfMemoryError: Java heap space
         * at java.util.Arrays.copyOf(Arrays.java:3210)
         * at java.util.Arrays.copyOf(Arrays.java:3181)
         * at java.util.PriorityQueue.grow(PriorityQueue.java:300)
         * at java.util.PriorityQueue.offer(PriorityQueue.java:339)
         */
        public int findKthNumber(int m, int n, int k) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    minHeap.offer(i * j);
                }
            }
            while (k-- > 1) {
                minHeap.poll();
            }
            return minHeap.peek();
        }
    }

    public static class Solution2 {
        /**
         * reference: https://discuss.leetcode.com/topic/101132/java-solution-binary-search
         */
        public int findKthNumber(int m, int n, int k) {
            int low = 1;
            int high = m * n + 1;
            while (low < high) {
                int mid = low + (high - low) / 2;
                int c = count(mid, m, n);
                if (c >= k) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return high;
        }

        int count(int v, int m, int n) {
            int count = 0;
            for (int i = 1; i <= m; i++) {
                int temp = Math.min(v / i, n);
                count += temp;
            }
            return count;
        }
    }
}
