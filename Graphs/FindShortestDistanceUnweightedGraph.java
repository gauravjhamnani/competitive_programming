class Solution {
    // Function to detect cycle in an undirected graph.
    
    
    public int[] findShortestDistanceUnweightedGraph(int source, List<List<Integer>> adj) {
        int V = adj.size();
        int[] distance = new int[V];
        Arrays.fill(distance, -1);
        distance[source] = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.addLast(source);
        int currDist = 1;
        while (!q.empty()) {
            int currSize = q.size();
            while (currSize > 0) {
                int curr = q.removeFirst();
                for (int nodes : adj.get(curr)) {
                    if (distance[nodes] == -1) {
                        distance[nodes] = currDist;
                        q.addLast(nodes);
                    }
                }
                currSize--;
            }
            currDist++;
        }
        return distance;
    } 
}