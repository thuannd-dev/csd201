/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchalgorithm;

/**
 *
 * @author DELL
 */
public class SearchAlgorithms {

    public static int linearSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (key > array[mid]) {
                left = mid + 1;
            } else if (key < array[mid]) {
                right = mid - 1;
            } else {        //key = arr[mid] --> tìm thấy return mid
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 7, 8, 9, 10, 23};
        int key = 5;
        //int result = linearSearch(arr, key);
        int result = binarySearch(arr, key);
        if (result != -1) {
            System.out.println("Number " + key + " is found at position " + result);
        } else {
            System.out.println("Number " + key + " is not found !");
        }
    }
}
