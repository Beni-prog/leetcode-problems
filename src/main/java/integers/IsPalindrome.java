package integers;

/**
 * Problem 9. Palindrome Number
 * <p>
 * Given an integer x, return true if x is a palindrome and false otherwise.
 */
public class IsPalindrome {

    /**
     * This method computes the reverse of x and then checks if it's equal to its initial value.
     *
     * @param x an integer number
     * @return true if x is palindrome, false otherwise
     */
    public static boolean isPalindrome(int x) {
        String value = String.valueOf(x);
        StringBuilder reversedValue = new StringBuilder();

        for (int i = value.length() - 1; i >= 0; i--) {
            reversedValue.append(value.charAt(i));
        }

        return reversedValue.toString().equals(value);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(121));
    }
}
