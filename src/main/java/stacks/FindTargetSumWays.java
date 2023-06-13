package stacks;

import java.util.HashMap;
import java.util.Map;

public class FindTargetSumWays {

    public static int findTargetSumWays(int[] nums, int S) {
        // Create a memoization map to store intermediate results
        Map<String, Integer> memo = new HashMap<>();
        return calculate(nums, 0, 0, S, memo);
    }

    private static int calculate(int[] nums, int index, int sum, int target, Map<String, Integer> memo) {
        // Check if the current combination has been calculated before
        String key = index + ":" + sum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Base case: when we reach the end of the array
        if (index == nums.length) {
            // Check if the sum matches the target
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        // Calculate the number of expressions by adding or subtracting the current number
        int positive = calculate(nums, index + 1, sum + nums[index], target, memo);
        int negative = calculate(nums, index + 1, sum - nums[index], target, memo);

        // Store the result in the memoization map
        memo.put(key, positive + negative);

        return positive + negative;
    }

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
