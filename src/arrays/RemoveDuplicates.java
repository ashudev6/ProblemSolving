package arrays;

public class RemoveDuplicates {
    public static void main(String[] ar) {
        int[] arr = {1,1,2,3,4,4,5,5,5};
        System.out.println(doRemoveDuplicates(arr));
    }

    static int doRemoveDuplicates(int[] arr) {
        if (arr.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i]!= arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;
    }
}
