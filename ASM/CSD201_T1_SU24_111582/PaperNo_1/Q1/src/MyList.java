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
        Node newNode = new Node(new Phone(xId, xWeight, xPrice));
        if (isEmpty()) {
            head = tail = newNode;
            return;
        }
        Node current = head;
        while (current != null) {
            if (current.info.id.equals(xId)) {
                return;
            }
            current = current.next;
        }
        tail.next = newNode;
        tail = newNode;

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

    void addThird(Node newNode) {
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        if (isEmpty()) {
            head = tail = newNode;
            return;
        }
        Node current = head;
        while (current != null) {
            if (current.info.id.equals(newNode.info.id)) {
                return;
            }
            current = current.next;
        }
        current = head.next;
        newNode.next = current.next;
        current.next = newNode;
        //---------------------------------------------------------
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
        addThird(v);
        //---------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    int findMaxWeight() {
        if (isEmpty()) {
            return -99999;
        }
        int maxWeight = head.info.weight;
        Node current = head.next;
        while (current != null) {
            if (current.info.weight > maxWeight) {
                maxWeight = current.info.weight;
            }
            current = current.next;
        }
        return maxWeight;
        //---------------------------------------------------------
    }

    void deleteNodeHaveMaxWeight(int maxWeight) {
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        if (isEmpty()) {
            return;
        }
        if (head.info.weight == maxWeight) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
            }
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.info.weight == maxWeight) {
                if (current.next == tail) {
                    tail = current;
                }
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
        //---------------------------------------------------------
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
        deleteNodeHaveMaxWeight(findMaxWeight());
        //---------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    int countPhoneHavePriceGreaterThan5() {
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        if (isEmpty()) {
            return 0;
        }
        int count = 0;
        Node current = head;
        while (current != null) {
            if (current.info.price > 5) {
                count++;
            }
            current = current.next;
        }
        return count;
        //---------------------------------------------------------
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
        int k = countPhoneHavePriceGreaterThan5();
        f.writeBytes(k + "");
        // hint: you should write a new function named countSomeThing() for this question,
        // then assign int k = this.countSomeThing()
        // finally, you just call f.writeBytes(k + "") to complete this question.
        //---------------------------------------------------------
        f.close();
    }

    void deleteFirstNode() {
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        if (isEmpty()) {
            return;
        }
        if (head == tail) {
            head = tail = null;
            return;
        }
        head = head.next;
        //---------------------------------------------------------
    }
    
    void swapInfo(Node first, Node second) {
        Phone tmp = first.info;
        first.info = second.info;
        second.info = tmp;
    }
    
    void sortList() {
        if (isEmpty() || head == tail) {
            return;
        }
        Node i = head, j;
        while(i != null) {
            j = i.next;
            while(j != null) {
                if(i.info.weight < j.info.weight) {
                    swapInfo(i, j);
                }
                j = j.next;
            }
            i = i.next;
        }
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
        deleteFirstNode();
        sortList();
        //---------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
