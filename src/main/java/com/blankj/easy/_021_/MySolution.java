package com.blankj.easy._021_;

import com.blankj.structure.ListNode;
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

        ListNode listNode0 = ListNode.createTestData("[1,3,5,7,9]");
        ListNode listNode1 = ListNode.createTestData("[2,4,6,8,10]");

        ListNode result_1 = run_1(listNode0, listNode1);
        logger.info("result_1:{}", result_1);

        ListNode.print(result_1);
    }

    /**
     * 遍历1次
     * 时间复杂度：O(n * m)
     * 空间复杂度：O(1)
     *
     * @return
     */
    private static ListNode run_1(ListNode l0, ListNode l1) {
        ListNode resultNode = new ListNode(0);
        ListNode tempNode = resultNode;

        while (l0 != null && l1 != null) {
            if (l0.val <= l1.val) {
                tempNode.next = l0;
                l0 = l0.next;
            } else {
                tempNode.next = l1;
                l1 = l1.next;
            }
            tempNode = tempNode.next;
        }

        tempNode.next = l0 != null ? l0 : l1;
        return resultNode;
    }
}
