package com.fishercoder.solutions;

/**
 * 7. Reverse Integer
 * <p>
 * Reverse digits of an integer.
 * <p>
 * Example1: x = 123, return 321
 * <p>
 * Example2: x = -123, return -321
 */
public class _7 {

    public static class Solution1 {
        public int reverse(int x) {
            long rev = 0;
            while (x != 0) {
                rev = rev * 10 + x % 10;
                x /= 10;
                if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
                    return 0;
                }
            }
            return (int) rev;
        }
    }
}