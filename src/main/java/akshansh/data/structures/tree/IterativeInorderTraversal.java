package akshansh.data.structures.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import static akshansh.data.structures.tree.BinaryTree.*;

public class IterativeInorderTraversal {

    static List<Node> iterativeInorder(Node root) {
        Stack<Node> nodeStack = new Stack<>();
        List<Node> nodes = new ArrayList<>();

        while (root != null) {
            nodeStack.push(root);
            root = root.left;
        }

        Node currentNode;
        while (!nodeStack.isEmpty()) {
            currentNode = nodeStack.pop();
            nodes.add(currentNode);
            currentNode = currentNode.right;

            while (currentNode != null) {
                nodeStack.push(currentNode);
                currentNode = currentNode.left;
            }
        }

        return nodes;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.Node node = binaryTree.levelOrderInsertion(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println(iterativeInorder(node).stream().map(node1 -> node1.data).collect(Collectors.toList()));
    }
}
