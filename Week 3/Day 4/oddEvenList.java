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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddCursor = head;
        ListNode evenCursor = head.next;
        ListNode evenListHead = evenCursor; 
        while (evenCursor != null && evenCursor.next != null) {
            oddCursor.next = evenCursor.next;
            oddCursor = oddCursor.next;

            evenCursor.next = oddCursor.next;
            evenCursor = evenCursor.next;
        }
        oddCursor.next = evenListHead;

        return head;
    }
}