package strings;


/**
 * Problem 8. String to Integer (atoi)
 * <p>
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 * <p>
 * The algorithm for myAtoi(string s) is as follows:
 * <p>
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either.
 * This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 * Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string
 * is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0.
 * Change the sign as necessary (from step 2). If the integer is out of the 32-bit signed integer range [-231, 231 - 1],
 * then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231,
 * and integers greater than 231 - 1 should be clamped to 231 - 1.
 * <p>
 * Return the integer as the final result.
 */
public class StringToInteger {

    /**
     * It first skips any leading whitespace in the input string, checks for a sign character ('+' or '-'),
     * and then parses digits until it encounters a non-digit character. The method also checks for overflow,
     * returning the appropriate maximum or minimum value of int if the parsed value is too large or too small.
     *
     * @param s the string that must be converted to integer
     * @return an integer number
     */
    public static int myAtoi(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int sign = 1;
        int i = 0;
        int result = 0;

        // Skip whitespace
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // Check sign
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        // Parse digits
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Check for overflow
            // Overflow means, in this case, that the result without the last digit is already greater/lesser
            // than the max/min integer value without its last digit OR
            // the result without the last digit is equal to the max/min integer value without its last digit,
            // and then we have to check the last digits to decide if result will be greater/lesser than max/min integer value
            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return sign * result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("     -42 - the greatest1"));
        System.out.println(myAtoi("     - the greatest1"));
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi(""));
        System.out.println(myAtoi("  "));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("20000000000000000000"));
        System.out.println(myAtoi("+1"));
    }
}
