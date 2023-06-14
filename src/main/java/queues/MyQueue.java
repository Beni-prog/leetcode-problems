package queues;

import java.util.Stack;

public class MyQueue {

    Stack<Integer> stackOne;
    Stack<Integer> stackTwo;

    public MyQueue() {
        stackOne = new Stack<>();
        stackTwo = new Stack<>();
    }

    public void push(int x) {
        stackOne.push(x);
    }

    public int pop() {
        while (!stackOne.isEmpty()) {
            stackTwo.push(stackOne.pop());
        }

        int i = stackTwo.pop();

        while (!stackTwo.isEmpty()) {
            stackOne.push(stackTwo.pop());
        }

        return i;
    }

    public int peek() {
        while (!stackOne.isEmpty()) {
            stackTwo.push(stackOne.pop());
        }

        int i = stackTwo.peek();

        while (!stackTwo.isEmpty()) {
            stackOne.push(stackTwo.pop());
        }

        return i;
    }

    public boolean empty() {
        return stackOne.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }
}
