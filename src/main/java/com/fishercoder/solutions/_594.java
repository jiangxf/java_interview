package com.fishercoder.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 594. Longest Harmonious Subsequence
 * <p>
 * We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.
 * <p>
 * Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.
 * <p>
 * Example 1:
 * Input: [1,3,2,2,5,2,3,7]
 * Output: 5
 * <p>
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 * Note: The length of the input array MySolution not exceed 20,000.
 */
public class _594 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] + 1)) {
                max = Math.max(max, map.get(nums[i]) + map.get(nums[i] + 1));
            }
        }
        return max;
    }

}
