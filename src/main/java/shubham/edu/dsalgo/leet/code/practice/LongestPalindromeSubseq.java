package shubham.edu.dsalgo.leet.code.practice;

/**
 * Given a string s, find the longest palindromic subsequence's length in s.
 *
 * A subsequence is a sequence that can be derived from another sequence by deleting some or
 * no elements without changing the order of the remaining elements.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "bbbab"
 * Output: 4
 * Explanation: One possible longest palindromic subsequence is "bbbb".
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: 2
 * Explanation: One possible longest palindromic subsequence is "bb".
 *
 */
class Solution {
    public int longestPalindromeSubseq(String s) {

        char[] ca = s.toCharArray();
        int longestPalindrome = 0;
        int longestPalindromeSofar = 0;
        int mayDelete = 0;
        boolean palStartFound = false;

        for (int i = 0, j = ca.length - 1; i <= j;){
            if(ca[i] == ca[j]){
                
            }
        }
        return 0;

    }
}

public class LongestPalindromeSubseq {
    public static void main(String[] args) {

    }
}
