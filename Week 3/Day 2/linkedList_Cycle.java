/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slowExplorer = head;
        ListNode fastExplorer = head;
        while (fastExplorer != null && fastExplorer.next != null) {
            slowExplorer = slowExplorer.next;         
            fastExplorer = fastExplorer.next.next;     
            if (slowExplorer == fastExplorer) {
                return true;
            }
        }
        return false;
    }
}