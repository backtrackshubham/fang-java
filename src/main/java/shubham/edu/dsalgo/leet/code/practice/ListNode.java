package shubham.edu.dsalgo.leet.code.practice;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Random;

public class ListNode {
    public Integer val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode apply(int value){
        return new ListNode(value);
    }

    public ListNode addElementEnd(ListNode node){
        ListNode t = this;
        while (t.next !=  null) {
            t = t.next;
        }
        t.next = node;
        return this;
    }

    public static ListNode buildRandomList(int numElements){
        if(numElements > 0){
            Random rand = new java.util.Random();
            ListNode node = new ListNode(rand.nextInt(1000));
            while (--numElements > 0){
                node.addElementEnd(new ListNode(rand.nextInt(1000)));
            }
            return node;
        } else return null;
    }

    @Override
    public String toString() {
        StringBuilder strRep = new StringBuilder();
        ListNode t = this;
        while (t != null) {
            strRep.append(t.val).append("-->");
            t = t.next;
        }

        return strRep.toString();
    }
}
