package com.blankj.easy._028_;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/05/01
 *     desc  :
 * </pre>
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("12345", "5"));
        System.out.println(solution.strStr("12345", "23"));
        System.out.println(solution.strStr("12345", ""));
    }


    public int strStr(String haystack, String needle) {

        int l1 = haystack.length();
        int l2 = needle.length();

        if (l2 == 0) return 0;
        if (l1 < l2) return -1;

        int temp = 0;
        for (int i = 0; i < haystack.length(); i++) {

            if (i + l2 > l1) return -1;

            if (haystack.charAt(i) == needle.charAt(temp)) {
                temp++;
            } else {
                temp = 0;
            }

            if (temp == l2) {
                return i + 1 - l2;
            }
        }
        return -1;
    }

//    public int strStr(String haystack, String needle) {
//        int l1 = haystack.length(), l2 = needle.length();
//        if (l1 < l2) return -1;
//        for (int i = 0; ; i++) {
//            if (i + l2 > l1) return -1;
//            for (int j = 0; ; j++) {
//                if (j == l2) return i;
//                if (haystack.charAt(i + j) != needle.charAt(j)) break;
//            }
//        }
//    }
}
