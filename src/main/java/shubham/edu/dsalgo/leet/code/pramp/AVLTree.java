package shubham.edu.dsalgo.leet.code.pramp;


import java.util.*;

class Tree<T> {
    T value;
    Tree<T> left;
    Tree<T> right;
    int hl = 0;
    int hr = 0;

    Tree(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{ value :" + this.value + "}";
    }
}

public class AVLTree {
    public static void main(String[] args) {
//        List<Integer> li = IntStream.range(0, 3).boxed().collect(Collectors.toList());
//        Tree<Integer> tn = AVLTreeHelper.insertElements(li);
//
//        System.out.println(AVLTreeHelper.inorderTraversalIterative(tn));



        int [][] x = new int[2][3];


        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(x[i][j]);
            }
        }
    }
}

class AVLTreeHelper {

    static List<Integer> inorderTraversalIterative(Tree<Integer> root) {
//        System.out.println(root.value+";;;;;;;;;;;;");
        Stack<Tree<Integer>> s = new Stack<>();
        ArrayList<Integer> al = new ArrayList<>();
        if (root == null) return al;
        Tree<Integer> elmUndProcess = root;
        while (elmUndProcess != null || !s.empty()) {
            while (elmUndProcess != null) {
                s.push(elmUndProcess);
                elmUndProcess = elmUndProcess.left;
            }
            elmUndProcess = s.pop();
            al.add(elmUndProcess.value);
            elmUndProcess = elmUndProcess.right;
        }
        return al;
    }

    static Tree<Integer> insertElements(List<Integer> elements) {
        Tree<Integer> root = null;
        for (Integer e : elements) {
            if (root == null) {
                root = new Tree<>(e);
            } else {
                insert(root, e);

            }
        }

        return root;
    }

    static void insert(Tree<Integer> node, Integer element) {
        Tree<Integer> root = node;
//        System.out.println(root);
        Tree<Integer> parent = null;
        Tree<Integer> unbalancedNode = null;
        while (root != null) {
            parent = root;
            if (element > root.value) {
                root.hr += 1;
                if (Math.abs(root.hr - root.hl) > 1) unbalancedNode = root;
                root = root.right;
            } else {
                root.hl += 1;
                if (Math.abs(root.hr - root.hl) > 1) unbalancedNode = root;
                root = root.left;
            }
        }

        if (parent != null) {
            if (element > parent.value) {
                parent.hr += 1;
                parent.right = new Tree<Integer>(element);
            } else {
                parent.hl += 1;
                parent.left = new Tree<Integer>(element);
            }
        }

        if (unbalancedNode != null) {
            balanceNode(unbalancedNode);
        }
    }

