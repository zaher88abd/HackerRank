import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Contacts {
    static Node rootNode = new Node('*', false);

    private static void add(String word, Node node) {
        Node current = node;
        if (word != null && word.length() > 0) {
            if (current.charArray.containsKey(word.charAt(0))) {
                Node nextNode = current.charArray.get(word.charAt(0));
                current.numberWord++;
                add(new StringBuilder(word).deleteCharAt(0).toString(), nextNode);
                return;
            }
            char key = word.charAt(0);
            word = new StringBuilder(word).deleteCharAt(0).toString();
            Node newNode = new Node(key);
            current.charArray.put(key, newNode);
            current.numberWord++;
            node.isEnd = false;
            add(word, newNode);
        } else {
            Node newNode = new Node('*', true);
            current.numberWord++;
            current.charArray.put('*', newNode);
        }
    }

    private static int find(String word, Node node) {
        if (word == null || word.length() == 0) {
            if (node.isEnd)
                return 1;
            else return node.numberWord;
        }
        if (!node.charArray.containsKey(word.charAt(0)))
            return 0;
        else {
            return find(new StringBuilder(word).deleteCharAt(0).toString()
                    , node.charArray.get(word.charAt(0)));
        }
    }

    public static class Node {
        char data;
        Map<Character, Node> charArray;
        boolean isEnd;
        int numberWord;

        public Node(char c) {
            this.data = c;
            this.charArray = new HashMap<Character, Node>();
            this.isEnd = false;
            this.numberWord = 0;
        }

        public Node(char c, boolean isEnd) {
            this.data = c;
            this.charArray = new HashMap<Character, Node>();
            this.isEnd = isEnd;
            this.numberWord = 0;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int a0 = 0; a0 < n; a0++) {
            String op = in.next();
            String contact = in.next();
            if (op.equals("add"))
                add(contact, rootNode);
            else if (op.equals("find"))
                System.out.println(find(contact, rootNode));
        }
    }

}
