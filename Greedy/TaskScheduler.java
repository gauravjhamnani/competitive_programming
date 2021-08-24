class TaskScheduler {
    
    // https://leetcode.com/problems/task-scheduler/

    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;    
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(26, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        for (int i = 0 ; i < 26 ; i++) {
            if (freq[i] != 0) {
                pq.add(freq[i]);
            }
        }
        int ans = 0, lastItr = 0;
        while (!pq.isEmpty()) {
            int cnt = Math.min(n + 1, pq.size());
            ans += n + 1;
            lastItr = 0;
            List<Integer> aux = new ArrayList<>();  
            while (cnt > 0) {
                int el  = pq.poll();
                if (el > 1) {
                    aux.add(el - 1);
                }
                cnt--;
                lastItr++;
            }
            for (int i : aux) {
                pq.add(i);
            }
        }
        return ans + lastItr - n - 1;
    }
}











