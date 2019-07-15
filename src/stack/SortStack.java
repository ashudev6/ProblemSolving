package stack;

import java.util.Stack;

public class SortStack {

    private Stack<Integer> sortedPush(Stack<Integer> s, int value) {
        if (s.isEmpty() || s.peek() < value) {
            s.push(value);
            return s;
        } else {
            int y = s.pop();
            s = sortedPush(s, value);
            s.push(y);
            return s;
        }
    }

    public Stack<Integer> sort(Stack<Integer> s) {
        if (!s.isEmpty()) {
            int x = s.pop();
            sort(s);
            return sortedPush(s, x);
        }
        return s;
    }
}
