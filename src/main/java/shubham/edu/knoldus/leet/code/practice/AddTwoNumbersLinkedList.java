package shubham.edu.knoldus.leet.code.practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AddTwoNumbersLinkedList {
    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 5, 6, 4};
        List<ListNode> collect = Arrays.stream(arr).mapToObj((value) -> SolutionAddList.getNode.apply(value)).collect(Collectors.toList());
        ListNode l1 = collect.get(0);
        ListNode l2 = collect.get(1);
        ListNode l3 = collect.get(2);
        ListNode l4 = collect.get(3);
        ListNode l5 = collect.get(4);
        ListNode l6 = collect.get(5);
        l1.next = l2;
        l2.next = l3;

        l4.next = l5;
        l5.next = l6;

        System.out.println(l1);
        System.out.println(l4);
        System.out.println(SolutionAddList.addTwoNumbers(l1, l4));
    }
}

class ListNode {
    Integer val;
    ListNode next;

    ListNode(int x) {
        val = x;
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

class SolutionAddList {
    static Function<Integer, ListNode> getNode = ListNode::new;

    static Double getResult(ListNode ln) {
        ListNode itr;
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

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Double res = getResult(l1) + getResult(l2);
        return fromInt(res);
    }

    static ListNode fromInt(Double res) {
        ListNode ln = null;
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
                ListNode itr = ln;
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