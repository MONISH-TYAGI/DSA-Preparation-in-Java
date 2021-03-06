//https://leetcode.com/problems/find-if-path-exists-in-graph/
class Graph {
    public ArrayList<Integer>[] adj;

    Graph(int n) {
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int src, int dest) {
        adj[src].add(dest);
        adj[dest].add(src);
    }

    public boolean DFS(int src, int dest, boolean[] vis) {
        if (src == dest)
            return true;
        if (vis[src] == true)
            return false;
        vis[src] = true;

        // Looping on Adjacency List at Index = Src
        for (int nbr : adj[src]) {
            if (DFS(nbr, dest, vis) == true)
                return true;
        }

        return false;
    }

    public boolean DFS(int src, int dest) {
        boolean[] vis = new boolean[adj.length];
        return DFS(src, dest, vis);
    }
}

class Solution {
    // Time - O(N + E) Where N = Number of Vertices, E = Number of Edges
    // Space - O(N + E) Input Space (Adjacency List)
    // - O(N) Extra Space (Visited Array), O(N) Recursion Call Stack Space
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Graph g = new Graph(n);
        for (int i = 0; i < edges.length; i++) {
            g.addEdge(edges[i][0], edges[i][1]);
        }

        return g.DFS(source, destination);
    }
}