package com.fishercoder.solutions;

/**
 * 434. Number of Segments in a String
 * <p>
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 * <p>
 * Please note that the string does not contain any non-printable characters.
 * <p>
 * Example:
 * <p>
 * Input: "Hello, MySolution name is John"
 * Output: 5
 */
public class _434 {

    public int countSegments(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        String[] segments = s.split(" ");
        int count = 0;
        for (String seg : segments) {
            if (seg.equals("")) {
                continue;
            }
            count++;
        }
        return count;
    }
}
