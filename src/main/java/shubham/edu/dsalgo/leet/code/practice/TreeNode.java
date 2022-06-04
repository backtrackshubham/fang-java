package shubham.edu.dsalgo.leet.code.practice;

import java.util.*;
import java.util.stream.Collectors;

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
            return Math.max(lh, lr);
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
          return  "" +this.val;
//        System.out.println(this.val);
//        StringBuffer str = new StringBuffer();
//        if(this.left != null && this.right != null){ // 1 0 | 0 1 | 1 1
//            return str.append(" ").append(this.left).append(" ").append(this.right).toString();
//        } else if(this.left != null) {
//            return str.append(" ").append(this.left).append(" ").toString();
//        }else if(this.right != null) {
//            return str.append(" ").append(this.right).append(" ").toString();
//        } else {
//            return str.append(this.val).toString();
//        }
    }

    private void printElementList(List<T> elements, int firstColumn, int middleColumn){
//        System.out.println("Got to print "+ elements);
          StringBuffer sb = new StringBuffer("");
          while (firstColumn > 0){
              sb.append("\t");
              firstColumn--;
          }
          StringBuffer mid = new StringBuffer("");
          while (middleColumn > 0){
              mid.append("\t");
              middleColumn--;
          }
          elements.forEach(el -> {
              if(el == null){
                  sb.append(" "+mid);
              } else {
                  sb.append(el+""+mid);
              }
          });
          sb.append("\n");
        System.out.println(sb);
    }


    public void printTree(){
          int height = this.getHeight();
          List<TreeNode<T>> li = new ArrayList<>();
          li.add(this);
          while(height >= 0){
              printElementList(li.stream().map(x -> {
                  if(x != null){
                      return x.val;
                  } else {
                      return null;
                  }
              }).collect(Collectors.toList()), (int)Math.pow(2, height) - 1, (int)Math.pow(2, height + 1));
              List<TreeNode<T>> temp = new ArrayList<>();
              Iterator<TreeNode<T>> it = li.listIterator();
              while (it.hasNext()){
                  TreeNode<T> next = it.next();
                  if(next != null){
                      if(next.left == null || next.right == null){
//                          System.out.println("Adding a null element");
//                          System.out.println(next.val);
                      }
                      temp.add(next.left);
                      temp.add(next.right);
                  }
              }
              height--;
              li = temp;
          }
    }

    static java.util.Random r = new Random();

    /**
     * This would build a tree with 2^elements - 1 nodes
     * max 127
     * @param elements
     * @return
     */
    public static TreeNode<Integer> buildTree(int elements){
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
        return buildPerfectTree(new TreeNode<Integer>(r.nextInt(200)), levels);
    }
    public static TreeNode<Integer> buildPerfectTree(TreeNode<Integer> tree, int levels){
        if (levels != 0) {
            tree.left = buildPerfectTree(new TreeNode<Integer>(r.nextInt(200)), levels - 1);
            tree.right = buildPerfectTree(new TreeNode<Integer>(r.nextInt(200)), levels - 1);
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
    public final TreeNode<Integer> getTargetCopy(final TreeNode<Integer> original, final TreeNode<Integer> cloned, final TreeNode<Integer> target) {
        ArrayList<TreeNode<Integer>> allNodesOriginal1 =  new ArrayList<TreeNode<Integer>>();
        allNodesOriginal1.add(original);
        ArrayList<TreeNode<Integer>> allNodesCloned1 =  new ArrayList<TreeNode<Integer>>();
        allNodesCloned1.add(cloned);
        ArrayList<TreeNode<Integer>> allNodesOriginal =  resolveNodes(allNodesOriginal1, new ArrayList<TreeNode<Integer>>());
        ArrayList<TreeNode<Integer>> allNodesCloned =  resolveNodes(allNodesCloned1, new ArrayList<TreeNode<Integer>>());
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

    private ArrayList<TreeNode<Integer>> resolveNodes(ArrayList<TreeNode<Integer>> toProcess, ArrayList<TreeNode<Integer>> processed){
        boolean hasAllNull = true;
        ArrayList<TreeNode<Integer>> toProcessNext = new ArrayList<>();
        ListIterator<TreeNode<Integer>> iteratorPN = toProcess.listIterator();

        while (iteratorPN.hasNext()){
            TreeNode<Integer> tn = iteratorPN.next();
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