package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class TwoNumbersSumClosestZero {

    public static void main(String[] ar) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scan.nextInt();
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = scan.nextInt();
            }
            System.out.println(findTwoNumbersSumClosestZero(arr, N));


        }


    }

    static int findTwoNumbersSumClosestZero(int[] arr, int N) {
        int sum = 0;
        Arrays.sort(arr);
        if (N >= 2) {
            sum = arr[0] + arr[1];
            if (sum == 0) return sum;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (j != i) {
                        int s = arr[i] + arr[j];
                        if (s == 0) {
                            return s;
                        } else {
                            if (s < 0 && sum > 0) {
                                if (Math.abs(s + 0) <= sum - 0) {
                                    sum = s;
                                }
                            } else if (s < 0 && sum < 0) {
                                if (Math.abs(s + 0) < Math.abs(sum + 0)) {
                                    sum = s;
                                }
                            } else if (s > 0 && sum > 0) {
                                if ((s - 0) < sum - 0) {
                                    sum = s;
                                }
                            } else {
                                if ((s - 0) <= Math.abs(sum + 0)) {
                                    sum = s;
                                }
                            }
                        }

                    }

                }
            }
        } else if (N == 1) {
            sum = arr[0];
        }
        return sum;
    }


}
