package arrays;

import java.util.Arrays;

public class FirstAndLastPosOfElement {

    public static int[] searchRange(int[] nums, int target) {
        int cop1 = -1;
        int cop2 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                cop1 = i;
                int j = i;
                while (j < nums.length && nums[j] == target) {
                    cop2 = j;
                    j++;
                }
                break;
            }
        }
        return new int[]{cop1, cop2};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
    }
}
