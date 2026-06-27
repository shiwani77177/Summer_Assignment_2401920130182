class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode anchor = new ListNode(0);
        ListNode current = anchor;
        int carryOver = 0;

        while (l1 != null || l2 != null || carryOver != 0) {
            int sum = carryOver;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carryOver = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        return anchor.next;
    }
}
