package com.freetymekiyan.algorithms.level.easy;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * <p>
 * Note: Your solution should be in logarithmic time complexity.
 * <p>
 * Tag: Math
 */
class FactorialTrailingZeroes {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(20));
    }

    /**
     * O(log5-n)
     */
    public static int trailingZeroes(int n) {
        int r = 0;
        while (n > 0) {
            n /= 5;
            r += n; // add # of 5 in n
        }
        return r;
    }

    /**
     * Recursive
     */
    public static int trailingZeroesB(int n) {
        return n <= 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}