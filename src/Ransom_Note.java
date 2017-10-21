import java.util.*;

public class Ransom_Note {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    boolean isValid = true;

    public Ransom_Note(String magazine, String note) {
            magazineMap = new HashMap<>();
        for (String s : magazine.split(" ")) {
            if (this.magazineMap.get(s) == null)
                this.magazineMap.put(s, 1);
            else
                this.magazineMap.put(s, this.magazineMap.get(s) + 1);
        }
        for (String s :
                note.split(" ")) {
            if (this.magazineMap.get(s) == null || this.magazineMap.get(s) == 0) {
                isValid = false;
                break;
            } else {
                this.magazineMap.put(s, this.magazineMap.get(s) - 1);
            }
        }
    }

    public boolean solve() {
        return isValid;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Eat whitespace to beginning of next line
        scanner.nextLine();

        Ransom_Note s = new Ransom_Note(scanner.nextLine(), scanner.nextLine());
        scanner.close();

        boolean answer = s.solve();
        if (answer)
            System.out.println("Yes");
        else System.out.println("No");

    }
}
