package akshansh.data.structures.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;
    }

    public Node levelOrderInsertion(int[] arr) {

        int height = 1;
        Queue<Node> nodeQueue = new LinkedList<>();
        Queue<Node> tempNodeQueue = new LinkedList<>();

        Node root = new Node();
        root.data = arr[0];
        nodeQueue.add(root);


        for (int i=1 ; i<arr.length ; i++) {
            for (int j=0 ; j<Math.pow(2, height) && i<arr.length ; j++) {
                Node tempNode = new Node();
                tempNode.data = arr[i];
                tempNodeQueue.add(tempNode);
                i++;
            }
            i--;

            Queue<Node> tempTempNodeQueue = new LinkedList<>();

            while (!nodeQueue.isEmpty() && !tempNodeQueue.isEmpty()) {
                Node removedNode = nodeQueue.remove();
                Node leftNode = tempNodeQueue.poll();
                Node rightNode = tempNodeQueue.poll();

                removedNode.left = leftNode;
                removedNode.right = rightNode;
                tempTempNodeQueue.add(leftNode);
                tempTempNodeQueue.add(rightNode);
            }

            nodeQueue.addAll(tempTempNodeQueue);
            tempTempNodeQueue.clear();

            height++;

        }

        return root;
    }
}
