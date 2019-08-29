package dp;

import java.util.HashMap;

public class FibonacciSeries {

    private static HashMap<Integer,Long> fibtable;

    public static void main(String[] args) {
        int n = 15;
        System.out.format("%sth Fibonacci number is: %s\n", n, fibRec(n));
        // Fill the base cases
        fibtable = new HashMap<>();
        System.out.format("%sth Fibonacci number is: %s\n", n, fibDPRec(n));
        System.out.format("%sth Fibonacci number is: %s\n", n, fibDPBottomUp(n));
    }

    private static long fibRec(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibRec(n - 1) + fibRec(n - 2);
        }
    }

    private static long fibDPRec(int n) {

        if (n == 0 || n == 1) {
            return n;
        }
        if (fibtable.containsKey(n)) {
            //System.out.println("key: " +  n + "value: "+ fibtable.get(n));
            return fibtable.get(n);
        } else {
            long x = fibDPRec(n - 1);
            long y = fibDPRec(n - 2);
            fibtable.put(n, x + y);
            return x + y;
        }
    }

    private static long fibDPBottomUp(int n) {
        HashMap<Integer, Long> fibTable = new HashMap<>();
        // Filling up the base cases
        fibTable.put(0, 0L);
        fibTable.put(1, 1L);
        for (int i = 2; i <= n; i++) {
            fibTable.put(i, fibTable.get(i - 1) + fibTable.get(i - 2));
            fibTable.remove(i - 2);
        }
        return fibTable.get(n);
    }
}
