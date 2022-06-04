package shubham.edu.dsalgo.leet.code.practice;

import java.util.*;
import java.util.function.Function;

public class Traversals {
    public static void main(String[] args) {
        TreeViews treeViews = new TreeViews<Integer>();

        TreeNode<Integer> t = TraversalHelper.parseAndBuildNodeBetter("3,5,1,6,2,0,8,null,null,7,4,null,null,null,null");
        TreeNode<Integer> t2 = TraversalHelper.parseAndBuildNodeBetter("3,5,1,6,2,0,8,null,null,7,4,null,null,null,null");
        TreeNode<Integer> t3 = TraversalHelper.parseAndBuildNodeBetter("3,5,7,4,null,null,9");
        TreeNode<Integer> t4 = TraversalHelper.parseAndBuildNodeBetter("3,5,7,4");
        t.printTree();
//        t2.printTree();
//        t3.printTree();
//        t4.printTree();

        t.toHeap((o1, o2) -> {
            if (o1.intValue() == o2.intValue()) {
                return 0;
            } else if (o1 > o2) {
                return 1;
            } else {
                return -1;
            }
        });
        t.printTree();
//        System.out.println("Preorder  " + TraversalHelper.preorderTraversalIterative(t));
//        System.out.println("Preorder  " + TraversalHelper.preorderTraversalRecursive(t, new ArrayList<>()));
//        System.out.println("Inorder   " + TraversalHelper.inorderTraversalIterative(t));
//        System.out.println("Inorder " + TraversalHelper.inorderTraversalRecursive(t, new ArrayList<>()));
//        System.out.println("Postorder " + TraversalHelper.postorderTraversal(t));
//        int[] inorder = {9,3,15,20,7};
//        int[] postOrder = {9,15,7,20,3};
//
//        TraversalHelper.buildTree(inorder, postOrder);
//
//        TreeNode test = TreeNode.buildTree(16);
//        System.out.println(test);
//        System.out.println("---------------------------");
//        System.out.println(t);
//        System.out.println("Preorder  " + TraversalHelper.preorderTraversalRecursive(test, new ArrayList<>()));;
//        System.out.println("Inorder   " + TraversalHelper.inorderTraversalIterative(test));
//        System.out.println("Postorder " + TraversalHelper.postorderTraversal(test));
//
//        System.out.println("---------------------------");
//        System.out.println(t);
//        System.out.println("Preorder  " + TraversalHelper.preorderTraversalRecursive(t, new ArrayList<>()));;
//        System.out.println("Inorder   " + TraversalHelper.inorderTraversalIterative(t));
//        System.out.println("Postorder " + TraversalHelper.postorderTraversal(t));
//
//        System.out.println("Tree left view "+treeViews.printView(t, true));
//        System.out.println("Tree right view "+treeViews.printView(t, false));
//
//        System.out.println("Tree left view "+treeViews.printView(test, true));
//        System.out.println("Tree right view "+treeViews.printView(test, false));
//
//
//        System.out.println("Tree height view "+ t.getHeight());
//        System.out.println("Tree height view "+t.getHeight());
//        t.printTree();
////        t.printTree(test);
//        System.out.println("==================================================");
//        test.printTree();
//        TreeNode<Integer> integerTreeNode = TraversalHelper.buildSkewed(2, true);
//        TreeNode<Integer> integerTreeNode1 = TraversalHelper.buildSkewed(3, false);
//        integerTreeNode.printTree();
//        integerTreeNode.printTree();
//        System.out.println(integerTreeNode.getHeight());
//        System.out.println(integerTreeNode1.getHeight());
//
//
//        System.out.println("Preorder   " + TraversalHelper.preorderTraversalIterative(integerTreeNode1));
//        System.out.println("Inorder   " + TraversalHelper.inorderTraversalIterative(integerTreeNode1));
//        System.out.println("Postorder " + TraversalHelper.postorderTraversal(integerTreeNode1));
//
//
//
//        System.out.println("Tree height view "+ test.getHeight());
//        System.out.println("Tree height view "+test.getHeight());
    }
}

class TraversalHelper {
    private static final Function<Integer, TreeNode<Integer>> getNodeInt = TreeNode::new;
    private static final Function<String, TreeNode<Integer>> getNode = (value) -> {
        if (value.equals("null")) return null;
        return new TreeNode<Integer>(Integer.parseInt(value));
    };

