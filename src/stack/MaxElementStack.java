package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class MaxElementStack {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();
        while (N > 0) {
            int[] action = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (action.length == 2 && action[0] == 1) {
                if (st.isEmpty() || st.peek() < action[1]) {
                    st.push(action[1]);
                } else {
                    st.push(st.peek());
                }
            } else if (action.length == 1 && action[0] == 2 && !st.isEmpty()) {
                st.pop();
            } else if (action.length == 1 && action[0] == 3) {
                System.out.println(st.peek());
            }
            N--;
        }
    }


}
