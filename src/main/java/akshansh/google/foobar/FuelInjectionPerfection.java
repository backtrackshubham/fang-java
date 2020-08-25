package akshansh.google.foobar;

/**
 * Fuel Injection Perfection
 * =========================
 *
 * Commander Lambda has asked for your help to refine the automatic quantum antimatter fuel injection system for her
 * LAMBCHOP doomsday device. It's a great chance for you to get a closer look at the LAMBCHOP - and maybe sneak in a
 * bit of sabotage while you're at it - so you took the job gladly.
 *
 * Quantum antimatter fuel comes in small pellets, which is convenient since the many moving parts of the LAMBCHOP
 * each need to be fed fuel one pellet at a time. However, minions dump pellets in bulk into the fuel intake. You
 * need to figure out the most efficient way to sort and shift the pellets down to a single pellet at a time.
 *
 * The fuel control mechanisms have three operations:
 *
 * 1) Add one fuel pellet
 * 2) Remove one fuel pellet
 * 3) Divide the entire group of fuel pellets by 2 (due to the destructive energy released when a quantum antimatter
 * pellet is cut in half, the safety controls will only allow this to happen if there is an even number of pellets)
 *
 * Write a function called solution(n) which takes a positive integer as a string and returns the minimum number of
 * operations needed to transform the number of pellets to 1. The fuel intake control panel can only display a number
 * up to 309 digits long, so there won't ever be more pellets than you can express in that many digits.
 *
 * For example:
 * solution(4) returns 2: 4 -> 2 -> 1
 * solution(15) returns 5: 15 -> 16 -> 8 -> 4 -> 2 -> 1
 *
 * Languages
 * =========
 *
 * To provide a Python solution, edit solution.py
 * To provide a Java solution, edit Solution.java
 *
 * Test cases
 * ==========
 * Your code should pass the following test cases.
 * Note that it may also be run against hidden test cases not shown here.
 *
 * -- Python cases --
 * Input:
 * solution.solution('15')
 * Output:
 *     5
 *
 * Input:
 * solution.solution('4')
 * Output:
 *     2
 *
 * -- Java cases --
 * Input:
 * Solution.solution('4')
 * Output:
 *     2
 *
 * Input:
 * Solution.solution('15')
 * Output:
 *     5
 */
public class FuelInjectionPerfection {

    public static void main(String[] args) {
        System.out.println(solution("6"));
    }

    public static int solution(String n) {
        int[] digits = new int[n.length()];

        for (int i=0 ; i<n.length() ; i++) {
            digits[i] = Character.getNumericValue(n.charAt(i));
        }

        int counter = 0;

        while (!isEqualToN(digits, 1)) {
            if (digits[digits.length - 1] % 2 == 0) {
                digits = getHalf(digits);
            } else {
                if (isEqualToN(digits, 3)) {
                    digits = minusOne(digits);
                } else {
                    int[] halfOfPlusOneDigits = getHalf(plusOne(digits));
                    if (halfOfPlusOneDigits[halfOfPlusOneDigits.length - 1] % 2 == 0) {
                        counter++;
                        digits = halfOfPlusOneDigits;
                    } else {
                        digits = minusOne(digits);
                    }
                }
            }

            counter++;
        }

        return counter;
    }

    private static boolean isEqualToN(int[] arr, int n) {
        for (int i=0 ; i<arr.length ; i++) {
            if ((i < arr.length -1 && arr[i] != 0) || (i == arr.length - 1 && arr[i] != n)) {
                return false;
            }
        }

        return true;
    }

    private static int[] getHalf(int[] arr) {
        int[] resultArr = new int[arr.length];
        int rem = 0;

        for (int i=0 ; i<arr.length ; i++) {
            int divident = arr[i] + rem;
            resultArr[i] = divident / 2;
            rem = (divident % 2) * 10;
        }

        return resultArr;
    }

    private static int[] plusOne(int[] arr) {
        int[] resultArr = new int[arr.length + 1];
        boolean done = false;

        for (int i=arr.length-1 ; i>=0 ; i--) {
            if (done) {
                resultArr[i+1] = arr[i];
            } else {
                if (arr[i] == 9) {
                    resultArr[i+1] = 0;
                } else {
                    resultArr[i+1] = arr[i] + 1;
                    done = true;
                }
            }
        }

        if (!done) {
            resultArr[0] = 1;
        }

        return resultArr;
    }

    private static int[] minusOne(int[] arr) {
        int[] resultArr = new int[arr.length];
        boolean done = false;

        for (int i=arr.length-1 ; i>=0 ; i--) {
            if (done) {
                resultArr[i] = arr[i];
            } else {
                if (arr[i] == 0) {
                    resultArr[i] = 9;
                } else {
                    resultArr[i] = arr[i] - 1;
                    done = true;
                }
            }
        }

        return resultArr;
    }
}
