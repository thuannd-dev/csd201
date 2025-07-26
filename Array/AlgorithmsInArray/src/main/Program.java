/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.Arrays;

/**
 *
 * @author DELL
 */
public class Program {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10};
        // int[] result = removeEvenNumber(numbers);
        // System.out.println(Arrays.toString(result));
        reverseArray(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println(maxNumberOfArray(numbers));
        System.out.println(findSecondMax(numbers));
    }

    public static int[] removeEvenNumber(int[] array) {
        int oddNumbers = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                oddNumbers++;
            }
        }
        int[] result = new int[oddNumbers];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                result[index] = array[i];
                index++;
            }
        }
        return result;
    }

    public static void reverseArray(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static int maxNumberOfArray(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static int findSecondMax(int[] array) {
        // int max = maxNumberOfArray(array);
        // int secondMax = Integer.MIN_VALUE;
        // for (int i = 0; i < array.length; i++) {
        //     if (array[i] > secondMax && array[i] != max) {
        //         secondMax = array[i];
        //     }
        // }
        // return secondMax;

        int firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > firstMax) {
                secondMax = firstMax;
                firstMax = array[i];
            } else if (array[i] > secondMax && array[i] < firstMax) {
                secondMax = array[i];
            }
        }
        return secondMax;
    }

}
