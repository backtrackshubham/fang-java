package shubham.edu.dsalgo.google.foobar;

import java.time.Instant;
import java.util.*;
import java.util.stream.IntStream;

public class Questions {
    static int recCalls = 0;

    public static int getDiffElement(int[] x, int[] y) {
        int lX = x.length;
        int lY = y.length;
        int i = 0;

        int sum = 0;
        while (i < lX && i < lY) {
            sum += Math.abs(x[i]);
            sum -= Math.abs(y[i]);
            i++;
        }

        return lX > lY ? (sum == 0 ? x[lX - 1] : sum + x[lX - 1]) : (sum == 0 ? y[lY - 1] : sum - y[lY - 1]);
    }

    public static int LAMBDistro(int LAMBS) {
        int stringed = stringy(LAMBS);
        int genre = generous(LAMBS);
        return stringed > genre ? stringed - genre : genre - stringed;
    }

    private static int stringy(int LAMBS) {
        if (LAMBS == 1 || LAMBS == 2) return LAMBS == 1 ? 1 : 2;
        int s1 = 1;
        int s2 = 1;
        int next = s1 + s2;
        int numHenchMen = 2;
        int sumTODis = LAMBS - 2;
        while (sumTODis >= next) {
            sumTODis -= next;
            s1 = s2;
            s2 = next;
            next = s1 + s2;
            numHenchMen++;
        }

        return numHenchMen;
    }

    private static int generous(int LAMBS) {
        if (LAMBS == 1 || LAMBS == 2) return 1;
        int s1 = 1;
        int s2 = 2;
        int next = s2 * 2;
        int numHenchMen = 2;
        int sumTODis = LAMBS - (s1 + s2);
        while (sumTODis >= next) {
            sumTODis -= next;
            s2 = next;
            next = s2 * 2;
            numHenchMen++;
        }

        return numHenchMen;
    }


    public static int getMinKnightMoves(int src, int dest) {
        int[] srcTransformed = transform(src);
        int[] destTransformed = transform(dest);
        Map<String, Integer> hm = new HashMap<String, Integer>();
        hm.put(src + "-" + src, 0);
        hm.put(dest + "-" + dest, 0);
        minMoves(srcTransformed, destTransformed, 0, hm);
        return hm.getOrDefault("found", 0);
    }


    private static void minMoves(int[] src, int[] dest, int moves, Map<String, Integer> hm) {
        if (interpolate(src) == interpolate(dest)) {
            return;
        } else {
            if (hm.containsKey("found")) return;

            int[][] canMoveFromSrc = canMoveFromSrc(src);

            for (int[] nextMove : canMoveFromSrc) {
                if (interpolate(dest) == interpolate(nextMove)) {
                    hm.put("found", moves + 1);
                    return;
                }
            }

            for (int[] nextMove : canMoveFromSrc) {
                if (hm.containsKey("found")) return;
                if (hm.containsKey(interpolate(nextMove) + "-" + interpolate(src))) {
                    if (hm.get(interpolate(nextMove) + "-" + interpolate(src)) > moves + 1) {
                        hm.put(interpolate(nextMove) + "-" + interpolate(src), moves + 1);
                    }
                } else if (hm.containsKey(interpolate(src) + "-" + interpolate(nextMove))) {
                    if (hm.get(interpolate(src) + "-" + interpolate(nextMove)) > moves + 1) {
                        hm.put(interpolate(src) + "-" + interpolate(nextMove), moves + 1);
                    }
                } else {
                    hm.put(interpolate(nextMove) + "-" + interpolate(src), moves + 1);
                    minMoves(nextMove, dest, moves + 1, hm);
                }
            }
        }
    }

