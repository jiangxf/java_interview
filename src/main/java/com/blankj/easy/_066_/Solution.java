package com.blankj.easy._066_;

import java.util.Arrays;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/05/06
 *     desc  :
 * </pre>
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] digits = solution.plusOne(new int[]{9, 9, 9});
        System.out.println(Arrays.toString(digits));
    }

    public int[] plusOne(int[] digits) {
        int last = digits.length - 1;
        int add = 9;

        for (int i = last; i >= 0; i--) {
            int temp = digits[i] + add;
            digits[i] = temp % 10;
            add = temp / 10;
        }

        if (add > 0) {
            int[] newArr = new int[digits.length + 1];
            newArr[0] = add;
            for (int i = 0; i < digits.length; i++) {
                newArr[i + 1] = digits[i];
            }
            return newArr;
        }
        return digits;
    }

//    public int[] plusOne(int[] digits) {
//        int p = digits.length - 1;
//        if (digits[p] < 9) {
//            digits[p] = ++digits[p];
//        } else {
//            do {
//                digits[p--] = 0;
//            } while (p >= 0 && digits[p] == 9);
//            if (digits[0] != 0) {
//                ++digits[p];
//            } else {
//                digits = new int[digits.length + 1];
//                digits[0] = 1;
//            }
//        }
//        return digits;
//    }
}
