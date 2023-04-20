package integers;

/**
 * Problem 7. Reverse Integer
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go
 * outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * <p>
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 */
public class ReverseInteger {

    /**
     * This method computes the reverse of an integer.
     *
     * @param x an integer number
     * @return the reverse of the integer
     */
    public static int reverse(int x) {
        long reverse = 0;

        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }

        if (reverse >= Integer.MIN_VALUE && reverse <= Integer.MAX_VALUE) {
            return (int) reverse;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(120));
        System.out.println(reverse(-120));
        System.out.println(reverse(1534236469));
        System.out.println(reverse(-2147483412));
        System.out.println(reverse(-2147483648));
    }
}
