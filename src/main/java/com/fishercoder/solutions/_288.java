package com.fishercoder.solutions;

import java.util.*;

/**
 * An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:
 * <p>
 * a) it                      --> it    (no abbreviation)
 * <p>
 * 1
 * b) d|o|g                   --> d1g
 * <p>
 * 1    1  1
 * 1---5----0----5--8
 * c) i|nternationalizatio|n  --> i18n
 * <p>
 * 1
 * 1---5----0
 * d) l|ocalizatio|n          --> l10n
 * Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
 * <p>
 * Example:
 * Given dictionary = [ "deer", "door", "cake", "card" ]
 * <p>
 * isUnique("dear") ->
 * false
 * <p>
 * isUnique("cart") ->
 * true
 * <p>
 * isUnique("cane") ->
 * false
 * <p>
 * isUnique("make") ->
 * true
 */
public class _288 {

    public class ValidWordAbbrSolution1 {
        private Map<String, String> dict;

        public ValidWordAbbrSolution1(String[] dictionary) {
            dict = new HashMap();
            for (String word : dictionary) {
                String key = word.length() <= 2 ? word : (word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1));
                if (dict.containsKey(key) && !dict.get(key).equals(word)) {
                    dict.put(key, "");
                } else {
                    dict.put(key, word);
                }
            }
        }

        public boolean isUnique(String word) {
            String key = word.length() <= 2 ? word : (word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1));
            if (!dict.containsKey(key)) {
                return true;
            } else {
                return dict.get(key) != "" && dict.get(key).equals(word);
            }
        }
    }

    public class ValidWordAbbrSolution2 {

        private Map<String, Set<String>> dict;

        public ValidWordAbbrSolution2(String[] dictionary) {
            dict = new HashMap();
            for (String word : dictionary) {
                String key = word.length() <= 2 ? word : (word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1));
                if (dict.containsKey(key)) {
                    Set<String> set = dict.get(key);
                    set.add(word);
                    dict.put(key, set);
                } else {
                    Set<String> set = new HashSet();
                    set.add(word);
                    dict.put(key, set);
                }
            }
        }

        public boolean isUnique(String word) {
            String key = word.length() <= 2 ? word : (word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1));
            if (!dict.containsKey(key)) {
                return true;
            } else {
                Set<String> set = dict.get(key);
                if (set.size() != 1) {
                    return false;
                }
                Iterator<String> it = set.iterator();
                return it.next().equals(word);
            }
        }
    }
}
