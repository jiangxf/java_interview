package com.fishercoder.solutions;

/**
 * 941. Valid Mountain Array
 * <p>
 * Given an array A of integers, return true if and only if it is a valid mountain array.
 * <p>
 * Recall that A is a mountain array if and only if:
 * <p>
 * A.length >= 3
 * There exists some i with 0 < i < A.length - 1 such that:
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[B.length - 1]
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [2,1]
 * Output: false
 * Example 2:
 * <p>
 * Input: [3,5,5]
 * Output: false
 * Example 3:
 * <p>
 * Input: [0,3,2,1]
 * Output: true
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 */
public class _941 {
    public static class Solution1 {
        public boolean validMountainArray(int[] A) {
            int i = 0;
            for (; i < A.length - 1; i++) {
                if (A[i] < A[i + 1]) {
                    continue;
                } else if (A[i] == A[i + 1]) {
                    return false;
                } else {
                    break;
                }
            }
            if (i == 0 || i >= A.length - 1) {
                return false;
            }
            for (; i < A.length - 1; i++) {
                if (A[i] > A[i + 1]) {
                    continue;
                } else {
                    return false;
                }
            }
            return i == A.length - 1;
        }
    }
}
