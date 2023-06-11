package stacks;

import java.util.Stack;

public class ReversePolishExpression {

    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            if (isNotOperationSign(token) && Integer.parseInt(token) > -200 && Integer.parseInt(token) < 200) {
                stack.push(token);
            } else {
                int secondOperand = Integer.parseInt(stack.pop());
                int firstOperand = Integer.parseInt(stack.pop());
                int result = performOperation(firstOperand, secondOperand, token);
                stack.push(String.valueOf(result));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private static int performOperation(int firstOperand, int secondOperand, String operation) {
        switch (operation) {
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            case "/":
                return firstOperand / secondOperand;
        }
        return -1;
    }

    private static boolean isNotOperationSign(String string) {
        return !string.equals("+") && !string.equals("-") && !string.equals("*") && !string.equals("/");
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
