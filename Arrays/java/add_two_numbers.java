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

    // https://leetcode.com/problems/add-two-numbers
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode ans = new ListNode();
        ListNode ref = ans;
        int carry = 0;
        while (Objects.nonNull(l1) || Objects.nonNull(l2)) {
            int sum = 0;
            if (Objects.nonNull(l1) && Objects.nonNull(l2)) {
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            } else if(Objects.nonNull(l1)) {
                sum = l1.val + carry;
                l1 = l1.next;
            } else {
                sum = l2.val + carry;
                l2 = l2.next;
            }
            carry = sum / 10;
            ans.next = new ListNode(sum % 10);
            ans = ans.next;
        }
        if (carry != 0) {
            ans.next = new ListNode(carry);
        }
        return ref.next;
    }
}