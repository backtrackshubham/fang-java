package shubham.edu.dsalgo.leet.code.practice;

import java.util.*;
import java.util.function.Function;

public class  Traversals {
    public static void main(String[] args) {

        TreeNode t = TraversalHelper.parseAndBuildNode("3,5,1,6,2,0,8,null,null,7,4,null,null,null,null");
////        System.out.println("Preorder " + TraversalHelper.preorderTraversalIterative(t));
//        System.out.println("Preorder " + TraversalHelper.preorderTraversalRecursive(t, new ArrayList<>()));
//        System.out.println("Inorder " + TraversalHelper.inorderTraversalIterative(t));
//        System.out.println("Inorder " + TraversalHelper.inorderTraversalRecursive(t, new ArrayList<>()));
//        System.out.println("Postorder " + TraversalHelper.postorderTraversal(t));
//        int[] inorder = {9,3,15,20,7};
//        int[] postOrder = {9,15,7,20,3};
//
//        TraversalHelper.buildTree(inorder, postOrder);

        TreeNode test = TreeNode.buildTree(3);
        System.out.println(test);
        System.out.println("---------------------------");
//        System.out.println(t);
        System.out.println("Preorder  " + TraversalHelper.preorderTraversalRecursive(test, new ArrayList<>()));;
        System.out.println("Inorder   " + TraversalHelper.inorderTraversalIterative(test));
        System.out.println("Postorder " + TraversalHelper.postorderTraversal(test));



    }
}

class TraversalHelper {
    /**
     * A string should be separated by , in BFS format including nulls
     *
     * @param inputString
     * @return
     */


    static TreeNode parseAndBuildNode(String inputString) {
        int length = inputString.split(",").length;
        int levels = 0;
        if ((length + 1) % 2 != 0) {
            throw new IllegalArgumentException("Invalid number of nodes");
        }
        while (length + 1 != Math.pow(2, levels) && Math.pow(2, levels) <= length + 1) {

            levels += 1;
        }
        if (length + 1 != Math.pow(2, levels)) throw new IllegalArgumentException("Invalid number of nodes");
        return buildNode(inputString, levels);
    }

    private static Function<Integer, TreeNode> getNodeInt = TreeNode::new;

    private static Function<String, TreeNode> getNode = (value) -> {
        if (value.equals("null")) return null;
        return new TreeNode(Integer.parseInt(value));
    };

    static int totalNodesInLevel(int level) {
        int totalNodes = 0;
        while (level > 0) {
            totalNodes += (int) Math.pow(2, --level);
        }
        return totalNodes;
    }

    static TreeNode buildNode(String string, int levels) {
        TreeNode toRet = null;
        String[] nodes = string.split(",");
//        if(levels == 1) {
//            toRet = getNode.apply(nodes[0]);
//            return toRet;
//        }
        toRet = getNode.apply(nodes[0]);
        for (int i = 1; i < levels; i++) {
            int numberOfNodesForThisLevel = (int) Math.pow(2, i); //4
            int indexToPickFrom = totalNodesInLevel(i); //3
            for (int x = indexToPickFrom; x < indexToPickFrom + numberOfNodesForThisLevel; x++) {
                System.out.println("Going to insert " + nodes[x]);
                insertAtFirstNull(toRet, getNode.apply(nodes[x]));
            }
        }
        return toRet;
    }

    static void insertAtFirstNull(TreeNode root, TreeNode toInsert) {
        Queue<TreeNode> tn = new LinkedList<>();
        tn.add(root);

        do {
            Queue<TreeNode> tnew = new LinkedList<>();
            for (TreeNode node : tn) {
                if (node.left == null) {
                    node.left = toInsert;
                    return;
                } else if (node.right == null) {
                    node.right = toInsert;
                    return;
                } else {
                    tnew.add(node.left);
                    tnew.add(node.right);
                }
            }
            tn = tnew;
        } while (!tn.isEmpty());
    }


