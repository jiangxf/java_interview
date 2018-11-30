package com.blankj.easy._026_;

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

        int[] arr = new int[]{0, 1, 1, 2, 3, 3, 3};
        Object result_1 = run_1(arr);
        logger.info("result_1:{}", result_1);

        //        int len = run_1(data);
//        for (int i = 0; i < len; i++) {
//            System.out.print(data[i] + (i == len - 1 ? "" : ", "));
//        }
    }

    /**
     * 遍历1次
     * 时间复杂度：O(n * m)
     * 空间复杂度：O(1)
     *
     * @param arr
     * @return
     */
    private static int run_1(int[] arr) {
        int len = arr.length;
        int temp = 1;

        for (int i = 1; i < len; i++) {
            if( arr[i] != arr[i - 1]){
                arr[temp++] = arr[i];
            }
        }

        return temp;
    }
}
