import java.awt.*;
import java.util.ArrayList;

public class DetectACycle {
    static class Node {
        int data;
        Node next;
    }

    public static void main(String[] args) {
        Node n = new Node();
        n.data = 1;
        hasCycle(n);
    }

    static boolean hasCycle(Node head) {
        if (head == null) return false;

        Node slow = head;
        Node fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
