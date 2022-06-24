package shubham.hackerrank.interview.arrays;

/**
 * You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates. You are allowed to swap any two elements. Find the minimum number of swaps required to sort the array in ascending order.
 *
 * Example
 *
 *
 * Perform the following steps:
 *
 * i   arr [7, 1, 3, 2, 4, 5, 6] swap (indices)
 * 0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
 * 1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
 * 2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
 * 3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
 * 4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
 * 5   [1, 2, 3, 4, 5, 6, 7]
 * It took  swaps to sort the array.
 */
public class MinSwaps {
    /**
     *
     * [7, 1, 3, 2, 4, 5, 6]
     * [6, 1, 3, 2, 4, 5, 7]
     * [1, 6, 3, 2, 4, 5, 7]
     * [1, 2, 3, 6, 4, 5, 7]
     * [1, 2, 3, 5, 4, 6, 7]
     * [1, 2, 3, 4, 5, 6, 7]
     *
     */
    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        int i = 0;
        while(i < arr.length) {
            if (i + 1 != arr[i]){
                int t = arr[i];
                arr[i] = arr[t - 1];
                arr[t - 1] = t;
                swaps++;
            } else {
                i++;
            }
        }
        return swaps;
    }
}
