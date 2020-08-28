package akshansh.data.structures.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CheckForMirrorTree {

    public static boolean isMirror(BinaryTree.Node root) {
        // add your code here;
        List<BinaryTree.Node> nodeQueue = new ArrayList<>();

        List<BinaryTree.Node> childNodeQueue = new ArrayList<>();

        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            for (BinaryTree.Node node : nodeQueue) {
                childNodeQueue.add(node == null ? null : node.left);
                childNodeQueue.add(node == null ? null : node.right);
            }

            for (int i=0,j=childNodeQueue.size() - 1 ; i<childNodeQueue.size() && j >= 0 ; i++,j--) {
                if (i == j || i > j) {
                    break;
                }

                if (!(childNodeQueue.get(i) == null && childNodeQueue.get(j) == null)) {
                    if (childNodeQueue.get(i) == null) {
                        return false;
                    } else if (childNodeQueue.get(j) == null) {
                        return false;
                    } else if (childNodeQueue.get(i).data != childNodeQueue.get(j).data) {
                        return false;
                    }
                }
            }

            if (childNodeQueue.stream().noneMatch(Objects::nonNull)) {
                break;
            }

            nodeQueue.clear();
            nodeQueue.addAll(childNodeQueue);
            childNodeQueue.clear();
        }

        return true;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.Node node = binaryTree.levelOrderInsertion(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println(isMirror(node));
    }
}
