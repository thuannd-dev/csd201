/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package recursion;

/**
 *
 * @author DELL
 */
public class Recursion {

    /**
     * @param args the command line arguments
     */
    public static void sayHello(int n) {
        if (n == 5) {
            return;
        }
        // System.out.println("Hello" + n);
        sayHello(n + 1);
        System.out.println("Hello" + n);
    }

    public static int factorial(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        if (n < 0) {
            return -1; // Error case for negative input
        }
        int result = factorial(n - 1) * n;
        return result;
    }

    public static double powerOfNumber(int n, int p) {
        if (p == 0) {
            return 1;
        }
        if (p < 0) {
            return 1 / powerOfNumber(n, -p);
        }
        return powerOfNumber(n, p - 1) * n;
    }

    public static int fibonacci(int n) {
        // if (n < 0) {
        //     return -1; // Error case for negative input
        // }
        // if (n == 0) {
        //     return 0;
        // }
        // if (n == 1) {
        //     return 1;
        // }
        if (n < 0) {
            return -1; // Error case for negative input
        }
        if (n <= 1) {
            return n; // Base case for Fibonacci sequence
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int sumDigits(int n) {
        if (n < 0) {
            n = -n; // Convert negative number to positive
        }
        if (n == 0) {
            return 0;
        }
        return n % 10 + sumDigits(n / 10);
    }

    public static void main(String[] args) {
        sayHello(0);
        System.out.println(factorial(5));
        System.out.println(powerOfNumber(2, -3));
        System.out.println(fibonacci(8));
        System.out.println(sumDigits(-459));
    }

}
