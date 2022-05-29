package shubham.edu.dsalgo.companies.google.foobar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int solution(int src, int dest) {
        int[] srcTransformed = transform(src);
        int[] destTransformed = transform(dest);
        Map<String, Integer> hm = new HashMap<String, Integer>();
        hm.put(src + "-" + src, 0);
        hm.put(dest + "-" + dest, 0);
        minMoves(srcTransformed, destTransformed, 0, hm);
        return hm.getOrDefault("found", 0);
    }


    private static void minMoves(int[] src, int[] dest, int moves, Map<String, Integer> hm) {
        if (interpolate(src) == interpolate(dest)) {
            return;
        } else {
            if(hm.containsKey("found")) return;

            int[][] canMoveFromSrc = canMoveFromSrc(src);

            for (int[] nextMove : canMoveFromSrc) {
                if(interpolate(dest) == interpolate(nextMove)){
                    hm.put("found", moves+1);
                    return;
                }
            }

            for (int[] nextMove : canMoveFromSrc) {
                if(hm.containsKey("found")) return;
                if (hm.containsKey(interpolate(nextMove) + "-" + interpolate(src))) {
                    if (hm.get(interpolate(nextMove) + "-" + interpolate(src)) > moves + 1) {
                        hm.put(interpolate(nextMove) + "-" + interpolate(src), moves + 1);
                    }
                } else if (hm.containsKey(interpolate(src) + "-" + interpolate(nextMove))) {
                    if (hm.get(interpolate(src) + "-" + interpolate(nextMove)) > moves + 1) {
                        hm.put(interpolate(src) + "-" + interpolate(nextMove), moves + 1);
                    }
                } else {
                    hm.put(interpolate(nextMove) + "-" + interpolate(src), moves + 1);
                    minMoves(nextMove, dest, moves + 1, hm);
                }
            }
        }
    }

    private static int[][] canMoveFromSrc(int[] src) {

        Comparator<int[]> x = Comparator.comparingInt(o -> interpolate(o) - interpolate(src));
        ArrayList<int[]> al = new ArrayList();
        //upper left
        if (src[0] - 2 > -1 && src[1] - 1 > -1) {
            int[] nC = new int[]{src[0] - 2, src[1] - 1};
            al.add(nC);
        }
        //upper right
        if (src[0] - 2 > -1 && src[1] + 1 < 8) {
            int[] nC = new int[]{src[0] - 2, src[1] + 1};
            al.add(nC);
        }
        //left upper
        if (src[0] - 1 > -1 && src[1] - 2 > -1) {
            int[] nC = new int[]{src[0] - 1, src[1] - 2};
            al.add(nC);
        }
        //left lower
        if (src[0] + 1 < 8 && src[1] - 2 > -1) {
            int[] nC = new int[]{src[0] + 1, src[1] - 2};
            al.add(nC);
        }
        //lower left
        if (src[0] + 2 < 8 && src[1] - 1 > -1) {
            int[] nC = new int[]{src[0] + 2, src[1] - 1};
            al.add(nC);
        }

        //lower right
        if (src[0] + 2 < 8 && src[1] + 1 < 8) {
            int[] nC = new int[]{src[0] + 2, src[1] + 1};
            al.add(nC);
        }
        //right upper
        if (src[0] - 1 > -1 && src[1] + 2 < 8) {
            int[] nC = new int[]{src[0] - 1, src[1] + 2};
            al.add(nC);
        }

        //right lower
        if (src[0] + 1 > 8 && src[1] + 2 < 8) {
            int[] nC = new int[]{src[0] + 2, src[1] + 1};
            al.add(nC);
        }
        al.sort(x);
        int[][] arr = new int[al.size()][];
        return al.toArray(arr);
    }


    private static int[] transform(int point) {
        int row = point / 8;
        int col = point % 8;

        return new int[]{row, col};
    }

    private static int interpolate(int[] point) {
        return point[0] * 8 + point[1];
    }
}
