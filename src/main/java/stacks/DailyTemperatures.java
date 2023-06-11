package stacks;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] results = new int[temperatures.length];

        //keep in the stack the indices of the temperatures
        for (int i = 0; i < temperatures.length; i++) {
            //we go back and fill the results array as long as the values are in decreasing order
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                results[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return results;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
