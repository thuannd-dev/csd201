/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedlist;

/**
 *
 * @author DELL
 */
public class LinkedList {

    private Node head;

    private static class Node {

        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }

    }

    public LinkedList() {
        this.head = null;
    }

    public void traversal() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void insertAtBegin(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int value) {
        if (head == null) {
            insertAtBegin(value);
            return;
        }
        Node newNode = new Node(value);
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void insertAtPosition(int value, int position) {
        if (position <= 0) {
            insertAtBegin(value);
            return;
        }
        if (position > size()) {
            insertAtEnd(value);
            return;
        }
        Node current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
    }

    public int search(int key) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.value == key) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public Node deleteAtBegin() {
        if (head == null) {
            return null;
        }
        Node temp = head;
        head = head.next;
        return temp;
    }

    public Node deleteAtEnd() {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return deleteAtBegin();
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        Node temp = current.next;
        current.next = null;
        return temp;
    }

    public Node deleteAtPosition(int position) {
        if (head == null) {
            return null;
        }
        if (position <= 0) {
            return deleteAtBegin();
        }
        if (position >= size()) {
            return deleteAtEnd();
        }
        Node current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        Node temp = current.next;
        current.next = current.next.next;
        return temp;
    }

    public static void main(String[] args) {
        LinkedList sll = new LinkedList();
        sll.insertAtBegin(10);
        sll.insertAtBegin(20);
        sll.insertAtBegin(30);
        sll.insertAtBegin(40);
        // sll.insertAtBegin(20);
        // sll.insertAtBegin(30);
        // sll.insertAtEnd(40);
        sll.traversal();

        // System.out.println(sll.search(20)); // Output: 2
        // sll.deleteAtEnd();
        // sll.traversal();
        sll.deleteAtPosition(1);
        sll.traversal();

    }

}
