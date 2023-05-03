package arrays;

/**
 * Problem 45. Jump Game II
 * <p>
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 * <p>
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at
 * nums[i], you can jump to any nums[i + j] where:
 * <p>
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 */
public class JumpGame {

    /**
     * For each index i, check if there is a new possible farthest length from that index. If yes, update the farthest
     * length. When you jumped . Always take the highest jump (use the maximum pair (i, nums[i]). After all the jumps
     * were made, if you didn't land on a max pair, you have already stored the last max pair, so use that pair to
     * continue jumping.
     *
     * @param nums an array of integers
     * @return the minimum number of jumps to reach from the index 0 to the end of the array
     */
    public static int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        int noOfStepsThatCanBeJumped = 0;
        int farthestLength = 0;

        for (int i = 0; i < n - 1; i++) {
            //the maximum length that can be reached from i-th index
            farthestLength = Math.max(farthestLength, i + nums[i]);
            //if you did all the jumps, you need to jump again
            if (i == noOfStepsThatCanBeJumped) {
                jumps++;
                noOfStepsThatCanBeJumped = farthestLength;
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 1, 1, 1}));
        System.out.println(jump(new int[]{2, 3, 1, 1, 4, 2, 2, 1, 1, 1, 3}));
    }
}
