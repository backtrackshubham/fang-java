package akshansh.data.structures.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1/
 */
public class DetectLoopInUndirectedGraph {

    static boolean[] visited;
    static boolean isCyclic(ArrayList<ArrayList<Integer>> g, int V)
    {
        // add your code here
        visited = new boolean[V];

        for (int i=0 ; i<V ; i++) {
            if (!visited[i]) {
                if (isCyclic(g, new ArrayList<>(), i, null)) {
                    return true;
                }
            }
        }

        return false;
    }

    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, List<Integer> visitedNodes, int start, Integer previous) {
        visited[start] = true;

        if (visitedNodes.contains(start)) {
            return true;
        }

        List<Integer> newVisitedNodes = new ArrayList<>(visitedNodes);
        newVisitedNodes.add(start);

        List<Integer> nextVertices = adj.get(start);

        for (int i=0 ; i<nextVertices.size() ; i++) {
            Integer nextVertex = nextVertices.get(i);
            if (!nextVertex.equals(previous)) {

                if (isCyclic(adj, newVisitedNodes, nextVertex, start)) {
                    return true;
                }
            }
        }

        return false;
    }
}
