package linkedlists;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {

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

    public static boolean isPalindrome(ListNode head) {
        List<Integer> listValues = new ArrayList<>();

        while (head != null) {
            listValues.add(head.val);
            head = head.next;
        }

        int i = 0, j = listValues.size() - 1;
        while (i <= j) {
            if (!listValues.get(i).equals(listValues.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode end1 = new ListNode(1, null);
        ListNode listNode17 = new ListNode(2, end1);
        ListNode listNode16 = new ListNode(3, listNode17);
        ListNode listNode15 = new ListNode(4, listNode16);
        ListNode listNode14 = new ListNode(4, listNode15);
        ListNode listNode13 = new ListNode(3, listNode14);
        ListNode listNode12 = new ListNode(2, listNode13);
        ListNode start1 = new ListNode(1, listNode12);

        ListNode start2 = new ListNode(1, null);

        ListNode listNode32 = new ListNode(1, null);
        ListNode listNode31 = new ListNode(2, listNode32);
        ListNode start3 = new ListNode(1, listNode31);

        System.out.println(isPalindrome(start1));//true
        System.out.println(isPalindrome(start2));//true
        System.out.println(isPalindrome(start3));//true
    }
}
