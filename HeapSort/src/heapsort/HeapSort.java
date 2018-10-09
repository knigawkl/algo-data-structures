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
            swap(arrayToSort, 0, i);

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
            swap(array, maxIndex, parentIndex);
            validateMaxHeap(array, heapSize, maxIndex);
        }
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {

        int[] unsortedArray = new int[]{21, 432, 456, 678, 7, 43, 234, 24};
        sort(unsortedArray);
        System.out.println(Arrays.toString(unsortedArray));
    }
}
