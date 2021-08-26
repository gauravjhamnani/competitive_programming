class Solution {

    // https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'c') {
                if (size < 2 || (stack.pop() != 'b' || stack.pop() != 'a')) {
                    return false;
                } 
                size -= 2;
            } else {
                stack.push(ch);
                size++;
            }
        }
        return stack.isEmpty();
    }
}