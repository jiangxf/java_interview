package com.fishercoder.solutions;

/**
 * 564. Find the Closest Palindrome
 * <p>
 * Given an integer n, find the closest integer (not including itself), which is a palindrome.
 * <p>
 * The 'closest' is defined as absolute difference minimized between two integers.
 * <p>
 * Example 1:
 * <p>
 * Input: "123"
 * Output: "121"
 * <p>
 * Note:
 * <p>
 * The input n is a positive integer represented by string, whose length MySolution not exceed 18.
 * If there is a tie, return the smaller one as answer.
 */
public class _564 {

    public String nearestPalindromic(String n) {
        if (n.length() >= 2 && allNine(n)) {
            String s = "1";
            for (int i = 0; i < n.length() - 1; i++) {
                s += "0";
            }
            s += "1";
            return s;
        }
        boolean isOdd = (n.length() % 2 != 0);
        String left = n.substring(0, (n.length() + 1) / 2);
        long[] increment = {-1, 0, +1};
        String ret = n;
        long minDiff = Long.MAX_VALUE;
        for (long i : increment) {
            String s = getPalindrom(Long.toString(Long.parseLong(left) + i), isOdd);
            if (n.length() >= 2 && (s.length() != n.length() || Long.parseLong(s) == 0)) {
                s = "";
                for (int j = 0; j < n.length() - 1; j++) {
                    s += "9";
                }
            }
            long diff = s.equals(n) ? Long.MAX_VALUE : Math.abs(Long.parseLong(s) - Long.parseLong(n));
            if (diff < minDiff) {
                minDiff = diff;
                ret = s;
            }
        }
        return ret;
    }

    private String getPalindrom(String s, boolean isOdd) {
        String right = new StringBuilder(s).reverse().toString();
        return isOdd ? s.substring(0, s.length() - 1) + right : s + right;
    }

    private boolean allNine(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '9') {
                return false;
            }
        }
        return true;
    }

}
