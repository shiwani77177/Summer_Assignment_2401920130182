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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode midNode = extractMiddle(head);
        ListNode rightHalf = midNode.next;
        midNode.next = null; 
        ListNode sortedLeft = sortList(head);
        ListNode sortedRight = sortList(rightHalf);
        return combineLists(sortedLeft, sortedRight);
    }
    
    private ListNode extractMiddle(ListNode start) {
        ListNode slowPtr = start;
        ListNode fastPtr = start.next;
        
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }
    
    private ListNode combineLists(ListNode pointerA, ListNode pointerB) {
        ListNode placeholder = new ListNode(-1);
        ListNode currentTail = placeholder;
        
        while (pointerA != null && pointerB != null) {
            if (pointerA.val <= pointerB.val) {
                currentTail.next = pointerA;
                pointerA = pointerA.next;
            } else {
                currentTail.next = pointerB;
                pointerB = pointerB.next;
            }
            currentTail = currentTail.next;
        }
        currentTail.next = (pointerA != null) ? pointerA : pointerB;
        
        return placeholder.next;
    }
}