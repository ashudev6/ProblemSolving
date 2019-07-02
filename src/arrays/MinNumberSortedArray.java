package arrays;

import java.util.Scanner;

public class MinNumberSortedArray {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0;t<T;t++) {
            int N= sc.nextInt();
            int[] arr = new int[N];
            for (int i=0;i<N;i++) {
                arr[i] = sc.nextInt();
            }
            findShortestNumIndexHelper(arr);

        }

    }

    static void findShortestNumIndexHelper(int[] arr) {
        int shortestNumIndex = findShortestNumIndex(arr);
        if (shortestNumIndex!=-1 ) {
            if (shortestNumIndex == arr.length-1 && arr[shortestNumIndex] >= arr[0]) {
                System.out.println(arr[0]);
            } else {
                System.out.println(arr[shortestNumIndex]);
            }

        }
    }

    static int findShortestNumIndex(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        int m = 0;
        while (r >= l) {
            m = (r + l) / 2;
            if (m == 0) {
                return 1;
            }
            if (arr[l] == arr[r]) {
                return l;
            }
            if (arr[m] < arr[m - 1] && arr[m] < arr[m + 1]) {
                return m;
            } else if (arr[m] > arr[m - 1] && arr[m] > arr[m + 1]) {
                return m + 1;
            } else if (arr[m] > arr[m - 1] && arr[m] < arr[m + 1]) {
                if (findDirection(arr, m)) {
                    r = m - 1;

                } else {

                    l = m + 1;
                }
            }

        }
        return -1;

    }

    static boolean findDirection(int[] arr, int index) {
        boolean left = false;
        if (arr[0] > arr[index]) {
            left = true;
        } else {
            return left;
        }

        return left;
    }
}
