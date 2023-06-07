package linkedlists;

public class LinkedListCycleII {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode listNode) {
            val = x;
            next = listNode;
        }
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode tortoise = head;
        ListNode hare = head;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;

            if (tortoise == hare) {
                break;
            }
        }

        if (hare == null || hare.next == null) {
            return null;
        }

        tortoise = head;
        while (tortoise != hare) {
            tortoise = tortoise.next;
            hare = hare.next;
        }

        return tortoise;
    }

    public static void main(String[] args) {

        ListNode end1 = new ListNode(5, null);
        ListNode listNode14 = new ListNode(4, end1);
        ListNode listNode13 = new ListNode(3, listNode14);
        ListNode listNode12 = new ListNode(2, listNode13);
        ListNode start1 = new ListNode(1, listNode12);
        end1.next = listNode13;

        System.out.println(detectCycle(start1).val);// 3
    }
}
