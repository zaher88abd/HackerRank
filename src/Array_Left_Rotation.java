import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Array_Left_Rotation {
    public static int[] shiftLeft(int[] a) {
        int temp = a[0];
        for (int i = 0; i <= a.length - 2; i++) {
            a[i] = a[i + 1];
        }
        a[a.length - 1] = temp;
        return a;
    }

    public static int[] arrayLeftRotation(int[] a, int n, int k) {
        for (int i = 0; i < k; i++) {
            a = shiftLeft(a);
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 5;
        int k = 2;
        int a[] = new int[]{1, 2, 3, 4, 5};
//        for (int a_i = 0; a_i < n; a_i++) {
//            a[a_i] = in.nextInt();
//        }
        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for (int i = 0; i < n; i++)
            System.out.print(output[i] + " ");
        System.out.println();
    }
}
