package google;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; // dp[i] represents the length of the longest increasing subsequence ending at index i
        Arrays.fill(dp, 1); // Initialize dp array with 1 (minimum length is 1 for each element)

        int maxLen = 1; // Variable to store the maximum length of the increasing subsequence

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));//4
        System.out.println(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));//4
        System.out.println(lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));//1
        System.out.println(lengthOfLIS(new int[]{1, 2, 3}));//3

    }
}
