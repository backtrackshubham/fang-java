package shubham.edu.dsalgo.oracle;

import java.util.Arrays;

public class Oracle {
    public static int[] moveZerosToEnd(int[] inputArray){
        /**
         * input [1, 0, 3, 0, 0, 5, 6]
         * output [1, 3, 5, 6, 0, 0, 0]
         * Order shall not be changed
         */

        int lastNum = -1;
        for (int i = 0; i < inputArray.length; i++) {
            if(inputArray[i] != 0){
                inputArray[++lastNum] = inputArray[i];
            }
        }

        if(lastNum == -1 || lastNum == (inputArray.length - 1)){
            return inputArray;
        } else {
            for (int i = lastNum + 1; i < inputArray.length; i++) {
                System.out.println("Came here");
                inputArray[i] = 0;
            }
            return inputArray;
        }
    }



    public static String longestSubStringWithoutRepeatedCharacters(int[] String){
        /**
         * input awaertyuirt
         * output waertyui
         */
        return null;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveZerosToEnd(new int[]{1, 2, 1, 4, 0, 6, 3, 4})));
        System.out.println(Arrays.toString(moveZerosToEnd(new int[]{0, 2, 1, 4, 0, 6, 3, 4})));
        System.out.println(Arrays.toString(moveZerosToEnd(new int[]{5, 2, 1, 4, 0, 6, 3, 4})));
        System.out.println(Arrays.toString(moveZerosToEnd(new int[]{0, 0, 0, 0, 0, 0, 0, 0})));
        System.out.println(Arrays.toString(moveZerosToEnd(new int[]{0})));
        System.out.println(Arrays.toString(moveZerosToEnd(new int[]{0, 0})));
        System.out.println(Arrays.toString(moveZerosToEnd(new int[]{1, 0})));
        System.out.println(Arrays.toString(moveZerosToEnd(new int[]{0, 1})));
        System.out.println(Arrays.toString(moveZerosToEnd(new int[]{4, 1})));
    }
}
