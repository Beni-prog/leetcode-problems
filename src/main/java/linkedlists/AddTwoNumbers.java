package linkedlists;

/**
 * Problem 2. Add two numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
 * and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumbers {

    /**
     * Definition for singly-linked list as stated in the problem.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * This method receives the heads of two singly linked lists, that represents two numbers, and outputs another
     * singly linked list that represents the sum of the two numbers. The digits in the lists are in reversed order.
     *
     * @param l1 the head of the first singly linked list
     * @param l2 the head of the second singly linked list
     * @return the head of the singly linked list that represents the sum of the two numbers.
     */
    public static ListNode addTwoNumbersImproved(ListNode l1, ListNode l2) {
        ListNode head;
        ListNode tail = new ListNode();

        if (l1.next == null && l2.next == null) {
            if (l1.val + l2.val >= 10) {
                return new ListNode((l1.val + l2.val) % 10, new ListNode((l1.val + l2.val) / 10 % 10, null));
            } else {
                return new ListNode(l1.val + l2.val, null);
            }
        }

        int sum;

        if (l1.val + l2.val >= 10) {
            head = new ListNode((l1.val + l2.val) % 10, null);
            sum = (l1.val + l2.val) / 10 % 10;
            l1 = l1.next;
            l2 = l2.next;
        } else {
            if (l1.next != null && l2.next == null) {
                head = new ListNode((l1.val + l2.val) % 10, null);
                sum = (l1.val + l2.val) / 10 % 10;
                l1 = l1.next;
            } else if (l1.next == null) {
                head = new ListNode((l1.val + l2.val) % 10, null);
                sum = (l1.val + l2.val) / 10 % 10;
                l2 = l2.next;
            } else {
                sum = (l1.val + l2.val) / 10 % 10;
                head = new ListNode((l1.val + l2.val) % 10, null);
                l1 = l1.next;
                l2 = l2.next;
            }
        }

        while (l1 != null && l2 != null) {
            sum += l1.val;
            sum += l2.val;
            ListNode currentNode = new ListNode(sum % 10);
            tail.next = currentNode;
            tail = currentNode;
            if (head.next == null) {
                head.next = tail;
            }
            if (sum >= 10) {
                sum = sum / 10 % 10;
            } else {
                sum = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            sum += l1.val;
            ListNode currentNode = new ListNode(sum % 10);
            tail.next = currentNode;
            tail = currentNode;
            if (head.next == null) {
                head.next = tail;
            }
            if (sum > 9) {
                sum = sum / 10 % 10;
            } else {
                sum = 0;
            }
            l1 = l1.next;
        }

        while (l2 != null) {
            sum += l2.val;
            ListNode currentNode = new ListNode(sum % 10);
            tail.next = currentNode;
            tail = currentNode;
            if (head.next == null) {
                head.next = tail;
            }
            if (sum > 9) {
                sum = sum / 10 % 10;
            } else {
                sum = 0;
            }
            l2 = l2.next;
        }
        if (sum != 0) {
            tail.next = new ListNode(sum, null);
        }


        return head;
    }

    public static void main(String[] args) {
        ListNode end11 = new ListNode(3, null);
        ListNode listNode12 = new ListNode(4, end11);
        ListNode listNode11 = new ListNode(2, listNode12);

        ListNode end12 = new ListNode(4, null);
        ListNode listNode22 = new ListNode(6, end12);
        ListNode listNode21 = new ListNode(5, listNode22);

        ListNode listNode1 = new ListNode(0, null);
        ListNode listNode2 = new ListNode(0, null);

        ListNode end31 = new ListNode(9, null);
        ListNode listNode23 = new ListNode(4, end31);
        ListNode listNode13 = new ListNode(2, listNode23);

        ListNode end13 = new ListNode(9, null);
        ListNode listNode32 = new ListNode(4, end13);
        ListNode listNode31 = new ListNode(6, listNode32);
        ListNode listNode00 = new ListNode(5, listNode31);


        ListNode start1_ = addTwoNumbersImproved(listNode11, listNode21);
        System.out.println("Case1_: ");
        while (start1_ != null) {
            System.out.println(start1_.val);
            start1_ = start1_.next;
        }

        ListNode start2_ = addTwoNumbersImproved(listNode1, listNode2);
        System.out.println("Case2_: ");
        while (start2_ != null) {
            System.out.println(start2_.val);
            start2_ = start2_.next;
        }

        ListNode start3_ = addTwoNumbersImproved(listNode00, listNode13);
        System.out.println("Case3_: ");
        while (start3_ != null) {
            System.out.println(start3_.val);
            start3_ = start3_.next;
        }

        ListNode end1 = new ListNode(9, null);
        ListNode listNode9 = new ListNode(9, end1);
        ListNode listNode8 = new ListNode(9, listNode9);
        ListNode listNode7 = new ListNode(9, listNode8);
        ListNode listNode6 = new ListNode(9, listNode7);
        ListNode listNode5 = new ListNode(9, listNode6);
        ListNode listNode4 = new ListNode(9, listNode5);
        ListNode listNode3 = new ListNode(9, listNode4);
        ListNode listNode20 = new ListNode(9, listNode3);
        ListNode listNode10 = new ListNode(3, listNode20);

        ListNode listNode0 = new ListNode(7, null);


        ListNode start4_ = addTwoNumbersImproved(listNode0, listNode10);
        System.out.println("Case4_: ");
        while (start4_ != null) {
            System.out.println(start4_.val);
            start4_ = start4_.next;
        }


        ListNode end111 = new ListNode(9, null);
        ListNode listNode911 = new ListNode(9, end111);
        ListNode listNode811 = new ListNode(9, listNode911);
        ListNode listNode711 = new ListNode(9, listNode811);
        ListNode listNode611 = new ListNode(9, listNode711);
        ListNode listNode511 = new ListNode(9, listNode611);
        ListNode listNode411 = new ListNode(9, listNode511);

        ListNode end222 = new ListNode(9, null);
        ListNode listNode922 = new ListNode(9, end222);
        ListNode listNode822 = new ListNode(9, listNode922);
        ListNode listNode722 = new ListNode(9, listNode822);

        ListNode start5_ = addTwoNumbersImproved(listNode411, listNode722);
        System.out.println("Case5_: ");
        while (start5_ != null) {
            System.out.println(start5_.val);
            start5_ = start5_.next;
        }

        ListNode end333 = new ListNode(1, null);
        ListNode listNode833 = new ListNode(9, end333);
        ListNode listNode733 = new ListNode(9, listNode833);

        ListNode listNode933 = new ListNode(1, null);

        ListNode start6_ = addTwoNumbersImproved(listNode733, listNode933);
        System.out.println("Case6_: ");
        while (start6_ != null) {
            System.out.println(start6_.val);
            start6_ = start6_.next;
        }

        ListNode start7_ = addTwoNumbersImproved(end1, end333);
        System.out.println("Case7_: ");
        while (start7_ != null) {
            System.out.println(start7_.val);
            start7_ = start7_.next;
        }
    }
}