    private static int[][] canMoveFromSrc(int[] src) {

        Comparator<int[]> x = Comparator.comparingInt(o -> interpolate(o) - interpolate(src));
        ArrayList<int[]> al = new ArrayList();
        //upper left
        if (src[0] - 2 > -1 && src[1] - 1 > -1) {
            int[] nC = new int[]{src[0] - 2, src[1] - 1};
            al.add(nC);
        }
        //upper right
        if (src[0] - 2 > -1 && src[1] + 1 < 8) {
            int[] nC = new int[]{src[0] - 2, src[1] + 1};
            al.add(nC);
        }
        //left upper
        if (src[0] - 1 > -1 && src[1] - 2 > -1) {
            int[] nC = new int[]{src[0] - 1, src[1] - 2};
            al.add(nC);
        }
        //left lower
        if (src[0] + 1 < 8 && src[1] - 2 > -1) {
            int[] nC = new int[]{src[0] + 1, src[1] - 2};
            al.add(nC);
        }
        //lower left
        if (src[0] + 2 < 8 && src[1] - 1 > -1) {
            int[] nC = new int[]{src[0] + 2, src[1] - 1};
            al.add(nC);
        }

        //lower right
        if (src[0] + 2 < 8 && src[1] + 1 < 8) {
            int[] nC = new int[]{src[0] + 2, src[1] + 1};
            al.add(nC);
        }
        //right upper
        if (src[0] - 1 > -1 && src[1] + 2 < 8) {
            int[] nC = new int[]{src[0] - 1, src[1] + 2};
            al.add(nC);
        }

        //right lower
        if (src[0] + 1 > 8 && src[1] + 2 < 8) {
            int[] nC = new int[]{src[0] + 2, src[1] + 1};
            al.add(nC);
        }
        al.sort(x);
        int[][] arr = new int[al.size()][];
        return al.toArray(arr);
    }


    private static int[] transform(int point) {
        int row = point / 8;
        int col = point % 8;

        return new int[]{row, col};
    }

    private static int interpolate(int[] point) {
        return point[0] * 8 + point[1];
    }

    static int getMinKnightMovesNew(int src, int dest) {
        int[] srcTransformed = transform(src);
        int[] destTransformed = transform(dest);
        int moves = 0;
        while (Math.abs(srcTransformed[0] - destTransformed[0]) > 3 || Math.abs(srcTransformed[1] - destTransformed[1]) > 3) {
            System.out.println("===================================");
            System.out.println("Src " + interpolate(srcTransformed));
            System.out.println("Src {" + srcTransformed[0] + "," + srcTransformed[1] + "}");
            System.out.println("Dest " + interpolate(destTransformed));
            System.out.println("===================================");
            if (Math.abs(srcTransformed[0] - destTransformed[0]) > Math.abs(srcTransformed[1] - destTransformed[1])) {
                if (srcTransformed[0] > destTransformed[0]) {
                    srcTransformed[0] -= 2;
                } else {
                    srcTransformed[0] += 2;
                }
                if (srcTransformed[1] > destTransformed[1]) {
                    if (srcTransformed[1] - 1 > -1) {
                        srcTransformed[1] -= 1;
                    } else srcTransformed[1] += 1;
                } else {
                    if (srcTransformed[1] + 1 < 8) {
                        srcTransformed[1] += 1;
                    } else srcTransformed[1] -= 1;
                }
            } else {
                if (srcTransformed[1] > destTransformed[1]) {
                    srcTransformed[1] -= 2;
                } else {
                    srcTransformed[1] += 2;
                }
                if (srcTransformed[0] > destTransformed[0]) {
                    if (srcTransformed[0] - 1 > -1) {
                        srcTransformed[0] -= 1;
                    } else srcTransformed[0] += 1;
                } else {
                    if (srcTransformed[0] + 1 < 8) {
                        srcTransformed[0] += 1;
                    } else srcTransformed[0] -= 1;
                }
            }
            moves++;
        }


        System.out.println("Src " + interpolate(srcTransformed));
        System.out.println("Dest " + interpolate(destTransformed));

        return moves;
    }

