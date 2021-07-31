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
class ReorderList {

    // https://leetcode.com/problems/reorder-list/

    public void reorderList(ListNode head) {
        Deque<ListNode> dq = new ArrayDeque<>();
        ListNode headCopy = head;
        while (headCopy != null) {
            dq.addLast(headCopy);
            headCopy = headCopy.next;
        }
        ListNode curr = new ListNode(0);
        while (dq.size() != 0) {
            curr.next = dq.removeFirst();
            curr = curr.next;
            if (dq.size() != 0) {
                curr.next = dq.removeLast();
                curr = curr.next;
            }
        }
        curr.next = null;
    }
}