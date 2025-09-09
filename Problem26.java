public class Problem26 {

    // Disjoint Set Union (Union-Find) class
    static class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        // Find with path compression
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        // Union by rank
        boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) return false; // cycle detected

            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
    }

    // Function to detect cycle
    public static boolean hasCycle(int V, int[][] edges) {
        DSU dsu = new DSU(V);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (!dsu.union(u, v)) {
                return true; // Cycle found
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {
            {0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 0}
        };

        System.out.println(hasCycle(V, edges)); // true
    }
}
