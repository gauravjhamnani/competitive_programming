class Solution {

    // https://leetcode.com/problems/valid-parentheses

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (isClosing(s.charAt(i))) {
                if (stack.isEmpty() || !isAMatch(stack.pop(), s.charAt(i))) {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
    
    private boolean isClosing(char ch) {
        return (ch == ')' || ch == ']' || ch == '}');
    }
    
    private boolean isAMatch(char op, char cl) {
        return (op == '(' && cl == ')')  ||
            (op == '[' && cl == ']') ||
            (op == '{' && cl == '}');
    }
}
   








