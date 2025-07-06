/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q1;

/**
 *
 * @author Legion 5 Pro
 */
public class OrderBST {
    TreeNode root;
    
    void loadData(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        String[] b = Lib.readLineToStrArray("data.txt", k + 1);
        double[] c = Lib.readLineToDoubleArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            Order newOrder = new Order(a[i], b[i], c[i]);
            insert(newOrder);
        }
    }
    
    public void insert(Order order){
        this.root = insert(this.root, order);
    }
    
    private TreeNode insert(TreeNode root, Order order){
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        
        //---------------------------------------------------------
    }
    
    public Order search(String id){
        return search(root, id);
    }
    
    public Order search(TreeNode root, String id){
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        
        //---------------------------------------------------------
    }
    
    public void remove(String id){
        root = remove(root, id);
    }
    
    public TreeNode remove(TreeNode root, String id){
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        
        //---------------------------------------------------------
    }
    
    public Order findMax(){
        return findMax(root);
    }
    
    public Order findMax(TreeNode root){
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        
        //---------------------------------------------------------
    }
}
