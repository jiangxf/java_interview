package com.blankj.easy._058_;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/05/05
 *     desc  :
 * </pre>
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord("word "));
        System.out.println(solution.lengthOfLastWord("hello world"));
    }

    public int lengthOfLastWord(String s) {
        int len = s.length() - 1;
        int temp = 0;
        boolean begin = false;

        for (int i = len; i >= 0; i--) {
            if (' ' == s.charAt(i)) {
                if (begin) {
                    return temp;
                }
            } else {
                if (!begin) begin = true;
                temp++;
            }
        }
        return temp;
    }

//    public int lengthOfLastWord(String s) {
//        int p = s.length() - 1;
//        while (p >= 0 && s.charAt(p) == ' ') p--;
//        int end = p;
//        while (p >= 0 && s.charAt(p) != ' ') p--;
//        return end - p;
//    }
}
