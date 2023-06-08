package linkedlists;

public class MergedTwoLinkedListsII {

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * This method iterates over two sorted linked lists and merged them into one sorted linked list.
     *
     * @param l1 the start node of the first sorted linked list
     * @param l2 the start node of the second sorted linked list
     * @return the start of the merged linked list
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode end1 = new ListNode(17, null);
        ListNode listNode14 = new ListNode(11, end1);
        ListNode listNode13 = new ListNode(7, listNode14);
        ListNode listNode12 = new ListNode(3, listNode13);
        ListNode start1 = new ListNode(1, listNode12);

        ListNode end2 = new ListNode(18, null);
        ListNode listNode24 = new ListNode(12, end2);
        ListNode listNode23 = new ListNode(6, listNode24);
        ListNode listNode22 = new ListNode(4, listNode23);
        ListNode start2 = new ListNode(2, listNode22);

        ListNode start = mergeTwoLists(start1, start2);
        while (start != null) {
            System.out.print(start.val);
            System.out.print(" ");
            start = start.next;
        }
    }
}
