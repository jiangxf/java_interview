package com.will.array;

import java.util.Arrays;

/**
 * Created by gouthamvidyapradhan on 17/02/2018.
 * Given a non-empty integer com.will.array, find the minimum number of moves required to make all com.will.array elements equal,
 * where a move is incrementing a selected element by 1 or decrementing a selected element by 1.
 * <p>
 * You may assume the com.will.array's length is at most 10,000.
 * <p>
 * Example:
 * <p>
 * Input:
 * [1,2,3]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * Only two moves are needed (remember each move increments or decrements one element):
 * <p>
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * <p>
 * Solution: O(n log n): Sort the com.will.array and find the median of the com.will.array.
 * Use the median of com.will.array to increment/decrement other value of com.will.array. Sum up the difference and return the answer.
 */
public class MinimumMovesToEqualArray {
    /**
     * Main method
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        int[] A = {1, 2, 3};
        System.out.println(new MinimumMovesToEqualArray().minMoves2(A));
    }

    public int minMoves2(int[] nums) {
        if (nums.length == 1) return 0;
        else if (nums.length == 2) return Math.abs(nums[0] - nums[1]);
        Arrays.sort(nums);
        int median;
        if ((nums.length % 2) == 1) {
            median = (nums.length / 2);
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += Math.abs(nums[i] - nums[median]);
            }
            return sum;
        } else {
            median = (nums.length / 2) - 1;
            int sum = 0;
            int min;
            for (int i = 0; i < nums.length; i++) {
                sum += Math.abs(nums[i] - nums[median]);
            }
            min = sum;
            sum = 0;
            median = (nums.length / 2);
            for (int i = 0; i < nums.length; i++) {
                sum += Math.abs(nums[i] - nums[median]);
            }
            min = Math.min(min, sum);
            return min;
        }
    }
}