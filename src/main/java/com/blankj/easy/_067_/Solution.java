package com.blankj.easy._067_;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/05/07
 *     desc  :
 * </pre>
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("1010", "1011"));
    }

    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int len = aLen > bLen ? aLen : bLen;

        int tempV = 0;
        int add = 0;
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            tempV += (aLen - 1 < i) ? 0 : a.charAt(aLen - 1 - i) - '0';
            tempV += (bLen - 1 < i) ? 0 : b.charAt(bLen - 1 - i) - '0';
            tempV += add;

            add = tempV == 2 ? 1 : 0;
            sb.insert(0, tempV % 2);
            tempV = 0;
        }
        if (add > 0) {
            sb.insert(0, add);
        }
        return sb.toString();
    }

//    public String addBinary(String a, String b) {
//        StringBuilder sb = new StringBuilder();
//        int carry = 0, p1 = a.length() - 1, p2 = b.length() - 1;
//        while (p1 >= 0 || p2 >= 0 || carry == 1) {
//            carry += p1 >= 0 ? a.charAt(p1--) - '0' : 0;
//            carry += p2 >= 0 ? b.charAt(p2--) - '0' : 0;
//            sb.insert(0, (char) (carry % 2 + '0'));
//            carry >>= 1;
//        }
//        return sb.print();
//    }

//    public String addBinary(String a, String b) {
//        StringBuilder sb = new StringBuilder();
//        int carry = 0, p1 = a.length() - 1, p2 = b.length() - 1;
//        while (p1 >= 0 && p2 >= 0) {
//            carry += a.charAt(p1--) - '0';
//            carry += b.charAt(p2--) - '0';
//            sb.insert(0, (char) (carry % 2 + '0'));
//            carry >>= 1;
//        }
//        while (p1 >= 0) {
//            carry += a.charAt(p1--) - '0';
//            sb.insert(0, (char) (carry % 2 + '0'));
//            carry >>= 1;
//        }
//        while (p2 >= 0) {
//            carry += b.charAt(p2--) - '0';
//            sb.insert(0, (char) (carry % 2 + '0'));
//            carry >>= 1;
//        }
//        if (carry == 1) {
//            sb.insert(0, '1');
//        }
//        return sb.toString();
//    }
}
