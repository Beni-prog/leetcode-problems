package arrays;

import java.util.*;

public class IntersectionOfArraysII {

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> frequencyMap1 = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();

        // Step 1: Calculate frequency of elements in nums1
        for (int num : nums1) {
            frequencyMap1.put(num, frequencyMap1.getOrDefault(num, 0) + 1);
        }

        // Step 2: Find intersection with frequency in nums2
        for (int num : nums2) {
            if (frequencyMap1.containsKey(num) && frequencyMap1.get(num) > 0) {
                resultList.add(num);
                frequencyMap1.put(num, frequencyMap1.get(num) - 1);
            }
        }

        // Convert the result list to an array
        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }

        return resultArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));//2, 2
        System.out.println(Arrays.toString(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));//4, 9
    }
}
