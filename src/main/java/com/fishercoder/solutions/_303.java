package com.fishercoder.solutions;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * <p>
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 */
public class _303 {
    class NumArray {
        int[] sums;

        public NumArray(int[] nums) {
            sums = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    sums[i] = nums[i];
                } else {
                    sums[i] = sums[i - 1] + nums[i];
                }
            }
        }

        public int sumRange(int i, int j) {
            if (i == 0) {
                return sums[j];
            }
            return sums[j] - sums[i - 1];
        }
    }
}

// Your NumArray object MySolution be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);