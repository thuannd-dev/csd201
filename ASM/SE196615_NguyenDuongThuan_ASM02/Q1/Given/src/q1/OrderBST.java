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
        if(root == null) {
            return new TreeNode(order);
        }
        if (order.orderID.compareTo(root.info.orderID) < 0) {
            root.left = insert(root.left, order);
        }else if(order.orderID.compareTo(root.info.orderID) >= 0) {
            root.right = insert(root.right, order);
        }
        return root;
    }
    
    public Order search(String id){
        return search(root, id);    
    }
    
    public Order search(TreeNode root, String id){
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        
        //---------------------------------------------------------
        if(root == null) {
            return null;
        }
        if(id.compareTo(root.info.orderID) < 0) {
            return search(root.left, id);
        }else if (id.compareTo(root.info.orderID) > 0) {
            return search(root.right, id);
        }else {
            return root.info;
        }
    }
    
    public void remove(String id){
        root = remove(root, id);
    }
    
    public TreeNode remove(TreeNode root, String id){
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        
        //---------------------------------------------------------
        if(root == null) {
            return null;
        }
        if(id.compareTo(root.info.orderID) < 0) {
            root.left = remove(root.left, id);
        }else if (id.compareTo(root.info.orderID) > 0) {
            root.right = remove(root.right, id);
        }else {
            if ((root.left == null) && (root.right == null)) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            //two child
            root.info = findMin(root.right);
            root.right = remove(root.right, root.info.orderID);  
        }
        return root;
    }
    
    
    public Order findMin(TreeNode root){
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        
        //---------------------------------------------------------
        if(root == null) {
            return null;
        }
        TreeNode current = root;
        while (current.left != null) {            
            current = current.left;
        }
        return current.info;
    }
    
    public Order findMax(){ 
        return findMax(root);
    }
    
    public Order findMax(TreeNode root){
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        
        //---------------------------------------------------------
        if(root == null) {
            return null;
        }
        TreeNode current = root;
        while (current.right != null) {            
            current = current.right;
        }
        return current.info;
    }
}
