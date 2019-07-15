package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BufferedReaderInput {

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] input = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            int[] i1  = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            // method to be called
            tc--;
        }
    }
}
