package shubham.edu.dsalgo.leet.code.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class MainSum {
    public static void main(String[] args) {

    }
}

public class DeepestLeafSum {

    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        } else {
            return traverseTree(root, 0, sum);
        }
    }

    private int findHeight(TreeNode treeNode, int height) {
        if (treeNode.left != null && treeNode.right != null) {
            int lh = findHeight(treeNode.left, height + 1);
            int lr = findHeight(treeNode.right, height + 1);
            System.out.println("Left Height " + lh + " Right Height " + lr);
            return height + Math.max(lh, lr);
        } else if (treeNode.left == null && treeNode.right == null) {
            return height;
        } else if (treeNode.right == null) {
            return findHeight(treeNode.left, height + 1);
        } else {
            return findHeight(treeNode.right, height + 1);
        }
    }

    private int traverseTree(TreeNode node, int height, int aggSum) {
        Iterator<TreeNode> iterator = Collections.emptyIterator();
        while (iterator.hasNext()) {
            aggSum += iterator.next().val;
        }

        return aggSum;
    }

    private ArrayList<TreeNode> getNodesWithHeight(TreeNode treeNode, int currentHeight, int height, ArrayList<TreeNode> nodes) {
        if (currentHeight == height) {
            nodes.add(treeNode);
            return nodes;
        } else {
            if (treeNode.left == null && treeNode.right == null) {
                return nodes;
            } else if (treeNode.left != null && treeNode.right != null) {
                nodes.addAll(getNodesWithHeight(treeNode.left, currentHeight + 1, height, nodes));
                nodes.addAll(getNodesWithHeight(treeNode.right, currentHeight + 1, height, nodes));
                return nodes;
            } else if (treeNode.right == null) {
                nodes.addAll(getNodesWithHeight(treeNode.left, currentHeight + 1, height, nodes));
                return nodes;
            } else {
                nodes.addAll(getNodesWithHeight(treeNode.right, currentHeight + 1, height, nodes));
                return nodes;
            }
        }
    }

    // path sum
    static public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null){
            return sum - root.val == 0;
        } else {
            if(root.left == null){
                return hasPathSum(root.right, sum - root.val);
            } else if(root.right == null){
                return hasPathSum(root.left, sum - root.val);
            } else {
                return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
            }
        }
    }

/*    static int countUniValues(TreeNode root, int sum) {
        if(root.left == null && root.right == null){
            return 0;
        } else {

        }
    }

    static boolean countUniValues*/
}

