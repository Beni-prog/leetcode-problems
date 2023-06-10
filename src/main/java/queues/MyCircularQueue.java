package queues;

public class MyCircularQueue {
    private final int[] queue;
    private int head;
    private int tail;
    private int size;

    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.head = -1;
        this.tail = -1;
        this.size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        if (isEmpty()) {
            head = 0;
        }

        //wrap the tail pointer when it reached the end of the array.
        tail = (tail + 1) % queue.length;
        queue[tail] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        if (head == tail) {
            head = -1;
            tail = -1;
        } else {
            head = (head + 1) % queue.length;
        }

        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[head];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(3);

        System.out.println(obj.isEmpty());//true
        System.out.println(obj.Front());//-1
        System.out.println(obj.enQueue(1));//true
        System.out.println(obj.enQueue(2));//true
        System.out.println(obj.enQueue(3));//true
        System.out.println(obj.enQueue(4));//false
        System.out.println(obj.isEmpty());//false
        System.out.println(obj.Rear());//3
        System.out.println(obj.Front());//1
        System.out.println(obj.isFull());//true
        System.out.println(obj.deQueue());//true
        System.out.println(obj.enQueue(4));//true
        System.out.println(obj.Rear());//4
        System.out.println(obj.deQueue());//true
        System.out.println(obj.deQueue());//true
        System.out.println(obj.deQueue());//true
        System.out.println(obj.deQueue());//false

        System.out.println("----------------------------------------");

        MyCircularQueue obj1 = new MyCircularQueue(2);

        System.out.println(obj1.enQueue(6));//true
        System.out.println(obj1.Rear());//6
        System.out.println(obj1.Rear());//6
        System.out.println(obj1.deQueue());//true
        System.out.println(obj1.enQueue(5));//true
        System.out.println(obj1.Rear());//5
        System.out.println(obj1.deQueue());//true
        System.out.println(obj1.Front());//-1
        System.out.println(obj1.deQueue());//false
        System.out.println(obj1.deQueue());//false
        System.out.println(obj1.deQueue());//false
    }
}
