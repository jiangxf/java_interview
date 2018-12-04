package com.blankj.easy._083_;

import com.blankj.structure.ListNode;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/05/10
 *     desc  :
 * </pre>
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode.print(solution.deleteDuplicates(ListNode.createTestData("[1,1,2]")));
        ListNode.print(solution.deleteDuplicates(ListNode.createTestData("[1,1,2,3,3]")));
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;

        while(temp.next != null){
            if(temp.val == temp.next.val){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }

        return head;
    }




















//    public ListNode deleteDuplicates(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode curr = head;
//        while (curr.next != null) {
//            if (curr.next.val == curr.val) {
//                curr.next = curr.next.next;
//            } else {
//                curr = curr.next;
//            }
//        }
//        return head;
//    }
}
