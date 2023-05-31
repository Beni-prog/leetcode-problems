package integers;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * <p>
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
public class SingleNumber {

    /**
     * This method finds the element that appears only once in the array, using XOR operation. XOR has the following
     * properties:
     * <p>
     * XOR of a number with itself is 0: a ^ a = 0.
     * XOR of a number with 0 is the number itself: a ^ 0 = a.
     * XOR is commutative: a ^ b = b ^ a.
     *
     * @param nums an array of integers
     * @return the integer that appears only n=once in the array.
     */
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            //performing the XOR operation,
            //we will cancel all the pairs in the array;
            //it works like this: when we apply ^ on 2 non zero elements, we perform the sum of them;
            //when we find an element that we've seen before, we subtract it;
            //hence, result will have the element that appears only once;
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}));
    }
}
