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

    // https://leetcode.com/problems/remove-nth-node-from-end-of-list/solution/
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return null;
        }
        int len = 0;
        ListNode copy1 = head;
        while (copy1 != null) {
            copy1 = copy1.next;
            len++;
        }
        if (len == n) {
            return head.next;
        }
        n = len - n;
        ListNode copy = head;
        int pos = 1;
        while (head != null && pos != n) {
            head = head.next;
            pos++;
        }
        if (head.next != null) {
            head.next = head.next.next;
        } 
        return copy;
    }
}