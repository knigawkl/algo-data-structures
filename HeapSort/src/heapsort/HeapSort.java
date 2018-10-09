package heapsort;

import java.util.Arrays;

public class HeapSort {

    public static void sort(int[] arrayToSort) {

        int n = arrayToSort.length;

        //last parent is at index: n / 2 - 1 
        for (int i = n / 2 - 1; i >= 0; i--) {
            HeapSort.validateMaxHeap(arrayToSort, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = arrayToSort[0];
            arrayToSort[0] = arrayToSort[i];
            arrayToSort[i] = temp;

            HeapSort.validateMaxHeap(arrayToSort, --n, 0);
        }
    }

    //check whather a heap is a max heap
    private static void validateMaxHeap(int[] array, int heapSize, int parentIndex) {

        int maxIndex = parentIndex;
        int leftChild = parentIndex * 2 + 1;
        int rightChild = parentIndex * 2 + 2;

        if (leftChild < heapSize && array[leftChild] > array[maxIndex]) {
            maxIndex = leftChild;
        }
        if (rightChild < heapSize && array[rightChild] > array[maxIndex]) {
            maxIndex = rightChild;
        }

        if (maxIndex != parentIndex) {
            int temp = array[maxIndex];
            array[maxIndex] = array[parentIndex];
            array[parentIndex] = temp;
            validateMaxHeap(array, heapSize, maxIndex);
        }
    }

    public static void main(String[] args) {

        int[] unsortedArray = new int[]{21, 432, 456, 678, 7, 43, 234, 24};
        sort(unsortedArray);
        System.out.println(Arrays.toString(unsortedArray));
    }
}
