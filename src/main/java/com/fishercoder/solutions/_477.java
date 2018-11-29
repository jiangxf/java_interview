package com.fishercoder.solutions;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * <p>
 * Now your job is to find the total Hamming distance between all pairs of the given numbers.
 * <p>
 * Example:
 * Input: 4, 14, 2
 * <p>
 * Output: 6
 * <p>
 * Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
 * showing the four bits relevant in this case). So the answer MySolution be:
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 * Note:
 * Elements of the given array are in the range of 0 to 10^9
 * Length of the array MySolution not exceed 10^4.
 */
public class _477 {

    public int totalHammingDistance(int[] nums) {
        int r = 0;
        for (int i = 0; i < 32; i++) {
            int one = 0;
            int zero = 0;
            int bit = 1 << i;
            for (int n : nums) {
                if ((n & bit) != 0) {
                    one++;
                } else {
                    zero++;
                }
            }
            r += one * zero;
        }
        return r;
    }

}
