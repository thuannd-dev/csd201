/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void clear() {
        root = null;
    }

    void visit(Node p) {
        System.out.print("p.info: ");
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void breadth(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }

    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }

    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder(p.left, f);
        postOrder(p.right, f);
        fvisit(p, f);
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void insert(String xPlace, int xWeight, int xColor) {
        //You should insert here statements to complete this function
        //---------------------------------------
        root = insert(root, xPlace, xWeight, xColor);

        //---------------------------------------
    }

    Node insert(Node root, String xPlace, int xWeight, int xColor) {
        // Không chèn nếu chữ cái đầu là 'F'
        if (xPlace.charAt(0) == 'F') {
            return root;
        }
        // Nếu root null, tạo node mới
        if (root == null) {
            return new Node(new Dog(xPlace, xWeight, xColor));
        }
        if (xWeight < root.info.weight) {
            root.left = insert(root.left, xPlace, xWeight, xColor);
            // Nếu bằng thì KHÔNG chèn gì cả, giữ nguyên
        } else if (xWeight > root.info.weight) {
            root.right = insert(root.right, xPlace, xWeight, xColor);
        }
        return root;
    }

//Do not edit this function. Your task is to complete insert function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    void preOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        if (p.info.color < 8) {
            fvisit(p, f);
        }
        preOrder2(p.left, f);
        preOrder2(p.right, f);
    }
//=============================================================

    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //You should insert here statements to complete this function
        //---------------------------------------
        preOrder2(root, f);
        //---------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    void descOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        descOrder(p.right, f);
        fvisit(p, f);
        descOrder(p.left, f);

    }
//=============================================================

    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        //You should insert here statements to complete this function
        //---------------------------------------
        descOrder(root, f);
        //---------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
    
    void rightRootNode(Node p, RandomAccessFile f) throws Exception {
        Node current  = p;
        while(current.right != null) {
            current = current.right;
        }
        fvisit(current, f);
        
    }
    
    
//=============================================================

    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        //You should insert here statements to complete this function
        //---------------------------------------
        rightRootNode(root, f);
        //---------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
    
    int countLeaves(Node root) {
      
        // If root is NULL, return 0
        if (root == null) {
            return 0;
        }

        // If the node has no left or right child, 
        // it is a leaf
        if (root.left == null && root.right == null) {
            return 1;
        }

        // Recursively count the leaves in the 
        // left and right subtrees
        return countLeaves(root.left) 
                         + countLeaves(root.right);
    }
//=============================================================

    void f5() throws Exception {
        clear();
        loadData(17);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        inOrder(root, f);
        f.writeBytes("\r\n");

        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        //---------------------------------------
        // hint: you should create a function to count the leaf nodes
        // named countLeaf(...)
        // then call int k = this.countLeaf(...)
        // finally, use f.writeBytes(k + "\r\n") to write the result
        //---------------------------------------
        int k = countLeaves(root);
        f.writeBytes(k + "\r\n");
        f.close();
    }
}
