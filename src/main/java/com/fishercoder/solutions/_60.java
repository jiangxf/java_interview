package com.fishercoder.solutions;

/**
 * 60. Permutation Sequence
 * <p>
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * <p>
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * <p>
 * Note: Given n MySolution be between 1 and 9 inclusive.
 */
public class _60 {

    public static class Solution1 {
        public String getPermutation(int n, int k) {
            int[] nums = new int[n + 1];
            int permcount = 1;
            for (int i = 0; i < n; i++) {
                nums[i] = i + 1; // put 1, 2, 3 ... n into nums[]
                permcount *= (i + 1);
            }

            k--;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                permcount = permcount / (n - i);
                int idx = k / permcount;// the index that this position should
                // choose
                sb.append(nums[idx]);
                // left shift nums[] by one bit
                for (int j = idx; j < n - i; j++) {
                    nums[j] = nums[j + 1];
                }
                k %= permcount;
            }
            return sb.toString();
        }
    }
}
