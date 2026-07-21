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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode ret = null;
        ListNode h = null;
        int rem = 0;
        while (c1 != null || c2 != null || rem == 1) {
            int val;
            if (c1 != null && c2 != null) {
                val = (c1.val + c2.val + rem) % 10;
                rem = (c1.val + c2.val + rem) / 10;
                if (ret == null) {
                    ret = new ListNode(val);
                    h = ret;
                } else {
                    ListNode temp = new ListNode(val);
                    ret.next = temp;
                    ret = ret.next;
                }
                c1 = c1.next;
                c2 = c2.next;
            } else if (c1 != null) {
                val = (c1.val + rem) % 10;
                rem = (c1.val + rem) / 10;
                if (ret == null) {
                    ret = new ListNode(val);
                    h = ret;
                } else {
                    ListNode temp = new ListNode(val);
                    ret.next = temp;
                    ret = ret.next;
                }
                c1 = c1.next;
            } else if (c2 != null) {
                val = (c2.val + rem) % 10;
                rem = (c2.val + rem) / 10;
                if (ret == null) {
                    ret = new ListNode(val);
                    h = ret;
                } else {
                    ListNode temp = new ListNode(val);
                    ret.next = temp;
                    ret = ret.next;
                }
                c2 = c2.next;
            } else {
                val = rem % 10;
                rem = rem / 10;
                if (ret == null) {
                    ret = new ListNode(val);
                    h = ret;
                } else {
                    ListNode temp = new ListNode(val);
                    ret.next = temp;
                    ret = ret.next;
                }
            }
        }
        return h;
    }
}
