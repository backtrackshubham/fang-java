package shubham.hackerrank.interview.warmup;


/**
 * There is a new mobile game that starts with consecutively numbered clouds.
 * Some of the clouds are thunderheads and others are cumulus.
 * The player can jump on any cumulus cloud having a number that is
 * equal to the number of the current cloud plus 1 or 2.
 * The player must avoid the thunderheads.
 * Determine the minimum number of jumps it will take to jump from the starting position to the last cloud. It is always possible to win the game.
 *
 * For each game, you will get an array of clouds numbered 0 if they are safe or 1 if they must be avoided.
 *
 * Example
 * c = [0,1,0,0,0,1,0]
 * Index the array from . The number on each cloud is its index in the list so the player must avoid the clouds at indices  and . They could follow these two paths:  or . The first path takes  jumps while the second takes . Return .
 */
public class JumpingOnTheClouds {
    static int jumpingOnClouds(int[] c) {
        //0 0 0 1 0 0
        int i = 0;
        int minMoves = 0;
        while (i != c.length - 1) {
            if (c[i + 1] == 1) {
                i = i + 2;
                minMoves++;
            } else {
                if (i + 2 < c.length && c[i + 2] == 0) {
                    i = i + 2;
                } else {
                    i++;
                }
                minMoves++;
            }
        }

        return minMoves;
    }
}