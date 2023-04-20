package arrays;

/**
 * 4. Median of Two Sorted Arrays
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n))
 */
public class MedianOfSortedArrays {

    /**
     * This method constructs a new sorted array from nums1 and nums2 and computed its median.
     *
     * @param nums1 the first sorted array
     * @param nums2 the second sorted array
     * @return if the new array length it's odd, return its middle value,
     * otherwise return average of the two values from the middle.
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, m = nums1.length, n = nums2.length, k = -1;
        int[] merged = new int[m + n];
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                merged[++k] = nums1[i];
                i++;
            } else {
                merged[++k] = nums2[j];
                j++;
            }
        }

        while (i < m) {
            merged[++k] = nums1[i];
            i++;
        }

        while (j < n) {
            merged[++k] = nums2[j];
            j++;
        }

        if (merged.length % 2 == 1) {
            return merged[merged.length / 2];
        } else {
            return (double) (merged[merged.length / 2] + merged[(merged.length / 2) - 1]) / 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
