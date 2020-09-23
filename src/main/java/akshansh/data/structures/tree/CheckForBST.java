package akshansh.data.structures.tree;

import java.util.ArrayList;
import java.util.List;

public class CheckForBST {

    static boolean flag = true;
    // return true if the given tree is a BST, else return false
    static boolean isBST(BinaryTree.Node root) {
        // code here.
        flag = true;
        inorder(root);

        return flag;
    }

    static List<Integer> inorder(BinaryTree.Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> leftNodes = inorder(root.left);

        for (int i=0 ; i<leftNodes.size() ; i++) {
            if (leftNodes.get(i) >= root.data) {
                flag = false;
            }
        }

        leftNodes.add(root.data);

        List<Integer> rightNodes = inorder(root.right);

        for (int i=0 ; i<rightNodes.size() ; i++) {
            if (rightNodes.get(i) < root.data) {
                flag = false;
            }
        }

        leftNodes.addAll(rightNodes);
        return leftNodes;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.Node node = binaryTree.levelOrderInsertion(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println(isBST(node));
    }
}
