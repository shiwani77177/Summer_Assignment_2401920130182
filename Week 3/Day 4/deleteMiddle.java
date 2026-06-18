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
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode midPrecursor = head;
        ListNode leadPtr = head.next.next;
        
        while (leadPtr != null && leadPtr.next != null) {
            midPrecursor = midPrecursor.next;
            leadPtr = leadPtr.next.next;
        }
        
        if (midPrecursor.next != null) {
            midPrecursor.next = midPrecursor.next.next;
        }
        
        return head;
    }
}
