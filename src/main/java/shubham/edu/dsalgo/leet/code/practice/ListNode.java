package shubham.edu.dsalgo.leet.code.practice;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Random;
import java.util.function.Supplier;

public class ListNode<T> {
    public T val;
    public ListNode<T> next;

    public ListNode(T x) {
        val = x;
    }

//    public static ListNode apply(int value, Supplier<T> supplier){
//        return new ListNode(value);
//    }

    public ListNode<T> addElementEnd(ListNode<T> node){
        ListNode<T> t = this;
        while (t.next !=  null) {
            t = t.next;
        }
        t.next = node;
        return this;
    }

    public static ListNode<Integer> buildRandomList(int numElements){
        if(numElements > 0){
            Random rand = new java.util.Random();
            ListNode<Integer> node = new ListNode<Integer>(rand.nextInt(1000));
            while (--numElements > 0){
                node.addElementEnd(new ListNode<Integer>(rand.nextInt(1000)));
            }
            return node;
        } else return null;
    }

    @Override
    public String toString() {
        StringBuilder strRep = new StringBuilder();
        ListNode<T> t = this;
        while (t != null) {
            strRep.append(t.val).append("-->");
            t = t.next;
        }

        return strRep.toString();
    }
}
