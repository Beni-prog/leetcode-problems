package linkedlists;

public class RotateList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode listNode) {
            val = x;
            next = listNode;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        //in case k > len, we want to save time so we will set k to
        //k%n, because we will get the same result
        k = k % len;

        while (k > 0) {
            ListNode current = head;

            while (current.next.next != null) {
                current = current.next;
            }

            ListNode newHead = new ListNode(current.next.val, null);
            current.next = null;
            newHead.next = head;
            head = newHead;
            k--;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode end1 = new ListNode(17, null);
        ListNode listNode14 = new ListNode(11, end1);
        ListNode listNode13 = new ListNode(7, listNode14);
        ListNode listNode12 = new ListNode(3, listNode13);
        ListNode start1 = new ListNode(1, listNode12);

        ListNode listNode31 = new ListNode(3, null);
        ListNode listNode21 = new ListNode(2, listNode31);
        ListNode start11 = new ListNode(1, listNode21);

        ListNode start = rotateRight(start1, 2000000000);
        while (start != null) {
            System.out.print(start.val);
            System.out.print(" ");
            start = start.next;
        }

        System.out.println();
        ListNode start2 = rotateRight(start11, 1);
        while (start2 != null) {
            System.out.print(start2.val);
            System.out.print(" ");
            start2 = start2.next;
        }
    }
}
