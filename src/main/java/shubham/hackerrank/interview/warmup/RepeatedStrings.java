package shubham.hackerrank.interview.warmup;

/**
 * There is a string, s, of lowercase English letters that is repeated infinitely many times. Given an integer, n,
 * find and print the number of letter a's in the first n letters of the infinite string.
 *
 * Example
 * Input s = abc, n = 13
 * Output 5
 * The substring we consider is , the first  characters of the infinite string. There are  occurrences of a in the substring.
 */
public class RepeatedStrings {
    public static long repeatedString(String s, long n) {
        if(s.length() > n){
            long count = 0;
            int i = 0;
            while (i < n){
                if(s.charAt(i++) == 'a'){
                    count++;
                }
            }
            return count;
        } else {
            int aCount = 0;
            int lastIndex = -1;
            char[] arr = s.toCharArray();
            for(int i = 0; i < s.length(); i++){
                if(arr[i] == 'a'){
                    aCount++;
                    lastIndex = i;
                }
            }
            if(lastIndex == -1){
                return 0;
            }

            long count = n / s.length() * aCount;
            long remaining = n % s.length();

            while(remaining > 0){
                if(arr[(int)remaining - 1] == 'a'){
                    count++;
                }
                remaining--;
            }

            return count;
        }
    }
}
