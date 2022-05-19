package shubham.edu.dsalgo.change;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    static void quickSort(int[] toSort){
        int piviot = toSort[0];

    }

    static int sortHelper(int[] toSort,int high, int low) {
        int pivot = low + (high - low) / 2;

        int i = low;
        int j = high;

        while(i < j){
            while(toSort[i] <= toSort[pivot]){
                i++;
            }
            while(toSort[j] > toSort[pivot]){
                j--;
            }

            toSort[i] = toSort[i] + toSort[j];
            toSort[j] = toSort[i] - toSort[j];
            toSort[i] = toSort[i] - toSort[j];
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] arr = new int[100];
        Random en = new Random();
        arr = Arrays.stream(arr).map(v -> en.nextInt(1000)).toArray();

        quickSort(arr);

    }
}
