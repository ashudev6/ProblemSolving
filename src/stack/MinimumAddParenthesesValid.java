package stack;

import java.util.Stack;

public class MinimumAddParenthesesValid {


    public static void main(String[] arg) {

//        String s = "())";
//            String s= "(((";
//            String s = "()";
            String s = "()))((";
        System.out.println(minAddToMakeValid(s));


    }

    static int minAddToMakeValid(String S) {
        if (S.length() == 0) {
            return 0;
        }

        Stack<Character> stack = new Stack<>();
        for (Character ch: S.toCharArray()) {
            if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.size();

    }



}
