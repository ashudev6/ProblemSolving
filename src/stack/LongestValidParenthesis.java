package stack;

import java.util.Stack;

public class LongestValidParenthesis {

    public int longestValidParentheses(String s) {

        if (s.length() <= 1) {
            return 0;
        }
        int maxValue = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                int x = stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxValue = Integer.max(maxValue, i - stack.peek());
                }
            }
        }

        return maxValue;

    }
}
