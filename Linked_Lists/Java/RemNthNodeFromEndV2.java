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
class RemNthNodeFromEndV2 {

    // https://leetcode.com/problems/remove-nth-node-from-end-of-list/solution/

    /*
    * This approach needs only one pass
    */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fwdPtr = head;
        while (n != 0 && fwdPtr != null) {
            fwdPtr = fwdPtr.next;
            n--;
        }
        if (n != 0) {
            return null;
        }
        if (fwdPtr == null) {
            return head.next;
        }
        ListNode bwdPtr = head;
        while (fwdPtr.next != null) {
            fwdPtr = fwdPtr.next;
            bwdPtr = bwdPtr.next;
        }
        bwdPtr.next = bwdPtr.next.next;
        return head;
    }
}