    /**
     * LL,LR,RR,RL
     * <p>
     * case 1:        3
     * /
     * 2
     * /
     * 1
     * For efficient use we new to swap values for ub -> l with ub
     * <p>
     * <p>
     * case 2:        3
     * /
     * 1
     * \
     * 2
     * <p>
     * <p>
     * <p>
     * case 3:        1
     * \
     * 2
     * \
     * 3
     * <p>
     * <p>
     * case 4:        1
     * \
     * 3
     * /
     * 2
     */
    static void balanceNode(Tree<Integer> unbalancedTree) {

        System.out.println("Before balancing " + inorderTraversalIterative(unbalancedTree));

        if (unbalancedTree.left != null && unbalancedTree.left.left != null) {
            System.out.println("Came in 1");
            System.out.println(unbalancedTree.value);
            System.out.println(unbalancedTree.left.value);
            System.out.println(unbalancedTree.left.left.value);
            unbalancedTree.left.value = unbalancedTree.left.value + unbalancedTree.value;
            unbalancedTree.value = unbalancedTree.left.value - unbalancedTree.value;
            unbalancedTree.left.value = unbalancedTree.left.value - unbalancedTree.value;
            unbalancedTree.right = unbalancedTree.left;
            unbalancedTree.left = unbalancedTree.left.left;
            unbalancedTree.right.left = null;

            System.out.println(unbalancedTree.value);
            System.out.println(unbalancedTree.left.value);
            System.out.println(unbalancedTree.right.value);

            unbalancedTree.right.hl = 0;
            unbalancedTree.right.hr = 0;
            unbalancedTree.left.hl = 0;
            unbalancedTree.left.hr = 0;
//            unbalancedTree.hl -= 1;
            unbalancedTree.hr += 1;
        } else if (unbalancedTree.left != null && unbalancedTree.left.right != null) {
            System.out.println("Came in 2");
            unbalancedTree.left.value = unbalancedTree.left.value + unbalancedTree.left.right.value;
            unbalancedTree.left.right.value = unbalancedTree.left.value - unbalancedTree.left.right.value;
            unbalancedTree.left.value = unbalancedTree.left.value - unbalancedTree.left.right.value;
            unbalancedTree.left.left = unbalancedTree.left.right;
            unbalancedTree.left.right = null;
            unbalancedTree.right.hl = 0;
            unbalancedTree.right.hr = 0;
            unbalancedTree.left.hl = 0;
            unbalancedTree.left.hr = 0;
//            unbalancedTree.hl -= 1;
            unbalancedTree.hr += 1;
        } else if (unbalancedTree.right != null && unbalancedTree.right.right != null) {
            System.out.println("Came in 3");

            System.out.println(unbalancedTree.value);
            System.out.println(unbalancedTree.right.value);
            System.out.println(unbalancedTree.right.right.value);

            unbalancedTree.right.value = unbalancedTree.right.value + unbalancedTree.value;
            unbalancedTree.value = unbalancedTree.right.value - unbalancedTree.value;
            unbalancedTree.right.value = unbalancedTree.right.value - unbalancedTree.value;
            unbalancedTree.left = unbalancedTree.right;
            unbalancedTree.right = unbalancedTree.right.right;
            unbalancedTree.left.right = null;

            System.out.println(unbalancedTree.left.value);
            System.out.println(unbalancedTree.value);
            System.out.println(unbalancedTree.right.value);

            unbalancedTree.right.hl = 0;
            unbalancedTree.right.hr = 0;
            unbalancedTree.left.hl = 0;
            unbalancedTree.left.hr = 0;
            unbalancedTree.hl += 1;
            System.out.println("Came in 3");
//            unbalancedTree.hr -= 1;
        } else if (unbalancedTree.right != null && unbalancedTree.right.left != null) {
            System.out.println("Came in 4");
            unbalancedTree.right.value = unbalancedTree.right.value + unbalancedTree.right.left.value;
            unbalancedTree.right.left.value = unbalancedTree.right.value - unbalancedTree.right.left.value;
            unbalancedTree.right.value = unbalancedTree.right.value - unbalancedTree.right.left.value;
            unbalancedTree.right.right = unbalancedTree.right.left;
            unbalancedTree.right.left = null;
            unbalancedTree.right.hl = 0;
            unbalancedTree.right.hr = 0;
            unbalancedTree.left.hl = 0;
            unbalancedTree.left.hr = 0;
            unbalancedTree.hl += 1;
//            unbalancedTree.hr -= 1;
        }
        System.out.println("after balancing " + inorderTraversalIterative(unbalancedTree));
    }

    int[] test(int[] nums, int[] index) {
        ArrayList<Integer> al = new ArrayList();


        for (int i = 0; i < nums.length; i++) {
            if (index[i] == al.size()) {
                al.add(nums[i]);
            } else {
                al.add(index[i], nums[i]);
            }
        }
        int[] a = new int[nums.length];
        int i = 0;

        ListIterator<Integer> li = al.listIterator();

        while (li.hasNext()) {
            a[i++] = li.next();
        }

        StringBuffer s = new StringBuffer();
        String sb = "" + 'a' + 'b';

        return a;
    }


    String freqAlphabets(String s) {
        int i = 0;
        int j = 0;
        StringBuffer sb = new StringBuffer();

        char[] arr = s.toCharArray();

        while (j < s.length()) {
            System.out.println(sb);
            while (j < s.length() && arr[j] != '#') {
                j++;
            }

            if (j < s.length() && arr[j] == '#') {
                if (j - i > 2) {
                    int x = j - 2;
                    while (i < x) {
                        char a = (char) (arr[i] + 48);
                        sb.append(a);
                        i++;
                    }
                }
                char a = (char) (Integer.parseInt("" + arr[i] + arr[i + 1]) + 96);
                sb.append(a);
            } else {
                while (i < j) {
                    char a = (char) (arr[i] + 48);
                    sb.append(a);
                    i++;
                }
            }

            j++;
            i = j;
        }

        return sb.toString();
    }

    static int oddCells(int n, int m, int[][] indices) {
        int[][] initial = new int[n][m];

        Map<String, Integer> str = new HashMap<>();

        //each of the indices can mutate n + m - 1
        for (int[] x : indices){
            int row = x[0];
            int col = x[1];
            for (int i = 0; i < m; i++) {
                String itIn = row +"-"+ i;
                if(i != col){
                    if(str.containsKey(itIn)){
                        str.remove(itIn);
                    } else{
                        str.put(itIn,0);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                String itIn = i +"-"+ col;
                if(i != row){
                    if(str.containsKey(itIn)){
                        str.remove(itIn);
                    } else{
                        str.put(itIn, 0);
                    }
                }
            }
            System.out.println(str);
        }
        return str.size();

    }
}