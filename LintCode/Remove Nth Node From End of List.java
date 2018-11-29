������Ϊhead�޷�ȷ���������õ���Dummy Node.

        ��Σ�Ϊ��ɾ��������N���ڵ㣬����ʹ���˿���ָ������ȡ�䵹���ڵ�N+1���ڵ㣬
        ����Ҫɾ���ڵ��ǰһ���㡣�����������ɾ��������

        ��������ѵ����ڿ���ָ����Ŀ�ʼ�ƶ����ƶ������㡣
        �����������⣬����ֻ��Ҫ����һ��򵥵�����ʵ��һ�߱���Եõ���ȷ�Ľ������ɾ�������������ڵ㣺1->2->3->null
        ������Ҫ�໭ͼ��(nullҲҪ������)��������������������˼����
        �в���ֻ���롣�������������ٶ����������׳���

/*
Given a linked list, remove the nth node from the end of list and return its head.

Note
The minimum number of nodes in list is n.

Example
Given linked list: 1->2->3->4->5->null, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5->null.
Challenge
O(n) time

Tags Expand 
Two Pointers Linked List

*/

/**
 * Definition for ListNode.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int val) {
 * this.val = val;
 * this.next = null;
 * }
 * }
 */
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n:    An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if (n <= 0) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode preDel = dummy;

        for (int i = 0; i < n; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        while (head != null) {
            head = head.next;
            preDel = preDel.next;
        }

        preDel.next = preDel.next.next;
        return dummy.next;
    }
}
