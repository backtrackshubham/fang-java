package shubham.edu.dsalgo.leet.code.practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AddTwoNumbersLinkedList {
    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 5, 6, 4};
        List<ListNode<Integer>> collect = Arrays.stream(arr).mapToObj((value) -> SolutionAddList.getNode.apply(value)).collect(Collectors.toList());
        ListNode<Integer> l1 = collect.get(0);
        ListNode<Integer> l2 = collect.get(1);
        ListNode<Integer> l3 = collect.get(2);
        ListNode<Integer> l4 = collect.get(3);
        ListNode<Integer> l5 = collect.get(4);
        ListNode<Integer> l6 = collect.get(5);
        l1.next = l2;
        l2.next = l3;

        l4.next = l5;
        l5.next = l6;

        l1.addElementEnd(new ListNode<>(12));
        l1.addElementEnd(new ListNode<>(13));
        l1.addElementEnd(new ListNode<>(14));
        System.out.println(l1);
        l1.reverseListRecursive();
        System.out.println(l1);
        System.out.println(l4);
        l4.reverseListRecursive();
        System.out.println(l4);
//        System.out.println(SolutionAddList.addTwoNumbers(l1, l4));

    }
}

class SolutionAddList {
    static Function<Integer, ListNode<Integer>> getNode = ListNode::new;

    static Double getResult(ListNode<Integer> ln) {
        ListNode<Integer> itr;
        Double res = 0.0;
        Integer elem = 0;
        System.out.println(ln);
        itr = ln;
        while (itr != null) {
            res += itr.val * Math.pow(10, elem);
            elem += 1;
            itr = itr.next;
        }
        return res;
    }

    static ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        Double res = getResult(l1) + getResult(l2);
        return fromInt(res);
    }

//    static ListNode<Integer> addTwoNumbersBetter(ListNode<Integer> l1, ListNode<Integer> l2) {
//        while ()
//    }

    static ListNode<Integer> fromInt(Double res) {
        ListNode<Integer> ln = null;
        Integer digits = Integer.parseInt(new StringBuffer(Double.toString(res).replace(".0", "")).toString());
        int digitsCount = Integer.toString(digits).length();
        Integer toInt;
        while (digitsCount > 0) {
            toInt = digits % 10;
            digits = digits / 10;
            if (ln == null) {
                ln = getNode.apply(toInt);
            } else if (ln.next == null) {
                ln.next = getNode.apply(toInt);
            } else {
                ListNode<Integer> itr = ln;
                while (itr.next != null) {
                    itr = itr.next;
                }
                itr.next = getNode.apply(toInt);
            }

            digitsCount--;
        }

        return ln;
    }
}