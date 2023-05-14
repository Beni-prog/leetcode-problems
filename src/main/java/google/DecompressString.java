package google;

import java.util.Stack;

/**
 * Decode string
 * <p>
 * Your input is a compressed string of the format number[string] and the decompressed output form should be the string
 * written number times. For example:
 * <p>
 * The input
 * <p>
 * 3[abc]4[ab]c
 * <p>
 * Would be output as
 * <p>
 * abcabcabcababababc
 * <p>
 * Number can have more than one digit. For example, 10[a] is allowed, and just means aaaaaaaaaa
 * <p>
 * One repetition can occur inside another. For example, 2[3[a]b] decompresses into aaabaaab
 */
public class DecompressString {

    /**
     * @param string a string formed out of digits, straight parentheses and letters
     * @return a string formed out only of letters, repeated as much as required by the digits in the first string
     */
    public static String decompressString(String string) {
        Stack<Integer> numbers = new Stack<>();
        Stack<String> letters = new Stack<>();
        StringBuilder result = new StringBuilder();


        int i = 0;
        while (i < string.length()) {
            if (Character.isDigit(string.charAt(i))) {
                StringBuilder digit = new StringBuilder();

                //there can be multiple digits,
                //so build the number
                while (Character.isDigit(string.charAt(i))) {
                    digit.append(string.charAt(i));
                    i++;
                }

                //add the number to numbers stack
                numbers.push(Integer.parseInt(digit.toString()));
            } else if (string.charAt(i) == ']') {
                //pop the string formed with the characters under the inner parentheses
                result = new StringBuilder(letters.pop() + result.toString().repeat(numbers.pop()));
                i++;
            } else if (string.charAt(i) == '[') {
                //push on the stack the string which was formed so far
                letters.push(result.toString());
                result = new StringBuilder();
                i++;
            } else {
                //construct the string formed with the characters under the inner parentheses
                result.append(string.charAt(i));
                i++;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(decompressString("3[c]2[e]"));
        System.out.println(decompressString("3[abc]4[ab]c"));
        System.out.println(decompressString("0[abc]"));
    }
}
