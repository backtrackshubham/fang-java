package shubham.edu.dsalgo.leet.code.practice;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithOutRepetition {
    public static void main(String[] args) {
//        System.out.println(LongestSubStringWithOutRepetitionHelper.lengthOfLongestSubstringEfficient("dvdf"));
        System.out.println(LongestSubStringWithOutRepetitionHelper.lengthOfLongestSubstringOnlyArray("abcabcbb"));
    }
}

class LongestSubStringWithOutRepetitionHelper{
    static public int lengthOfLongestSubstring(String s) {

        if(s.length() == 1) return 1;
        if (s.length() == 2) return  s.charAt(0) == s.charAt(1) ? 1 : 2;
        char[] arr = s.toCharArray();
        int longestSubStringLength = 1;
        int srtIndex = 0;
        boolean flagFound = false;

        for(int i = 0; i < arr.length; i ++){
            for(int j = i + 1; j <  arr.length; j ++){

                while(srtIndex != j){
                    if(arr[j] != arr[srtIndex]){
                        srtIndex++;
                    } else {
                        longestSubStringLength = Math.max(longestSubStringLength, j - i);
                        flagFound = true;
                        break;
                    }
                }
                if(flagFound) {
                    flagFound = false;
                    break;
                }
                srtIndex = i;
            }
        }
        return longestSubStringLength;

    }
    static public int lengthOfLongestSubstringEfficient(String s) {

        if(s.length() == 1 || s.length() == 0) return s.length();
        char[] arr = s.toCharArray();
        Map<Character, Integer> mp = new HashMap<Character, Integer>();
        int longestSubStringLength = 0;
        int oldCount = 0;
        for(int i = 0; i < arr.length; i ++){
            if(mp.containsKey(arr[i])){
                oldCount = Math.max(longestSubStringLength, oldCount);
                longestSubStringLength = 0;
                i = mp.get(arr[i]);
                mp.clear();
            } else {
                mp.put(arr[i], i);
                longestSubStringLength++;
            }
        }
        return Math.max(longestSubStringLength, oldCount);

    }

    static public int lengthOfLongestSubstringOnlyArray(String s) {

        if(s.length() == 1 || s.length() == 0) return s.length();
        char[] arr = s.toCharArray();
        int longestSubStringLength = 0;
        int oldCount = 0;
        for(int i = 0, j = 0; j < arr.length;){
            System.out.println("Starting  J is at " + j +" I is at " + i);
            if(i == j){
                    longestSubStringLength++;
                    j++;
                } else {
                    System.out.println("GTE");
                    while (j < arr.length && arr[i] != arr[j]){

                        System.out.println("Entered");
                        longestSubStringLength++;
                        j++;
                    }
                    System.out.println("GTEX "+ longestSubStringLength+ " J is at " + j +" I is at " + i);
                    oldCount = Math.max(longestSubStringLength, j - i);
                    System.out.println("Count so far "+ oldCount);
                    longestSubStringLength = 0;
                    i++;
                    j = i;
                }

        }
        return Math.max(oldCount,longestSubStringLength) + 1;

    }
}