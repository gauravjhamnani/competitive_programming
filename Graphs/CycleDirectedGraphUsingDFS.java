class Solution {

    // https://leetcode.com/problems/course-schedule/

    public boolean canFinish(int n, int[][] pre) {
        List<Integer>[] adj = new List[n];
        for (int i = 0 ; i < n ; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0 ; i < pre.length ; i++) {
            adj[pre[i][0]].add(pre[i][1]);
        }
        boolean[] visited = new boolean[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        boolean[] stackMap = new boolean[n];
        for (int i = 0 ; i < n ; i++) {
            if (!visited[i]) {
                boolean res = dfs(adj, i, visited, stack, stackMap);
                if (res) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean dfs(List<Integer>[] adj, Integer curr, boolean[] visited, 
                        ArrayDeque<Integer> stack, boolean[] stackMap) {
        visited[curr] = true;
        stack.addFirst(curr);
        stackMap[curr] = true;
        for (int node : adj[curr]) {
            if (visited[node]) {
                if (stackMap[node]) {
                    return true;
                }
            } else {
                boolean res = dfs(adj, node, visited, stack, stackMap);
                if (res) {
                    return true;
                }
            }
        }
        stack.removeFirst();
        stackMap[curr] = false;
        return false;
    }
}