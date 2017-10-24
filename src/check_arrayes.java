import java.util.Scanner;

public class check_arrayes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Double[] farr = new Double[n];
        Double[] sarr = new Double[n];
        for (int a_i = 0; a_i < n; a_i++) {
            farr[a_i] = (in.nextDouble());
        }
        for (int a_i = 0; a_i < n; a_i++) {
            sarr[a_i] = (in.nextDouble());
        }
        for (int a_i = 0; a_i < n; a_i++) {
            if (Double.compare(farr[a_i], sarr[a_i]) != 0)
                System.out.println("error" + a_i);
        }

    }
}
