package linkedlists;

public class OddEvenLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode listNode) {
            val = x;
            next = listNode;
        }
    }

    public static ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode headCopy = new ListNode(0, head);
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode startEvenNode = evenNode;

        while (oddNode.next != null && evenNode.next != null) {
            oddNode.next = evenNode.next;
            oddNode = evenNode.next;
            evenNode.next = oddNode.next;
            evenNode = oddNode.next;
        }

        oddNode.next = startEvenNode;

        return headCopy.next;
    }

    public static void main(String[] args) {
        ListNode end1 = new ListNode(8, null);
        ListNode listNode17 = new ListNode(7, end1);
        ListNode listNode16 = new ListNode(6, listNode17);
        ListNode listNode15 = new ListNode(5, listNode16);
        ListNode listNode14 = new ListNode(4, listNode15);
        ListNode listNode13 = new ListNode(3, listNode14);
        ListNode listNode12 = new ListNode(2, listNode13);
        ListNode start1 = new ListNode(1, listNode12);

        ListNode start = oddEvenList(start1);

        while (start != null) {
            System.out.print(start.val);
            System.out.print(" ");
            start = start.next;
        }
    }
}
