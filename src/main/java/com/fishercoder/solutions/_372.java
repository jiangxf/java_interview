package com.fishercoder.solutions;

/**
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.
 * <p>
 * Example1:
 * <p>
 * a = 2
 * b = [3]
 * <p>
 * Result: 8
 * Example2:
 * <p>
 * a = 2
 * b = [1,0]
 * <p>
 * Result: 1024
 */
public class _372 {
    /**
     * Reference: https://discuss.leetcode.com/topic/50586/math-solusion-based-on-euler-s-theorem-power-called-only-once-c-java-1-line-python
     */

    public int superPow(int a, int[] b) {
        if (a % 1337 == 0) {
            return 0;
        }
        int p = 0;
        for (int i : b) {
            p = (p * 10 + i) % 1140;
        }
        if (p == 0) {
            p += 1140;
        }
        return power(a, p, 1337);
    }

    private int power(int a, int n, int mod) {
        a %= mod;
        int result = 1;
        while (n != 0) {
            if ((n & 1) != 0) {
                result = result * a % mod;
            }
            a = a * a % mod;
            n >>= 1;
        }
        return result;
    }

}
