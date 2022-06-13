package shubham.hackerrank.interview.warmup;

import java.util.HashSet;
import java.util.Set;

/**
 * There is a large pile of socks that must be paired by color.
 * Given an array of integers representing the color of each sock,
 * determine how many pairs of socks with matching colors there are.
 *
 * Example
 * n = 7
 * arr = [1,2,1,2,1,3,2]
 *
 * There is one pair of color 1 and one of color 2. There are three odd socks left, one of each color. The number of pairs is .
 */
public class SalesByMatch {
    static int sockMerchant(int n, int[] ar) {
        int pairs = 0;
        Set<Integer> hm = new HashSet();
        for(int ele : ar){
            if(hm.contains(ele)){
                pairs++;
                hm.remove(ele);
            } else {
                hm.add(ele);
            }
        }
        return pairs;
    }
}
