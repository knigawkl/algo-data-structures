package quicksort;

import java.util.Arrays;

/* based on yt tutorial by K B */
public class QuickSort {

    public static void sort(int[] unsortedArray) {
        if (unsortedArray == null || unsortedArray.length == 0) {
            return;
        }
        int len = unsortedArray.length;
        quickSort(unsortedArray, 0, len - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int border = partitionArray(array, left, right);

        quickSort(array, left, border - 1);
        quickSort(array, border + 1, right);
    }

    private static int partitionArray(int[] array, int left, int right) {
        int pivotValue = choosePivot(array, left, right);
        int border = left - 1;
        int i = left;

        while (i < right) {
            if (array[i] < pivotValue) {
                border++;
                if (border != i) {
                    swap(array, border, i);
                }
            }
            i++;
        }

        border++;
        if (border != right) {
            swap(array, border, right);
        }

        return border;
    }

    private static int choosePivot(int[] array, int left, int right) {
        int mid = left + (right - left) / 2;
        int pivotValue = array[mid];
        swap(array, mid, right);
        return pivotValue;
    }

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int tmp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tmp;
    }

    public static void main(String[] args) {
        int[] testArray = {3, 43, 465, 75, 45, 57, 75, 75, 465, 3, 63, 36, 63, 65, 65, 6456, 45, 3, 34, 3, 3, 6};
        sort(testArray);
        System.out.println(Arrays.toString(testArray));
    }

}
