package com.blankj.easy._014_;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: MySolution
 * Date: 2018-11-29
 * Time: 15:47
 */
public class MySolution {

    protected static final Logger logger = LoggerFactory.getLogger(MySolution.class);

    static String[] arr = new String[]{"fl", "flow", "flower"};

    public static void main(String[] args) {

        Object result_1 = run_1(arr);
        logger.info("result_1:{}", result_1);
    }

    /**
     * 遍历1次
     * 时间复杂度：O(n * m)
     * 空间复杂度：O(1)
     *
     * @param arr
     * @return
     */
    private static String run_1(String[] arr) {
        int arrlen = arr.length;
        int strLen = arr[0].length();

        int i = 0;
        int j = 0;
        for (i = 0; i < strLen; i++) {

            char ch = arr[0].charAt(i);
            for (j = 1; j < arrlen; j++) {
                if (arr[j].length() <= i || arr[j].charAt(i) != ch) {
                    break;
                }
            }

            if (j != arrlen) {
                return arr[0].substring(0, i);
            }
        }

        return arr[0].substring(0, i);
    }
}
