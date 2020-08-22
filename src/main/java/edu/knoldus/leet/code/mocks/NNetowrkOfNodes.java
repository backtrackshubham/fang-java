package edu.knoldus.leet.code.mocks;

import java.util.ArrayList;

/**
 * There are N network nodes, labelled 1 to N.
 *
 * Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.
 *
 * Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
 * Output: 2
 *
 *
 * Note:
 *
 * N will be in the range [1, 100].
 * K will be in the range [1, N].
 * The length of times will be in the range [1, 6000].
 * All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.
 */
public class NNetowrkOfNodes {
    public static void main(String[] args) {

    }
}

class NNetowrkOfNodesHelepr {
    static int networkDelayTime(int[][] times, int N, int K) {
        int[] restNodes = new int[N - 1];
        for(int i = 1, j = 0; i <= N ;){
            if(i == K){

            } else {
                restNodes[j++] = i;
            }
        }
        printArray(restNodes);
        return  0;
    }

    static void printArray(int[] x){
        for (int i : x) System.out.println(i);
    }
}