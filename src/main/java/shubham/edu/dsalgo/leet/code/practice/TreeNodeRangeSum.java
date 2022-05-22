package shubham.edu.dsalgo.leet.code.practice;


import java.util.ArrayList;
import java.util.ListIterator;

class TreeNodeRangeSum {
    public int rangeSumBST(TreeNode<Integer> root, int L, int R) {
        if(root == null){
            return 0;
        }
        ArrayList<Integer> some = new ArrayList<>();
        traverse(root, L, R, some);
        int sum = 0;
        ListIterator<Integer> ls = some.listIterator();
        while (ls.hasNext()){
            sum += ls.next();
        }
        return sum;
    }

    public void traverse(TreeNode<Integer> root, int L, int R, ArrayList<Integer> ar) {
        if(root == null){
            return ;
        } else{
            if(root.val <= R && root.val >= L) ar.add(root.val);
            if(root.left != null && root.right != null){
            traverse(root.left, L, R, ar);
            traverse(root.right, L, R, ar);
            } else if(root.left != null){
                traverse(root.left, L, R, ar);
            } else {
                traverse(root.right, L, R, ar);
            }
        }
    }

    public int traverse2(TreeNode<Integer> root, int L, int R, int sum) {
        if(root == null){
            return sum;
        } else{
            if(root.val <= R && root.val >= L) sum += root.val;
            if(root.left != null && root.right != null){
                return sum + traverse2(root.left, L, R, 0) + traverse2(root.right, L, R, 0);
            } else if(root.left != null){
                return traverse2(root.left, L, R, sum);
            } else {
                return traverse2(root.right, L, R, sum);
            }
        }
    }

}