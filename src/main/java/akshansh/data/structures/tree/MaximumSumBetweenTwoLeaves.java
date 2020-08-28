package akshansh.data.structures.tree;

public class MaximumSumBetweenTwoLeaves {

    static int max = Integer.MIN_VALUE;
    static int maxPathSum(BinaryTree.Node root) {
        // code here
        max = Integer.MIN_VALUE;
        postorder(root);
        return max;
    }

    static int postorder(BinaryTree.Node root) {
        if (root == null) {
            return 0;
        }

        int leftTrav = postorder(root.left);

        int rightTrav = postorder(root.right);

        int currSum = leftTrav + rightTrav + root.data;

        if (currSum > max && (root.left != null && root.right != null)) {
            max = currSum;
        }

        if (root.left == null) {
            return root.data + rightTrav;
        } else if (root.right == null) {
            return root.data + leftTrav;
        } else if (leftTrav > rightTrav) {
            return root.data + leftTrav;
        } else {
            return root.data + rightTrav;
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.Node node = binaryTree.levelOrderInsertion(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println(maxPathSum(node));
    }
}
