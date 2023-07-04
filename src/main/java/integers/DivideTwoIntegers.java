package integers;

public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Divisor cannot be 0!");
        }

        // Handle overflow cases
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        //determine the sign of the quotient, using XOR operand, which will evaluate to true if
        //the operators are of different signs, or false otherwise
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;

        // Convert dividend and divisor to positive
        long dividendL = Math.abs((long) dividend);
        long divisorL = Math.abs((long) divisor);

        //perform binary division
        int quotient = 0;

        while(dividendL >= divisorL) {
            long temp = divisorL;
            long multiple = 1;

            while (dividendL >= temp << 1) {
                //multiply by 2
                temp <<= 1;
                multiple <<= 1;
            }

            dividendL -= temp;
            quotient += multiple;
        }

        return (int) sign * quotient;
    }

    public static void main(String[] args) {
        System.out.println(divide(-27, 3));
    }
}
