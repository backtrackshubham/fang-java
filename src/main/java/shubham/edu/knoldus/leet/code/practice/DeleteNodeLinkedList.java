package shubham.edu.knoldus.leet.code.practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DeleteNodeLinkedList {
    public static Node buildList(int value, Node head){
        if(value == 0) {
            return head;
        } else {
            Node newNode = new Node(value);
            if (head != null) {
                newNode.next = head;
            }
            head = newNode;
            return buildList(value - 1, head);
        }
    }

    public static int[] buildArray(){
        int[] toRet = new int[100];
        for (Integer i: IntStream.range(0, 100).boxed().collect(Collectors.toList())
             ) {
            toRet[i] = i;
        }
        return toRet;
    }

    public static Node getNodeRef(int value, Node head){
        while(head.value != value){
            head = head.next;
        }
        return head;
    }

    public static void deleteNode(Node ptr){
        if(ptr == null || ptr.next == null){
            return;
        }
        Node pre = null;
        while (ptr.next != null){
            ptr.value = ptr.next.value;
            pre = ptr;
            ptr = ptr.next;
        }

        pre.next = null;
    }

    public static String findPair(int[] arr, int sum){
        Map<Integer, Integer> hm = new HashMap<>();

        for (int x: arr
             ) {
            if(hm.containsKey(sum - x)){
                return "Found pair [" + x+", "+(sum - x)+"]";
            } else {
                hm.put(x, 0);
            }
        }
        System.out.println(hm);
        return "No Pair exist";
    }

   public static void generatePrintBinary(int n)
    {
        // Create an empty queue of strings
        Queue<String> q = new LinkedList<String>();

        // Enqueue the first binary number
        q.add("1");

        // This loops is like BFS of a tree with 1 as root
        // 0 as left child and 1 as right child and so on
        while(n-- > 0)
        {
            System.out.println(q);
            // print the front of queue
            String s1 = q.peek();
            q.remove();
            System.out.println(s1);

            // Store s1 before changing it
            String s2 = s1;

            // Append "0" to s1 and enqueue it
            q.add(s1 + "0");

            // Append "1" to s2 and enqueue it. Note that s2 contains
            // the previous front
            q.add(s2 + "1");
        }
    }

    public static void main(String[] args) {
        Node list = buildList(10, null);
        System.out.println(getNodeRef(5, list));
        System.out.println(list);
        deleteNode(getNodeRef(10, list));
        System.out.println(list);
//        System.out.println(Arrays.toString(buildArray()));
//        System.out.println(findPair(buildArray(), 31));
//
//
//        generatePrintBinary(16);
    }
}

class Node{
    int value;
    Node next;

    public Node(int newNode){
        this.value = newNode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node trav = this;
        while (trav != null){
            sb.append(" --> " + trav.value);
            trav = trav.next;
        }
        return sb.toString();
    }
}