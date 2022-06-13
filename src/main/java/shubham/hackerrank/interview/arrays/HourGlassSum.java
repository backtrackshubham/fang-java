package shubham.hackerrank.interview.arrays;

import java.util.List;

/**
 * Given a 6 x 6 2D Array, A:
 *
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * An hourglass in A is a subset of values with indices falling in this pattern in A's graphical representation:
 *
 * a b c
 *   d
 * e f g
 * There are 16 hourglasses in A. An hourglass sum is the sum of an hourglass' values.
 * Calculate the hourglass sum for every hourglass in A, then print the maximum hourglass sum. The array will always be .
 */
public class HourGlassSum {
    public static int hourglassSum(List<List<Integer>> arr) {
        int sum = -999999999;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).size(); j ++) {
                if(j < arr.get(i).size() - 1 && i < arr.size() - 1 && i > 0 && j > 0){
                    int newSum = (arr.get(i).get(j) +
                            arr.get(i - 1).get(j) +
                            arr.get(i + 1).get(j) +
                            arr.get(i + 1).get(j - 1) +
                            arr.get(i + 1).get(j + 1) +
                            arr.get(i - 1).get(j + 1) +
                            arr.get(i - 1).get(j - 1));
                    if(newSum > sum) sum = newSum;
                }
            }
        }
        return sum;
    }

//    public static boolean validCoordinate(int i, int j, int rows, int cols) {
//        return j < cols - 1 && i < rows - 1 && i > 0 && j > 0;
//     }

//    public static int hourglassSum(int[][] arr) {
//
//    }
}
