package com.blankj.easy._069_;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/05/08
 *     desc  :
 * </pre>
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(10));
    }

    public int mySqrt(int x) {
        int half = x;
        while (half * half > x) {
            half = (half + x / half) >> 1;
        }
        return half;
    }

//    public int mySqrt(int x) {
//        long n = x;
//        while (n * n > x) {
//            n = (n + x / n) >> 1;
//        }
//        return (int) n;
//    }
}
