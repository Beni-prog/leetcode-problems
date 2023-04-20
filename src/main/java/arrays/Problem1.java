package arrays;

import utils.Utils;

import java.util.HashMap;
import java.util.Map;

public class Problem1 {
    private static final Map<Integer, Integer> pairsGivenSum = new HashMap<>();


    public static void main(String[] args) {
        //1. Find pair of type (a,b), with a+b=target;
        System.out.println("\nPb 1: ");
        findPairGivenSum(new int[]{1, 9, 5, 8, 6, 7, 2, 3, 4, 1, 1, 9}, 10);
    }



    /**
     * Problem 1. only works for positive integers
     * @param numbers
     * @param target
     */
    private static void findPairGivenSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        java.util.Arrays.sort(numbers);

        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                pairsGivenSum.put(numbers[start], numbers[end]);
                start++;
            } else if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                end--;
            }
        }
        Utils.displayMap(pairsGivenSum);
    }
}
