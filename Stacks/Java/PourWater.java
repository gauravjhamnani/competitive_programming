public class PourWater {

    // https://leetcode.com/problems/pour-water/

    /**
     * @param heights: the height of the terrain
     * @param V: the index
     * @param K: the unit of water
     * @return: how much water is at each index
     */
    public int[] pourWater(int[] heights, int K, int V) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();
        int n = heights.length;
        updateLeftStack(heights, V - 1, left);
        updateRightStack(heights, V + 1, right);
        while (K > 0) {
            if (left.isEmpty() && right.isEmpty()) {
                heights[V]++;
                updateLeftStack(heights, V - 1, left);
                updateRightStack(heights, V + 1, right);
            } else if (left.isEmpty()) {
                int pos = right.pop();
                heights[pos]++;
                updateRightStack(heights, pos, right);
            } else {
                int pos = left.pop();
                heights[pos]++;
                updateLeftStack(heights, pos, left);
            }
            K--;
        }
        return heights;
    }

    public void updateLeftStack(int[] heights, int pos, Stack<Integer> left) {
        int n = heights.length;
        while (pos >= 0) {
            if ((pos + 1) >= n || heights[pos + 1] > heights[pos]) {
                left.push(pos);
            } else if (heights[pos] > heights[pos + 1]) {
                return;
            }
            pos--;
        }
    }

    public void updateRightStack(int[] heights, int pos, Stack<Integer> right) {
        int n = heights.length;
        while (pos < n) {
            if (pos <= 0 || heights[pos - 1] > heights[pos]) {
                right.push(pos);
            } else if (heights[pos] > heights[pos - 1]) {
                return;
            }
            pos++;
        }
    }
}