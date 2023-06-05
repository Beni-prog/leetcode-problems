package arrays;

import java.util.*;

public class TwoSumReturnIndices {

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(numbers[i])) {
                map.put(numbers[i], i);
            } else if (2 * numbers[i] == target) {
                result[0] = map.get(numbers[i]);
                result[1] = i;
                return result;
            }
        }

        for (int number : numbers) {
            if (map.containsKey(number) && map.containsKey(target - number) && !map.get(number).equals(map.get(target - number))) {
                result[0] = map.get(number);
                result[1] = map.get(target - number);
                return result;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 3}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{2, 5, 5, 11}, 10)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1}, 11)));
    }
}
