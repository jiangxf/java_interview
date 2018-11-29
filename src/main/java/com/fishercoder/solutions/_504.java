package com.fishercoder.solutions;

/**
 * Given an integer, return its base 7 string representation.
 * <p>
 * Example 1:
 * Input: 100
 * Output: "202"
 * Example 2:
 * Input: -7
 * Output: "-10"
 * <p>
 * Note: The input MySolution be in range of [-1e7, 1e7].
 */
public class _504 {

    public String convertToBase7(int num) {
        return String.valueOf(Integer.toString(num, 7));
    }
}