    static List<Integer> preorderTraversalIterative(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        ArrayList<Integer> al = new ArrayList<>();
        if (root == null) return al;
        TreeNode elmUndProcess = root;
        while (elmUndProcess != null || !s.empty()) {
            while (elmUndProcess != null) {
                al.add(elmUndProcess.val);
                s.push(elmUndProcess);
                elmUndProcess = elmUndProcess.left;
            }
            elmUndProcess = s.pop();
            elmUndProcess = elmUndProcess.right;

        }
        return al;
    }

    static List<Integer> preorderTraversalRecursive(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        } else {
            list.add(root.val);
            return preorderTraversalRecursive(root.right, preorderTraversalRecursive(root.left, list));
        }
    }

    static List<Integer> inorderTraversalIterative(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        ArrayList<Integer> al = new ArrayList<>();
        if(root == null) return al;
        TreeNode elmUndProcess = root;
        while ( elmUndProcess != null || !s.empty()){
            while (elmUndProcess != null){
                s.push(elmUndProcess);
                elmUndProcess = elmUndProcess.left;
            }
            elmUndProcess = s.pop();
            al.add(elmUndProcess.val);
            elmUndProcess = elmUndProcess.right;
        }
        return al;
    }

    static List<Integer> inorderTraversalIterativeSmart(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        ArrayList<Integer> al = new ArrayList<>();
        if (root == null) return al;
        TreeNode elmUndProcess = root;
        s.push(elmUndProcess);
        while (!s.empty() || elmUndProcess != null) {

            while (elmUndProcess != null) {
                s.push(elmUndProcess);
                elmUndProcess = elmUndProcess.left;
            }

            elmUndProcess = s.pop();
            al.add(elmUndProcess.val);
            elmUndProcess = elmUndProcess.right;

        }
        return al;
    }

    static List<Integer> inorderTraversalRecursive(TreeNode root, List<Integer> list) {

        if (root == null) {
            return list;
        } else if (root.left == null) {
            list.add(root.val);
            return list;
        } else {
            list.addAll(preorderTraversalRecursive(root.left, list));
            list.add(root.val);
            return preorderTraversalRecursive(root.right, list);
        }
    }

    static List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<>();
        TreeNode elmUndProcess = root;
        if (root == null) return al;
        Stack<TreeNode> t = new Stack<>();

        do {
            while (elmUndProcess != null) {
                if (elmUndProcess.right != null) t.push(elmUndProcess.right);
                t.push(elmUndProcess);
                elmUndProcess = elmUndProcess.left;
            }
            elmUndProcess = t.pop();
            if (elmUndProcess.right != null && !t.empty() && elmUndProcess.right == t.peek()) {
                t.pop();
                t.push(elmUndProcess);
                elmUndProcess = elmUndProcess.right;
            } else {
                al.add(elmUndProcess.val);
                elmUndProcess = null;
            }

        } while (!t.empty());
        return al;
    }

    static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> finalList = new ArrayList<>();
        Queue<TreeNode> tn = new LinkedList<>();
        List<Integer> finalListToAdd = new ArrayList<>();
        tn.add(root);
        if (root == null) return finalList;

        do {
            Queue<TreeNode> tnew = new LinkedList<>();
            for (TreeNode node : tn) {
                finalListToAdd.add(node.val);
                if (node.left != null && node.right != null) {
                    tnew.add(node.left);
                    tnew.add(node.right);
                } else if (node.left != null) tnew.add(node.left);
                else if (node.right != null) tnew.add(node.right);
            }
            finalList.addAll(Collections.singleton(finalListToAdd));
            finalListToAdd = new ArrayList<>();
            tn = tnew;
        } while (!tn.isEmpty());

        return finalList;
    }

    static int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return compareNodes(root.left, root.right);
        }
    }

    static boolean compareNodes(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val == right.val) {
            return compareNodes(left.left, right.right) && compareNodes(left.right, right.left);
        } else return false;
    }

    static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null && --sum == 0) {
            return true;
        } else if (root == null) {
            return false;
        } else {
            return hasPathSum(root.left, ++sum - root.val) || hasPathSum(root.right, ++sum - root.val);
        }
    }

    static TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0){
            return null;
        } else if(inorder.length == 1 || postorder.length == 1){
            return getNodeInt.apply(inorder[0]);
        } else{
            return treeBuilderHelperRecursive(null, inorder, postorder);
        }
    }

    static TreeNode treeBuilderHelperRecursive(TreeNode tree, int[] inorder, int[] postorder){
        if(inorder.length == 0 || postorder.length == 0){
            return tree;
        }
        TreeNode root = getNodeInt.apply(postorder[postorder.length - 1]);
        int rootPosition = postorder.length - 1;
        int rootPositionInOrder = postorder.length - 1;
        int currentNodeLeft = Integer.MIN_VALUE;
        int currentNodeRight = Integer.MIN_VALUE;
        ArrayList<Integer> leftSubtreeInOrder = new ArrayList<>();
        ArrayList<Integer> rightSubTreeInOrder = new ArrayList<>();
        ArrayList<Integer> leftSubtreePostOrder = new ArrayList<>();
        ArrayList<Integer> rightSubtreePostOrder = new ArrayList<>();



        //find root in inorder
        for (int i = 0; i < inorder.length; i++) {
            if(root.val == inorder[i]){
                rootPositionInOrder = i;
                break;
            }
        }

        for (int i = 0; i < rootPositionInOrder; i++) {
            leftSubtreeInOrder.add(inorder[i]);
        }
        for (int i = 1; i < inorder.length - rootPositionInOrder; i++) {
            rightSubTreeInOrder.add(inorder[rootPositionInOrder + i]);
        }

        for (int i = postorder.length - 1; i >= 0 ; i--) {
            if(leftSubtreeInOrder.contains(postorder[i])){
                currentNodeLeft = postorder[i];
                break;
            }
        }

        for (int i = postorder.length - 1; i >= 0 ; i--) {
            if(rightSubTreeInOrder.contains(postorder[i])){
                currentNodeRight = postorder[i];
                break;
            }
        }

        for (int i : postorder){
            if(leftSubtreeInOrder.contains(i)){
                leftSubtreePostOrder.add(i);
            }

            if(rightSubTreeInOrder.contains(i)){
                rightSubtreePostOrder.add(i);
            }
        }
        System.out.println("Iteration 1");
        if(currentNodeLeft != Integer.MIN_VALUE && currentNodeRight != Integer.MIN_VALUE){
            root.left = getNodeInt.apply(currentNodeLeft);
            root.right = getNodeInt.apply(currentNodeRight);
            treeBuilderHelperRecursive(root.left, leftSubtreeInOrder.stream().mapToInt(x -> x).toArray(),
                    leftSubtreePostOrder.stream().mapToInt(x -> x).toArray());
            treeBuilderHelperRecursive(root.right, rightSubTreeInOrder.stream().mapToInt(x -> x).toArray(),
                    rightSubtreePostOrder.stream().mapToInt(x -> x).toArray());
        }

        return root;

    }

   static String removeOuterParentheses(String S) {
        int outerCount = S.indexOf("((");
        if(outerCount < 0){
            return "";
        }
        // (()())(())

        char[] sArray = S.toCharArray();
        char[] toRet = new char[sArray.length];
        outerCount = 0;
        int findFirstIndex = 0;
        for (int i = 0; i < S.length(); i++) {
            if(sArray[i] == '('){
                if(i <= findFirstIndex){
                    findFirstIndex = i;
                    sArray[i] = ' ';
                }
                outerCount++;
            } else {
                outerCount--;
                if(outerCount > 0){
                    sArray[i + 1] = ' ';
                    i++;
                }
            }
        }


        return new String(sArray).replace(" ","");
    }

    static void printSubsets(char[] set) {
        int n = set.length;

        // Run a loop for printing all 2^n
        // subsets one by one
        for (int i = 0; i < (1 << n); i++) {
            System.out.print("{ ");
            System.out.print(i);

            // Print current subset
            for (int j = 0; j < n; j++)


                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                if ((i & (1 << j)) > 0) {
                    System.out.print(j);
                    System.out.print(set[j] + " ");
                }

            System.out.println("}");
        }
    }
}