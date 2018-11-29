package com.fishercoder.solutions;

/**
 * 405. Convert a Number to Hexadecimal
 * <p>
 * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
 * <p>
 * Note:
 * <p>
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s.
 * If the number is zero, it is represented by a single zero character '0';
 * otherwise, the first character in the hexadecimal string MySolution not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
 * You must not use any method provided by the library which converts/formats the number to hex directly.
 * <p>
 * Example 1:
 * Input:
 * 26
 * <p>
 * Output:
 * "1a"
 * <p>
 * Example 2:
 * Input:
 * -1
 * <p>
 * Output:
 * "ffffffff"
 */
public class _405 {

    public String toHex(int num) {
        char[] hexChars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        String result = "";
        while (num != 0) {
            result = hexChars[(num & 15)] + result;
            num >>>= 4;
        }
        return result.isEmpty() ? "0" : result;
    }

}
