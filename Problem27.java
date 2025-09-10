/*Day 27 of 30 🗓

Problem : Find the Shortest Path in an Unweighted Graph
You are given an unweighted graph represented by an adjacency list. Your task is to find the shortest path (in terms of the number of edges) between two given nodes in the graph.

Input :
* An integer V representing the number of vertices in the graph.
* A list of edges, where each edge connects two vertices of the graph.
* Two integers, start and end, representing the source and destination nodes respectively.
* V = 5, Edges = [[0, 1], [0, 2], [1, 3], [2, 3], [3, 4]], start = 0, end = 4

Output :
Return the shortest path length (number of edges) from start to end. If there is no path, return -1.
Output: 3
 */
import java.util.*;

public class Problem27 {

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {
            {0, 1}, {0, 2}, {1, 3}, {2, 3}, {3, 4}
        };
        int start = 0, end = 4;
        System.out.println(shortestPath(V, edges, start, end));
    }

    public static int shortestPath(int V, int[][] edges, int start, int end) {
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]); // since undirected
        }

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        int[] distance = new int[V];
        Arrays.fill(distance, -1);

        queue.offer(start);
        visited[start] = true;
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (node == end) {
                return distance[node]; // shortest path found
            }

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[node] + 1;
                    queue.offer(neighbor);
                }
            }
        }
        return -1; // if no path found
    }
}
