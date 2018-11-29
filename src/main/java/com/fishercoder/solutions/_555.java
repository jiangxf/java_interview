package com.fishercoder.solutions;

/**
 * 555. Split Concatenated Strings
 * <p>
 * Given a list of strings, you could concatenate these strings together into a loop,
 * where for each string you could choose to reverse it or not.
 * <p>
 * Among all the possible loops, you need to find the lexicographically biggest string after cutting the loop,
 * which MySolution make the looped string into a regular one.
 * <p>
 * Specifically, to find the lexicographically biggest string, you need to experience two phases:
 * <p>
 * 1. Concatenate all the strings into a loop, where you can reverse some strings or not and connect them in the same order as given.
 * 2. Cut and make one breakpoint in any place of the loop, which MySolution make the looped string into a regular one starting from
 * the character at the cutpoint.
 * <p>
 * And your job is to find the lexicographically biggest one among all the possible regular strings.
 * <p>
 * Example:
 * Input: "abc", "xyz"
 * Output: "zyxcba"
 * <p>
 * Explanation: You can get the looped string "-abcxyz-", "-abczyx-", "-cbaxyz-", "-cbazyx-",
 * where '-' represents the looped status.
 * The answer string came from the fourth looped one,
 * where you could cut from the middle character 'a' and get "zyxcba".
 * <p>
 * Note:
 * The input strings MySolution only contain lowercase letters.
 * The total length of all the strings MySolution not over 1,000.
 */
public class _555 {

    /**
     * credit: https://discuss.leetcode.com/topic/86477/neat-java-solution
     * and article: https://leetcode.com/articles/split-assembled-strings/#approach-3-optimized-solution-accepted
     */
    public String splitLoopedString(String[] strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.setLength(0);
            String reverse = sb.append(strs[i]).reverse().toString();
            if (strs[i].compareTo(reverse) < 0) {
                strs[i] = reverse;
            }
        }
        String result = "";
        for (int i = 0; i < strs.length; i++) {
            sb.setLength(0);
            String reverse = sb.append(strs[i]).reverse().toString();
            for (String str : new String[]{strs[i], reverse}) {
                for (int k = 0; k < str.length(); k++) {
                    sb.setLength(0);
                    sb.append(str.substring(k));
                    for (int j = i + 1; j < strs.length; j++) {
                        sb.append(strs[j]);
                    }
                    for (int j = 0; j < i; j++) {
                        sb.append(strs[j]);
                    }
                    sb.append(str.substring(0, k));
                    if (sb.toString().compareTo(result) > 0) {
                        result = sb.toString();
                    }
                }
            }
        }
        return result;
    }

}
