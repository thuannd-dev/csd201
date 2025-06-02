/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package q1;

import java.util.Scanner;

/**
 *
 * @author Linh
 */
public class Q1 {

    public static void main(String[] args) throws Exception {
        ComputerStore t = new ComputerStore();
        int choice;
        Scanner sca = new Scanner(System.in);
        System.out.println();
        System.out.println(" 1. Test f1 (2.5 mark)");
        System.out.println(" 2. Test f2 (2.5 mark)");
        System.out.println(" 3. Test f3 (2.5 mark)");
        System.out.println(" 4. Test f4 (2.5 mark)");
        System.out.print("    Your selection (1 -> 4): ");
        choice = sca.nextInt();
        sca.nextLine();
        switch(choice) {
            case 1: t.f1();
                System.out.println("\nOUTPUT:");
                Lib.viewFile("f1.txt");
                break;
            case 2: t.f2();
                System.out.println("\nOUTPUT:");
                Lib.viewFile("f2.txt");
                break;
            case 3: t.f3();
                System.out.println("\nOUTPUT:");
                Lib.viewFile("f3.txt");
                break;
            case 4: t.f4();
                System.out.println("\nOUTPUT:");
                Lib.viewFile("f4.txt");
                break;
            default: System.out.println("Wrong selection");
        }
        System.out.println();
    }     
    
}
