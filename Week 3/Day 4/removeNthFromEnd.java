/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode forwardPtr = sentinel;
        ListNode trailingPtr = sentinel;

        int windowGap = 0;
        while (windowGap <= n && forwardPtr != null) {
            forwardPtr = forwardPtr.next;
            windowGap++;
        }

        while (forwardPtr != null) {
            forwardPtr = forwardPtr.next;
            trailingPtr = trailingPtr.next;
        }

        if (trailingPtr.next != null) {
            trailingPtr.next = trailingPtr.next.next;
        }
        
        return sentinel.next;
    }
}
