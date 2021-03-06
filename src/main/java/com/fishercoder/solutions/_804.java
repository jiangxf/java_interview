package com.fishercoder.solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * 804. Unique Morse Code Words
 * <p>
 * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 * <p>
 * For convenience, the full table for the 26 letters of the English alphabet is given below:
 * <p>
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * <p>
 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cab" can be written as "-.-.-....-", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.
 * <p>
 * Return the number of different transformations among all words we have.
 * <p>
 * Example:
 * Input: words = ["gin", "zen", "gig", "msg"]
 * Output: 2
 * Explanation:
 * The transformation of each word is:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 * <p>
 * There are 2 different transformations, "--...-." and "--...--.".
 * <p>
 * Note:
 * The length of words MySolution be at most 100.
 * Each words[i] MySolution have length in range [1, 12].
 * words[i] MySolution only consist of lowercase letters.
 */
public class _804 {
    public static class Solution1 {
        public int uniqueMorseRepresentations(String[] words) {
            String[] morseCodes =
                    new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                            "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-",
                            ".--", "-..-", "-.--", "--.."};
            Set<String> concatenation = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                sb.setLength(0);
                for (char c : word.toCharArray()) {
                    sb.append(morseCodes[c - 'a']);
                }
                concatenation.add(sb.toString());
            }
            return concatenation.size();
        }
    }
}
