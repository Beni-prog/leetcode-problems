package linkedlists;

public class ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode listNode) {
            val = x;
            next = listNode;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next;

        if (head.next == null) {
            return head;
        }

        while (current != null) {
            next = current.next; // Store the next node
            current.next = previous; // Reverse the direction of the current node
            previous = current; // Move the previous pointer
            current = next; // Move the current pointer
        }

        return previous;
    }

    public static void main(String[] args) {
        ListNode end1 = new ListNode(5, null);
        ListNode listNode14 = new ListNode(4, end1);
        ListNode listNode13 = new ListNode(3, listNode14);
        ListNode listNode12 = new ListNode(2, listNode13);
        ListNode start1 = new ListNode(1, listNode12);

        ListNode start = reverseList(start1);
        while (start != null) {
            System.out.print(start.val);
            System.out.print(" ");
            start = start.next;
        }
    }
}
