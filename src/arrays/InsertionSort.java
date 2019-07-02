package arrays;

public class InsertionSort {

    public  static void main(String[] ar) {
        int [] arr = {1,6,5,3,2,4};
        doInsertionSort(arr);

    }


    static void doInsertionSort(int [] arr) {
        int n = arr.length;
        if (n>0) {
            for (int j = 1; j < n; j++) {
                int key = arr[j];
                int i = j-1;
                while(i>=0 && arr[i] > key) {
                   arr[i+1] = arr[i];
                   i--;
                }
                arr[i+1] = key;
            }
        }
        for (int i:
             arr) {
            System.out.println(i);
        }
    }


}
