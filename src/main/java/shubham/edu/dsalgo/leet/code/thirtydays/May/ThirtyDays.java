package shubham.edu.dsalgo.leet.code.thirtydays.May;

import shubham.edu.dsalgo.google.foobar.Questions;


public class ThirtyDays {
    public static void main(String[] args) {
        int[] x = {14, 27, 1, 4, 2, 50, 3, 1};
        int[] y = {2, 4, -4, 3, 1, 1, 14, 27, 50};

        System.out.println((Questions.getDiffElement(x,y)));
        System.out.println((Questions.getDiffElement(new int[]{13, 5, 6, 2, 5}, new int[]{5, 2, 5, 13})));
        System.out.println((Questions.getDiffElement(new int[]{14, 27, 1, 4, 2, 50, 3, 1}, new int[]{2, 4, -4, 3, 1, 1, 14, 27, 50})));
        System.out.println((Questions.getDiffElement(x,y)));
    }


}
