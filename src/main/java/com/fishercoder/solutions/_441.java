package com.fishercoder.solutions;

/**
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 * <p>
 * Given n, find the total number of full staircase rows that can be formed.
 * <p>
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 * <p>
 * Example 1:
 * <p>
 * n = 5
 * <p>
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * <p>
 * Because the 3rd row is incomplete, we return 2.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * n = 8
 * <p>
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * <p>
 * Because the 4th row is incomplete, we return 3.
 */
public class _441 {

    public static int arrangeCoins(int n) {
        if (n < 2) {
            return n;
        }
        int row = 0;
        int count = 0;
        long sum = 0;
        while (sum < n) {
            row += 1;
            sum += row;
            count++;
        }
        if (sum == n) {
            return count;
        }
        return count - 1;
    }

    public static void main(String... args) {
        int n = 3;//should be 2
        System.out.println(arrangeCoins(n));
    }
}
