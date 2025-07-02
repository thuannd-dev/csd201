/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sortalgorithm;

/**
 *
 * @author DELL
 */
public class SortAlgorithms {

    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // mảng đã được sắp xếp rồi 
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            // nếu không có phần tử nào được hoán đổi, thoát khỏi vòng lặp, tức là vòng lặp đã được sắp xếp
            if (!swapped) {
                break;
            }
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            // Di chuyển các phần tử của arr[0..i-1], mà lớn hơn key, đến một vị trí phía sau vị trí hiện tại của chúng
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // Tìm phần tử nhỏ nhất trong mảng chưa được sắp xếp
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Hoán đổi phần tử nhỏ nhất với phần tử đầu tiên của mảng chưa được sắp xếp
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        // Tạo các mảng tạm để lưu các phần tử
        int size1 = mid - left + 1;
        int size2 = right - mid;
        int[] L = new int[size1];
        int[] R = new int[size2];
        // Sao chép dữ liệu vào các mảng tạm
        for (int i = 0; i < size1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < size2; j++) {
            R[j] = arr[mid + 1 + j];
        }
        // Gộp các mảng tạm vào mảng gốc
        int i = 0, j = 0, k = left;
        while (i < size1 && j < size2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        // Sao chép các phần tử còn lại của L (nếu có)
        while (i < size1) {
            arr[k++] = L[i++];
        }
        // Sao chép các phần tử còn lại của R (nếu có)
        while (j < size2) {
            arr[k++] = R[j++];
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        // Tìm điểm giữa của mảng
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);

    }

    public static int findPivotIndex(int[] arr, int left, int right) {
        // Tìm chỉ số của phần tử chốt (pivot) trong mảng
        int pivot = arr[right];
        int i = left - 1; // Chỉ số của phần tử nhỏ hơn pivot
        for (int j = left; j <= right; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        // Hoán đổi phần tử chốt với phần tử ở vị trí i + 1
        swap(arr, i + 1, right);
        return i + 1;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = findPivotIndex(arr, left, right);
        quickSort(arr, left, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, right);

    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Unsorted array");
        printArray(arr);
        System.out.println();
        // selectionSort(arr);
        // mergeSort(arr, 0, arr.length - 1);
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array");
        printArray(arr);
    }

}