    static int getMinKnightMovesRec(int src, int dest, int moves) {
        int[] srcTransformed = transform(src);
        int[] destTransformed = transform(dest);

        if (moves != 0) {
            System.out.println("==================New=================");
            System.out.println("Src " + interpolate(srcTransformed));
            System.out.println("Src {" + srcTransformed[0] + "," + srcTransformed[1] + "}");
            System.out.println("Dest " + interpolate(destTransformed));
            System.out.println("==================New=================");
        }


        if (!(Math.abs(srcTransformed[0] - destTransformed[0]) > 3 || Math.abs(srcTransformed[1] - destTransformed[1]) > 3)) {

        } else {
            System.out.println("===================================");
            System.out.println("Src " + interpolate(srcTransformed));
            System.out.println("Src {" + srcTransformed[0] + "," + srcTransformed[1] + "}");
            System.out.println("Dest " + interpolate(destTransformed));
            System.out.println("===================================");
            if (Math.abs(srcTransformed[0] - destTransformed[0]) > Math.abs(srcTransformed[1] - destTransformed[1])) {
                if (srcTransformed[0] > destTransformed[0]) {
                    srcTransformed[0] -= 2;
                } else {
                    srcTransformed[0] += 2;
                }
                if (srcTransformed[1] > destTransformed[1]) {
                    if (srcTransformed[1] - 1 > -1) {
                        srcTransformed[1] -= 1;
                    } else srcTransformed[1] += 1;
                } else {
                    if (srcTransformed[1] + 1 < 8) {
                        srcTransformed[1] += 1;
                    } else srcTransformed[1] -= 1;
                }
            } else {
                if (srcTransformed[1] > destTransformed[1]) {
                    srcTransformed[1] -= 2;
                } else {
                    srcTransformed[1] += 2;
                }
                if (srcTransformed[0] > destTransformed[0]) {
                    if (srcTransformed[0] - 1 > -1) {
                        srcTransformed[0] -= 1;
                    } else srcTransformed[0] += 1;
                } else {
                    if (srcTransformed[0] + 1 < 8) {
                        srcTransformed[0] += 1;
                    } else srcTransformed[0] -= 1;
                }
            }
            moves++;
            return getMinKnightMovesRec(interpolate(srcTransformed), interpolate(destTransformed), moves);
        }


        while (Math.abs(srcTransformed[0] - destTransformed[0]) > 3 || Math.abs(srcTransformed[1] - destTransformed[1]) > 3) {
            System.out.println("===================================");
            System.out.println("Src " + interpolate(srcTransformed));
            System.out.println("Src {" + srcTransformed[0] + "," + srcTransformed[1] + "}");
            System.out.println("Dest " + interpolate(destTransformed));
            System.out.println("===================================");
            if (Math.abs(srcTransformed[0] - destTransformed[0]) > Math.abs(srcTransformed[1] - destTransformed[1])) {
                if (srcTransformed[0] > destTransformed[0]) {
                    srcTransformed[0] -= 2;
                } else {
                    srcTransformed[0] += 2;
                }
                if (srcTransformed[1] > destTransformed[1]) {
                    if (srcTransformed[1] - 1 > -1) {
                        srcTransformed[1] -= 1;
                    } else srcTransformed[1] += 1;
                } else {
                    if (srcTransformed[1] + 1 < 8) {
                        srcTransformed[1] += 1;
                    } else srcTransformed[1] -= 1;
                }
            } else {
                if (srcTransformed[1] > destTransformed[1]) {
                    srcTransformed[1] -= 2;
                } else {
                    srcTransformed[1] += 2;
                }
                if (srcTransformed[0] > destTransformed[0]) {
                    if (srcTransformed[0] - 1 > -1) {
                        srcTransformed[0] -= 1;
                    } else srcTransformed[0] += 1;
                } else {
                    if (srcTransformed[0] + 1 < 8) {
                        srcTransformed[0] += 1;
                    } else srcTransformed[0] -= 1;
                }
            }
            moves++;
        }


        System.out.println("Src " + interpolate(srcTransformed));
        System.out.println("Dest " + interpolate(destTransformed));

        return moves;
    }

    private static int getMovesFromDiffTwo(int[] srcTransformed, int[] destTransformed) {
        if (Math.abs(srcTransformed[0] - destTransformed[0]) == Math.abs(srcTransformed[1] - destTransformed[1])) {
            return 4;
        } else if ((Math.abs(srcTransformed[0] - destTransformed[0]) == 1 && Math.abs(srcTransformed[1] - destTransformed[1]) == 2) ||
                Math.abs(srcTransformed[0] - destTransformed[0]) == 2 && Math.abs(srcTransformed[1] - destTransformed[1]) == 1) {
            return 1;
        } else if ((Math.abs(srcTransformed[0] - destTransformed[0]) == 0 && Math.abs(srcTransformed[1] - destTransformed[1]) == 2) ||
                Math.abs(srcTransformed[0] - destTransformed[0]) == 2 && Math.abs(srcTransformed[1] - destTransformed[1]) == 0) {
            return 2;
        } else if ((Math.abs(srcTransformed[0] - destTransformed[0]) == 0 && Math.abs(srcTransformed[1] - destTransformed[1]) == 1) ||
                Math.abs(srcTransformed[0] - destTransformed[0]) == 1 && Math.abs(srcTransformed[1] - destTransformed[1]) == 0) {
            return 3;
        } else {
            return 0;
        }
    }

    public static int queueTodo(int start, int window) {
        int xorred = 0;
        int add = window;
        while (window > 0) {
            int i = 0;
            while (i < window) {
                xorred ^= start + i;
                i++;
            }
            start = start + add;
            window--;
        }
        return xorred;
    }

