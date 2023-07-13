package arrays;

public class FindNextPermutation {

    public static void nextPermutation(int[] nums) {
        int indexI = -1;
        int indexJ = -1;

        // Find the index of the first element that breaks the descending order from right to left
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                indexI = i - 1;
                break;
            }
        }

        if (indexI == -1) {
            // If no pair is found, reverse the entire array
            reverse(nums, 0, nums.length - 1);
        } else {
            // Find the index of the element that is greater than nums[indexI]
            for (int i = nums.length - 1; i > indexI; i--) {
                if (nums[i] > nums[indexI]) {
                    indexJ = i;
                    break;
                }
            }

            // Swap the elements at indices indexI and indexJ
            swap(nums, indexI, indexJ);

            // Reverse the subarray starting from index indexI + 1 to get the smallest permutation
            reverse(nums, indexI + 1, nums.length - 1);
        }
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 1, 5};
        nextPermutation(nums1);
        for (int j : nums1) {
            System.out.print(j + " ");
        }
    }
}
