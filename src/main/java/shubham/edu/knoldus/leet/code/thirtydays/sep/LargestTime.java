package shubham.edu.knoldus.leet.code.thirtydays.sep;

public class LargestTime {
    public static void main(String[] args) {
        int [] x = {2,0,6,6};
        System.out.println(computeLargestTime(x));
    }

    static String computeLargestTime(int[] digitsArray){
        String answer = "";
        int index = 0;
        int[] indexOccupied = {0,0,0,0};
        while (index < 4){
            if(index == 0){ //check for hour ten's digit
                System.out.println("Answer so far " + answer);
                String candidateIndex = "";
                for (int i = 0; i < digitsArray.length; i++) {
                    if(digitsArray[i] > -1 && digitsArray[i] < 3 ){
                        candidateIndex+=(i+" ");
                    }
                }
                if(candidateIndex.isEmpty()){
                    return "";
                } else {
                    String[] candidates = candidateIndex.split(" ");
                    int maxIndex = Integer.parseInt(candidates[0]);
                    for (String can: candidates
                    ) {
                        if(digitsArray[Integer.parseInt(can)] > digitsArray[maxIndex]){
                            maxIndex =  Integer.parseInt(can);
                        }
                    }
                    System.out.println("max index " + maxIndex);
                    indexOccupied[maxIndex] = 1;
                    answer+=(digitsArray[maxIndex]);
                    index++;
                }
            } else if(index == 1) { //check unit digit for hour x : 0 <= x <= 3
                String candidateIndex = "";
                if(Integer.parseInt(answer) == 0 || Integer.parseInt(answer) == 1){
                    System.out.println("Answer is 0 or 1");
                    for (int i = 0; i < digitsArray.length; i++) {
                        if(digitsArray[i] > -1 && digitsArray[i] < 10){
                            if(indexOccupied[i] != 1){
                                candidateIndex+=( i+" ");
                            }
                        }
                    }
                } else {
                    for (int i = 0; i < digitsArray.length; i++) {
                        if(digitsArray[i] > -1 && digitsArray[i] < 4){
                            if(indexOccupied[i] != 1){
                                candidateIndex+=(i+" ");
                            }
                        }
                    }
                }

                if(candidateIndex.isEmpty()){
                    return "";
                } else {
                    String[] candidates = candidateIndex.split(" ");
                    int maxIndex = Integer.parseInt(candidates[0]);
                    for (String can: candidates
                    ) {
                        if(digitsArray[Integer.parseInt(can)] > digitsArray[maxIndex]){
                            maxIndex =  Integer.parseInt(can);
                        }
                    }
                    indexOccupied[maxIndex] = 1;
                    answer+=(digitsArray[maxIndex]);
                    index++;
                }
            } else if(index == 2) { //check ten's digit for minute x : 0 <= x <= 6
                System.out.println("Answer so far " + answer);

                String candidateIndex = "";
                for (int i = 0; i < digitsArray.length; i++) {
                    if(digitsArray[i] > -1 && digitsArray[i] < 6){
                        if(indexOccupied[i] != 1){
                            candidateIndex+=(i+" ");
                        }
                    }
                }
                if(candidateIndex.isEmpty()){
                    return "";
                } else {
                    String[] candidates = candidateIndex.split(" ");
                    int maxIndex = Integer.parseInt(candidates[0]);
                    for (String can: candidates
                    ) {
                        if(digitsArray[Integer.parseInt(can)] > digitsArray[maxIndex]){
                            maxIndex =  Integer.parseInt(can);
                        }
                    }
                    indexOccupied[maxIndex] = 1;
                    answer+=(":"+digitsArray[maxIndex]);
                    index++;
                }
            } else if(index == 3) { //check ten's digit for minute x : 0 <= x <= 9
                System.out.println("Answer so far " + answer);

                String candidateIndex = "";
                for (int i = 0; i < digitsArray.length; i++) {
                    if(digitsArray[i] > -1 && digitsArray[i] < 10){
                        if(indexOccupied[i] != 1){
                            candidateIndex+=(i+" ");
                        }
                    }
                }
                if(candidateIndex.isEmpty()){
                    return "";
                } else {
                    String[] candidates = candidateIndex.split(" ");
                    int maxIndex = Integer.parseInt(candidates[0]);
                    for (String can: candidates
                    ) {
                        if(digitsArray[Integer.parseInt(can)] > digitsArray[maxIndex]){
                            maxIndex =  Integer.parseInt(can);
                        }
                    }
                    indexOccupied[maxIndex] = 1;
                    answer+=(digitsArray[maxIndex]);
                    index++;
                }
            }else {
                return "";
            }
        }

        return answer;
    }

}
