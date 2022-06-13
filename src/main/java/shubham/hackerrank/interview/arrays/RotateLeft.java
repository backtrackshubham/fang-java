package shubham.hackerrank.interview.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * A left rotation operation on an array shifts each of the array's elements 1 unit to the left.
 * For example, if 2 left rotations are performed on array [1,2,3,4,5],
 * then the array would become [3,4,5,1,2]. Note that the lowest index item moves to the highest index in a rotation. This is called a circular array.
 *
 * Given an array arr of n integers and a number d, perform d left rotations on the array.
 * Return the updated array to be printed as a single line of space-separated integers.
 */
public class RotateLeft {
    public static List<Integer> rotLeft(List<Integer> a, int d) {
        int elementToStart = d % a.size();

        if (elementToStart == 0) {
            return a;
        } else {
            List<Integer> li = new ArrayList<>();
            int i = 0;
            while (i < a.size()) {
                li.add(a.get((i + elementToStart) % a.size()));
                i++;
            }
            return li;
        }
    }
}