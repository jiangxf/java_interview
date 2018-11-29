package com.blankj.easy._007;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: MySolution
 * Date: 2018-11-29
 * Time: 15:47
 */
public class MySolution {

    protected static final Logger logger = LoggerFactory.getLogger(MySolution.class);

    public static void main(String[] args) {

        int oldValue = -123040500;

        Object result_1 = run_1(oldValue);
        logger.info("result_1:{}", result_1);

        Object result_2 = run_2(oldValue);
        logger.info("result_2:{}", result_2);
    }

    /**
     * 遍历1次
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param oldValue
     * @return
     */
    private static int run_1(int oldValue) {

        logger.info("oldValue:{}", oldValue);

        // 去掉后面的0
        while (oldValue % 10 == 0) {
            oldValue = oldValue / 10;
        }
        logger.info("oldValue:{}", oldValue);

        int before = 1;
        if (oldValue < 0) {
            before = -1;
            oldValue *= -1;
        }
        logger.info("oldValue:{}", oldValue);

        String oldValueStr = String.valueOf(oldValue);
        int len = oldValueStr.length();
        char[] newValueArr = new char[len];
        for (int i = oldValueStr.length() - 1; i >= 0; i--) {
            newValueArr[len - 1 - i] = oldValueStr.charAt(i);
        }

        return Integer.valueOf(new String(newValueArr)) * before;
    }

    /**
     * 遍历1次
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param oldValue
     * @return
     */
    private static int run_2(int oldValue) {

        int result = 0;
        int temp = oldValue;

        while (temp != 0) {
            result = result * 10 + temp % 10;
            temp /= 10;
        }
        return result;
    }
}
