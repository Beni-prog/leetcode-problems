package arrays;

public class RotatedArray {

    public static int search(int[] nums, int target) {
        int pivot = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                pivot = i;
                break;
            }
        }
        return binarySearch(0, pivot, nums, target) != -1 ? binarySearch(0, pivot, nums, target) : binarySearch(pivot + 1, nums.length - 1, nums, target);

    }

    private static int binarySearch(int left, int right, int[] nums, int target) {
        int middle = left + (right - left) / 2;
        while (left <= right) {
            if (target == nums[middle]) {
                return middle;
            } else if (target < nums[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
            middle = left + (right - left) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));//4
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));//-1
        System.out.println(search(new int[]{1}, 0));//-1
    }
}
