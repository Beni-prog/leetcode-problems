package linkedlists;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem 23. Merge k Sorted Lists
 * <p>
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * <p>
 * Merge all the linked-lists into one sorted linked-list and return it.
 */
public class MergeKSortedLists {

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
     * This method merges k sorted lists and build a single sorted linked list.
     *
     * @param lists a list of nodes representing the starting nodes of a sorted linked list.
     * @return a list node representing the start node of the new built linked list.
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        //add the head nodes of all the linked lists to the min-heap
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        //repeatedly extract the minimum element from the min-heap
        //and add it to the result linked list
        while (!minHeap.isEmpty()) {
            ListNode curr = minHeap.poll();
            tail.next = curr;
            tail = curr;
            //add also the curr next element on the min-heap,
            //because it might be the next minimum value
            if (curr.next != null) {
                minHeap.offer(curr.next);
            }
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

        ListNode start = mergeKLists(new ListNode[]{start1, start2});
        while (start != null) {
            System.out.print(start.val);
            System.out.print(" ");
            start = start.next;
        }
    }
}
