package heap;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BuildHeap {

    public static void main(String[] ar) {
        System.out.println("Enter no of elements :");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        int arr [] = new int[N+1];
        arr [0] = N;
        for (int i = 0; i <N ; i++) {
            arr[i+1] = new Random().nextInt(10);
        }
        System.out.println("given :" + Arrays.toString(arr));
        BuildHeap heap = new BuildHeap();
        heap.heapSort(arr);
        System.out.println("sorted arr : " + Arrays.toString(arr));

    }

    int parent(int index, int[] arr) {
        return index / 2;
    }

    int left(int index, int[] arr) {
        return 2 * index;
    }

    int right(int index, int arr[]) {
        return 2 * index + 1;
    }

    void maxHeapify(int[] arr, int index) {
        int left = left(index, arr);
        int right = right(index, arr);
        if (left > arr[0]) return;
        int largest = index;
        if (left <= arr[0] && arr[left] > arr[largest]) largest = left;


        if (right <= arr[0] && arr[right] > arr[largest]) largest = right;

        if (largest != index) {
            int temp = arr[largest];
            arr[largest] = arr[index];
            arr[index] = temp;
            maxHeapify(arr, largest);
        }



    }

    void heapSort(int[] arr) {
        arr = buildHeap(arr);
        System.out.println("heapified :" +Arrays.toString(arr));
        int size =  arr[0];
        while (arr[0] > 1) {
            int temp = arr[arr[0]];
            arr[arr[0]] = arr[1];
            arr[1] = temp;
            arr[0] = arr[0] - 1;
            maxHeapify(arr, 1);
        }

    }

    int[] buildHeap(int[] arr) {
        for (int i = arr[0] / 2; i >= 1; i--) {
            maxHeapify(arr, i);
        }
        return arr;
    }




}
