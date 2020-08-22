package edu.knoldus.leet.code.pramp;


/**
 * Array Index & Element Equality
 * Given a sorted array arr of distinct integers, write a function indexEqualsValueSearch that returns the lowest index i for which arr[i] == i. Return -1 if there is no such index. Analyze the time and space complexities of your solution and explain its correctness.
 *
 * Examples:
 *
 * input: arr = [-8,0,2,5]
 * output: 2 # since arr[2] == 2
 *
 * input: arr = [-1,0,3,6]
 * output: -1 # since no index in arr satisfies arr[i] == i.
 * Constraints:
 */

public class FindElement {
    // O(n)
    static int indexEqualsValueSearchIterative(int[] arr) {
       for(int i = 0; i < arr.length; i ++){
           if(i == arr[i]){
               return i;
           }
       }
       return  -1;
    }


    // O(n)
    static int indexEqualsValueSearchBinary(int[] arr) {
        return findElement(arr, 0, arr.length - 1);
    }


    static int findElement(int[] arr, int start,int end){
        System.out.println(end);
        System.out.println(start);
        if(start == end || start > end){
            return arr[start - 1] == start - 1 ? start - 1 : -1;
        } else {
            int pivot = end - start / 2;
            if(arr[pivot] <= pivot){
                int res = findElement(arr, start, pivot - 1);
                return res == -1 ? pivot : res;
            } else {
                return findElement(arr, pivot + 1, end);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {-8,0,2,5};
        int[] arr2 = {-1,0,3,6};
//        System.out.println(indexEqualsValueSearchIterative(arr));
//        System.out.println(indexEqualsValueSearchIterative(arr2));
        System.out.println(indexEqualsValueSearchBinary(arr));
        System.out.println(indexEqualsValueSearchBinary(arr2));
    }
}
