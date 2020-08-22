//package edu.knoldus.leet.code.practice;
//
//public class BalancedString {
//    public static void main(String[] args) {
//        System.out.println(new BalancedStringHelper().balancedStringSplit("RLRRRLLRLL"));
//    }
//}
//class BalancedStringHelper {
//    public int balancedStringSplit(String s) {
//        int toRet = 0;
//        int countR = 0;
//        int countL = 0;
//
//        char first = s.charAt(0);
//        if(first == 'L'){
//            countL++;
//        } else {
//            countR++;
//        }
//        System.out.println("--------------");
//        System.out.println(countR);
//        System.out.println(countL);
//        System.out.println("--------------");
//
//        for(int i = 1; i < s.length(); i ++){
//            if(first == s.charAt(i)){
//                System.out.println("Entered if " + i);
//
//                if(first == 'L'){
//                    countL++;
//                } else {
//                    countR++;
//                }
//            } else {
//                System.out.println("Entered else");
//
//                int countToMonitor = first == 'L' ? countL : countR;
//                int j;
//                for (j = 0; j < countToMonitor; j++) {
//                    System.out.println("Iterating");
//                    if(first == s.charAt(i + j)){
//                        break;
//                    }
//
//                    if(first != 'L'){
//                        countL++;
//                    } else {
//                        countR++;
//                    }
//                }
//                if(countL == countR){
//                    System.out.println("Incrementing");
//                    toRet+=1;
//                }
//                countL = 0;
//                countR = 0;
//                if(i + 1 == s.length()){
//                    break;
//                }
//
//                first = s.charAt(i);
//                if(i + 2 != s.length()) i += 1;
//                if(first == 'L'){
//                    countL++;
//                } else {
//                    countR++;
//                }
//                System.out.println("Got new i " + first + "" + i);
//            }
//        }
//
//        return toRet;
//    }
//}