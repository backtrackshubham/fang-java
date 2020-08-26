package shubham.edu.knoldus.leet.code.practice;

public class MakeValidParentheses {
    public static void main(String[] args) {
//        System.out.println(MakeValidParenthesesHelper.minRemoveToMakeValidRefactored("lee(t(c)o)de)"));
//        System.out.println(MakeValidParenthesesHelper.minRemoveToMakeValidRefactored("a)b(c)d"));
//        System.out.println(MakeValidParenthesesHelper.minRemoveToMakeValidRefactored("))(("));
        System.out.println(MakeValidParenthesesHelper.minRemoveToMakeValidNewIdea("())()((("));
    }
}
class MakeValidParenthesesHelper {
    static String minRemoveToMakeValid(String s) { //Stupid solution
        int extraParantheses = 0;

        char[] arr = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (arr[i] == '(' || arr[i] == ')') {
                arr[i] = '*';
                extraParantheses++;
            }
        }

        if (extraParantheses % 2 == 0) {
            return s;
        } else {
            extraParantheses--;
            int numPar = extraParantheses / 2;
            while (extraParantheses > 0) {
                for (int i = 0; i < s.length(); i++) {
                    if (arr[i] == '*') {
                        if (extraParantheses > numPar) {
                            arr[i] = '(';
                        } else {
                            System.out.println("In else");
                            arr[i] = ')';
                        }
                        break;
                    }
                }
                --extraParantheses;
            }
        }

        return new String(arr).replace("*", "");

    }


    static String minRemoveToMakeValidRefactored(String s) { // ())()((("
        int countL =  0;
        int countR =  0;
        int invalidParentheses =  0;

        char[] arr = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            System.out.println("================= char "+ arr[i]);
            if(arr[i] == '('){
                countL++;
                if(countL == 0 && countR > 0) {
                    invalidParentheses++;
                }
            }else if(arr[i] == ')'){
                countR++;
                if(countL == 0 && countR > 0) {
                    invalidParentheses++;
                }
            }
        }

        countR-=invalidParentheses;
        while (invalidParentheses > 0){
            System.out.println("So we have some redicules");
            for (int i = 0; i < s.length(); i++) {
                if(arr[i] == ')'){
                    arr[i] = '*';
                    break;
                }
            }
            --invalidParentheses;
        }

        if(countL > countR){
            int diff = countL - countR;
            while (diff > 0){
                for (int i = 0; i < s.length(); i++) {
                    if(arr[i] == '('){
                        arr[i] = ' ';
                        break;
                    }
                }
                --diff;
            }
        } else {
            int diff = countR - countL;
            while (diff > 0) {

                for (int i = s.length() - 1; i > -1; i--) {
                    if (arr[i] == ')') {
                        arr[i] = ' ';
                        break;
                    }
                }
                --diff;
            }
        }

        return new String(arr).replace("*", "").replace(" ", "");

    }

    static String minRemoveToMakeValidNewIdea(String s) {
        int count =  0;
        int invalidParentheses =  0;

        char[] arr = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if(arr[i] == '('){
                count++;
            }else if(arr[i] == ')'){
                count--;
                if(count < 0) {
                    invalidParentheses++;
                }
            }
        }

        System.out.println(invalidParentheses);
        System.out.println(count);

        while (invalidParentheses > 0){
            System.out.println("So we have some redicules");
            for (int i = 0; i < s.length(); i++) {
                if(arr[i] == ')'){
                    arr[i] = '*';
                    break;
                }
            }
            --invalidParentheses;
        }

        if(count == 0) return new String(arr).replace("*", "");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println(count);
        System.out.println(invalidParentheses);

        while (count != 0){
            int indexToRemove = 0;
            boolean isL = count > 0;
            if(count > 0){
                //remove first ( from r to l
                for (int i = arr.length - 1; i > 0; i--) {
                    if(arr[i] == '('){
                        indexToRemove = i;
                        break;
                    }
                }
                count--;
            } else {
                //remove last ) from r to l
                for (int i = arr.length - 1; i > 0; i--) {
                    if(arr[i] == ')'){
                        indexToRemove = i;
                    }
                }
                count++;

            }

            arr[indexToRemove] = ' ';

        }

        return new String(arr).replace("*", "").replace(" ", "");

    }
/*
    static String minRemoveToMakeValidRecursive(String s, int il, int ri){
        char[] arr = s.toCharArray();
        for (int i = il, j = ri; i < s.length() && j > 0;) {

            if(arr[i] == '(' && arr[j] != ')') {
             il = i;
             ri = j;
             break;
            }
            if(arr[i] != '('){
                i++;
            }

            if(arr[j] != ')'){
                j--;
            }
        }
    }*/
}