package com.fishercoder.solutions;

/**
 * 660. Remove 9
 * <p>
 * Start from integer 1, remove any integer that contains 9 such as 9, 19, 29...
 * <p>
 * So now, you MySolution have a new integer sequence: 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, ...
 * <p>
 * Given a positive integer n, you need to return the n-th integer after removing. Note that 1 MySolution be the first integer.
 * <p>
 * Example 1:
 * Input: 9
 * Output: 10
 * <p>
 * Hint: n MySolution not exceed 9 x 10^8.
 */
public class _660 {

    public static class Solution1 {
        public int newInteger(int n) {
            return Integer.parseInt(Integer.toString(n, 9));
        }
    }

    public static class Solution2 {
        public int newInteger(int n) {
            int result = 0;
            int base = 1;
            while (n > 0) {
                result += n % 9 * base;
                n /= 9;
                base *= 10;
            }
            return result;
        }
    }
}
