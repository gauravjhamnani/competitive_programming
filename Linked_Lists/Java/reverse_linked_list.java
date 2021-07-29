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

    // https://leetcode.com/problems/reverse-linked-list

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode revHead = head;
        head = head.next;
        revHead.next = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = revHead;
            revHead = head;
            head = temp;
        }
        return revHead;
    }
}