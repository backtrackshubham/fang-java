package akshansh.google.foobar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Please Pass the Coded Messages
 * ==============================
 *
 * You need to pass a message to the bunny prisoners, but to avoid detection, the code you agreed to use is... obscure,
 * to say the least. The bunnies are given food on standard-issue prison plates that are stamped with the numbers 0-9
 * for easier sorting, and you need to combine sets of plates to create the numbers in the code. The signal that a
 * number is part of the code is that it is divisible by 3. You can do smaller numbers like 15 and 45 easily, but
 * bigger numbers like 144 and 414 are a little trickier. Write a program to help yourself quickly create large numbers
 * for use in the code, given a limited number of plates to work with.
 *
 * You have L, a list containing some digits (0 to 9). Write a function solution(L) which finds the largest number that
 * can be made from some or all of these digits and is divisible by 3. If it is not possible to make such a number,
 * return 0 as the solution. L will contain anywhere from 1 to 9 digits. The same digit may appear multiple times
 * in the list, but each element in the list may only be used once.
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
 * Solution.solution({3, 1, 4, 1})
 * Output:
 *     4311
 *
 * Input:
 * Solution.solution({3, 1, 4, 1, 5, 9})
 * Output:
 *     94311
 *
 * -- Python cases --
 * Input:
 * solution.solution([3, 1, 4, 1])
 * Output:
 *     4311
 *
 * Input:
 * solution.solution([3, 1, 4, 1, 5, 9])
 * Output:
 *     94311
 */
public class PleasePassTheCodedMessages {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2}));
    }

    public static int solution(int[] l) {
        List<Integer> nonDivByThree = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i=0 ; i<l.length ; i++) {
            if (l[i] % 3 != 0) {
                nonDivByThree.add(l[i]);
            } else {
                result.add(l[i]);
            }
        }

        Map<Integer, List<Integer>> remToEles = new HashMap<>();

        for (int i=0 ; i<nonDivByThree.size() ; i++) {
            int rem = nonDivByThree.get(i) % 3;
            List<Integer> eles = remToEles.get(rem);

            if (eles == null) {
                eles = new ArrayList<>();
            }

            eles.add(nonDivByThree.get(i));
            remToEles.put(rem, eles);
        }

        for (Map.Entry<Integer, List<Integer>> entry : remToEles.entrySet()) {
            Integer rem = entry.getKey();
            List<Integer> eles = entry.getValue();

            eles.sort(Collections.reverseOrder());

            while (eles.size() >= 3) {
                result.add(eles.remove(0));
                result.add(eles.remove(0));
                result.add(eles.remove(0));
            }

            remToEles.put(rem, eles);
        }

        List<Integer> oneRem = remToEles.get(1);
        List<Integer> twoRem = remToEles.get(2);

        while (oneRem != null && !oneRem.isEmpty() && twoRem != null && !twoRem.isEmpty()) {
            result.add(oneRem.remove(0));
            result.add(twoRem.remove(0));
        }

        result.sort(Collections.reverseOrder());

        return result.isEmpty() ? 0 : Integer.parseInt(result.stream().map(Object::toString).collect(Collectors.joining()));
    }
}
