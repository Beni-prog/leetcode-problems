package google;

import java.util.Stack;

/**
 * Decode string
 */
public class DecompressString {
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
