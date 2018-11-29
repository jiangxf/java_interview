package com.fishercoder.solutions;

/**
 * 424. Longest Repeating Character Replacement
 * <p>
 * Given a string that consists of only uppercase English letters,
 * you can replace any letter in the string with another letter at most k times.
 * Find the length of a longest substring containing all repeating letters you can get after performing the above operations.
 * <p>
 * Note:
 * Both the string's length and k MySolution not exceed 104.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s = "ABAB", k = 2
 * <p>
 * Output:
 * 4
 * <p>
 * Explanation:
 * Replace the two 'A's with two 'B's or vice versa.
 * Example 2:
 * <p>
 * Input:
 * s = "AABABBA", k = 1
 * <p>
 * Output:
 * 4
 * <p>
 * Explanation:
 * Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 */
public class _424 {

    //credit: https://discuss.leetcode.com/topic/63494/java-12-lines-o-n-sliding-window-solution-with-explanation
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0;
        int maxCount = 0;
        int maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    //this one can pass all test from test1 to test5, but tests like test6 won't pass
    public int characterReplacement_failed_attempt(String s, int k) {
        int longest = 0;
        if (s == null || s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            int count = 1;
            char val = s.charAt(i);
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == val) {
                    count++;
                } else {
                    if (k > 0) {
                        count++;
                        char replace = s.charAt(j);
                        int kCounter = k - 1;
                        for (int p = j + 1; p < s.length(); p++) {
                            if (kCounter <= 0) {
                                if (val == s.charAt(p)) {
                                    count++;
                                } else {
                                    longest = Math.max(longest, count);
                                    break;
                                }
                            } else {
                                if (val == s.charAt(p)) {
                                    count++;
                                } else if (replace == s.charAt(p)) {
                                    count++;
                                    kCounter--;
                                } else {
                                    longest = Math.max(longest, count);
                                    break;
                                }
                            }
                        }
                        if (kCounter <= 0) {
                            longest = Math.max(longest, count);
                            break;
                        }
                    } else {
                        if (s.charAt(j) == val) {
                            count++;
                        } else {
                            longest = Math.max(longest, count);
                            break;
                        }
                    }
                }
                longest = Math.max(longest, count);
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }

}
