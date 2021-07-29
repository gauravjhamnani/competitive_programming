/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    // https://leetcode.com/problems/swapping-nodes-in-a-linked-list

    
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int len = findLength(head);
        if (len % 2 == 1 && (k - 1) == len/2) {
            return head;
        }
        if (k > len/2) {
            k = len - k + 1;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode preL = findKthNode(dummy, k - 1);
        ListNode preR = findKthNode(preL, len - (2 * k) + 1);
        swapNodes(preL, preR);
        return dummy.next;
    }

    private ListNode swapNodes(ListNode preL, ListNode preR) {
        if (preL.next == preR) { // when adjacent nodes need to be swapped
            ListNode temp2 = preR.next.next;
            preL.next = preR.next;
            preL.next.next = preR;
            preR.next = temp2;
        } else {
            ListNode temp1 = preL.next;
            ListNode temp2 = preR.next.next;
            preL.next = preR.next;
            preL.next.next = temp1.next;
            preR.next = temp1;
            temp1.next = temp2;
        }
    }
    
    private int findLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
    
    private ListNode findKthNode(ListNode head, int k) {
        int pos = 0;
        while (head != null && pos != k) {
            head = head.next;
            pos++;
        }
        return head;
    }
}