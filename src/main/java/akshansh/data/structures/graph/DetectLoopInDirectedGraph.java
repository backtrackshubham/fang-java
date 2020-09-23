package akshansh.data.structures.graph;

import java.util.ArrayList;
import java.util.List;

public class DetectLoopInDirectedGraph {

    static boolean[] visited;
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V)
    {
        // add your code here
        visited = new boolean[V];

        for (int i=0 ; i<V ; i++) {
            if (!visited[i]) {
                if (isCyclic(adj, new ArrayList<>(), i)) {
                    return true;
                }
            }
        }

        return false;
    }

    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, List<Integer> visitedNodes, int start) {
        visited[start] = true;
        if (visitedNodes.contains(start)) {
            return true;
        }

        List<Integer> newVisitedNodes = new ArrayList<>(visitedNodes);
        newVisitedNodes.add(start);

        List<Integer> nextVertices = adj.get(start);

        for (int i=0 ; i<nextVertices.size() ; i++) {
            if (isCyclic(adj, newVisitedNodes, nextVertices.get(i))) {
                return true;
            }
        }

        return false;
    }
}
