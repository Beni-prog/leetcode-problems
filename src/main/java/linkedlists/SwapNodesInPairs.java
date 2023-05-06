package linkedlists;

import utils.Utils.ListNode;

/**
 * Problem. 24. Swap Nodes in Pairs
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without
 * modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 */
public class SwapNodesInPairs {

    /**
     * This method swaps every two adjacent nodes and build a new list with this order.
     *
     * @param head the start node of a linked list
     * @return the start node of the new list in which every two adjacent nodes are swapped.
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        //link dummy node to the initial list
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            //1. curr is on the odd position, starting from 1
            ListNode curr = prev.next;
            //2. next is on the even position, starting from 2
            ListNode next = curr.next;
            //3. skip a node
            curr.next = next.next;
            //4. link next to curr
            next.next = curr;

            prev.next = next;
            //the current becomes the
            //previous for the next pair
            prev = curr;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode end1 = new ListNode(5, null);
        ListNode listNode14 = new ListNode(4, end1);
        ListNode listNode13 = new ListNode(3, listNode14);
        ListNode listNode12 = new ListNode(2, listNode13);
        ListNode start1 = new ListNode(1, listNode12);

        ListNode start = swapPairs(start1);
        while (start != null) {
            System.out.print(start.val);
            System.out.print(" ");
            start = start.next;
        }
    }
}
