package arrays;

public class MySqrt {

    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int left = 0;
        int right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            } else if (square > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left - 1;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));//2
        System.out.println(mySqrt(16));//4
        System.out.println(mySqrt(20));//4
        System.out.println(mySqrt(2147395600));//46340
    }
}
