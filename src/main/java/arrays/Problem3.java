package arrays;

import java.util.HashMap;
import java.util.Map;

public class Problem3 {

    private static final Map<Integer, Integer> pairsZeroSubArray = new HashMap<>();

    public static void main(String[] args) {
        //3. Find zero sub arrays
        findZeroSumSubArray(new int[]{3, 4, -7, 3, 1, 3, 1, -4, -2, -2});
    }

    /**
     * Problem 3.
     * @param numbers
     */
    private static void findZeroSumSubArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int sum = 0;
            for (int j = i; j < numbers.length; j++) {
                sum += numbers[j];
                if (sum == 0)
                    pairsZeroSubArray.put(i, j);
            }
        }

        for (Map.Entry entry : pairsZeroSubArray.entrySet()) {
            int i = (int) entry.getKey();
            while (i <= (int) entry.getValue()) {
                System.out.print(numbers[i] + " ");
                i++;
            }
            System.out.println();
        }
    }
}
