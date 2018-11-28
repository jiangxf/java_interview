package com.fishercoder.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.
 * <p>
 * Note:
 * The array size can be very large. Solution that uses too much extra space will not pass the judge.
 * <p>
 * Example:
 * <p>
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 * solution.pick(3);
 * <p>
 * // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(1);
 */
public class _398 {

//TODO: use reservoir sampling to solve it again

    class Solution {
        //brute force
        int[] input;
        java.util.Random rand = new java.util.Random();

        public Solution(int[] nums) {
            input = nums;
        }

        public int pick(int target) {
            List<Integer> list = new ArrayList();
            for (int i = 0; i < input.length; i++) {
                if (input[i] == target) {
                    list.add(i);
                }
            }
            if (list.size() == 1) {
                return list.get(0);
            }
            int randomIndex = rand.nextInt(list.size());
            return list.get(randomIndex);
        }
    }


    class SolutionMemoryLimitExceeded {

        java.util.Random rand = new java.util.Random();
        private Map<Integer, List<Integer>> map = new HashMap();

        public SolutionMemoryLimitExceeded(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    List<Integer> list = map.get(nums[i]);
                    list.add(i);
                    map.put(nums[i], list);
                } else {
                    List<Integer> list = new ArrayList();
                    list.add(i);
                    map.put(nums[i], list);
                }
            }
        }

        public int pick(int target) {
            List<Integer> list = map.get(target);
            if (list.size() == 1) {
                return list.get(0);
            }
            int randomIndex = rand.nextInt(list.size());
            return list.get(randomIndex);
        }
    }
}
