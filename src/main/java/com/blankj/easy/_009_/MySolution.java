package com.blankj.easy._009_;

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

    public static void main(String[] args) {

        int oldValue = 1204021;

//        Object result_1 = run_1(oldValue);
//        logger.info("result_1:{}", result_1);

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
    private static boolean run_1(int oldValue) {
        // 排除负数
        // 参考 007，求逆序，再比较
        return true;
    }

    /**
     * 算一般的逆序即可
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param oldValue
     * @return
     */
    private static boolean run_2(int oldValue) {

        // 排除负数
        // 排除最后一位是0值的情况
        if(oldValue < 0 || oldValue % 10 == 0){
            return false;
        }

        int result = 0;
        int temp = oldValue;

        while (temp != 0) {
            result = result * 10 + temp % 10;
            temp /= 10;

            // 已经走到中间+1的位置了
            if(result >= temp){
                return (result / 10 == temp) || (result == temp);
            }
        }
        return false;
    }
}
