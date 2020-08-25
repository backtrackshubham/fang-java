package edu.knoldus.leet.code.practice;

class GridHeight {
    public void main(String[] args) {
        int[][] grid = {{3, 0, 8, 4},
                {2, 4, 5, 7},
                {9, 2, 6, 3},
                {0, 3, 1, 0}};
        GridHeightImpl gHI = new GridHeightImpl();


    }

    public class GridHeightImpl {
        public int maxIncreaseKeepingSkyline(int[][] grid) {
            int[] lRView = getView(grid, true);
            int[] tBView = getView(grid, false);


            System.out.println(lRView);
            System.out.println(tBView);
            return 5;
        }

        private int[] getView(int[][] arr, boolean isLr) {
            int[] toRet = new int[arr.length];
            if (isLr) {
                for (int i = 0; i < arr.length; i++) {
                    toRet[i] = findMax(arr[i]);
                }
            } else {
                int[] findMaxFrom = new int[arr.length];
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr.length; j++) {
                        findMaxFrom[j] = arr[j][i];
                    }
                    toRet[i] = findMax(findMaxFrom);
                }
            }

            return toRet;
        }

        private int findMax(int[] toFind) {
            int max = 0;
            for (int i = 0; i < toFind.length; i++) {
                for (int j = 0; j < toFind.length; j++) {
                    if (toFind[i] >= toFind[j]) {
                        max = toFind[i];
                    } else {
                        max = toFind[j];
                    }
                }
            }
            return max;
        }
    }
}