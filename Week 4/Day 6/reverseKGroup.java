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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pointerGroupPrev = dummy;

        while (true) {
            ListNode kthNode = getKthNode(pointerGroupPrev, k);
            if (kthNode == null) {
                break;
            }

            ListNode nextGroupStart = kthNode.next;
            ListNode prev = nextGroupStart;
            ListNode curr = pointerGroupPrev.next;

            while (curr != nextGroupStart) {
                ListNode nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }

            ListNode temp = pointerGroupPrev.next;
            pointerGroupPrev.next = kthNode;
            pointerGroupPrev = temp;
        }

        return dummy.next;
    }

    public ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
