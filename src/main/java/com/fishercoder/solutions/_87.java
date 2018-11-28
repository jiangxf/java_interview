package com.fishercoder.solutions;

/**
 * 87. Scramble String
 * <p>
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * <p>
 * Below is one possible representation of s1 = "great":
 * <p>
 * great
 * /    \
 * gr    eat
 * / \    /  \
 * g   r  e   at
 * / \
 * a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * <p>
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 * <p>
 * rgeat
 * /    \
 * rg    eat
 * / \    /  \
 * r   g  e   at
 * / \
 * a   t
 * We say that "rgeat" is a scrambled string of "great".
 * <p>
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 * <p>
 * rgtae
 * /    \
 * rg    tae
 * / \    /  \
 * r   g  ta  e
 * / \
 * t   a
 * We say that "rgtae" is a scrambled string of "great".
 * <p>
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 */
public class _87 {

    public static class Solution1 {
        /**
         * credit: https://discuss.leetcode.com/topic/19158/accepted-java-solution
         */
        public boolean isScramble(String s1, String s2) {
            if (s1.equals(s2)) {
                return true;
            }
            if (s1.length() != s2.length()) {
                return false;
            }

            int[] letters = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                letters[s1.charAt(i) - 'a']++;
                letters[s2.charAt(i) - 'a']--;
            }

            for (int i : letters) {
                if (i != 0) {
                    return false;
                }
            }

            for (int i = 1; i < s1.length(); i++) {
                if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(
                        s1.substring(i), s2.substring(i))) {
                    return true;
                }
                if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) && isScramble(
                        s1.substring(i), s2.substring(0, s2.length() - i))) {
                    return true;
                }
            }
            return false;
        }
    }
}
