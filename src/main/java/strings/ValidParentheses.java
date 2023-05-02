package strings;

import java.util.Stack;

/**
 * Problem 20. Valid Parentheses
 * <p>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
public class ValidParentheses {

    /**
     * This method checks whether a parenthesis string is valid or not.
     *
     * @param s a parenthesis string.
     * @return true is the parentheses are correctly closed or false otherwise
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            //if it's an open parenthesis, add it to the stack
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (stack.isEmpty() || (c == '}' && stack.peek() != '{') || (c == ']' && stack.peek() != '[')
                    || (c == ')' && stack.peek() != '(')) {
                //if it's a closed parenthesis, check if it matches the top char on the stack
                return false;
            } else {
                //the top char on the stack matched the character so we remove it from the stack
                stack.pop();
            }
        }

        //if the stack is empty, it means that for every open parenthesis there was a closed one on the top of the stack
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("{[((()))]}"));
        System.out.println(isValid("{[((())]}"));
        System.out.println(isValid("{["));
        System.out.println(isValid("{[}"));
        System.out.println(isValid("}"));
    }
}
