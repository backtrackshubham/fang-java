package shubham.edu.dsalgo.google.kickstart.may;

import java.util.Arrays;
import java.util.Scanner;

public class CountDownArray {
    public static void main(String[] args) {
        int numTestCase;
        Scanner s = new Scanner(System.in);
        numTestCase = Integer.parseInt(s.nextLine());
        int caseIndicator = 0;
        String[] result = new String[numTestCase];


        while(caseIndicator < numTestCase){
            String numElLine = s.nextLine();

            int numElements = Integer.parseInt(numElLine.split(" ")[0]);
            int countDown = Integer.parseInt(numElLine.split(" ")[1]);
            numElLine = s.nextLine();
            int i = 0;
            int[] averyArray = new int[numElements];
            for (String num: numElLine.split(" ")) {
                averyArray[i++] = Integer.parseInt(num);
            }
            i = 0; //to store countdown counts

            int itr = 0;

            while (itr < averyArray.length - 1){
                if(averyArray[itr] - averyArray[itr + 1] == 1){
                    int diff = countDown - 2;
                    itr++;
                    while(itr < averyArray.length - 1 && averyArray[itr] - averyArray[itr + 1] == 1){
                        diff--;
                        itr++;
                    }

                    if(diff == 0){
                        i++;
                    }
                } else {
                    itr++;
                }
            }
            result[caseIndicator] = "Case #"+(caseIndicator+1)+": "+i;
            caseIndicator++;
            System.out.println("Array");
            System.out.println(Arrays.toString(result));
            System.out.println("Array");
        }
        for (String res: result
             ) {
            System.out.println(res);
        }
    }
}
