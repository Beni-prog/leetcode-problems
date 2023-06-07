package linkedlists;

public class LinkedListCycle {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode listNode) {
            val = x;
            next = listNode;
        }
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode tortoise = head;
        ListNode hare = head;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;

            if (tortoise == hare) {
                return true; // Cycle detected
            }
        }

        return false; // No cycle detected
    }

    public static void main(String[] args) {
        ListNode end1 = new ListNode(5, null);
        ListNode listNode14 = new ListNode(4, end1);
        ListNode listNode13 = new ListNode(3, listNode14);
        ListNode listNode12 = new ListNode(2, listNode13);
        ListNode start1 = new ListNode(1, listNode12);
        end1.next = listNode13;

        System.out.println(hasCycle(start1));

        ListNode listNode21 = new ListNode(2, null);
        ListNode start11 = new ListNode(1, listNode21);

        System.out.println(hasCycle(start11));
    }
}
