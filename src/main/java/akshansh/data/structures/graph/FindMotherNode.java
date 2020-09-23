package akshansh.data.structures.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://practice.geeksforgeeks.org/problems/mother-vertex/1
 */
public class FindMotherNode {

    static boolean[] visited1;
    static int findMother(ArrayList<ArrayList<Integer>> g, int n) {
        // add your code here
        visited1 = new boolean[n];

        for (int i=0 ; i<n ; i++) {
            if (!visited1[i]) {
                List<Integer> nodesDiscovered = dfs(g, n, i);
                if (nodesDiscovered.size() == n) {
                    return i;
                }
            }
        }

        return -1;
    }

    static List<Integer> dfs(ArrayList<ArrayList<Integer>> g, int n, int start) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];
        List<Integer> result = new ArrayList<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            Integer vertex = stack.pop();

            if (!visited[vertex]) {
                visited[vertex] = true;
                visited1[vertex] = true;
                result.add(vertex);
                ArrayList<Integer> nextVertices = g.get(vertex);

                for (int i=nextVertices.size() - 1 ; i>=0 ; i--) {
                    Integer nextVertex = nextVertices.get(i);
                    if (!visited[nextVertex]) {
                        stack.push(nextVertex);
                    }
                }
            }
        }

        return result;
    }
}
