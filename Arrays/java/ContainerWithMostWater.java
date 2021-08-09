class ContainerWithMostWater {
    
    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
        
    class Sort implements Comparator<Point> {
        @Override
        public int compare(Point a, Point b) {
            return a.y - b.y;
        }
    }
        
    public int maxArea(int[] height) {
        int n = height.length;
        Point[] a = new Point[n];
        for (int i = 0 ; i < n ; i++) {
            a[i] = new Point(i, height[i]);
        }
        Arrays.sort(a, new Sort());
        int[] max = new int[n + 1];
        int[] min = new int[n + 1];
        min[n] = 10001;
        for (int i = n - 1 ; i >= 0 ; i--) {
            min[i] = Math.min(min[i + 1], a[i].x);
            max[i] = Math.max(max[i + 1], a[i].x);
        }
        int i = 0;
        int ans = 0;
        while (i < n) {
            int minIdx = min[i], maxIdx = max[i];
            do {
                ans = Math.max(ans, Math.max(Math.abs(a[i].x - minIdx), Math.abs(a[i].x - maxIdx)) * a[i].y);
                i++;
            } while (i < n && (a[i].y == a[i - 1].y));
        }
        return ans;
    }
}