/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q1;

/**
 *
 * @author Legion 5 Pro
 */
public class TreeNode {
    Order info;
    TreeNode left;
    TreeNode right;
    
   TreeNode(Order o, TreeNode left, TreeNode right){
        this.info = o;
        this.left = left;
        this.right = right;
    }
   
   TreeNode(Order o){
       this(o, null, null);
   }
}
