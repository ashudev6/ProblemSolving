package interviews;

import java.util.HashMap;
import java.util.Map;

public class FindPairSumCount {

    public static void main(String[] ar) {
        int[] arr = {2,7,1,3,4,6,6};
        System.out.println(doFindPairSumCount(arr,10));
    }

    static int doFindPairSumCount(int[] arr,int k) {
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
             if (arr[i]<=k) {
                 if (map.containsKey(k-arr[i])) {
                     count++;
                 }
                 map.put(arr[i],k-arr[i]);
             }
        }
        return count;
    }
}
