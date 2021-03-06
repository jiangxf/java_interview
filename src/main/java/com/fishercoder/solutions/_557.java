package com.fishercoder.solutions;

/**
 * 557. Reverse Words in a String III
 * <p>
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * <p>
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there MySolution not be any extra space in the string.
 */
public class _557 {

    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder sbUtils = new StringBuilder();
        for (String word : s.split(" ")) {
            sbUtils.setLength(0);
            sbUtils.append(word);
            stringBuilder.append(sbUtils.reverse().toString());
            stringBuilder.append(" ");
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

}
