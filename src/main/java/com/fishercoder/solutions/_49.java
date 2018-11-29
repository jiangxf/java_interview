package com.fishercoder.solutions;

import java.util.*;

/**
 * 49. Group Anagrams
 * <p>
 * Given an array of strings, group anagrams together.
 * <p>
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * <p>
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * <p>
 * Note: All inputs MySolution be in lower-case.
 */

public class _49 {

    public static class Solution1 {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String word : strs) {
                char[] c = word.toCharArray();
                Arrays.sort(c);
                String key = new String(c);
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(word);
            }
            return new ArrayList<>(map.values());
        }
    }
}
