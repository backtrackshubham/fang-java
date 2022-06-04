package shubham.edu.dsalgo.leet.code.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeViews<T> {
     List<T> printView(TreeNode<T> treeNode, Boolean left){
         List<T> toRet = new ArrayList<>();
         List<TreeNode<T>> tempList = new ArrayList<>();
         tempList.add(treeNode);
         toRet.add(treeNode.val);
         do {
             List<TreeNode<T>> child = new ArrayList<>();
             Iterator<TreeNode<T>> itr = tempList.iterator();
             while (itr.hasNext()){
                 TreeNode<T> t = itr.next();
                 if (t.left != null){
                     child.add(t.left);
                 }
                 if(t.right != null){
                     child.add(t.right);
                 }
             }
             tempList = child;
             if(!child.isEmpty()){
                 toRet.add(getViewElement(child, left).val);
             }
         } while (!tempList.isEmpty());
         return toRet;
     }

     private TreeNode<T> getViewElement(List<TreeNode<T>> list, Boolean isLeft){
         if(isLeft){
             return list.get(0);
         } else {
             return list.get(list.size() - 1);
         }
     }
}
