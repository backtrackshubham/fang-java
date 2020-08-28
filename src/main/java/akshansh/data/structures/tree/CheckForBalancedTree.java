package akshansh.data.structures.tree;

import java.util.ArrayList;
import java.util.List;

public class CheckForBalancedTree {

    static boolean isBalanced(BinaryTree.Node root) {
        // Your code here
        int diff = heightDiff(root, true);
        return !(diff > 1 || diff == -1);
    }

    static int heightDiff(BinaryTree.Node root, boolean flag) {
        if (root == null) {
            return 0;
        }

        int leftHeight = 0;
        int rightHeight = 0;

        if (root.left != null) {
            leftHeight = heightDiff(root.left, false);
        }

        if (root.right != null) {
            rightHeight = heightDiff(root.right, false);
        }

        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        int diff = leftHeight - rightHeight;

        if (diff < 0) {
            diff *= -1;
        }

        if (diff > 1) {
            return -1;
        }

        return flag ? diff : (leftHeight > rightHeight ? ++leftHeight : ++rightHeight);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.Node node = binaryTree.levelOrderInsertion(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println(isBalanced(node));
    }
}
