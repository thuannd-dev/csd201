package q1;

/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

class ItemList {

    Node head, tail;

    ItemList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void loadDataItem(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

    void addLast(String name, int quantity, int price) {
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        Node newNode = new Node(new Item(name, quantity, price));
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        this.tail.next = newNode;
        this.tail = newNode;
        //---------------------------------------------------------
    }

}

class RequestQueue {

    Node front, rear;

    RequestQueue() {
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
        String[] a = Lib.readLineToStrArray("data.txt", k + 3);
        int[] b = Lib.readLineToIntArray("data.txt", k + 4);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            enQueue(a[i], b[i]);
        }
    }

    void enQueue(String name, int quantity) {
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        Node newNode = new Node(new Item(name, quantity));
        if (this.isEmpty()) {
            this.front = newNode;
            this.rear = newNode;
            return;
        }
        this.rear.next = newNode;
        this.rear = newNode;
        //---------------------------------------------------------
    }

    Item deQueue() {
        Item tmp = new Item();
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        if (this.isEmpty()) {
            return null;
        }
        tmp = this.front.info;
        if (this.front.next == null) {
            this.front = null;
            this.rear = null;
        } else {
            this.front = this.front.next;
        }
        //---------------------------------------------------------
        return tmp;
    }

}

class ComputerStore {

    ItemList IList = new ItemList();
    RequestQueue RQueue = new RequestQueue();

    ComputerStore() {
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = IList.head;
        f.writeBytes("Data Item: ");
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
        f.writeBytes("Request   : ");
        p = RQueue.front;
        if (p == null) {
            f.writeBytes("Empty");
        }
        while (p != null) {
            f.writeBytes("(" + p.info.getName() + "," + p.info.getQuantity() + ") ");
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void load(int k) throws Exception //do not edit this function
    {
        IList.loadDataItem(k);
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

    void f2() throws Exception {
        load(1);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/

        //check RQueue Empty
        if (RQueue.isEmpty()) {
            return;
        }
        //get request item in RQueue
        Item requestItem = RQueue.deQueue();
        //update
        updateItemInIList(requestItem);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    public boolean isAvailableQuantity(Node item, Item request) {
        if (item.info.getQuantity() >= request.getQuantity()) {
            return true;
        }
        return false;
    }

    public void updateItemInIList(Item requestItem) {
        //search item in IList and update quantity by first request item in RQueue
        Node item = IList.head;
        while (item != null) {
            //if name of item not equal to request item, travel to next item in IList
            if (!item.info.getName().equals(requestItem.getName())) {
                item = item.next;
                continue;
            }
            //name of item equal to request item => check quantity
            if (isAvailableQuantity(item, requestItem)) {
                //update quantity
                int newQuantity = item.info.getQuantity() - requestItem.getQuantity();
                item.info.setQuantity(newQuantity);
                // if set quantity successfully => end loop
                // must not use return beacause end function => not run ftraverse(f);f.close();
                break;
            }
            //travel to next item in IList
            item = item.next;
        }
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
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/

        while (!RQueue.isEmpty()) {
            //get request item in RQueue
            Item requestItem = RQueue.deQueue();
            //update
            updateItemInIList(requestItem);
        }

        //------------------------------------------------------------------------------------
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
        int S = 0;
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        
        //caculate
        S = calcuteTotalRevenue();
        //------------------------------------------------------------------------------------
        f.writeBytes("Money     : " + S + " ");
        f.close();
    }

    public int calcuteRevenueOfItem(Item requestItem) {
        //search item in IList and calcute by quantity * price
        Node item = IList.head;
        while (item != null) {
            //if name of item not equal to request item, travel to next item in IList
            if (!item.info.getName().equals(requestItem.getName())) {
                item = item.next;
                continue;
            }
            //name of item equal to request item => check quantity
            if (isAvailableQuantity(item, requestItem)) {
                //calcute
                return item.info.getPrice() * requestItem.getQuantity();
            }
            //travel to next item in IList
            item = item.next;
        }
        return 0;
    }
    
    public int calcuteTotalRevenue() {
        int total = 0;
        while (!RQueue.isEmpty()) {
            //get request item in RQueue
            Item requestItem = RQueue.deQueue();
            //caculate
            total += calcuteRevenueOfItem(requestItem);
        }
        return total;
    }

}
