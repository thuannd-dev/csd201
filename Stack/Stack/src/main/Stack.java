/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author DELL
 */
public class Stack {

    private Node top;
    private int length;

    public class Node {

        private char value;
        private Node next;

        public Node(char value) {
            this.value = value;
            this.next = null;
        }
    }

    public Stack() {
        this.top = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public void push(char value) {
        Node newNode = new Node(value);
        newNode.next = this.top;
        this.top = newNode;
        this.length++;
    }

    public Node pop() {
        if (this.isEmpty()) {
            return null;
        }
        Node temp = this.top;
        this.top = this.top.next;
        this.length--;
        return temp;
    }

    public Node peek() {
        return this.top;
    }

    public void printStack() {
        Node currentNode = this.top;
        while (currentNode != null) {
            System.out.println(currentNode.value);
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }

    public boolean checkParentheses(String str) {
        Stack stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
                stack.push(str.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (str.charAt(i) == ')' && stack.peek().value == '(' || str.charAt(i) == ']' && stack.peek().value == '[' || str.charAt(i) == '}' && stack.peek().value == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean checkParenthesesVerTeacher(String str) {
        Stack stack = new Stack();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.peek().value;
                if (c == ')' && top == '(' || c == ']' && top == '[' || c == '}' && top == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        // stack.push(1);
        // stack.push(2);
        // stack.push(3);
        // stack.printStack();
        // System.out.println(stack.pop().value);
        // System.out.println(stack.peek().value);
        System.out.println(stack.checkParenthesesVerTeacher("{[()]}}"));
        System.out.println(stack.checkParentheses("{[()]}}"));
    }

}
