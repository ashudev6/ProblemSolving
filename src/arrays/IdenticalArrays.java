package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class IdenticalArrays {

    public static void main(String[] ar) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] arr1 = new int[N];
            int[] arr2 = new int[N];
            for (int j = 0; j < N; j++) {
                arr1[j] = sc.nextInt();
            }
            for (int k = 0; k < N; k++) {
                arr2[k] = sc.nextInt();
            }
            System.out.println(findIdenticalArrays(arr1,arr2,N));

        }
    }

    static int findIdenticalArrays(int[] arr1,int[] arr2,int N) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (arr1[i] != arr2[i]) {
                return 0;
            } else {
                count++;
            }
        }
        if (count == N) {
            return 1;
        }
        return 0;
    }
}
