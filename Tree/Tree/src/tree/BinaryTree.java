/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tree;

/**
 *
 * @author DELL
 */
public class BinaryTree {

    public static class Node {

        private int value;
        private Node left, right;

        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    private Node root;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node firstNode = new Node(1);
        binaryTree.root = firstNode;
        Node secondNode = new Node(2);
        firstNode.left = secondNode;
        Node thirdNode = new Node(3);
        firstNode.right = thirdNode;
        Node fourthNode = new Node(4);
        secondNode.left = fourthNode;
        Node fifthNode = new Node(5);
        secondNode.right = fifthNode;
        Node sixthNode = new Node(6);
        thirdNode.left = sixthNode;
        System.out.println("Preorder Traversal:");
        preOrder(binaryTree.root);
        System.out.println("\nInorder Traversal:");
        inOrder(binaryTree.root);
        System.out.println("\nPostorder Traversal:");
        postOrder(binaryTree.root);
    }

    //preorder traversal: Root, Left, Right
    public static void preOrder(Node root) {
        // Base case: if the node is null, return
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //inorder traversal: Left, Root, Right
    public static void inOrder(Node root) {
        // Base case: if the node is null, return
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }

    //postorder traversal: Left, Right, Root
    public static void postOrder(Node root) {
        // Base case: if the node is null, return
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " ");
    }

    //level order traversal: visit nodes level by level
    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.value + " ");
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

}
