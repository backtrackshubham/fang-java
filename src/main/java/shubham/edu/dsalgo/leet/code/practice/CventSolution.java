package shubham.edu.dsalgo.leet.code.practice;

public class CventSolution {

    static int[] solution(int[] A, int F, int M) {
        int sumIremember = 0;

        for (int i = 0; i < A.length; i++) {
            sumIremember += A[i];
        }

        int sumIDontRemember = (M * (A.length + F)) - sumIremember;

        int[] forg = new int[F];

        int resultToTake = 6;
        int i = 0;
        while (sumIDontRemember > 0) {
            if (resultToTake >= sumIDontRemember) {
                sumIDontRemember -= resultToTake;
            }
            forg[i++] = resultToTake;
            if (i == forg.length && sumIDontRemember != 0) {

            }
        }
        return A;
    }
}

