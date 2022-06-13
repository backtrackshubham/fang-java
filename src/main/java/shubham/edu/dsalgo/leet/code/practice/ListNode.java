package shubham.edu.dsalgo.leet.code.practice;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Random;
import java.util.function.Supplier;

public class ListNode<T> {

    class RevHelper {
        public T value;
        public ListNode<T> rev;

        public RevHelper(T value, ListNode<T> rev) {
            this.value = value;
            this.rev = rev;
        }
    }
    public T val;
    public ListNode<T> next;

    private int length = 0;

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
        length++;
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

    //1 --> 2 --> 3
    public void reverseListRecursive() {
        if(this.next == null){

        } else if (this.next.next == null) {
            T valNextNode = this.next.val;
            this.next.val = this.val;
            this.val = valNextNode;
        } else {
            ListNode<T> nodeToStart = this.next;
            RevHelper rev = recNodeHelper(null, nodeToStart, this.val);
            this.val = rev.value;
            this.next = rev.rev;
        }
    }

    private RevHelper recNodeHelper(ListNode<T> reversed, ListNode<T> next, T nodeValue) {
        if (next == null) {
            return new RevHelper(nodeValue, reversed);
        } else {
            if(next.next == null){
                T t2 = next.val;
                next.val = nodeValue;
                ListNode<T> t = next.next;
                next.next = reversed;
                return recNodeHelper(next, t, t2);
            } else {
                ListNode<T> t = next.next;
                next.next = reversed;
                return recNodeHelper(next, t, nodeValue);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder strRep = new StringBuilder();
        ListNode<T> t = this;
        while (t != null) {
//            System.out.println(t.val);
            strRep.append(t.val).append("-->");
            t = t.next;
        }

        return strRep.toString();
    }
}
