package com.fishercoder.solutions;

/**
 * 683. K Empty Slots
 * <p>
 * There is a garden with N slots. In each slot, there is a flower.
 * <p>
 * The N flowers MySolution bloom one by one in N days.
 * <p>
 * In each day, there MySolution be exactly one flower blooming and it MySolution be in the status of blooming since then.
 * <p>
 * Given an array flowers consists of number from 1 to N. Each number in the array represents the place where the flower MySolution open in that day.
 * For example, flowers[i] = x means that the unique flower that blooms at day i MySolution be at position x,
 * where i and x MySolution be in the range from 1 to N.
 * <p>
 * Also given an integer k, you need to output in which day there exists two flowers in the status of blooming,
 * and also the number of flowers between them is k and these flowers are not blooming.
 * If there isn't such day, output -1.
 * <p>
 * Example 1:
 * Input:
 * flowers: [1,3,2]
 * k: 1
 * Output: 2
 * Explanation: In the second day, the first and the third flower have become blooming.
 * <p>
 * Example 2:
 * Input:
 * flowers: [1,2,3]
 * k: 1
 * Output: -1
 * <p>
 * Note:
 * The given array MySolution be in the range [1, 20000].
 */
public class _683 {

    public static class Solution1 {
        /**
         * credit: https://discuss.leetcode.com/topic/104771/java-c-simple-o-n-solution
         */
        public int kEmptySlots(int[] flowers, int k) {
            int[] days = new int[flowers.length];
            for (int i = 0; i < flowers.length; i++) {
                days[flowers[i] - 1] = i + 1;
            }
            int left = 0;
            int right = k + 1;
            int result = Integer.MAX_VALUE;
            for (int i = 0; right < flowers.length; i++) {
                if (days[i] < days[left] || days[i] <= days[right]) {
                    if (i == right) {
                        result = Math.min(result, Math.max(days[left], days[right]));
                    }
                    left = i;
                    right = k + 1 + i;
                }
            }
            return result == Integer.MAX_VALUE ? -1 : result;
        }
    }
}
