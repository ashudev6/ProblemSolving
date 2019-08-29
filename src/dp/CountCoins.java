package dp;

import  java.util.*;
public class CountCoins {

    private static HashMap<String, Integer> fibTable;



    public  static void main(String[] ar) {
        int[] arr = {1,4,2};
        int n = 5;
        System.out.println(countCoinsRec(arr,arr.length-1,n));
        fibTable = new HashMap<>();
        System.out.println(countCoinDP(arr,arr.length-1,n));
//        System.out.println(fibTable +  "size :" +fibTable.size());
        System.out.println(countCoinDPBottomUP(arr,arr.length,n));

    }

    static int update (HashMap<String,String> map) {
        map.put("Plant","as1");
        map.put("Mat","we21");
        return  0;
    }

    static int countCoinsRec(int[] arr,int index,int n) {
        if (n == 0) return 1;
        if (index <0 || n<0) return 0;
        return countCoinsRec(arr,index,n-arr[index])+ countCoinsRec(arr,index-1,n);

    }

    static  int countCoinDP(int[] coins, int index, int n) {

        if (index < 0 || n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        }
        String key = index + ":" + n;
        if (fibTable.containsKey(key)) {
            return fibTable.get(key);
        }
        int x = countCoinDP(coins, index - 1, n);
        int y = countCoinDP(coins, index, n - coins[index]);
        fibTable.put(key, x + y);
        return x + y;
    }

    private static int countCoinDPBottomUP(int[] coins, int index, int n) {
        int i, j, x, y;

        // We need n+1 rows as the table
        // is constructed in bottom up
        // manner using the base case 0
        // value case (n = 0)
        int[][] table = new int[n + 1][index];

        // Fill the enteries for 0
        // value case (n = 0)
        for (i = 0; i < index; i++)
            table[0][i] = 1;

        // Fill rest of the table entries
        // in bottom up manner
        for (i = 1; i < n + 1; i++) {
            for (j = 0; j < index; j++) {
                // Count of solutions including S[j]
                x = (i - coins[j] >= 0) ? table[i - coins[j]][j] : 0;

                // Count of solutions excluding S[j]
                y = (j >= 1) ? table[i][j - 1] : 0;

                // total count
                table[i][j] = x + y;
            }
            System.out.println(Arrays.toString(table[i]));
        }
        System.out.println(Arrays.toString(table));
        return table[n][index - 1];
    }
}
