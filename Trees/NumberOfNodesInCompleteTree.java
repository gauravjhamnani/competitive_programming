class NumberOfNodesInCompleteTree {

    // https://leetcode.com/problems/count-complete-tree-nodes
    
    public int countNodes(TreeNode root) {
        int ans = 0;
        int height = calcLeftHeight(root);
        int depth = 0;
        while (root != null) {
            depth++;
            int secondHalfHeight = calcLeftHeight(root.right);
            ans += 1 << secondHalfHeight;
            if (height == (secondHalfHeight + depth)) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return ans;
    }
    
    private int calcLeftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            node = node.left;
            height++;
        }
        return height;
    }
}