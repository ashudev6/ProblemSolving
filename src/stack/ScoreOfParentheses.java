package stack;

import java.util.Stack;

public class ScoreOfParentheses {

    public static void main(String[] ar) {
        String S = "()";
        String S1 = "(())";
        String S2 = "()()";

//        System.out.println(scoreOfParentheses(S));
//        System.out.println(scoreOfParentheses(S1));
//        System.out.println(scoreOfParentheses(S2));
        String S3 = "(()(()))";
        System.out.println(scoreOfParentheses(S3));
    }

    static int scoreOfParentheses(String S) {
        if (S.length() == 2) return 1;
        Stack<Character> st = new Stack<>();
        StringBuffer exp = new StringBuffer();
        for (int i = 0; i < S.length(); i++) {
            st.push(S.charAt(i));
        }
        StringBuffer strA = new StringBuffer(String.valueOf('A'));
        while (!st.isEmpty()) {
            Character val = st.pop();
            StringBuffer strVal = new StringBuffer(String.valueOf(val));
            if (!st.isEmpty()) {
                if ((st.peek() == '(' && val == ')') || (st.peek() == ')' && val == '(')) {
                    exp = strA.append(exp);
                    st.pop();
                } else {
                    exp = exp.append(strVal);

                }
            } else {
                exp = strVal.append(exp);
            }

        }
        System.out.println(exp);
        return  0;
    }
}
