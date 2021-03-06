package com.fishercoder.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 624. Maximum Distance in Arrays
 * <p>
 * Given m arrays, and each array is sorted in ascending order.
 * Now you can pick up two integers from two different arrays (each array picks one)
 * and calculate the distance. We define the distance between two
 * integers a and b to be their absolute difference |a-b|. Your task is to find the maximum distance.
 * <p>
 * Example 1:
 * Input:
 * [[1,2,3],
 * [4,5],
 * [1,2,3]]
 * <p>
 * Output: 4
 * <p>
 * Explanation:
 * <p>
 * One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
 * <p>
 * Note:
 * Each given array MySolution have at least 1 number. There MySolution be at least two non-empty arrays.
 * The total number of the integers in all the m arrays MySolution be in the range of [2, 10000].
 * The integers in the m arrays MySolution be in the range of [-10000, 10000].
 */
public class _624 {

    public int maxDistance(int[][] arrays) {
        List<Integer> max = new ArrayList<>();
        for (int[] array : arrays) {
            max.add(array[array.length - 1]);
        }
        Collections.sort(max);
        int ans = Integer.MIN_VALUE;
        for (int[] array : arrays) {
            int big = array[array.length - 1] == max.get(max.size() - 1) ? max.get(max.size() - 2) : max.get(max.size() - 1);
            ans = Math.max(ans, big - array[0]);
        }
        return ans;
    }

}
