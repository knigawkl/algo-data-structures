package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] array = new int[] {3, 32, 5, 565, 867, 34, 6};
        System.out.println(Arrays.toString(array));
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static int[] insertionSort(int[] array) {

        int i, key;
        for (int j = 1; j < array.length ; j++) {
            key = array[j];
            //inserting array[j]
            i = j - 1;
            while (i > 0 && array[i] > key) {
                array[i+1] = array[i];
                i = i - 1;
            }
            array[i+1] = key;
        }
        return array;
    }

}
