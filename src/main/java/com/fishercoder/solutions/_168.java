package com.fishercoder.solutions;

/**
 * 168. Excel Sheet Column Title
 * <p>
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * <p>
 * For example:
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: "A"
 * <p>
 * Example 2:
 * <p>
 * Input: 28
 * Output: "AB"
 * <p>
 * Example 3:
 * <p>
 * Input: 701
 * Output: "ZY"
 */
public class _168 {
    public static class Solution1 {
        public String convertToTitle(int n) {
            /**Get the right most digit first, move to the left, e.g. when n = 28, we get 'B' first, then we get 'A'.*/
            StringBuilder sb = new StringBuilder();
            while (n != 0) {
                int temp = (n - 1) % 26;
                sb.append((char) (temp + 65));
                n = (n - 1) / 26;
            }
            return sb.reverse().toString();
        }
    }
}
