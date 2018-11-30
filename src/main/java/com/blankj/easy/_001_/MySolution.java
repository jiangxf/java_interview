package com.blankj.easy._001_;

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

    static int[] arr = new int[]{2, 7, 11, 15, 18, 19, 23, 24};
    static int sum = 26;

    public static void main(String[] args) {

        int[] result_1 = run_1(arr, sum);
        logger.info("result_1:{}", result_1);

        int[] result_2 = run_2(arr, sum);
        logger.info("result_2:{}", result_2);
    }

    /**
     * 遍历2次
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(2)
     *
     * @param arr
     * @param sum
     * @return
     */
    private static int[] run_1(int[] arr, int sum) {
        int first = 0;
        int second = 0;
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            first = arr[i];

            // i 之前的已经做过比较，不需要考虑
            for (int j = i + 1; j < len; j++) {
                if (i == j) {
                    continue;
                }

                second = arr[j];
                if (sum - first == second) {
                    return new int[]{first, second};
                }
            }
        }
        return null;
    }

    /**
     * 遍历1次
     * 时间复杂度：O(n)
     * 空间复杂度：O(2n)
     *
     * @param arr
     * @param sum
     * @return
     */
    private static int[] run_2(int[] arr, int sum) {
        Map<Integer /* 差值 */, Integer /* 索引 */> map = Maps.newHashMap();

        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(sum - arr[i])) {
                return new int[]{arr[i], arr[map.get(sum - arr[i])]};
            }
            map.put(arr[i], i);
        }

        return null;
    }
}
