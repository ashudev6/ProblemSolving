package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NextLargerElement {

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] input = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            int[] i1  = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            printnextGreaterforEach(input);
            //printnextGreaterforEachBack(input);
            tc--;
        }
    }

    private static void printnextGreaterforEachBack(long[] input) {
        if (input.length == 0) {
            return;
        }

        long[] output = new long[input.length];
        Arrays.fill(output, -1);
        Stack<Integer> stack = new Stack<>();
        stack.push(input.length - 1);
        for (int i = input.length - 2; i > -1; i--) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else if (input[stack.peek()] > input[i]) {
                output[i] = input[stack.peek()];
                stack.push(i);
            } else {
                while (!stack.isEmpty() && input[stack.peek()] < input[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    output[i] = input[stack.peek()];
                }
                stack.push(i);
            }
        }

        for (Long i : output) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void printnextGreaterforEach(long[] input) {
        if (input.length == 0) {
            return;
        }

        long[] output = new long[input.length];
        Arrays.fill(output, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            if (stack.isEmpty() || input[stack.peek()] > input[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && input[stack.peek()] < input[i]) {
                    output[stack.pop()] = input[i];
                }
                stack.push(i);
            }
        }

        for (Long i : output) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


}
