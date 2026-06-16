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
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode primaryWalker = head;
        ListNode advancedWalker = head;
        ListNode intersectionNode = null;

        while (advancedWalker != null && advancedWalker.next != null) {
            primaryWalker = primaryWalker.next;
            advancedWalker = advancedWalker.next.next;

            if (primaryWalker == advancedWalker) {
                intersectionNode = primaryWalker;
                break;
            }
        }

        if (intersectionNode == null) {
            return null;
        }
        ListNode originFinder = head;
        while (originFinder != intersectionNode) {
            originFinder = originFinder.next;
            intersectionNode = intersectionNode.next;
        }
        return originFinder;
    }
}
