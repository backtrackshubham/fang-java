package shubham.random;

import shubham.edu.dsalgo.leet.code.practice.ListNode;


public class MergeTwoList {
    public static void main(String[] args) {
        ListNode<Integer> x = new ListNode<Integer>(1)
                            .addElementEnd(new ListNode<Integer>(3)
                                    .addElementEnd(new ListNode<Integer>(5)
                                            .addElementEnd(new ListNode<Integer>(7))));
        ListNode<Integer> y = new ListNode<Integer>(2)
                            .addElementEnd(new ListNode<Integer>(4)
                                    .addElementEnd(new ListNode<Integer>(6)
                                            .addElementEnd(new ListNode<Integer>(8)
                                                    .addElementEnd(new ListNode<Integer>(10)
                                                            .addElementEnd(new ListNode<Integer>(12))))));
        System.out.println(mergeTwoList(x, y).toString());
        ;

    }

    static ListNode<Integer> mergeTwoList(ListNode<Integer> firstList, ListNode<Integer> secondList) {
        ListNode<Integer> nodeToRet = firstList;

        while (firstList != null && secondList != null){
            ListNode<Integer> tNode = firstList.next;
            ListNode<Integer> sNode = secondList.next;
            firstList.next = secondList;
            secondList.next = tNode;
            firstList = tNode;
            secondList = sNode;
        }


        if(secondList != null){
            ListNode<Integer> tn = nodeToRet;
            while (tn.next != null){
                tn = tn.next;
            }
            tn.next = secondList;
        }

        return nodeToRet;
    }
}
