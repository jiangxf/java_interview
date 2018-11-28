package com.freetymekiyan.algorithms.level.easy;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
 * stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of
 * money you can rob tonight without alerting the police.
 * <p>
 * Company Tags: LinkedIn, Airbnb
 * Tags: Dynamic Programming
 * Similar Problems: (M) Maximum Product Subarray, (M) House Robber II, (M) Paint House, (E) Paint Fence, (M) House
 * Robber III
 */
public class HouseRobber {

    private HouseRobber hr;

    /**
     * DP. Space Optimized.
     * Max amount of house n is either rob the previous house or rob this house.
     * Recurrence relation:
     * max[n] = max(max[n - 2] + nums[n], max[n - 1])
     * Optimization:
     * Use constant variables instead of an array.
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int preMax = nums[0];
        int max = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = preMax;
            preMax = max;
            max = Math.max(temp + nums[i], preMax);
        }
        return max;
    }

    /**
     * DP. More compact code.
     */
    public int robB(int[] nums) {
        int preMax = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int curMax = Math.max(preMax + nums[i], max);
            preMax = max;
            max = curMax;
        }
        return max;
    }
}
