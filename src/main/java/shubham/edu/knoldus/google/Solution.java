package shubham.edu.knoldus.google;

import java.util.Random;
import java.util.stream.IntStream;

public class Solution {
    // public static int solution(String x) {
    //     // Your code here
    // }
    public static int solution(String num) {
        int moves = 0;

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

        int movesAdd = 0;


        if(num.length() > 1){
            String afterAdd;
            char c = num.charAt(num.length() - 2);
            if(c == '0'||
               c == '2'||
               c == '4'||
               c == '6'||
               c == '8'
            ){
                afterAdd = subtractDigitLongNumber(num, '1');
            } else {
                afterAdd = addDigitLongNumber(num, '1');
            }
            movesAdd = solution(afterAdd);
        } else {
            switch (num){
                case "2":
                    movesAdd = solution(num);
                case "3":
                    movesAdd = solution("2");
                case "4":
                    movesAdd = solution(num);
                case "5":
                    movesAdd = solution("4");
                case "6":
                    movesAdd = solution(num);
                case "7":
                    movesAdd = solution("8");
                case "8":
                    movesAdd = solution(num);
                case "9":
                    movesAdd = solution("8");
            }
        }

//        movesSub = hm.getOrDefault(afterSub, toReachOneString(afterSub, hm));
//        hm.put(afterSub, movesSub);
        return movesAdd + moves;
    }

    public static String addDigitLongNumber(String num, char toAdd) {
        char[] numArray = new char[num.length() + 1];
        System.arraycopy(num.toCharArray(), 0, numArray, 1, numArray.length - 1);
        int lI = numArray.length - 1;
        int sum = Integer.parseInt("" + toAdd) + Integer.parseInt("" + numArray[lI]);
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
        StringBuilder quotient = new StringBuilder();
        int l = dividend.length();
        char[] numberCharArray = dividend.toCharArray();
        boolean hasCarry = false;
        for (int i = 0; i < l; i++) {
            char v = numberCharArray[i];
            if (v == '0') {
                quotient.append(v);
            } else if (v == '2' || v == '4' || v == '6' || v == '8') {
                int in = Integer.parseInt("" + v);
                quotient.append(in / 2);
                hasCarry = false;
            } else if (v == '3' || v == '5' || v == '7' || v == '9') {
                int in = Integer.parseInt("" + v);
                quotient.append(in / 2);
                numberCharArray[i--] = '1';
                hasCarry = true;
            } else {
                if (!hasCarry && i != 0) quotient.append('0');
                int in = Integer.parseInt("" + v + numberCharArray[++i]);
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

    public static void main(String[] args) {
        Random r = new Random();
        String reduce = IntStream.range(0, 1000).mapToObj(v -> "" + r.nextInt(10)).reduce("", (a, b) -> a + b);
        System.out.println(solution("35097043013700775679443120738031065315225297949377734962699612888869116512714635626044471972478334532694755129352937651778789380257880099706940905734920204927959002234377853042714681571824480703981764403917469831672643371002844373104197694562212427771102049045260970479573457545967907451322975243352885200140"));
    }
}