package arrays;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> sum = new HashMap<>();
        int k = 0;

        for (int num1 : nums1) {
            for (int num2 : nums2) {
                sum.put(num1 + num2, sum.getOrDefault(num1 + num2, 0) + 1);
            }
        }

        for (int num3 : nums3) {
            for (int num4 : nums4) {
                if (sum.containsKey(-(num3 + num4))) {
                    k += sum.get(-(num3 + num4));
                }
            }
        }

        return k;
    }

    public static void main(String[] args) {
        System.out.println(fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
        System.out.println(fourSumCount(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}));
        System.out.println(fourSumCount(new int[]{1}, new int[]{-1}, new int[]{0}, new int[]{1}));
    }
}
