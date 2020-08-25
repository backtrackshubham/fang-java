package akshansh.google.foobar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given a square area of solar material, you have to make as many largest possible squares out of it as possible.
 * For ex. if solar material area is 12, then the answer would be [9, 1, 1, 1].
 *
 * Input: 12
 * Output: [9,1,1,1]
 */
public class NumberOfSquares {

    public static void main(String[] args) {
        int[] res = solution(15324);

        System.out.println(Arrays.toString(res));
    }

    public static int[] solution(int area) {
        // Your code here
        List<Integer> areas = new ArrayList<>();
        int currentArea = area;

        while (currentArea > 0) {
            double sqrt = Math.sqrt(currentArea);
            double sqrtFloor = Math.floor(sqrt);

            if (sqrt == sqrtFloor) {
                areas.add(currentArea);
                area -= currentArea;
                currentArea = area;
            } else {
                currentArea--;
            }
        }

        int[] result = new int[areas.size()];
        for (int i=0 ; i<result.length ; i++) {
            result[i] = areas.get(i);
        }

        return result;
    }
}
