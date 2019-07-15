package stack;

import java.util.Stack;

public class ValidString {

    public static void main(String[] arg) {
        String s = "{([])}";
        //String s= "()[]{}";
        //String s = "(]";
        //String s = "([)]";
        //String  s= "{[]}";
        //String s= "(])";
        System.out.println(isValidString(s));

    }

    static boolean isValidString(String string) {
        if (string.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack();
        for (int i = 0; i < string.length(); i++) {

            if (string.charAt(i) == '(' || string.charAt(i) == '[' || string.charAt(i) == '{') {
                stack.push(new Character(string.charAt(i)));
            } else if (stack.isEmpty()) {
                return false;
            } else {
                Character ch = stack.pop();
                if (ch == '(' && string.charAt(i) != ')') {
                    return false;
                } else if (ch == '[' && string.charAt(i) != ']') {
                    return false;
                } else if (ch == '{' && string.charAt(i) != '}') {
                    return false;
                }
            }
        }
        return (stack.isEmpty());
    }


}