    public static long toReachOne(long num, int moves) {
        System.out.println("-->" + num);
        if (num == 1) {
            return moves;
        } else if (num % 2 == 0) {
            return toReachOne(num / 2, moves + 1);
        } else {
            long moveAdd = toReachOne(num + 1, moves + 1);
            long moveSub = toReachOne(num - 1, moves + 1);
            return Math.min(moveAdd, moveSub);
        }
    }

    public static Long toReachOneWithMap(Long num, Long moves, Map<Long, Long> hm) {
        if (num == 1) {
            return moves;
        } else if (num % 2 == 0) {
            if (hm.containsKey(num / 2)) {
                System.out.println(hm);
                return hm.get(num / 2);
            } else {
                Long res = toReachOneWithMap(num / 2, moves + 1, hm);
                hm.put(num / 2, res);
                hm.put(num, moves + res);
                return res;
            }
        } else {
            Long moveAdd = toReachOneWithMap(num + 1, moves + 1, hm);
            Long moveSub = toReachOneWithMap(num - 1, moves + 1, hm);
            Long res = Math.min(moveAdd, moveSub);
            hm.put(num, res);
            hm.put(num + 1, moveAdd);
            hm.put(num - 1, moveSub);
            return res;
        }
    }

    public static int toReachOneWhile(int num) {
        int moves = 0;
        while (num % 2 == 0) {
            moves++;
            num /= 2;
            System.out.println("Now num  = " + num);
            System.out.println("Now num  = " + (num % 2 == 0));
        }
        if (num == 1) {
            return moves;
        }

        return moves + Math.min(toReachOneWhile(num + 1), toReachOneWhile(num - 1));
    }

    public static Long toReachOneString(String num, HashMap<String, Long> hm) {
        String key = num;
        System.out.println(hm);
        Long moves = 0L;

        if (num.equals("1")) {
            return moves;
        }

        char v;
        v = num.charAt(num.length() - 1);
        while (v == '2' || v == '4' || v == '6' || v == '8' || v == '0') {
            num = divideLongNumberBy2(num);
            v = num.charAt(num.length() - 1);
            moves++;
        }

        if (num.equals("1")) {
            hm.put(key, moves);
            return moves;
        }

        Long movesAdd;
        char[] numberCharArray = num.toCharArray();
        String afterAdd = addDigitLongNumber(num, '1');
        System.out.println(num);
        movesAdd = hm.getOrDefault(afterAdd, toReachOneString(afterAdd, hm));
        hm.put(afterAdd, movesAdd);
//        movesSub = hm.getOrDefault(afterSub, toReachOneString(afterSub, hm));
//        hm.put(afterSub, movesSub);


        Long res = movesAdd + moves;

        hm.put(key, res);
        return res;
    }

    public static Long toReachOneStringV2(String num) {
        Long moves = 0L;

        if (num.equals("1")) {
            return moves;
        }

        char v;
        v = num.charAt(num.length() - 1);
        while (v == '2' || v == '4' || v == '6' || v == '8' || v == '0') {
            num = divideLongNumberBy2(num);
            v = num.charAt(num.length() - 1);
            moves++;
        }

        if (num.equals("1")) {
            return moves;
        }

        Long movesAdd;
        char[] numberCharArray = num.toCharArray();
        String afterAdd = addDigitLongNumber(num, '1');
        System.out.println(num);
        movesAdd = toReachOneStringV2(afterAdd);
//        movesSub = hm.getOrDefault(afterSub, toReachOneString(afterSub, hm));
//        hm.put(afterSub, movesSub);
        return movesAdd + moves;
    }

    public static String addDigitLongNumber(String num, char toAdd) {
        char[] numArray = new char[num.length() + 1];
        for (int i = numArray.length - 1; i > 0; i--) {
            numArray[i] = num.toCharArray()[i - 1];
        }
        int lI = numArray.length - 1;
        Integer sum = Integer.parseInt("" + toAdd) + Integer.parseInt("" + numArray[lI]);
        if (sum < 10) {
            numArray[lI] += Integer.parseInt("" + toAdd);
        } else {
            int prev = lI - 1;
            numArray[lI] = ("" + sum).toCharArray()[1];
            //("" + sum).toCharArray()[1] = 1
            while (prev >= 1 && numArray[prev] + 1 > '9') {
                numArray[prev] = '0';
                prev--;
            }
            if (prev >= 1) {
                numArray[prev] += 1;
            } else {
                numArray[prev] = '1';
            }
        }
        return new String(numArray).trim();
    }

