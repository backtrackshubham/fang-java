package akshansh.google.foobar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The Grandest Staircase Of Them All
 * ==================================
 *
 * With her LAMBCHOP doomsday device finished, Commander Lambda is preparing for her debut on the galactic stage - but in order to make a grand entrance, she needs a grand staircase! As her personal assistant, you've been tasked with figuring out how to build the best staircase EVER.
 *
 * Lambda has given you an overview of the types of bricks available, plus a budget. You can buy different amounts of the different types of bricks (for example, 3 little pink bricks, or 5 blue lace bricks). Commander Lambda wants to know how many different types of staircases can be built with each amount of bricks, so she can pick the one with the most options.
 *
 * Each type of staircase should consist of 2 or more steps.  No two steps are allowed to be at the same height - each step must be lower than the previous one. All steps must contain at least one brick. A step's height is classified as the total amount of bricks that make up that step.
 * For example, when N = 3, you have only 1 choice of how to build the staircase, with the first step having a height of 2 and the second step having a height of 1: (# indicates a brick)
 *
 * #
 * ##
 * 21
 *
 * When N = 4, you still only have 1 staircase choice:
 *
 * #
 * #
 * ##
 * 31
 *
 * But when N = 5, there are two ways you can build a staircase from the given bricks. The two staircases can have heights (4, 1) or (3, 2), as shown below:
 *
 * #
 * #
 * #
 * ##
 * 41
 *
 * #
 * ##
 * ##
 * 32
 *
 * Write a function called solution(n) that takes a positive integer n and returns the number of different staircases that can be built from exactly n bricks. n will always be at least 3 (so you can have a staircase at all), but no more than 200, because Commander Lambda's not made of money!
 *
 * Languages
 * =========
 *
 * To provide a Java solution, edit Solution.java
 * To provide a Python solution, edit solution.py
 *
 * Test cases
 * ==========
 * Your code should pass the following test cases.
 * Note that it may also be run against hidden test cases not shown here.
 *
 * -- Java cases --
 * Input:
 * Solution.solution(3)
 * Output:
 *     1
 *
 * Input:
 * Solution.solution(200)
 * Output:
 *     487067745
 *
 * -- Python cases --
 * Input:
 * solution.solution(200)
 * Output:
 *     487067745
 *
 * Input:
 * solution.solution(3)
 * Output:
 *     1
 */
public class TheGrandestStaircaseOfThemAll {

    public static void main(String[] args) {
        System.out.println(solution(200));
    }

    public static int solutionNotOptimized(int n) {
        List<List<Integer>> results = getTwoSols(n);

        Map<Integer, List<List<Integer>>> numToTwoSols = new HashMap<>();

        Set<List<Integer>> resulsStrSet = new HashSet<>();

        for (int i=0 ; i<results.size() ; i++) {
            List<Integer> sols = new ArrayList<>(results.get(i));
            Integer removedInt = sols.remove(sols.size() - 1);
            List<List<Integer>> twoSolsOfLastDigit = numToTwoSols.get(removedInt);

            if (twoSolsOfLastDigit == null) {
                twoSolsOfLastDigit = getTwoSols(removedInt);
                numToTwoSols.put(removedInt, twoSolsOfLastDigit);
            }

            long start = System.currentTimeMillis();
            for (int j=0 ; j<twoSolsOfLastDigit.size() ; j++) {
                List<Integer> currTwoSols = twoSolsOfLastDigit.get(j);
                List<Integer> currSols = new ArrayList<>(sols);
                if (Collections.disjoint(currSols, currTwoSols)) {
                    currSols.addAll(currTwoSols);
                    currSols.sort(Integer::compareTo);

                    if (!resulsStrSet.contains(currSols)) {
                        results.add(currSols);
                        resulsStrSet.add(currSols);
                    }
                }
            }
            long end = System.currentTimeMillis() - start;
            if (end > 10) {
                System.out.println(end);
            }
        }

        return results.size();
    }

    public static List<List<Integer>> getTwoSols(int n) {
        List<List<Integer>> results = new ArrayList<>();

        for (int i=1 ; i<Math.ceil((double)n/2) ; i++) {
            results.add(Arrays.asList(i, n-i));
        }

        return results;
    }

    public static int solution(int n) {

        if (n < 3) {
            return 0;
        }

        int totalCoefficients = 3;
        for (int i=3 ; i<=n ; i++) {
            totalCoefficients += i;
        }

        int[] coefficients = new int[totalCoefficients+1];

        Set<Integer> eles = new HashSet<>();
        eles.add(0);
        eles.add(1);
        eles.add(2);
        eles.add(3);

        coefficients[0] = 1;
        coefficients[1] = 1;
        coefficients[2] = 1;
        coefficients[3] = 1;

        for (int i=3 ; i<=n ; i++) {
            Set<Integer> temp = new HashSet<>();
            int[] tempCoeff = Arrays.copyOf(coefficients, coefficients.length);
            for (Integer currEle : eles) {
                int afterAdding = currEle + i;
                int coefficient = tempCoeff[currEle];

                coefficients[afterAdding]+=coefficient;
                temp.add(afterAdding);
            }

            eles.addAll(temp);
        }

        return coefficients[n] - 1;
    }
}
