package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class NonRepeatingNumberInSortedArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scan.nextInt();
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = scan.nextInt();
            }
            System.out.println(findNonRepeatingInSortedArrayBinarySearch(arr));

        }
    }

    static int findNonRepeatingInSortedArrayBinarySearch(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;
        if (arr.length > 1) {
            while (l <= r) {
                mid = (l + r) / 2;
                if (mid > 0 && mid < arr.length - 1) {
                    if (l == r) {
                        return arr[l];
                    } else if (mid % 2 == 0 && arr[mid + 1] == arr[mid]) {
                        l = mid + 1;
                    } else if (mid % 2 == 0 && arr[mid - 1] == arr[mid]) {
                        r = mid - 1;
                    } else if (mid % 2 != 0 && arr[mid - 1] == arr[mid]) {
                        l = mid + 1;
                    } else if (mid % 2 != 0 && arr[mid + 1] == arr[mid]) {
                        r = mid - 1;
                    } else if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1]) {
                        return arr[mid];
                    }
                } else if (mid == 0) {
                    if (arr[mid] != arr[mid + 1]) {
                        return arr[mid];
                    }
                } else if (mid == arr.length - 1) {
                    if (arr[mid] != arr[mid - 1]) {
                        return arr[mid];
                    }
                }
            }
        }
        return -1;
    }

    static void findNonRepeatingInSortedArray(int[] arr, int N) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (!hm.containsKey(arr[i])) {
                hm.put(arr[i], 1);
            } else {
                int value = hm.get(arr[i]);
                hm.put(arr[i], value + 1);
            }
        }
        for (Map.Entry<Integer, Integer> st : hm.entrySet()) {
            if (st.getValue() == 1) {
                System.out.println(st.getKey());
                break;
            } else {
                continue;
            }
        }

    }
}
