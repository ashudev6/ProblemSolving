package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindFloor {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] strs1 = findNumbers(br);
            int N = Integer.parseInt(strs1[0]);
            int num = Integer.parseInt(strs1[1]);
            String[] strs2 = findNumbers(br);
            int[] arr = new int[N];
            for (int j =0;j<strs2.length;j++) {
                arr[j] = Integer.parseInt(strs2[j]);
            }
            System.out.println(findFloor(arr,num,N));
        }
    }

    public static String[] findNumbers(BufferedReader br) throws IOException {
        String line = br.readLine();
        return line.trim().split("\\s+");
    }

    static int findFloor(int[] arr,int num,int N) {
        int l=0;
        int r = N-1;
        int m = -1;
        while(r>=l) {
            m = (l+r)/2;
            if (arr[m] == num) {
                return m;
            } else if (arr[m] < num) {
                if ( m <N-1 && arr[m+1]<= num) {
                    l = m+1;
                } else {
                    return m ;
                }
            } else {
                r = m-1;
            }
        }
        return r ;
    }
}
