package arrays;

/**
 * Problem 27. Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
 * The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 * <p>
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the
 * following things:
 * <p>
 * Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
 * The remaining elements of nums are not important as well as the size of nums.
 * <p>
 * Return k.
 */
public class RemoveElement {

    /**
     * This method removes all the array elements that are equal to val.
     *
     * @param nums an array of integers
     * @param val  an integer
     * @return the nums array where the first k elements in the array do not contain val. k is the number of elements
     * not equal to val
     */
    public static int removeElement(int[] nums, int val) {

        //apply the reverse logic
        //instead of looking for elements that equal to val,
        //look for elements that are different than val and count them
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{1, 2, 3, 2, 4, 2, 3}, 2));
    }
}
