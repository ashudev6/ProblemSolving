package recursion;

public class MaxMinValueArray {

    public static void main(String[] ar) {
        int[] arr = {1000,200,36000,-15,60,12};
        System.out.println(findMaxValueArray(arr,6));
        System.out.println(findMinValueArray(arr,6));
    }

    static int findMaxValueArray(int[] arr,int len) {
        if (len == 0) return arr[0];
        return findMax(findMaxValueArray(arr,len-1), arr[len-1]);

    }
    static  int findMax(int n1,int n2) {
        return  n1>n2?n1:n2;
    }

    static int findMinValueArray(int[] arr,int len) {
        if (len == 0) return arr[0];
        return findMin(findMinValueArray(arr,len-1), arr[len-1]);

    }
    static  int findMin(int n1,int n2) {
        return  n1>n2?n2:n1;
    }
}
