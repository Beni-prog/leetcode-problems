package recursion;

public class PowFunction {

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        return powRecursive(x, n);
    }

    private static double powRecursive(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double half = powRecursive(x, n / 2);

        if (n % 2 == 0) {
            // If n is even, x^n = (x^(n/2))^2
            return half * half;
        } else {
            // If n is odd, x^n = x * (x^(n/2))^2
            return x * half * half;
        }
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, 5));//32
    }
}