    public static String subtractDigitLongNumber(String num, char toSub) {
        char[] numArray = num.toCharArray();
        int lI = numArray.length - 1;
        if (numArray[lI] >= toSub) {
            numArray[lI] -= Integer.parseInt("" + toSub);
        } else {
            int prev = lI - 1;
            numArray[lI] = ("" + (10 - Integer.parseInt("" + toSub))).toCharArray()[0];
            while (numArray[prev] == '0') {
                numArray[prev] = '9';
                prev--;
            }
            numArray[prev] -= 1;
        }
        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] == '0') {
                numArray[i] = ' ';
            } else break;
        }
        return new String(numArray).trim();
    }

    public static String divideLongNumberBy2(String dividend) {
        StringBuffer quotient = new StringBuffer();
        int l = dividend.length();
        char[] numberCharArray = dividend.toCharArray();
        boolean hasCarry = false;
        for (int i = 0; i < l; i++) {
            char v = numberCharArray[i];
            if (v == '0') {
                quotient.append(v);
            } else if (v == '2' || v == '4' || v == '6' || v == '8') {
                Integer in = Integer.parseInt("" + v);
                quotient.append(in / 2);
                hasCarry = false;
            } else if (v == '3' || v == '5' || v == '7' || v == '9') {
                Integer in = Integer.parseInt("" + v);
                quotient.append(in / 2);
                numberCharArray[i--] = '1';
                hasCarry = true;
            } else {
                if (!hasCarry && i != 0) quotient.append('0');
                Integer in = Integer.parseInt("" + v + numberCharArray[++i]);
                if (in % 2 == 0) {
                    quotient.append(in / 2);
                    hasCarry = false;
                } else {
                    hasCarry = true;
                    quotient.append(in / 2);
                    numberCharArray[i--] = '1';
                }
            }
        }
        return quotient.toString().trim();
    }

    public static Long moves(String num){
        String key = num;

//        System.out.println("Rec call number" + (++recCalls));
        Long moves = 0L;

        if (num.equals("1")) {
            System.out.println("Returning from 422");
            return moves;
        }

        char v;
        v = num.charAt(num.length() - 1);
        while (v == '2' || v == '4' || v == '6' || v == '8' || v == '0') {
            num = divideLongNumberBy2(num);
            System.out.println(num);
            v = num.charAt(num.length() - 1);
            moves++;
        }

        if (num.equals("1")) {
            System.out.println("Returning from 431");
            System.out.println(moves);

            return moves;
        }
        Long addMoves = moves(addDigitLongNumber(num, '1'));
        Long subMoves = moves(subtractDigitLongNumber(num, '1'));
        return moves + Math.min(addMoves, subMoves);
    }

    public static void main(String[] args) {
//        System.out.println(LAMBDistro(143));
//        System.out.println(LAMBDistro(10));
//        System.out.println(getMinKnightMoves(0, 25));
//        System.out.println(queueTodo(17, 4));
        Random r = new Random();
        String reduce = IntStream.range(0, 308).mapToObj(v -> "" + r.nextInt(10)).reduce("", (a, b) -> a + b);
//        System.out.println(reduce);
        HashMap<String, Long> hm = new HashMap<>();
        String t = "35097043013700775679443120738031065315225297949377734962699612888869116512714635626044471972478334532694755129352937651778789380257880099706940905734920204927959002234377853042714681571824480703981764403917469831672643371002844373104197694562212427771102049045260970479573457545967907451322975243352885200140";
//        String t = "3509704301370077567944312073803106531522529794937773496";
        String tw = "9999999999999999999999999999999999999999999999999999999";
        String tz = "1000000000000000000000000000000000000000000000000000000";
//
////        System.out.println(t.length());
//        System.out.println(tw);
//        System.out.println(addDigitLongNumber("0", '4'));
//        System.out.println(subtractDigitLongNumber("4", '4'));
//        System.out.println(tz);
//        System.out.println(subtractDigitLongNumber(tz, '4'));

        System.out.println(Instant.now());
//        System.out.println(toReachOneString("602816357360646", hm));
//        System.out.println(toReachOneString(t, hm));
        System.out.println(toReachOneStringV2(t));
//        System.out.println(moves(t));
        System.out.println(Instant.now());
//        System.out.println(toReachOneWithMap(100L, 0L, new HashMap<>()));
//        System.out.println("150970430137006");
//        System.out.println(toReachOneString("10000", hm));
//        System.out.println(toReachOneString("" + Long.MAX_VALUE));
//        System.out.println(150970430137006L / 2);


//        System.out.println(getMinKnightMovesNew(56, 0));

    }
}
