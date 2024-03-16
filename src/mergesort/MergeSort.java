/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mergesort;
import java.util.Scanner;
/**
 *
 * @author Chris
 */
public class MergeSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        System.out.println("Programa que sirve para ordenar a traves del metodo de Merge Sort");
        System.out.println("Ingrese el numero de elementos a ordenar");
        int numEl = sc.nextInt();
        /* creates a temporary array to store the return value of NewArray */
        int[] tmpArray = new int[numEl];
        /* Call to create an array */
        tmpArray = NewArray(numEl);
        /* print unordered array */
        System.out.println("El arreglo que ha ingresado es:");
        PrintArray(numEl, tmpArray);
        /* pass the tmpArray to the order function and overwrite tmp with merge sorted */
        mergeSort(tmpArray, 0, numEl - 1);
        System.out.println("El arreglo ordenado es:");
        PrintArray(numEl, tmpArray);
    }
    
public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            // Find the middle point to divide the array into two halves
            int middle = (left + right) / 2;

            // Recursively sort the two halves
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            // Merge the sorted halves
            merge(array, left, middle, right);
        }
    }

    /* Helper method to merge two subarrays */
    public static void merge(int[] array, int left, int middle, int right) {
        // Calculate sizes of two subarrays to be merged
        int sizeLeft = middle - left + 1;
        int sizeRight = right - middle;

        // Create temporary arrays to hold the elements of two subarrays
        int[] leftArray = new int[sizeLeft];
        int[] rightArray = new int[sizeRight];

        // Copy data to temporary arrays
        for (int i = 0; i < sizeLeft; ++i) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < sizeRight; ++j) {
            rightArray[j] = array[middle + 1 + j];
        }

        // Merge the temporary arrays

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = left;
        while (i < sizeLeft && j < sizeRight) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray[] if any
        while (i < sizeLeft) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray[] if any
        while (j < sizeRight) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    /* creates and fills the array */
    public static int[] NewArray(int numEl) {
        int[] newArray = new int[numEl];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < numEl; i++) {
            System.out.println("Ingrese el dato en la posicion " + i);
            int nwEl = sc.nextInt();
            newArray[i] = nwEl;
        }
        return newArray;
    }

    /* PrintArray */
    public static void PrintArray(int numEl, int[] arrayToPrint) {
        for (int i = 0; i < numEl; i++) {
            System.out.print(arrayToPrint[i] + " ");
        }
        System.out.println();
    }
}
