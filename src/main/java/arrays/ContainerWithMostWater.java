package arrays;

/**
 * Problem 11. Container With Most Water
 * <p>
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the
 * ith line are (i, 0) and (i, height[i]).
 * <p>
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * <p>
 * Return the maximum amount of water a container can store.
 * <p>
 * Notice that you may not slant the container.
 */
public class ContainerWithMostWater {

    /**
     * We start with the left and right pointers at the beginning and end of the array, respectively, and move them
     * inward while updating the maximum area found so far.
     * At each step, we compute the area of the container formed by the current left and right pointers, which is equal
     * to the minimum of the two heights times the distance between them. We then update the maximum area found so far
     * with the current area.
     * <p>
     * Finally, we move the left and right pointers inward based on the height of the two endpoints. Specifically, if the
     * height of the left endpoint is smaller than the height of the right endpoint, we move the left pointer to the right,
     * since increasing the left height will not increase the area of the container. Similarly, if the height of the right
     * endpoint is smaller than the height of the left endpoint, we move the right pointer to the left.
     *
     * @param height the array containing integer numbers
     * @return the maximum area
     */
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            //compute max between new area and old area
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));//49
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 7, 2, 3, 7}));//49
        System.out.println(maxArea(new int[]{1, 3, 2, 2, 5, 4, 8, 3, 2}));//10
        System.out.println(maxArea(new int[]{1, 1}));//1
        System.out.println(maxArea(new int[]{1, 0, 0, 0, 0, 0, 0, 2, 2}));//8
        System.out.println(maxArea(new int[]{4, 3, 2, 1, 4}));//16
        System.out.println(maxArea(new int[]{1, 2, 4, 3}));//4
    }
}
