//package shubham.edu.dsalgo.strings;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class PermuteString {
//    static String[] permuteString(String input){
//        return permute(input, 0);
//    }
//
//    static List<String> perOfLength(String s, int length){
//        if(length == 1){
//            Character[] test = new Character[s.length()];
//            int i = 0;
//            while (i < s.length()){
//              test[i] = s.charAt(i);
//              i++;
//            }
//            return Arrays.stream(test).map(x -> ""+x).collect(Collectors.toList());
//        } else {
//
//        }
//    }
//    static String[] permute(String s, int indexStart){
//        if(indexStart == s.length() - 1){
//            return new String[]{s.substring(s.length() - 1)};
//        } else {
//            String[] permutations = permute(s, indexStart + 1);
//            StringBuilder ten = new StringBuilder();
//            for (int i = 0; i <= indexStart; i++) {
//                ten.append(s, i, i);
//            }
//            List<String> collect = Arrays.stream(permutations).map(str -> ten.toString() + str).collect(Collectors.toList());
//            String[] arr = new String[collect.size()];
//            for (int i = 0; i < collect.size(); i++) {
//                arr[i] = collect.get(i);
//            }
//            return arr;
//        }
//    }
//
//    public static void main(String[] args) {
//        String[] s =  permuteString("abc");
//        for (String as:s
//             ) {
//
//            System.out.println(as);
//        }
//    }
//}
