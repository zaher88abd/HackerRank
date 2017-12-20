import java.util.*;


/*
* the input is three numbers: num p q
*
* p != q
* print from 1 to num
* print "OUTTHINK" if i is equal p or q
* print "THINK"  if i is greater than 10 and
*/
public class IBM_challenge {

    public static void main(String[] args) {
        String line = new Scanner(System.in).nextLine();

        int num1 = Integer.parseInt(line.split(" ")[0]);
        int p = Integer.parseInt(line.split(" ")[1]);
        int q = Integer.parseInt(line.split(" ")[2]);

        String s = " ";
        for (int i = 1; i <= num1; i++) {
            if (i == p || i == q)
                System.out.print(s + "OUTTHINK");
            else if (i >= 10 && (i % 10 == p || i % 10 == q))
                System.out.print(s + "THINK");
            else if (i % p == 0 || i % q == 0)
                System.out.print(s + "OUT");
            else
                System.out.print(s + i);
            s = ",";

        }

    }
}
