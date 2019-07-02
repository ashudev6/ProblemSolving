package arrays;

public class MaxNumber {
    public  static  void  main(String[] args) {
        //int arr [] = { 8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
        //int arr [] = { 1, 3, 50, 10, 9, 7, 6};
        //int arr [] = { 10, 20, 30, 40, 70};
        int arr [] = { 120, 100, 80, 20, 0};
        int max = 0;
        for (int i =0;i<arr.length;i++) {
            if (max<arr[i]) {
                max = arr[i];
                //System.out
            } else {
                break;
            }
        }
        System.out.println(max);
    }
}
