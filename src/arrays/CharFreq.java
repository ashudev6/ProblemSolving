package arrays;

import java.util.*;

public class CharFreq {

    public static void main(String[] arg) {
        List<Character> list = new ArrayList<>();
        list.add('a');
        //System.out.println(Collections.frequency(list, 'a'));
        list.add('b');
        list.add('c');
        list.add('a');
        //System.out.println(Collections.frequency(list, 'a'));
        if (list.contains('v')) {
            //System.out.println(Collections.frequency(list, 'v'));
        }
        //int[] a = {45, 43, 12, 89, 3};
        int[] a = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int start = 0;
        int end = a.length;
        Arrays.sort(a);
        //System.out.println("index of found element is " + binarySearch(a, 1, start, end-1));
        //System.out.println("index of found element is " + CountOccurances(a,end,0));
        for(int i = 0;i<a.length;i++) {
            if (i<a.length-1) {
                System.out.print(a[i] + " ");
            } else {
                System.out.print(a[i]);
            }

        }

    }

    static int binarySearch(int[] a, int b, int s, int e) {
        //int foundIndex = -1;
        if (e >= s) {
            int m = s+ (e-s)/ 2;
            if (b == a[m]) {
                return m;
            } else if (b > a[m]) {
                return binarySearch(a, b, m + 1, e);
            } else {
                return binarySearch(a, b, s, m - 1);
            }
        }
        return -1;


    }

    static  int GetRightPosition(int A[], int l, int r, int key)
    {
        int m;

        while( r - l > 1 )
        {
            m = l + (r - l)/2;

            if( A[m] <= key )
                l = m;
            else
                r = m;
        }

        return l;
    }

    // Input: Indices Range (l ... r]
// Invariant: A[r] >= key and A[l] > key
    static  int GetLeftPosition(int A[], int l, int r, int key)
    {
        int m;

        while( r - l > 1 )
        {
            m = l + (r - l)/2;

            if( A[m] >= key )
                r = m;
            else
                l = m;
        }

        return r;
    }

    static  int CountOccurances(int A[], int size, int key)
    {
        // Observe boundary conditions
        int left = GetLeftPosition(A, -1, size-1, key);
        int right = GetRightPosition(A, 0, size, key);

        // What if the element doesn't exists in the array?
        // The checks helps to trace that element exists
        return (A[left] == key && key == A[right])?
                (right - left + 1) : 0;
    }
}
