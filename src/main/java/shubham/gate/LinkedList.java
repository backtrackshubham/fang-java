package shubham.gate;

import shubham.edu.dsalgo.leet.code.practice.ListNode;

public class LinkedList {
    static ListNode reverseListIterative(ListNode list){
        if(list == null || list.next == null){
            return list;
        } else {
            ListNode prev = null;
            while (list != null){
                ListNode next = list.next;
                list.next = prev;
                prev = list;
                list = next;
            }
            return prev;
        }
    }

    static ListNode reverseListRecursive(ListNode list) {
        if(list == null || list.next == null){
            return list;
        } else {
            ListNode next = list.next;
            list.next = null;
         return recNodeHelper(list, next);
        }
    }

    static ListNode recNodeHelper(ListNode reversed, ListNode next) {
        if (next == null) {
            return reversed;
        } else {
            ListNode t = next.next;
            next.next = reversed;
            return recNodeHelper(next, t);
        }
    }

    public static void main(String[] args) {
        ListNode list = ListNode.buildRandomList(10);
        System.out.println(list);
        ListNode res = reverseListIterative(list);
        System.out.println(res);
        System.out.println(reverseListRecursive(res));
        ListNode t = ListNode.buildRandomList(10);
        System.out.println(t);
    }
}
