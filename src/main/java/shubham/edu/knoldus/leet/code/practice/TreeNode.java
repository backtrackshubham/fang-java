package edu.knoldus.leet.code.practice;

import java.util.ArrayList;
import java.util.ListIterator;

class Main{
    public static void main(String[] args) {

    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        System.out.println(this.val);
        StringBuffer str = new StringBuffer();
        if(this.left != null && this.right != null){ // 1 0 | 0 1 | 1 1
            return str.append(" ").append(this.left.toString()).append(" ").append(this.right.toString()).toString();
        } else if(this.left != null) {
            return str.append(" ").append(this.left.toString()).append(" ").toString();
        }else if(this.right != null) {
            return str.append(" ").append(this.right.toString()).append(" ").toString();
        } else {
            return str.append(this.val).toString();
        }
    }
}


class Solution {
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