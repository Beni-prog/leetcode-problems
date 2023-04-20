package arrays;

import java.util.HashMap;
import java.util.Map;

import static utils.Utils.displayMap;

public class Problem2 {

    private static final Map<Integer, Integer> pairsMaximumProduct = new HashMap<>();

    public static void main(String[] args) {
        //2. Find pair of type (a,b), with a*b=max;
        System.out.println("\nPb 2: ");
        findPairMaximumProduct(new int[]{1, 5, 8, -6, -12, 6, 7, 2, 3, 4, 1, 1, 9});
    }

    /**
     * Problem 2.
     * @param numbers
     */
    private static void findPairMaximumProduct(int[] numbers) {
        int firstMax = numbers[0];
        int secondMax = numbers[0];
        int firstMin = numbers[0];
        int secondMin = numbers[0];

        for (int number : numbers) {
            if (number > firstMax) {
                secondMax = firstMax;
                firstMax = number;
            } else if (number > secondMax) {
                secondMax = number;
            }

            if (number < firstMin) {
                secondMin = firstMin;
                firstMin = number;
            } else if (number < secondMin && number != firstMin) {
                secondMin = number;
            }
        }
        findPairGivenProduct(numbers, Math.max(firstMax * secondMax, firstMin * secondMin));
    }

    private static void findPairGivenProduct(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++)
                if (numbers[i] * numbers[j] == target) {
                    pairsMaximumProduct.put(numbers[i], numbers[j]);
                }
        }
        displayMap(pairsMaximumProduct);
    }
}
