import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Bubble_Sort {
    private static void bubbleSort(int[] array) {
        int swap = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    swap++;
                }
            }
        }
        System.out.println("Array is sorted in " + swap + " swaps.\n" +
                "First Element: " + array[0] + "\n" +
                "Last Element: " + array[array.length - 1]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
    }
}
