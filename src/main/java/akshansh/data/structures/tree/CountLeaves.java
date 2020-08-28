package akshansh.data.structures.tree;

public class CountLeaves {

    static int countLeaves(BinaryTree.Node node) {
        int count = 0;
        // Your code
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        if (node.left != null) {
            count += countLeaves(node.left);
        }

        if (node.right != null) {
            count += countLeaves(node.right);
        }

        return count;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.Node node = binaryTree.levelOrderInsertion(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println(countLeaves(node));
    }
}
