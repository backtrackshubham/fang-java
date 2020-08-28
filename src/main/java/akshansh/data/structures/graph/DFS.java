package akshansh.data.structures.graph;

import java.util.ArrayList;
import java.util.Stack;

public class DFS {

    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> g, int N) {
        // add your code here
        boolean[] visited = new boolean[N];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        ArrayList<Integer> result = new ArrayList<>();

        while (!stack.isEmpty()) {
            int currVertex = stack.pop();

            if (!visited[currVertex]) {
                visited[currVertex] = true;
                result.add(currVertex);
                ArrayList<Integer> nextVertices = g.get(currVertex);

                for (int i = nextVertices.size() - 1; i >= 0; i--) {
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
