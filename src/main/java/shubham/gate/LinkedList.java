package shubham.gate;

import shubham.edu.dsalgo.leet.code.practice.ListNode;

public class LinkedList {
    static ListNode<Integer> reverseListIterative(ListNode<Integer> list){
        if(list == null || list.next == null){
            return list;
        } else {
            ListNode<Integer> prev = null;
            while (list != null){
                ListNode<Integer> next = list.next;
                list.next = prev;
                prev = list;
                list = next;
            }
            return prev;
        }
    }

    static ListNode<Integer> reverseListRecursive(ListNode<Integer> list) {
        if(list == null || list.next == null){
            return list;
        } else {
            ListNode<Integer> next = list.next;
            list.next = null;
         return recNodeHelper(list, next);
        }
    }

    static ListNode<Integer> recNodeHelper(ListNode<Integer> reversed, ListNode<Integer> next) {
        if (next == null) {
            return reversed;
        } else {
            ListNode<Integer> t = next.next;
            next.next = reversed;
            return recNodeHelper(next, t);
        }
    }

    public static void main(String[] args) {
        ListNode<Integer> list = ListNode.buildRandomList(10);
        System.out.println(list);
        ListNode<Integer> res = reverseListIterative(list);
        System.out.println(res);
        System.out.println(reverseListRecursive(res));
        ListNode<Integer> t = ListNode.buildRandomList(10);
        System.out.println(t);
    }
}
