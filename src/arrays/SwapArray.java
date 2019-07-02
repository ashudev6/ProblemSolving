package arrays;
import java.util.*;
import java.lang.*;
import java.io.*;

public class SwapArray {

    public  static  void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();
        while(testCase-- > 0) {
            int length = scan.nextInt();
            int[]arr = new int[length];
            for (int i=0;i<length;i++) {
                arr[i] = scan.nextInt();

            }
            //System.out.println(Arrays.toString(arr));
            System.out.println(Arrays.toString(swapArray(arr,length)));

        }
    }

    static int [] swapArray(int[] arr,int l) {
        for (int i = 0;i<l-2;i++) {
            int temp = 0;
            temp = arr[i];
            arr[i] = arr[i+2];
            arr[i+2] = temp;
        }
        return arr;

    }
}
