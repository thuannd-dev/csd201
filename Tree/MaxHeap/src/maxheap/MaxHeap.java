/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package maxheap;

/**
 *
 * @author DELL
 */
public class MaxHeap {

    private Integer[] heap;
    private int size;

    public MaxHeap(int capacity) {
        heap = new Integer[capacity + 1];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void insert(int value) {
        if (size == heap.length - 1) {
            resize(heap.length * 2);
        }
        size++;
        heap[size] = value;
        swim(size);
    }

    public void resize(int newCapacity) {
        Integer[] temp = new Integer[newCapacity];
        for (int i = 0; i < heap.length; i++) {
            temp[i] = heap[i];
        }
        heap = temp;
    }

    public void swim(int k) {
        while (k > 1 && heap[k] > heap[k / 2]) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    public void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void printHeap() {
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println("");
    }

    public int delete() {
        if (size == 0) {
            throw new RuntimeException("Heap is empty");
        }
        int max = heap[1];
        swap(1, size);
        size--;
        heap[size + 1] = null;
        sink(1);
        return max;
    }

    public void sink(int k) {
        while (2 * k <= size) { // has at least 1 child
            // has 1 child
            if (2 * k + 1 > size) {
                if (heap[k] < heap[2 * k]) {
                    swap(k, 2 * k);
                    k = 2 * k;
                } else {
                    return;
                }
            }
            if (heap[k] < heap[2 * k] || heap[k] < heap[2 * k + 1]) {
                if (heap[2 * k] > heap[2 * k + 1]) {
                    swap(k, 2 * k);
                    k = 2 * k;
                } else {
                    swap(k, 2 * k + 1);
                    k = 2 * k + 1;
                }
            } else {
                return;
            }
        }
    }

    public int getMax() {
        return heap[1];
    }

    public static void main(String[] args) {
        MaxHeap myHeap = new MaxHeap(5);
        myHeap.insert(5);
        myHeap.insert(10);
        myHeap.insert(24);
        myHeap.insert(25);
        myHeap.insert(10);
        myHeap.insert(12);
        myHeap.insert(14);
        myHeap.insert(22);
        myHeap.printHeap();

        System.out.println(myHeap.delete());
        myHeap.printHeap();
        System.out.println(myHeap.delete());
        myHeap.printHeap();
        System.out.println(myHeap.delete());
        myHeap.printHeap();
        System.out.println(myHeap.delete());
        myHeap.printHeap();

        System.out.println("Maximum number: " + myHeap.getMax());

    }
}
