package linkedlists;

public class IntersectionOfTwoLinkedLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode listNode) {
            val = x;
            next = listNode;
        }
    }

    /**
     * Traverse both linked lists simultaneously by advancing the pointers pointerA and pointerB one node at a time.
     * <p>
     * When either of the pointers reaches the end of a linked list, move it to the head of the other linked list.
     * This step ensures that the pointers will meet at the intersection point if there is one.
     *
     * @param headA the start node of the first linked list
     * @param headB the start node of the second linked list
     * @return the node in which the lists intersect
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointerA = headA;
        ListNode pointerB = headB;

        //we repeat this process as many times as the
        //difference between the length of the 2 linked list
        while (pointerA != pointerB) {
            pointerA = (pointerA != null) ? pointerA.next : headB;
            pointerB = (pointerB != null) ? pointerB.next : headA;
        }

        return pointerA;
    }

    public static void main(String[] args) {
        ListNode end1 = new ListNode(5, null);
        ListNode listNode14 = new ListNode(4, end1);
        ListNode listNode13 = new ListNode(3, listNode14);
        ListNode listNode12 = new ListNode(2, listNode13);
        ListNode start1 = new ListNode(1, listNode12);

        ListNode listNode21 = new ListNode(2, listNode14);
        ListNode start11 = new ListNode(1, listNode21);

        System.out.println(getIntersectionNode(start1, start11).val);
    }
}
