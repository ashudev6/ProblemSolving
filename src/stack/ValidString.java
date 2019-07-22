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
        //System.out.println(isValidString(s));
//        StringBuffer sb1 = new
//                StringBuffer("Welcome to Geeksforgeeks");
//        sb1.append('I');
//        System.out.println(sb1);
//        StringBuffer sb2 = new StringBuffer(String.valueOf('I'));
//        sb1 = new StringBuffer(String.valueOf('I')).append(sb1);
//        //sb1 = sb2.append(sb1);
//        System.out.println(sb1);

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
