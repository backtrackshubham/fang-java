//package edu.knoldus.leet.code.practice;
//
//import java.util.*;
//
//public class LongestPalindromicSubstring {
//
//}
//
//class LongestPalindromicSubstringHelper{
//    static String longestPalindrome(String s) {
//        char[] strArr = s.toCharArray();
//        int longestPal = 0;
//        int newLongestPal = 0;
//        Queue<Character> lin = new LinkedList<>();
//        for (int i = 0; i < s.length(); i++) {
//            if(!lin.isEmpty()){
//                if(lin.peek() == strArr[i]){
//                    newLongestPal++;
//                    int inI = i + 1;
//                    while (!lin.isEmpty() && inI < s.length()){
//                        if(lin.remove() != strArr[inI]){
//                            break;
//                        }
//                        newLongestPal++;
//                        inI++;
//                    }
//                    if(lin.size() == 1 || lin.isEmpty()){
//                        newLongestPal = lin.isEmpty() ? newLongestPal : newLongestPal + 1;
//                        longestPal = Math.max(newLongestPal, longestPal);
//                    } else {
//                         lin = new LinkedList<>();
//                    }
//                } else {
//                    lin.add(strArr[i]);
//                }
//            } else {
//                lin.add(strArr[i]);
//            }
//        }
//
//    }
//}