package shubham.edu.knoldus.leet.code.practice;

public class MinimumTimeVisitingAllPoints {
    public static void main(String[] args) {
        int[][] points = {{1,1},{3,4},{-1,0}};

        System.out.println(MinimumTimeVisitingAllPointsHelper.minTimeToVisitAllPoints(points));
    }
}

class MinimumTimeVisitingAllPointsHelper{
    static int minTimeToVisitAllPoints(int[][] points) {
        int sum = 0;
        for (int i = 0; i < points.length - 1; i++) {
            sum += Math.abs(Math.abs(points[i][0] - points[i +1][0]) - Math.abs(points[i][1] - points[i +1][1])) +
                    Math.min(Math.abs(points[i][0] - points[i +1][0]) ,Math.abs(points[i][1] - points[i +1][1]));
        }
        return sum;
    }

    static int diffBetweenPoints(int[] x1y1, int[] x2y2){
        if(x1y1[0] == x2y2[0]){
            return x1y1[1] >= x2y2[1] ? x1y1[1] - x2y2[1] :  x2y2[1] - x1y1[1];
        } else if(x1y1[1] == x2y2[1]){
            return x1y1[0] >= x2y2[0] ? x1y1[0] - x2y2[0] :  x2y2[0] - x1y1[0];
        } else {
            int sum = 0;
            int stepsToTravel = Math.abs(x1y1[0] - x2y2[0]) + Math.abs(x2y2[1] - x1y1[1]);
            while (x1y1[0] != x2y2[0] && x1y1[1] != x2y2[1]){
                x1y1[0] = x1y1[0] > x2y2[0] ? x1y1[0] - 1 : x1y1[0] + 1;
                x1y1[1] = x1y1[1] > x2y2[1] ? x1y1[1] - 1 : x1y1[1] + 1;
                stepsToTravel-=2;
                sum++;
             }
            return sum + stepsToTravel;
        }
    }
}
