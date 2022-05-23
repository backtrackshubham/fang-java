package shubham.edu.dsalgo.leet.code.practice;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

class Main{
    public static void main(String[] args) {

    }
}

class TreeNode<T> {
      T val;
      TreeNode<T> left;
      TreeNode<T> right;
      TreeNode(T x) { val = x; }

    public int getHeight() {
          return findHeight(this, 0);
    }
    private int findHeight(TreeNode<T> treeNode, int height) {
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

    @Override
    public String toString() {
//        System.out.println(this.val);
        StringBuffer str = new StringBuffer();
        if(this.left != null && this.right != null){ // 1 0 | 0 1 | 1 1
            return str.append(" ").append(this.left).append(" ").append(this.right).toString();
        } else if(this.left != null) {
            return str.append(" ").append(this.left).append(" ").toString();
        }else if(this.right != null) {
            return str.append(" ").append(this.right).append(" ").toString();
        } else {
            return str.append(this.val).toString();
        }
    }

    static java.util.Random r = new Random();

    /**
     * This would build a tree with 2^elements - 1 nodes
     * max 127
     * @param elements
     * @return
     */
    public static TreeNode buildTree(int elements){
        int validElements = getValidNumberOfElements(elements);
        int levels = (validElements == 1) ?
                        0 : (validElements == 3 ?
                        1 : (validElements == 7 ?
                        2 : (validElements == 15 ?
                        3 : (validElements == 31) ?
                        4 : (validElements == 63 ?
                        5 : 6))));
        System.out.println(levels);
        System.out.println(validElements);
        return buildPerfectTree(new TreeNode(r.nextInt(200)), levels);
    }
    public static TreeNode buildPerfectTree(TreeNode tree, int levels){
        if (levels != 0) {
            tree.left = buildPerfectTree(new TreeNode(r.nextInt(200)), levels - 1);
            tree.right = buildPerfectTree(new TreeNode(r.nextInt(200)), levels - 1);
        }
        return tree;
    }

    private static int getValidNumberOfElements(int original) {
        //1,3,7,15,31,63,127
        if (original < 1) {
           return 1;
        } else if (original < 3) {
            return 3;
        } else if (original < 7) {
            return 7;
        }  else if (original < 15) {
            return 15;
        }  else if (original < 31) {
            return 31;
        }  else if (original < 63) {
            return 63;
        } else if (original < 127) {
            return 127;
        } else return 127;
    }
}


class Solution2 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        ArrayList<TreeNode> allNodesOriginal1 =  new ArrayList<TreeNode>();
        allNodesOriginal1.add(original);
        ArrayList<TreeNode> allNodesCloned1 =  new ArrayList<TreeNode>();
        allNodesCloned1.add(cloned);
        ArrayList<TreeNode> allNodesOriginal =  resolveNodes(allNodesOriginal1, new ArrayList<TreeNode>());
        ArrayList<TreeNode> allNodesCloned =  resolveNodes(allNodesCloned1, new ArrayList<TreeNode>());
        ListIterator itr = allNodesOriginal.listIterator();
        int index = 0 ;
        while (itr.hasNext()){
            if(itr.next() == target){
                break;
            }
            index += 1;
        }

        return allNodesCloned.get(index);
    }

    private ArrayList<TreeNode> resolveNodes(ArrayList<TreeNode> toProcess, ArrayList<TreeNode> processed){
        boolean hasAllNull = true;
        ArrayList<TreeNode> toProcessNext = new ArrayList<>();
        ListIterator<TreeNode> iteratorPN = toProcess.listIterator();

        while (iteratorPN.hasNext()){
            TreeNode tn = iteratorPN.next();
            processed.add(tn);
            if(tn == null){
                toProcessNext.add(null);
                toProcessNext.add(null);
            } else {
                toProcessNext.add(tn.left);
                toProcessNext.add(tn.right);
            }
        }
        iteratorPN = toProcessNext.listIterator();

        while (iteratorPN.hasNext()){
            if(iteratorPN.next() != null){
                hasAllNull = false;
            }
        }
        if(hasAllNull){
            return processed;
        }
        return resolveNodes(toProcessNext, processed);
    }
}