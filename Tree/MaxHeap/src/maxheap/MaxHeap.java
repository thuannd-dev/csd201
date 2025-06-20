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

    /**
     * @param args the command line arguments
     */
    private Integer[] heap;
    private int size;// Current number of elements in the heap

    public MaxHeap(int capacity) {
        heap = new Integer[capacity + 1];// Index 0 is not used - null value
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void insert(int key) {
        if (size == heap.length - 1) {
            this.resize(this.size * 2);
        }
        size++;
        heap[size] = key;
        swim(size);
    }

    private void swim(int k) {
        //k khác 1 và giá trị của con lớn hơn giá trị của cha thì hoán đổi
        while (k > 1 && heap[k / 2] < heap[k]) {
            swap(k / 2, k);
            k /= 2;
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void resize(int newCapacity) {
        Integer[] newHeap = new Integer[newCapacity + 1];
        for (int i = 1; i <= size; i++) {
            newHeap[i] = heap[i];
        }
        heap = newHeap;
    }

    public void printHeap() {
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(5);
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(5);
        maxHeap.insert(30);
        maxHeap.insert(15);
        maxHeap.insert(25);
        maxHeap.insert(35);
        System.out.println("Size of heap: " + maxHeap.getSize());
        System.out.println("Is heap empty? " + maxHeap.isEmpty());
        maxHeap.printHeap();

    }

}
