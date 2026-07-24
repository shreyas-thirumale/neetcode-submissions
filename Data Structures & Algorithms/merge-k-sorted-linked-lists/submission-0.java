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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ListNode curr = null;
        for (ListNode head : lists) {
            curr = head;
            while (curr != null) {
                pq.offer(curr.val);
                curr = curr.next;
            }
        }
        ListNode newH = null;
        ListNode iter = null;
        while (!pq.isEmpty()) {
            if (iter == null) {
                ListNode temp = new ListNode(pq.poll(), null);
                iter = temp;
                newH = iter;
            } else {
                ListNode temp = new ListNode(pq.poll(), null);
                iter.next = temp;
                iter = iter.next;
            }
        }
        return newH;

    }
}
