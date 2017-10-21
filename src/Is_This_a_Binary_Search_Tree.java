import java.util.ArrayList;
import java.util.List;

public class Is_This_a_Binary_Search_Tree {
    /* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/

    ArrayList<Integer> list = new ArrayList<>();

    boolean checkRight(int rootData, Node root) {
        if (root == null)
            return true;
        else if (rootData > root.data)
            return false;
        else return true && checkRight(rootData, root.right) && checkRight(rootData, root.left);
    }

    boolean checkLeft(int rootData, Node root) {
        if (root == null)
            return true;
        else if (rootData < root.data)
            return false;
        else return true && checkLeft(rootData, root.right) && checkLeft(rootData, root.left);
    }

    boolean checkBST(Node root) {
        if (root == null)
            return true;
        else if (list.indexOf(root.data) == -1)
            list.add(root.data);
        else return false;
        if (!checkRight(root.data, root.right))
            return false;
        if (!checkLeft(root.data, root.left))
            return false;
        return true && checkBST(root.left) && checkBST(root.right);

    }

    public class Node {
        int data;
        Node left;
        Node right;
    }
}
