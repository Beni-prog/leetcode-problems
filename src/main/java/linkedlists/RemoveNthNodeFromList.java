package linkedlists;

/**
 * Problem 19. Remove Nth Node From End of List
 * <p>
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class RemoveNthNodeFromList {

    /**
     * Definition of a singly linked list
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

    static class Solution {

        /**
         * This method eliminates the nth node from the end of a singly linked list.
         *
         * @param head the start node of a singly linked list
         * @param n    the postion of the node from the end of the list we want to remove
         * @return the start node of the list witohout the nth node
         */
        public static ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            //use two pointers, slow and fast, initialized to point at the head of the linked list
            ListNode slow = dummy;
            ListNode fast = dummy;

            //move the fast pointer n steps ahead of the slow pointer
            for (int i = 0; i <= n; i++) {
                fast = fast.next;
            }

            //now fast is on the (n+1)th node and slow is still on ListNode(0)
            //there will always be n nodes between these two pointers
            //so, when fast will reach the end and it will be null,
            //the slow will be on the n-1 node
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }

            slow.next = slow.next.next;
            return dummy.next;
        }

        public static void main(String[] args) {
            ListNode end = new ListNode(5, null);
            ListNode listNode14 = new ListNode(4, end);
            ListNode listNode13 = new ListNode(3, listNode14);
            ListNode listNode12 = new ListNode(2, listNode13);
            ListNode start = new ListNode(1, listNode12);

            ListNode head = removeNthFromEnd(start, 3);
            while (head != null) {
                System.out.print(head.val);
                System.out.print(" ");
                head = head.next;
            }
        }
    }
}
