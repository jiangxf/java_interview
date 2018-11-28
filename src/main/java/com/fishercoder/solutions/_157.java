package com.fishercoder.solutions;

/**
 * 157. Read N Characters Given Read4
 * <p>
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * <p>
 * The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
 * <p>
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 * <p>
 * Example 1:
 * <p>
 * Input: buf = "abc", n = 4
 * Output: "abc"
 * Explanation: The actual number of characters read is 3, which is "abc".
 * <p>
 * Example 2:
 * <p>
 * Input: buf = "abcde", n = 5
 * Output: "abcde"
 * <p>
 * Note:
 * The read function will only be called once for each test case.
 */
public class _157 {
    public static class Solution1 {
        public int read(char[] buf, int n) {
            int index = 0;
            int next = 0;
            char[] buffer = new char[4];
            while (index < n && (next = read4(buffer)) != 0) {
                for (int i = 0; i < next && index < n; index++, i++) {
                    buf[index] = buffer[i];
                }
            }
            return index;
        }

        private int read4(char[] buffer) {
            //this is a fake method to make Eclipse happy
            return 0;
        }
    }
}
