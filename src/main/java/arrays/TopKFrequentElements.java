package arrays;

import java.util.*;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int integer : nums) {
            frequency.put(integer, frequency.getOrDefault(integer, 0) + 1);
        }

        // Sort the map by values
        List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(frequency.entrySet());
        sortedList.sort(Map.Entry.comparingByValue((a, b) -> -a.compareTo(b)));
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = sortedList.get(i).getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(topKFrequent(new int[]{1}, 1)));
    }
}
