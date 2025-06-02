/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package queue;

/**
 *
 * @author DELL
 */
public class Queue {

    private Node front;
    private int length;

    public class Node {

        private String value;
        private Node next;

        public Node(String value) {
            this.value = value;
            this.next = null;
        }
    }

    public Queue() {
        front = null;
        length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public Node peek() {
        return front;
    }

    public void enqueue(String value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            front = newNode;
            length++;
            return;
        }
        Node currentNode = front;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
        length++;
    }

    public Node dequeue() {
        if (isEmpty()) {
            return null;
        }
        Node node = front;
        front = front.next;
        length--;
        return node;
    }

    public void printQueue() {
        Node currentNode = front;
        while (currentNode != null) {
            System.out.println(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    public static void printBinaryNumber(int n) {
        Queue queue = new Queue();
        queue.enqueue("1");
        for (int i = 0; i < n; i++) {
            Node currentNode = queue.dequeue();
            System.out.println(currentNode.value);
            queue.enqueue(currentNode.value + "0");
            queue.enqueue(currentNode.value + "1");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Queue queue = new Queue();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.printQueue();
        queue.dequeue();
        queue.printQueue();
        printBinaryNumber(2);
    }

}
