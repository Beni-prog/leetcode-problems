package heaps;

import java.util.Arrays;

public class MyHeap {

    private int initialCapacity = 10;
    private int[] array = new int[initialCapacity];
    private int size = 0;

    public MyHeap() {

    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int currentNodeIndex) {
        return (currentNodeIndex - 1) / 2;
    }

    private boolean hasLeftChild(int currentNodeIndex) {
        return getLeftChildIndex(currentNodeIndex) < size;
    }

    private boolean hasRightChild(int currentNodeIndex) {
        return getRightChildIndex(currentNodeIndex) < size;
    }

    private boolean hasParent(int currentNodeIndex) {
        return getParentIndex(currentNodeIndex) >= 0;
    }

    private int getLeftChild(int index) {
        return array[getLeftChildIndex(index)];
    }

    private int getRightChild(int index) {
        return array[getRightChildIndex(index)];
    }

    private int getParent(int index) {
        return array[getParentIndex(index)];
    }

    private void swap(int indexOne, int indexTwo) {
        int aux = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = aux;
    }

    private void ensureExtraCapacity() {
        if (size == initialCapacity) {
            initialCapacity *= 2;
            array = Arrays.copyOf(array, initialCapacity);
        }
    }

    private int peek() {
        if (size == 0) {
            throw new IllegalStateException("No element in the heap");
        }
        return array[0];
    }

    private int pull() {
        if (size == 0) {
            throw new IllegalStateException("No element in the heap");
        }
        int min = array[0];
        array[0] = array[size - 1];
        size--;
        heapifyDown();
        return min;
    }

    private void add(int newElement) {
        ensureExtraCapacity();
        array[size] = newElement;
        size++;
        heapifyUp();
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && getRightChild(index) < getLeftChild(index)) {
                smallerChildIndex = getRightChild(index);
            }

            if (array[index] < array[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && getParent(index) > array[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public static void main(String[] args) {
        MyHeap minHeap = new MyHeap();

        minHeap.add(4);
        minHeap.add(7);
        minHeap.add(2);
        minHeap.add(3);
        minHeap.add(1);

        System.out.println(minHeap.peek());//1
        System.out.println(minHeap.pull());//1
        System.out.println(minHeap.peek());//2

    }
}
