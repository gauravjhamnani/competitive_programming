import java.util.*;

class TestClass {

    // https://www.hackerearth.com/practice/algorithms/graphs/topological-sort/tutorial/

    public static void dfs(Set<Integer>[] adjList, int curr, boolean[] visited, ArrayDeque<Integer> dq) {
        visited[curr] = true;
        for (Integer neigh : adjList[curr]) {
            if (!visited[neigh]) {
                dfs(adjList, neigh, visited, dq);
            }
        }
        dq.addFirst(curr);
    }


    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();                 
        int m = sc.nextInt();
        Set<Integer>[] adjList = new TreeSet[n];
        for (int i = 0 ; i < n ; i++) {
            adjList[i] = new TreeSet<>(Collections.reverseOrder());
        }
        for (int i = 0 ; i < m ; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            adjList[s - 1].add(d - 1);
        }
        boolean[] visited = new boolean[n];
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i =  n - 1 ; i >= 0 ; i--) {
            if (!visited[i]) {
                dfs(adjList, i, visited, dq);
            }
        }

        while (!dq.isEmpty()) {
            System.out.print((dq.removeFirst() + 1) + " ");
        }
    }
}