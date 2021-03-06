package com.fishercoder.solutions;

/**
 * 600. Non-negative Integers without Consecutive Ones
 * <p>
 * Given a positive integer n, find the number of non-negative integers less than or equal to n, whose binary representations do NOT contain consecutive ones.
 * <p>
 * Example 1:
 * Input: 5
 * Output: 5
 * Explanation:
 * Here are the non-negative integers <= 5 with their corresponding binary representations:
 * 0 : 0
 * 1 : 1
 * 2 : 10
 * 3 : 11
 * 4 : 100
 * 5 : 101
 * Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule.
 * <p>
 * Note: 1 <= n <= 109
 */
public class _600 {

    /**
     * Brute force is definitely correct, but too time consuming and resulted in TLE.
     */
    public int findIntegers(int num) {
        int answer = 0;
        for (int i = 0; i <= num; i++) {
            if (hasConsecutiveOnes(i)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean hasConsecutiveOnes(int num) {
        String bin = Integer.toBinaryString(num);
        for (int i = 0; i < bin.length() - 1; i++) {
            if (bin.charAt(i) == '1' && bin.charAt(i + 1) == '1') {
                return false;
            }
        }
        return true;
    }

    public static class DPSolution {
        /**
         * Credit: https://leetcode.com/articles/non-negative-integers-without-consecutive-ones/#approach-3-using-bit-manipulation-accepted
         */
        public int findIntegers(int num) {
            int[] f = new int[32];
            f[0] = 1;
            f[1] = 2;
            for (int i = 2; i < f.length; i++) {
                f[i] = f[i - 1] + f[i - 2];
            }
            int i = 30;
            int sum = 0;
            int prevBit = 0;
            while (i >= 0) {
                if ((num & (1 << i)) != 0) {
                    sum += f[i];
                    if (prevBit == 1) {
                        sum--;
                        break;
                    }
                    prevBit = 1;
                } else {
                    prevBit = 0;
                }
                i--;
            }
            return sum + 1;
        }
    }

}
