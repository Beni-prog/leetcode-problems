package linkedlists;

public class RemoveNthNodeFromListII {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode listNode) {
            val = x;
            next = listNode;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast = head;
        ListNode slow = head;

        //put fast on the n position from end to start
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        //the number of nodes between these 2 pointers will be n
        //when the fast reaches null, slow will reach the node next to that from nth position
        //from end to start
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode end = new ListNode(5, null);
        ListNode listNode14 = new ListNode(4, end);
        ListNode listNode13 = new ListNode(3, listNode14);
        ListNode listNode12 = new ListNode(2, listNode13);
        ListNode start = new ListNode(1, listNode12);

        System.out.println(removeNthFromEnd(start, 2));
    }
}
