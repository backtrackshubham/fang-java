package shubham.edu.dsalgo.leet.code.practice;

import java.util.Arrays;

public class RotOranges {
    static int[] transform(int point, int cl) {
        int row = point / cl;
        int col = point % cl;

        return new int[]{row, col};
    }

    private static int interpolate(int[] point, int rl) {
        return point[0] * rl + point[1];
    }

    public static int timeToRot(int[][] orr) {
        int rl = orr.length;
        int cl = orr[0].length;
        int tToRot = 0;

        int numCanBeRot = 0;

        for (int i = 0; i < rl; i++) {
            for (int j = 0; j < cl; j++) {
                if (orr[i][j] == 1) numCanBeRot++;
            }
        }

        System.out.println("Total to rot "+ numCanBeRot);

        while (numCanBeRot > 0) {

            int cr = numCanBeRot;
            for (int i = 0; i < rl * cl; i++) {
                int r = transform(i, cl)[0];
                int c = transform(i, cl)[1];
//                System.out.println("I is "+i);


                if (orr[r][c] == 2) {
                    if (r - 1 > -1 && orr[r - 1][c] == 1) {
//                        System.out.println("Can Rot { " + (r - 1) + " , " + c + " }");
                        orr[r - 1][c] = 2;
                        numCanBeRot--;
                    }

                    if (c - 1 > -1 && orr[r][c - 1] == 1) {
//                        System.out.println("Can Rot { " + (r) + " , " + (c - 1) + " }");
                        orr[r][c - 1] = 2;
                        numCanBeRot--;
                    }

                    if (c + 1 < cl && orr[r][c + 1] == 1) {
//                        System.out.println("Can Rot { " + r + " , " + (c + 1) + " }");
                        orr[r][c + 1] = 2;
                        numCanBeRot--;
                    }

                    if (r + 1 < rl && orr[r + 1][c] == 1) {
//                        System.out.println("Can Rot { " + (r + 1) + " , " + c + " }");
                        orr[r + 1][c] = 2;
                        numCanBeRot--;
                    }
                }
            }

            System.out.println("Array after first itr");
            for (int[] x : orr
                 ) {
                System.out.println(Arrays.toString(x));
            }
            System.out.println("Array after first itr");

            if(numCanBeRot == cr){
                return -1;
            }
            tToRot++;
            
        }
        return tToRot;

    }

    public static void main(String[] args) {
        int[][] orr = {{2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};

        System.out.println(timeToRot(orr));
    }
}
