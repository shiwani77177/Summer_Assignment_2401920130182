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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slowExplorer = head;
        ListNode fastExplorer = head;
        
        while (fastExplorer != null && fastExplorer.next != null) {
            slowExplorer = slowExplorer.next;
            fastExplorer = fastExplorer.next.next;
        }
        
        ListNode invertedSegmentHead = null;
        ListNode currentWalkNode = slowExplorer;
        
        while (currentWalkNode != null) {
            ListNode trailingNodeSave = currentWalkNode.next;
            currentWalkNode.next = invertedSegmentHead;
            invertedSegmentHead = currentWalkNode;
            currentWalkNode = trailingNodeSave;
        }
        ListNode forwardPointer = head;
        ListNode backwardPointer = invertedSegmentHead;
        boolean matchesPerfect = true;
        
        while (backwardPointer != null) {
            if (forwardPointer.val != backwardPointer.val) {
                matchesPerfect = false;
                break;
            }
            forwardPointer = forwardPointer.next;
            backwardPointer = backwardPointer.next;
        }
        
        return matchesPerfect;
    }
}