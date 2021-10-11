class Pair {
    int curr;
    int parent;
    public Pair(int a, int b) {
        curr = a;
        parent = b;
    }
}

class Solution {
    // Function to detect cycle in an undirected graph.
    
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        ArrayDeque<Pair> q = new ArrayDeque<>();
        for (int i = 0 ; i < V ; i++) {
            if (!visited[i]) {
                q.addLast(new Pair(i, -1));
                while (!q.isEmpty()) {
                    Pair front = q.removeFirst();
                    int node = front.curr;
                    int parent = front.parent;
                    // System.out.println("parent " + node);
                    visited[node] = true;
                    for (Integer neigh : adj.get(node)) {
                        if (neigh != parent) {
                            if (visited[neigh]) {
                                // System.out.println(neigh);
                                return true;
                            } else {
                                q.addLast(new Pair(neigh, node));
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}