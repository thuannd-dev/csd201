/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

class dataList {

    Node head, tail;

    dataList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void loadDataRoom(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int[] d = Lib.readLineToIntArray("data.txt", k + 3);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i], d[i]);
        }
    }

    void addLast(String code, int status, int size, int price) {
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------

        //---------------------------------------------------------
        if (!(status == 0 || status == 1) || size < 1 || price < 1) {
            return;
        }
        Node newNode = new Node(new Room(code, status, size, price));
        if (isEmpty()) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

}

class requestQueue {

    Node front, rear;

    requestQueue() {
        front = rear = null;
    }

    boolean isEmpty() {
        return (front == null);
    }

    void clear() {
        front = rear = null;
    }

    void loadDataRequest(int k) //do not edit this function
    {
        int[] a = Lib.readLineToIntArray("data.txt", k + 4);
        int[] b = Lib.readLineToIntArray("data.txt", k + 5);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            enQueue(a[i], b[i]);
        }
    }

    void enQueue(int size, int price) {
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------

        //---------------------------------------------------------
        if (size < 1 || price < 1) {
            return;
        }
        Node newNode = new Node(new Room(size, price));
        if (isEmpty()) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    Room deQueue() {
        Room tmp = new Room();
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        if (isEmpty()) {
            return null;
        }
        if (front == rear) {
            tmp = front.info;
            clear();
            return tmp;
        }
        tmp = front.info;
        front = front.next;
        //---------------------------------------------------------
        return tmp;
    }

}

class MyStore {

    dataList dList = new dataList();
    requestQueue RQueue = new requestQueue();

    MyStore() {
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = dList.head;
        f.writeBytes("Data List: ");
        if (p == null) {
            f.writeBytes("Empty");
        }
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
        f.writeBytes("Request  : ");
        p = RQueue.front;
        if (p == null) {
            f.writeBytes("Empty");
        }
        while (p != null) {
            f.writeBytes("(" + p.info.getSize() + "," + p.info.getPrice() + ") ");
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void load(int k) throws Exception //do not edit this function
    {
        dList.loadDataRoom(k);
        RQueue.loadDataRequest(k);
    }

//===========================================================================
//=======YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void f1() throws Exception {
        load(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

    void rent(Room t) throws Exception {
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        if (dList.isEmpty()) {
            return;
        }
        Node best = null;
        Node current = dList.head;
        while (current != null) {
            if (t.getPrice() >= current.info.getPrice()
                    && t.getSize() <= current.info.getSize()
                    && current.info.getStatus() == 0) {
                if(best == null || best.info.getPrice() > current.info.getPrice()) {
                    best = current;
                }
            }
            current = current.next;
        }
        if (best != null) //---------------------------------------------------------
        {
            best.info.setStatus(1);
        }
    }

    void f2() throws Exception {
        load(1);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        rent(RQueue.deQueue());
        //---------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void f3() throws Exception {
        load(1);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        Room r;
        while ((r = RQueue.deQueue()) != null) {
            rent(r);
        }
        //---------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void f4() throws Exception {
        load(1);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        int count = 0;
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        Room r;
        while ((r = RQueue.deQueue()) != null) {
            rent(r);
        }
        Node current = dList.head;
        while (current != null) {
            if (current.info.getStatus() == 0) {
                count++;
            }
            current = current.next;
        }
        //---------------------------------------------------------
        ftraverse(f);
        f.writeBytes("Available Room(s): " + count + " ");
        f.close();
    }

}
