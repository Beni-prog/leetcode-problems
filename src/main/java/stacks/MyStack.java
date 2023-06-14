package stacks;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    Queue<Integer> queueOne;
    Queue<Integer> queueTwo;

    public MyStack() {
        queueOne = new LinkedList<>();
        queueTwo = new LinkedList<>();
    }

    public void push(int x) {
        if (queueOne.size() == 0 && queueTwo.size() != 0) {
            queueTwo.offer(x);
        } else {
            queueOne.offer(x);
        }
    }

    public int pop() {
        if (queueOne.size() != 0) {
            while (queueOne.size() > 1) {
                queueTwo.offer(queueOne.poll());
            }
            return queueOne.poll();
        } else {
            while (queueTwo.size() > 1) {
                queueOne.offer(queueTwo.poll());
            }
            return queueTwo.poll();
        }
    }

    public int top() {
        if (queueOne.size() != 0) {
            while (queueOne.size() > 1) {
                queueTwo.offer(queueOne.poll());
            }
            int i = queueOne.peek();
            queueTwo.offer(queueOne.poll());
            return i;
        } else {
            while (queueTwo.size() > 1) {
                queueOne.offer(queueTwo.poll());
            }
            int i = queueTwo.peek();
            queueOne.offer(queueTwo.poll());
            return i;
        }
    }

    public boolean empty() {
        return queueOne.isEmpty() && queueTwo.isEmpty();
    }

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }
}
