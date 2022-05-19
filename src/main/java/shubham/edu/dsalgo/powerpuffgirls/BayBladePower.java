package shubham.edu.dsalgo.powerpuffgirls;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class BayBladePower {
    public static void main(String[] args) {
        int testcases;
        Scanner s = new Scanner(System.in);
        testcases = Integer.parseInt(s.nextLine());

        for (int i = 0; i < testcases; i++) {

            Integer numPlayer = Integer.parseInt(s.nextLine());
            String[] teamGrevo = s.nextLine().split(" ");
            String[] teamOppo = s.nextLine().split(" ");
            Long[] teamGrevoArr = new Long[numPlayer];
            Long[] teamOppoArr = new Long[numPlayer];

            for (int j = 0; j < numPlayer; j++) {
                teamGrevoArr[j] = Long.parseLong(teamGrevo[j]);
                teamOppoArr[j] = Long.parseLong(teamOppo[j]);
            }

            System.out.println(winFightsInOptimalManner(numPlayer,
                    teamGrevoArr,
                    teamOppoArr
            ));
        }
    }

    public static Integer winFightsInOptimalManner(Integer playes,Long[] gRevoTeam, Long[] oppoTeam) {
        Map<Integer, Long> opMp = new HashMap<>();
        for (int i = 0; i < oppoTeam.length; i++) {
            opMp.put(i, oppoTeam[i]);
        }
        System.out.println(opMp);
        Integer maxWins = 0;

        for (Long grev: gRevoTeam) {
            Long minDiff = grev;
            int minIndex = 0;
            boolean foundElement = false;
            for (Entry<Integer, Long> entry : opMp.entrySet()) {
                // System.out.println("Traversing");
                if(entry.getValue() < grev){
                    // System.out.println("Entered for "+ entry.getValue()+" "+ grev);
                    if(minDiff > grev - entry.getValue()){
                        // System.out.println("Entered value");
                        minIndex = entry.getKey();
                        maxWins++;
                        foundElement = true;
                        minDiff = grev - entry.getValue();
                    }
                }
            }

            if(foundElement) {
                System.out.println(grev + " Will fight "+opMp.get(minIndex));
                opMp.remove(minIndex);
            }
        }
        return maxWins;
    }
}
