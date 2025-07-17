/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */

    void addLast(String xId, int xWeight, int xPrice) {
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        // Validate input
    if (xWeight <= 0 || xPrice <= 0) {
        return; // Invalid weight or price
    }

    // Check for unique id
    Node current = head;
    while (current != null) {
        if (current.info.id.equals(xId)) {
            return; // Duplicate id found, do not add
        }
        current = current.next;
    }

    // Create new Phone object and Node
    Phone newPhone = new Phone(xId, xWeight, xPrice);
    Node newNode = new Node(newPhone);

    // If the list is empty, set head and tail to the new node
    if (head == null) {
        head = tail = newNode;
    } else {
        // Otherwise, add the new node to the end of the list
        tail.next = newNode;
        tail = newNode;
    }
		
		
		
        //---------------------------------------------------------
    }

    //==================================================================
    //You do not need to edit this function. Your task is to complete the addLast function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Node v = new Node(new Phone("New", 8, 9));
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        
		if (head != null && head.next != null && head.next.next != null) {
        // Find the 2nd node
        Node current = head.next;
        // Insert the new node as the 3rd node
        v.next = current.next;
        current.next = v;
    }
		
		
        //---------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
         if (head == null) return;

    Node maxNode = head;
    Node current = head.next;

    while (current != null) {
        if (current.info.weight > maxNode.info.weight) {
            maxNode = current;
        }
        current = current.next;
    }

    // Delete the node with the maximum weight
    if (head == maxNode) {
        head = head.next;  // If maxNode is head, remove head
    } else {
        Node prev = head;
        while (prev.next != maxNode) {
            prev = prev.next;
        }
        prev.next = maxNode.next;  // Bypass maxNode
    }
		
		
		
        //---------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        
        // hint: you should write a new function named countSomeThing() for this question,
        // then assign int k = this.countSomeThing()
        // finally, you just call f.writeBytes(k + "") to complete this question.
        int count = 0;
    Node current = head;
    while (current != null) {
        if (current.info.price > 5) {
            count++;
        }
        current = current.next;
    }

    f.writeBytes(count + "\r\n");
        
		
		
		
        //---------------------------------------------------------
        f.close();
    }

//==================================================================
    void f5() throws Exception {
        clear();
        loadData(17);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        // Delete the first node
    if (head != null) {
        head = head.next;
    }

    // Sort the list in descending order by weight
    if (head != null) {
        // Convert linked list to array for easy sorting
        List<Phone> phoneList = new ArrayList<>();
        Node current = head;
        while (current != null) {
            phoneList.add(current.info);
            current = current.next;
        }

        // Sort the list in descending order by weight
        phoneList.sort((p1, p2) -> Integer.compare(p2.weight, p1.weight));

        // Rebuild the linked list with sorted elements
        clear();
        for (Phone phone : phoneList) {
            addLast(phone.id, phone.weight, phone.price);
        }
    }
		
		
		
        //---------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
