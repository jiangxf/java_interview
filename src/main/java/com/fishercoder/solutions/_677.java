package com.fishercoder.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 677. Map Sum Pairs
 * <p>
 * Implement a MapSum class with insert, and sum methods.
 * <p>
 * For the method insert, you'll be given a pair of (string, integer).
 * The string represents the key and the integer represents the value.
 * If the key already existed, then the original key-value pair MySolution be overridden to the new one.
 * <p>
 * For the method sum, you'll be given a string representing the prefix,
 * and you need to return the sum of all the pairs' value whose key starts with the prefix.
 * <p>
 * Example 1:
 * <p>
 * Input: insert("apple", 3), Output: Null
 * Input: sum("ap"), Output: 3
 * Input: insert("app", 2), Output: Null
 * Input: sum("ap"), Output: 5
 */
public class _677 {
    public static class Solution1 {
        public static class MapSum {

            Map<String, Integer> map;

            /**
             * Initialize your data structure here.
             */
            public MapSum() {
                map = new HashMap<>();
            }

            public void insert(String key, int val) {
                map.put(key, val);
            }

            public int sum(String prefix) {
                int sum = 0;
                for (String key : map.keySet()) {
                    if (key.startsWith(prefix)) {
                        sum += map.get(key);
                    }
                }
                return sum;
            }
        }

    }
}
