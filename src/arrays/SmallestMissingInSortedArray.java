package arrays;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SmallestMissingInSortedArray {

      public static  void  main(String[] ar) {
          Scanner sc = new Scanner(System.in);
          int T = sc.nextInt();
          for (int i = 0; i < T; i++) {
              int N = sc.nextInt();
              int M = sc.nextInt();
              int[] arr = new int[N];
              for (int j = 0; j < N; j++) {
                  arr[j] = sc.nextInt();
              }
              System.out.println(findSmallestMissingInSortedArray(arr,N,M));
          }
      }

      static  int findSmallestMissingInSortedArray(int[] arr,int N,int M) {
          for (int i = 0; i < M; i++) {
               int index = new SearchTwoDMatrix().binarySearch(arr,i);
               if (index == -1) {
                   return i;
              }
          }

          return -1;
      }
}
