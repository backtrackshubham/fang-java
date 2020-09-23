package akshansh.data.structures.tree;

import java.util.ArrayList;

public class InorderTraversal {

    static ArrayList<Integer> inOrder(BinaryTree.Node root)
    {
        ArrayList<Integer> nodes = new ArrayList<>();

        if (root == null) {
            return nodes;
        }
        // Code
        if (root.left != null) {
            nodes = inOrder(root.left);
        }

        nodes.add(root.data);

        if (root.right != null) {
            nodes.addAll(inOrder(root.right));
        }

        return nodes;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.Node node = binaryTree.levelOrderInsertion(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println(inOrder(node));
    }
}
