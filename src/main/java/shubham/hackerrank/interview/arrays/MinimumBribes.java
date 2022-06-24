package shubham.hackerrank.interview.arrays;


/**
 * It is New Year's Day and people are in line for the Wonderland rollercoaster ride. Each person wears a sticker indicating their initial position in the queue from  to . Any person can bribe the person directly in front of them to swap positions, but they still wear their original sticker. One person can bribe at most two others.
 * <p>
 * Determine the minimum number of bribes that took place to get to a given queue order. Print the number of bribes, or, if anyone has bribed more than two people, print Too chaotic.
 * <p>
 * Example
 * Q = [1, 2, 3, 5, 4, 6, 7, 8]
 * <p>
 * If person 5 bribes person 4, the queue will look like this: . Only  bribe is required. Print 1.
 * <p>
 * Q = [4, 1, 2, 3]
 * Person 4 had to bribe 3 people to get to the current position. Print Too chaotic.
 * 1 2 5 3 7 8 6 4
 * 1 2 3 4 5 6 7 8
 * 1 2 5 3 4 6 7 8
 * 1 2 5 3 6 7 8 4
 * 1 2 5 3 7 8 6 4
 */

import java.util.List;

public class MinimumBribes {

    public static void minimumBribes(List<Integer> q) {
        int minSwaps = 0;

        for (int i = 0; i < q.size(); i++) {
            if ((q.get(i) - 1) - i > 2) {
                System.out.println("Too chaotic");
                return;
            }

            for (int j = Math.max(0, q.get(i) - 2);j < i; j++) {
                if (q.get(j) > q.get(i)) {
                    minSwaps++;
                }
            }
        }

        System.out.println(minSwaps);
    }
}
