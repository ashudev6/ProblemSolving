package arrays;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SearchPairDifferenceArray {

    public static void main(String[] ar) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int L = sc.nextInt();
            int N = sc.nextInt();
            int[] arr = new int[L];
            for (int j = 0; j < L; j++) {
                arr[j] = sc.nextInt();
            }
            System.out.println(findSearchPairDifferenceArray(arr,N));
        }
    }

    static int findSearchPairDifferenceArray(int[] arr,int N) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i]+N) || set.contains(arr[i]-N)){
                return 1;
            } else {
              set.add(arr[i]);
            }
        }
        return  -1;
    }

}
