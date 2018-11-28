package com.fishercoder.solutions;

/**
 * 453. Minimum Moves to Equal Array Elements
 * <p>
 * Given a non-empty integer array of size n,
 * find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.
 * <p>
 * Example:
 * <p>
 * Input:
 * [1,2,3]
 * <p>
 * Output:
 * 3
 * <p>
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 * <p>
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */

public class _453 {
    /**
     * Looked at this solution: https://discuss.leetcode.com/topic/66557/java-o-n-solution-short
     * i.e. Add 1 to n-1 elements basically equals to subtracting 1 from one element. So the easiest way
     * to make all elements in this array equal is to make all of them equal to the minimum element.
     */
    public static int minMoves(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int min = nums[0];
        for (int n : nums) {
            min = Math.min(min, n);
        }
        int res = 0;
        for (int n : nums) {
            res += n - min;
        }
        return res;
    }

    public static void main(String... args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(minMoves(nums));
    }

}
