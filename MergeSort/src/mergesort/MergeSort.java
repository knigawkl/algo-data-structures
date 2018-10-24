package mergesort;

import java.util.Arrays;

/* based on a yt tutorial by K B */
public class MergeSort {

    private static int[] extraArray;

    public static void sort(int[] arrayToSort) {
        int len = arrayToSort.length;
        extraArray = new int[len];
        mergeSort(arrayToSort, 0, len - 1);
    }

    private static void mergeSort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int middle = (leftIndex + rightIndex) / 2;
            mergeSort(array, leftIndex, middle);
            mergeSort(array, middle + 1, rightIndex);
            merge(array, leftIndex, middle, rightIndex);
        }
    }

    private static void merge(int[] array, int leftIndex, int middleIndex, int rightIndex) {
        for (int i = leftIndex; i <= rightIndex; i++) {
            extraArray[i] = array[i];
        }

        int firstHalfPointer = leftIndex;
        int secondHalfPointer = middleIndex + 1;
        int current = leftIndex;

        while (firstHalfPointer <= middleIndex && secondHalfPointer <= rightIndex) {
            if (extraArray[firstHalfPointer] <= extraArray[secondHalfPointer]) {
                array[current] = extraArray[leftIndex];
                firstHalfPointer++;
            } else {
                array[current] = extraArray[rightIndex];
                secondHalfPointer++;
            }
            current++;
        }
        
        while (firstHalfPointer <= middleIndex) {
            array[current] = extraArray[firstHalfPointer];
            current++;
            firstHalfPointer++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 4, 43, 46, 5674, 234, 65, 567, 1, 34, 675};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
