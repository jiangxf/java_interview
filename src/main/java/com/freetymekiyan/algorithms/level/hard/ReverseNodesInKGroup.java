package com.freetymekiyan.algorithms.level.hard;

import com.freetymekiyan.algorithms.utils.Utils.ListNode;

/**
 * 25. Reverse Nodes in k-Group
 * <p>
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * <p>
 * Only constant memory is allowed.
 * <p>
 * For example,
 * Given this linked list: 1->2->3->4->5
 * <p>
 * For k = 2, you should return: 2->1->4->3->5
 * <p>
 * For k = 3, you should return: 3->2->1->4->5
 * <p>
 * Company Tags: Microsoft, Facebook
 * Tags: Linked List
 * Similar Problems: (E) Swap Nodes in Pairs
 */
public class ReverseNodesInKGroup {

    /**
     * Recursive.
     * Recurrence relation:
     * Reverse the current group and connect with reverseKGroup result on the rest of the list.
     * Implementation:
     * Try to find the head of the rest of the list by moving pointer.
     * Increment a counter for each step.
     * If counter != k, the group doesn't exist, return head directly.
     * Else reverse the rest of the list.
     * Store the node
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode nextHead = head;
        int count = 0;
        while (nextHead != null && count != k) { // Find the head of the rest of the list.
            nextHead = nextHead.next;
            count++;
        }
        if (count != k) {
            return head; // Return original head since not enough nodes.
        }
        ListNode newHead = reverseKGroup(nextHead, k); // Recurse on the rest of the list.
        // Head of reversed list. Init as the restHead which is the tail.
        while (count-- > 0) { // Reverse node k times.
            ListNode next = head.next;
            head.next = newHead; // newHead is the head of current reversed list.
            newHead = head;
            head = next;
        }
        return newHead;
    }

    /**
     * Iterative.
     * Divide linked list into two parts:
     * The first K nodes as a group, L1, might not exist.
     * The rest of the linked list, L2.
     * So first we move a pointer to the head of L2.
     * If we reach the end before K step, no more reverse, break and return.
     * If we find the head of L2, restHead, use it as a stop point for reverse.
     * Then we reverse the current group.
     */
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // We need a pointer at previous group's tail to connect previous group with current group.
        // The pointer MySolution act like a dummy head, whose next is the current head of reversed list.
        // Since first group doesn't have a previous tail, we create one for it.
        ListNode pre = dummy; // The dummy node before current group's head. Also the tail of previous group.
        ListNode cur = head; // Current group head.

        while (cur != null) {
            ListNode nextHead = cur;
            int group = k;
            while (nextHead != null && group > 0) { // Find nextHead.
                group--;
                nextHead = nextHead.next;
            }
            if (group > 0) { // Reach list end. Not enough nodes.
                break;
            }
            // Similar to reverse linked list. Reverse cur and cur.next.
            while (cur.next != nextHead) { // Stop right before next group's head.
                ListNode next = cur.next.next;
                cur.next.next = pre.next;
                pre.next = cur.next;
                cur.next = next;
            }
            pre = cur; // Move current dummy to the end of current group.
            cur = cur.next; // Move current head to the next group.
        }

        return dummy.next;
    }
}