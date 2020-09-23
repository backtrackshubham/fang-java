package akshansh.data.structures.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * https://practice.geeksforgeeks.org/problems/print-adjacency-list/0
 */
public class PrintAdjacencyList {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            String[] veStr = reader.readLine().split(" ");
            int v = Integer.parseInt(veStr[0]);
            int e = Integer.parseInt(veStr[1]);

            List<List<Integer>> adjacencyList = new ArrayList<>(v);

            for (int j = 0; j < v; j++) {
                adjacencyList.add(new ArrayList<>());
            }

            for (int j = 0; j < e; j++) {
                String[] edgeStr = reader.readLine().split(" ");
                int v1 = Integer.parseInt(edgeStr[0]);
                int v2 = Integer.parseInt(edgeStr[1]);
                List<Integer> v1AdjList = adjacencyList.get(v1);
                v1AdjList.add(v2);

                List<Integer> v2AdjList = adjacencyList.get(v2);
                v2AdjList.add(v1);
            }

            for (int j = 0; j < v; j++) {
                List<Integer> vAdjList = adjacencyList.get(j);
                StringBuilder adjListStr = new StringBuilder();
                adjListStr.append(j);

                for (int k = 0; k < vAdjList.size(); k++) {
                    adjListStr.append(" -> ").append(vAdjList.get(k));
                }

                System.out.println(adjListStr);
            }
        }
    }
}
