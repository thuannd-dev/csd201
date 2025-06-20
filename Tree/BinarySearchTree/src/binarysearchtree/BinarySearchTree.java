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

    public Node delete(int key, Node root) {
        if (root == null) {//base case
            return null;
        }
        if (key < root.value) {
            root.left = delete(key, root.left);
        } else if (key > root.value) {
            root.right = delete(key, root.right);
        } else {
            // Node to be deleted found
            if ((root.left == null) && (root.right == null)) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.value = minValueNode(root.right);
            root.right = delete(root.value, root.right);
        }
        return root;
    }

    private int minValueNode(Node root) {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(34);
        bst.insert(23);
        bst.insert(10);
        bst.insert(25);
        bst.insert(26);
        bst.insert(10);
        bst.insert(7);
        bst.insert(15);
        bst.insert(30);
        bst.insert(40);
        bst.insert(50);
        bst.insert(60);
        bst.inorderTraversal();
        System.out.println("Searching for 7: " + bst.search(7)); // true
        System.out.println("Searching for 20: " + bst.search(20)); // false
        System.out.println("Is the tree a valid BST? " + bst.validateBST(bst.root, Integer.MIN_VALUE, Integer.MAX_VALUE)); // true
        bst.insert(10); // Duplicate, should not be inserted
        bst.inorderTraversal(); // Should not include duplicate 10  
        System.out.println(bst.validateBST()); // true
        bst.delete(23, bst.root); // Delete node with value 23
        bst.inorderTraversal(); // Should not include 23
    }
}
