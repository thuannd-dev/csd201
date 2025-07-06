package q1;

/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;


class ComputerStore {

    OrderQueue orderQueue = new OrderQueue();
    OrderBST orderTree = new OrderBST();
    Scanner sc = new Scanner(System.in);

    ComputerStore() {
    }

    void load(int k) throws Exception //do not edit this function
    {
        orderQueue.loadData(k);
        orderTree.loadData(k);
    }
    
    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }
    
    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = orderQueue.front;
        f.writeBytes("Order Queue: ");
        if (p == null) {
            f.writeBytes("Empty");
        }
        while (p != null) {
            f.writeBytes("(" +  p.info.getID() + "," + p.info.getName() + "," + p.info.getPrice()   + ") ");
            p = p.next;
        }
        f.writeBytes("\r\n");
        // BST inOrder traversal
        f.writeBytes("Order BST: ");
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = orderTree.root;
        while(current!=null || !stack.isEmpty()){
            while(current != null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            f.writeBytes("(" +  current.info.getID() + "," + current.info.getName() + "," + current.info.getPrice()   + ") ");
            current = current.right;
        }
        f.writeBytes("\r\n");
    }
    
    String loadInput(int k) //do not edit this function
    {
        String a = Lib.readLineToStr("data.txt", k);
        return a;
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
        String searchID = loadInput(5);
        System.out.println(searchID);
        Order found = orderTree.search(searchID);
        if (found != null){
            f.writeBytes("Found Order: ");
            f.writeBytes("(" +  found.getID() + "," + found.getName() + "," + found.getPrice()   + ") ");
            f.writeBytes("\r\n");
        }else{
            f.writeBytes("Not found");
            f.writeBytes("\r\n");
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
        Order max = orderTree.findMax();
        if (max != null){
            f.writeBytes("Highest Alphabetical ID Order: ");
            f.writeBytes("(" +  max.getID() + "," + max.getName() + "," + max.getPrice()   + ") ");
            f.writeBytes("\r\n");
        }else{
            f.writeBytes("Not found");
            f.writeBytes("\r\n");
        }
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
        String deleteID = loadInput(7);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    

}
