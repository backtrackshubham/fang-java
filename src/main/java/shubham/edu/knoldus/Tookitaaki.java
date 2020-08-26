package shubham.edu.knoldus;

import java.util.HashSet;
import java.util.Set;

public class Tookitaaki {
    static class CannotMakePalindrome extends Exception {
        String message;
        CannotMakePalindrome(String message){
            this.message = message;
        }
    }
    static boolean canMakePalindrome(String mayBeString) {
        char[] strArray = mayBeString.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c: strArray) {
            if(set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.isEmpty() || set.size() == 1;
    }

    static String makePalindrome(String mayBePalindrome) throws CannotMakePalindrome {
        char[] strArray = mayBePalindrome.toCharArray();
        char [] newToBuild = new char[strArray.length];

        int i = 0;
        int j = strArray.length - 1;
        Set<Character> set = new HashSet<>();
        for (char c: strArray) {
            if(set.contains(c)) {
                set.remove(c);
                newToBuild[i++] = c;
                newToBuild[j--] = c;
            } else {
                set.add(c);
            }
        }

        if (strArray.length % 2 == 0) {
            if(j - i == -1) {
                return new String(newToBuild);
            } else {
                throw new CannotMakePalindrome("Can't make a valid for "+ mayBePalindrome);
            }
        } else {
            if(j - i == 0) {
                for (Character c: set
                     ) {
                    newToBuild[i] = c;
                }
                return new String(newToBuild);
            } else {
                throw new CannotMakePalindrome("Can't make a valid for "+ mayBePalindrome);
            }
        }
    }
    public static void main(String[] args) {
        try {
            System.out.println(makePalindrome("aab"));
        } catch (CannotMakePalindrome cannotMakePalindrome) {
            System.out.println(cannotMakePalindrome.message);
        }
        try {
            System.out.println(makePalindrome("shubham"));
        } catch (CannotMakePalindrome cannotMakePalindrome) {
            System.out.println(cannotMakePalindrome.message);

        }
        try {
            System.out.println(makePalindrome("aabb"));
        } catch (CannotMakePalindrome cannotMakePalindrome) {
            System.out.println(cannotMakePalindrome.message);

        }
        try {
            System.out.println(makePalindrome("abcdedcba"));
        } catch (CannotMakePalindrome cannotMakePalindrome) {
            System.out.println(cannotMakePalindrome.message);

        }
        try {
            System.out.println(makePalindrome("abcdedcbag"));
        } catch (CannotMakePalindrome cannotMakePalindrome) {
            System.out.println(cannotMakePalindrome.message);
        }

        try {
            System.out.println(makePalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabb"));
        } catch (CannotMakePalindrome cannotMakePalindrome) {
            System.out.println(cannotMakePalindrome.message);
        }
    }
}
