package akshansh.data.structures.tree;

import static akshansh.data.structures.tree.BinaryTree.*;

public class SortedArrayToBTWithMinHeight {

    static Node binaryTraversal(int[] arr) {
        if (arr.length == 0) {
            return null;
        }

        int mid = arr.length / 2;

        Node node = new Node();
        node.data = arr[mid];

        if (arr.length > 1) {
            int[] leftArr = new int[mid];
            int[] rightArr = new int[arr.length % 2 == 0 ? mid - 1 : mid];
            for (int i=0 ; i<leftArr.length ; i++) {
                leftArr[i] = arr[i];
                if (mid + i + 1 < arr.length) {
                    rightArr[i] = arr[mid + i + 1];
                }
            }

            Node leftNode = binaryTraversal(leftArr);
            Node rightNode = binaryTraversal(rightArr);

            node.left = leftNode;
            node.right = rightNode;
        }

        return node;
    }

    public static void main(String[] args) {
        Node node = binaryTraversal(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8});
//        System.out.println(node);
    }

}
