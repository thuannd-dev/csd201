/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package binarysearchtree;

/**
 *
 * @author DELL
 */
public class BinarySearchTree {

    /**
     * @param args the command line arguments
     */
    private static class Node {

        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.value + " ");
            inorderTraversal(node.right);
        }
    }

    public void inorderTraversal() {
        inorderTraversal(root);
        System.out.println();
    }

    public Node insert(Node root, int key) {
        Node newNode = new Node(key);
        if (root == null) {
            return newNode;
        }
        if (key < root.value) {
            root.left = insert(root.left, key);
        } else if (key >= root.value) {
            root.right = insert(root.right, key);
        }
        // If the key is already present, we do not insert it again
        return root;
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    public boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (key < root.value) {
            return search(root.left, key);
        } else if (key > root.value) {
            return search(root.right, key);
        } else {
            return true; // key found
        }

    }

    public boolean search(int key) {
        return search(root, key);
    }

    public boolean validateBST(Node root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((min != null && root.value < min) || (max != null && root.value >= max)) {//insert bằng vào bên phải
            return false;
        }
        return validateBST(root.left, min, root.value) && validateBST(root.right, root.value, max);
    }

    public boolean validateBST() {
        return validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.inorderTraversal();
        System.out.println("Searching for 7: " + bst.search(7)); // true
        System.out.println("Searching for 20: " + bst.search(20)); // false}
        System.out.println("Is the tree a valid BST? " + bst.validateBST(bst.root, Integer.MIN_VALUE, Integer.MAX_VALUE)); // true
        bst.insert(10); // Duplicate, should not be inserted
        bst.inorderTraversal(); // Should not include duplicate 10  
        System.out.println(bst.validateBST()); // true
    }
}
