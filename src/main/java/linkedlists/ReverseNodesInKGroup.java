package linkedlists;

import utils.Utils.ListNode;

/**
 * Problem 25. Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a
 * multiple of k then left-out nodes, in the end, should remain as it is.
 * <p>
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 */
public class ReverseNodesInKGroup {

    /**
     * This method reverses the k-multiple nodes from a linked list.
     *
     * @param head the start node of a linked list
     * @param k    which k groups to reverse in the list
     * @return a start node which points to the reveresed list.
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;
        int count = 0;

        // Count the number of nodes in the current portion
        while (current != null && count < k) {
            current = current.next;
            count++;
        }

        // If there are k nodes, reverse them
        if (count == k) {
            current = head;
            while (count > 0) {
                //don't lose the remaining portion of the linked list
                next = current.next;
                //reverses the link between the current node and its next node
                current.next = prev;
                //update the prev pointer to the current node, as it will become
                //the previous node for the next iteration
                prev = current;
                //move forward in the linked list
                current = next;
                count--;
            }

            // Recursively reverse the next portion
            if (next != null) {
                head.next = reverseKGroup(next, k);
            }

            return prev; // new head of the reversed portion
        } else {
            return head; // not enough nodes to reverse
        }
    }

    public static void main(String[] args) {
        ListNode end = new ListNode(5, null);
        ListNode listNode14 = new ListNode(4, end);
        ListNode listNode13 = new ListNode(3, listNode14);
        ListNode listNode12 = new ListNode(2, listNode13);
        ListNode start = new ListNode(1, listNode12);

        ListNode head = reverseKGroup(start, 3);
        while (head != null) {
            System.out.print(head.val);
            System.out.print(" ");
            head = head.next;
        }
    }
}
