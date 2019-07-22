package queues;

public class BinaryStringBelowN {

    public static void main(String[] ar) {
        int N = 10;
        for (int i = 1; i <=N; i++) {
            printBinaryStringBelowN(i);

        }

    }

    static void printBinaryStringBelowN(int N) {
        StringBuffer sb = new StringBuffer();
        while (N > 0) {
            int x = N % 2;
            String y = String.valueOf(x);
            sb= new StringBuffer(y).append(sb);
            N = N / 2;

        }
        System.out.println(sb.toString());




    }
}
