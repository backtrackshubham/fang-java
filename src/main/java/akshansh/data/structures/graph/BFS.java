package akshansh.data.structures.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1/
 */
public class BFS {

    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> g, int N) {
        // add your code here

        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        ArrayList<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int currVertex = queue.remove();
            if (!visited[currVertex]) {
                result.add(currVertex);
                visited[currVertex] = true;

                ArrayList<Integer> currNextVertices = g.get(currVertex);
                for (int i=0 ; i<currNextVertices.size() ; i++) {
                    int nextVertex = currNextVertices.get(i);
                    if (!visited[nextVertex]) {
                        queue.add(nextVertex);
                    }
                }
            }
        }

        return result;
    }
}
