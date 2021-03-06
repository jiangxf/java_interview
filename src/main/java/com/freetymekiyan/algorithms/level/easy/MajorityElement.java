package com.freetymekiyan.algorithms.level.easy;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2
 * ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Tags: Divide and Conquer, Array, Bit Manipulation
 */
class MajorityElement {

    /**
     * Runtime: O(n) — Bit manipulation: We would need 32 iterations, each
     * calculating the number of 1's for the ith bit of all n numbers. Since a
     * majority must exist, therefore, either count of 1's > count of 0's or
     * vice versa (but can never be equal). The majority number’s ith bit must
     * be the one bit that has the greater count.
     */
    public static int majorityElement2(int[] num) {
        // TODO: 12/6/17 add implementation
        return -1;
    }

    /**
     * Voting algo.
     * Init majority element maj as the first number.
     * For each number in the array:
     * | If count is 0:
     * |   Change maj to current element.
     * |   count++.
     * | Else if num[i] == maj:
     * |   count++.
     * | Else:
     * |   count--.
     * Return maj.
     */
    public int majorityElement(int[] num) {
        int maj = num[0];
        int count = 0;
        for (int i = 0; i < num.length && count <= num.length / 2; i++) {
            if (count == 0) {
                maj = num[i];
                count++;
            } else {
                count = num[i] == maj ? count + 1 : count - 1;
            }
        }
        return maj;
    }
}