import java.util.*;

public class Number_Needed {
    public static int numberNeeded(String first, String second) {
        int count = 0;
        for (int i = 0; i < first.length(); i++) {
            if (second.contains(String.valueOf(first.toCharArray()[i])))
                count++;
        }
        return first.length()+second.length()-(count*2);
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String a = in.next();
//        String b = in.next();
        System.out.println(numberNeeded("cde","abcc"));
    }
}