    /**
     * A string should be separated by , in BFS format including nulls
     *
     * @param inputString
     * @return
     */

    static TreeNode<Integer> parseAndBuildNode(String inputString) {
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

    static TreeNode<Integer> parseAndBuildNodeBetter(String inputString) {
        String[] split = inputString.split(",");
        int length = split.length;
        int i = 0;
        if (split[i].contains("null")) {
            return null;
        }
        TreeNode<Integer>[] treeArray = new TreeNode[length];

        TreeNode<Integer> toRet = new TreeNode<>(Integer.parseInt(split[i]));
        treeArray[i] = toRet;
        while (i < length) {
            if (!split[i].contains("null")) {
                int leftIndex = 2 * i + 1;
                int rightIndex = 2 * i + 2;
                if (leftIndex < length) {
                    if (!split[leftIndex].contains("null")) {

                        TreeNode<Integer> integerTreeNodeLeft = new TreeNode<>(Integer.parseInt(split[leftIndex]));
                        treeArray[i].left = integerTreeNodeLeft;
                        treeArray[leftIndex] = integerTreeNodeLeft;
                    } else {
                        treeArray[leftIndex] = null;
                    }
                }
                if (rightIndex < length) {
                    if (!split[rightIndex].contains("null")) {
                        TreeNode<Integer> integerTreeNodeRight = new TreeNode<>(Integer.parseInt(split[rightIndex]));
                        treeArray[i].right = integerTreeNodeRight;
                        treeArray[rightIndex] = integerTreeNodeRight;
                    } else {
                        treeArray[rightIndex] = null;
                    }
                }
            }
            i++;
        }
        System.out.println(inputString);
        System.out.println(split.length);
        System.out.println(treeArray.length);
        System.out.println(Arrays.asList(treeArray));
//
//        while(i <= length){
//            int leftIndex = 2 * i + 1;
//            int rightIndex = 2 * i + 2;
//
//            if(leftIndex < length){
//
//            }
//
//            if(rightIndex < length){
//
//            }
//        }
//
        return toRet;
    }

    static TreeNode<Integer> buildSkewed(int num, boolean isLeft) {
        TreeNode<Integer> tree = null;

        while (num > 0) {
            if (tree == null) {
                tree = new TreeNode<>(num--);
            } else {
                TreeNode tmp = new TreeNode<>(num--);
                if (isLeft) {
                    tmp.left = tree;
                } else {
                    tmp.right = tree;
                }
                tree = tmp;
            }
        }
        return tree;

    }

    static int totalNodesInLevel(int level) {
        int totalNodes = 0;
        while (level > 0) {
            totalNodes += (int) Math.pow(2, --level);
        }
        return totalNodes;
    }


    static TreeNode<Integer> buildNode(String string, int levels) {
        TreeNode<Integer> toRet = null;
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
//                System.out.println("Going to insert " + nodes[x]);
                insertAtFirstNull(toRet, getNode.apply(nodes[x]));
            }
        }
        return toRet;
    }

    static void insertAtFirstNull(TreeNode<Integer> root, TreeNode<Integer> toInsert) {
        Queue<TreeNode<Integer>> tn = new LinkedList<>();
        tn.add(root);

        do {
            Queue<TreeNode<Integer>> tnew = new LinkedList<>();
            for (TreeNode<Integer> node : tn) {
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


    static List<Integer> preorderTraversalIterative(TreeNode<Integer> root) {
        Stack<TreeNode<Integer>> s = new Stack<>();
        ArrayList<Integer> al = new ArrayList<>();
        if (root == null) return al;
        TreeNode<Integer> elmUndProcess = root;
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

    static List<Integer> preorderTraversalRecursive(TreeNode<Integer> root, List<Integer> list) {
        if (root == null) {
            return list;
        } else {
            list.add(root.val);
            return preorderTraversalRecursive(root.right, preorderTraversalRecursive(root.left, list));
        }
    }

    static List<Integer> inorderTraversalIterative(TreeNode<Integer> root) {
        Stack<TreeNode<Integer>> s = new Stack<>();
        ArrayList<Integer> al = new ArrayList<>();
        if (root == null) return al;
        TreeNode<Integer> elmUndProcess = root;
        while (elmUndProcess != null || !s.empty()) {
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

    static List<Integer> inorderTraversalIterativeSmart(TreeNode<Integer> root) {
        Stack<TreeNode<Integer>> s = new Stack<>();
        ArrayList<Integer> al = new ArrayList<>();
        if (root == null) return al;
        TreeNode<Integer> elmUndProcess = root;
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

    static List<Integer> inorderTraversalRecursive(TreeNode<Integer> root, List<Integer> list) {

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

    static List<Integer> postorderTraversal(TreeNode<Integer> root) {
        ArrayList<Integer> al = new ArrayList<>();
        TreeNode<Integer> elmUndProcess = root;
        if (root == null) return al;
        Stack<TreeNode<Integer>> t = new Stack<>();

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

    static List<List<Integer>> levelOrder(TreeNode<Integer> root) {
        List<List<Integer>> finalList = new ArrayList<>();
        Queue<TreeNode<Integer>> tn = new LinkedList<>();
        List<Integer> finalListToAdd = new ArrayList<>();
        tn.add(root);
        if (root == null) return finalList;

        do {
            Queue<TreeNode<Integer>> tnew = new LinkedList<>();
            for (TreeNode<Integer> node : tn) {
                finalListToAdd.add(node.val);
                if (node.left != null && node.right != null) {
                    tnew.add(node.left);
                    tnew.add(node.right);
                } else if (node.left != null) tnew.add(node.left);
                else if (node.right != null) tnew.add(node.right);
            }
            finalList.add(finalListToAdd);
            finalListToAdd = new ArrayList<>();
            tn = tnew;
        } while (!tn.isEmpty());

        return finalList;
    }

    static int maxDepth(TreeNode<Integer> root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    static boolean isSymmetric(TreeNode<Integer> root) {
        if (root == null) {
            return true;
        } else {
            return compareNodes(root.left, root.right);
        }
    }

    static boolean compareNodes(TreeNode<Integer> left, TreeNode<Integer> right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val == right.val) {
            return compareNodes(left.left, right.right) && compareNodes(left.right, right.left);
        } else return false;
    }

    static boolean hasPathSum(TreeNode<Integer> root, int sum) {
        if (root == null && --sum == 0) {
            return true;
        } else if (root == null) {
            return false;
        } else {
            return hasPathSum(root.left, ++sum - root.val) || hasPathSum(root.right, ++sum - root.val);
        }
    }

    static TreeNode<Integer> buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        } else if (inorder.length == 1 || postorder.length == 1) {
            return getNodeInt.apply(inorder[0]);
        } else {
            return treeBuilderHelperRecursive(null, inorder, postorder);
        }
    }

    static TreeNode<Integer> treeBuilderHelperRecursive(TreeNode<Integer> tree, int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return tree;
        }
        TreeNode<Integer> root = getNodeInt.apply(postorder[postorder.length - 1]);
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
            if (root.val == inorder[i]) {
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

        for (int i = postorder.length - 1; i >= 0; i--) {
            if (leftSubtreeInOrder.contains(postorder[i])) {
                currentNodeLeft = postorder[i];
                break;
            }
        }

        for (int i = postorder.length - 1; i >= 0; i--) {
            if (rightSubTreeInOrder.contains(postorder[i])) {
                currentNodeRight = postorder[i];
                break;
            }
        }

        for (int i : postorder) {
            if (leftSubtreeInOrder.contains(i)) {
                leftSubtreePostOrder.add(i);
            }

            if (rightSubTreeInOrder.contains(i)) {
                rightSubtreePostOrder.add(i);
            }
        }
        System.out.println("Iteration 1");
        if (currentNodeLeft != Integer.MIN_VALUE && currentNodeRight != Integer.MIN_VALUE) {
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
        if (outerCount < 0) {
            return "";
        }
        // (()())(())

        char[] sArray = S.toCharArray();
        char[] toRet = new char[sArray.length];
        outerCount = 0;
        int findFirstIndex = 0;
        for (int i = 0; i < S.length(); i++) {
            if (sArray[i] == '(') {
                if (i <= findFirstIndex) {
                    findFirstIndex = i;
                    sArray[i] = ' ';
                }
                outerCount++;
            } else {
                outerCount--;
                if (outerCount > 0) {
                    sArray[i + 1] = ' ';
                    i++;
                }
            }
        }


        return new String(sArray).replace(" ", "");
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
