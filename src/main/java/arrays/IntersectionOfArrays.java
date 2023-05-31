package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            if (set.contains(num)) {
                result.add(num);
            }
        }

        int size = result.size();
        Integer[] myResult = result.toArray(new Integer[size]);
        int[] results = new int[myResult.length];
        for (int i = 0; i < myResult.length; i++) {
            results[i] = myResult[i];
        }

        return results;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}
