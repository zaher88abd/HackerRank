import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Balanced_Brackets {

     static boolean isBalanced(String expression) {
        int bigB = 0, squreB = 0, smallB = 0;
        for (int i = 0; i < expression.length(); i++) {
            switch (expression.toCharArray()[i]) {
                case '{':
                    bigB++;
                    break;
                case '[':
                    squreB++;
                    break;
                case '(':
                    smallB++;
                    break;
                case ')':
                    smallB--;
                    break;
                case ']':
                    squreB--;
                    break;
                case '}':
                    bigB--;
                    break;
            }
        }
         return bigB == 0 && squreB == 0 && smallB == 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }
    }
}
