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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        curr = head;
        int index = count - n;
        if (index == 0) return head.next;
        int temp = 0;
        ListNode prev = null;
        while (temp != index) {
            prev = curr;
            curr = curr.next;
            temp++;
        }
        
        if (curr == null || prev == null) {
            return null;
        }
        prev.next = curr.next;
        curr.next = null;
        return head;

    }
}
