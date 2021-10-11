class Solution {
    // Function to detect cycle in an undirected graph.
    
    private boolean isCycleFound = false;
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0 ; i < V ; i++) {
            if (!visited[i]) {
                dfs(adj, i, -1, visited);
                if (isCycleFound) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private void dfs(ArrayList<ArrayList<Integer>> adj, int curr, int prev, boolean[] visited) {
        if (isCycleFound) {
            return;
        }
        visited[curr] = true;
        for (int nodes : adj.get(curr)) {
            if (nodes != prev) {
                if (visited[nodes]) {
                    isCycleFound = true;
                    return;
                } else {
                    dfs(adj, nodes, curr, visited);
                }
            }
        }
    }
    
}