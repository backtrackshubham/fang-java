package shubham.random;

import shubham.edu.dsalgo.leet.code.practice.ListNode;


public class MergeTwoList {
    public static void main(String[] args) {
        ListNode x = new ListNode(1)
                            .addElementEnd(new ListNode(3)
                                    .addElementEnd(new ListNode(5)
                                            .addElementEnd(new ListNode(7))));
        ListNode y = new ListNode(2)
                            .addElementEnd(new ListNode(4)
                                    .addElementEnd(new ListNode(6)
                                            .addElementEnd(new ListNode(8)
                                                    .addElementEnd(new ListNode(10)
                                                            .addElementEnd(new ListNode(12))))));
        System.out.println(mergeTwoList(x, y).toString());
        ;

    }

    static ListNode mergeTwoList(ListNode firstList, ListNode secondList) {
        ListNode nodeToRet = firstList;

        while (firstList != null && secondList != null){
            ListNode tNode = firstList.next;
            ListNode sNode = secondList.next;
            firstList.next = secondList;
            secondList.next = tNode;
            firstList = tNode;
            secondList = sNode;
        }


        if(secondList != null){
            ListNode tn = nodeToRet;
            while (tn.next != null){
                tn = tn.next;
            }
            tn.next = secondList;
        }

        return nodeToRet;
    }
}
