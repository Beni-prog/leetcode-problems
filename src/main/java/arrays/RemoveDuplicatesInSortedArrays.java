package arrays;

/**
 * Problem 26. Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each
 * unique element appears only once. The relative order of the elements should be kept the same. Then return the number
 * of unique elements in nums.
 * <p>
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
 * <p>
 * Change the array nums such that the first k elements of nums contain the unique elements in the order they were
 * present in nums initially. The remaining elements of nums are not important as well as the size of nums.
 * <p>
 * Return k.
 */
public class RemoveDuplicatesInSortedArrays {

    /**
     * This method removes the duplicates from a sorted array in ascending order and it also modifies the initial array.
     *
     * @param nums an array of integers
     * @return the number of unique elements in the array
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //the key is to override the elements when no duplicates were found
        int k = 1; // Initialize the count of unique elements
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i]; //when elements are unique, k=i
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 2, 3, 3, 3, 4}));
    }
}
