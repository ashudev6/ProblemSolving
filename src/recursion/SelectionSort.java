package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] ar) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        selectionSortRec(arr,0);
        for (int k:arr
             ) {
            System.out.println(k);

        }


    }




    static void selectionSortRec(int[] arr, int s) {
        if (s == arr.length-1) return;
        if (s< arr.length-1){
            int min_index = findMinIndex(arr,s);
            //System.out.println("min element:" + arr[min_index]);
            if (min_index!=-1 && arr[s]>arr[min_index] ) {
                int temp = arr[s];
                arr[s] = arr[min_index];
                arr[min_index] = temp;
            }
            selectionSortRec(arr,s+1);
        }

    }

    static int findMinIndex(int[] arr,int beg) {
        if (beg<arr.length-1) {
            int min = arr[beg];
            int min_index = beg;
            for (int i = beg; i < arr.length ; i++) {
                if (arr[i]<min) {
                    min = arr[i];
                    min_index= i;
                }
            }
            return min_index;
        }
        return -1;
    }
}
