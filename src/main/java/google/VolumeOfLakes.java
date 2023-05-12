package google;

/**
 * Imagine an island that is in the shape of a bar graph. When it rains, certain areas of the island fill up with
 * rainwater to form lakes. Any excess rainwater the island cannot hold in lakes will run off the island to the west or
 * east and drain into the ocean.
 * <p>
 * Given an array of positive integers representing 2-D bar heights, design an algorithm (or write a function) that can
 * compute the total volume (capacity) of water that could be held in all lakes on such an island given an array of the
 * heights of the bars. Assume an elevation map where the width of each bar is 1.
 * <p>
 * Example: Given [1,3,2,4,1,3,1,4,5,2,2,1,4,2,2], return 15 (3 bodies of water with volumes of 1,7,7 yields total
 * volume of 15)
 */
public class VolumeOfLakes {

    /**
     * @param heights an array of positive integers
     * @return the volume of all spots that can contain water
     */
    public static int getVolumesOfLakes(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int volume = 0;

        while (left <= right) {
            if (heights[left] <= heights[right]) {
                leftMax = Math.max(leftMax, heights[left]);
                volume += leftMax - heights[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, heights[right]);
                volume += rightMax - heights[right];
                right--;
            }
        }

        return volume;
    }

    public static void main(String[] args) {
        System.out.println(getVolumesOfLakes(new int[]{1, 3, 2, 4, 1, 3, 1, 4, 5, 2, 2, 1, 4, 2, 2}));
    }
}
