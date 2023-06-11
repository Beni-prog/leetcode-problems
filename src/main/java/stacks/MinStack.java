package stacks;

public class MinStack {
    private static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    int min;
    Node head;

    public MinStack() {
        min = Integer.MAX_VALUE;
        head = null;
    }

    //the key is to consider the top of the stack as the head of the linked list and
    //to add/remove the element from the head of the linked list
    //this is how we obtain constant time for pop/push operations
    public void push(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        min = Math.min(min, val);
    }

    public void pop() {
        if (head.val == min) {
            min = head.next != null ? findMin(head.next) : Integer.MAX_VALUE;
        }
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return min;
    }

    private int findMin(Node node) {
        int min = node.val;
        while (node != null) {
            min = Math.min(min, node.val);
            node = node.next;
        }
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
