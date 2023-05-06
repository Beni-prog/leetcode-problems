package utils;

import java.util.Map;

/**
 * This is a utility class.
 */
public class Utils {

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * This method is used to display a map.
     *
     * @param map a map
     */
    public static void displayMap(Map<Integer, Integer> map) {
        for (Map.Entry entry : map.entrySet()) {
            System.out.println("Pair: (" + entry.getKey() + ", " + entry.getValue() + ")");
        }
    }


    /**
     * This method displays a 2D integer array.
     *
     * @param matrix a 2D integer array
     */
    public static void displayMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
        }
    }
}
