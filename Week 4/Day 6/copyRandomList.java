/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node current = head;
        while (current != null) {
            Node clone = new Node(current.val);
            clone.next = current.next;
            current.next = clone;
            current = clone.next;
        }

        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        Node oldList = head;
        Node newList = head.next;
        Node clonedHead = head.next;

        while (oldList != null) {
            oldList.next = oldList.next.next;
            if (newList.next != null) {
                newList.next = newList.next.next;
            }
            oldList = oldList.next;
            newList = newList.next;
        }

        return clonedHead;
    }
}