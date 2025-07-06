/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q1;

/**
 *
 * @author Legion 5 Pro
 */
public class OrderQueue {
    Node front;
    int length;
    
    public OrderQueue(){
        this.front = null;
        this.length = 0;
    }
    
    public int length(){
        return length;
    }
    
    public boolean isEmpty(){
        return this.length == 0;
    }
    
    void loadData(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        String[] b = Lib.readLineToStrArray("data.txt", k + 1);
        double[] c = Lib.readLineToDoubleArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            enqueue(a[i], b[i], c[i]);
        }
    }
    
    public void enqueue(String orderID, String customerName, double totalPrice){
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        
        //---------------------------------------------------------
    }
    
    public void remove(String id){
         //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        
        //---------------------------------------------------------
    }
    
    public void displayOrders(){
        if (this.isEmpty()){
            System.out.println("There is no Order right now");
            return;
        }
        Node current = this.front;
        while(current != null){
            System.out.println(current.info.orderID+ " --> ");
        }
    }
}
