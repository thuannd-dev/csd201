package q1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class Item {
    String name;
    int price;
    int quantity;

    public Item(String name, int quantity, int price) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public Item(String name, int quantity) {
        this.name = name;
        this.price = 0;
        this.quantity = quantity;
    }

    public Item() {
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public String toString(){
        return "("+name+","+quantity+","+price+")";
    }
}
