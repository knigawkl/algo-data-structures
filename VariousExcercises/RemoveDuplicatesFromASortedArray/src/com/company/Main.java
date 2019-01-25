package com.company;

public class Main {

    //returns the new length of the array
    public static void main(String[] args) {

        int[] sortedArray = {1, 2, 3, 3, 4, 4};
        System.out.println(removeDuplicatesFromASortedArray(sortedArray));
    }

    public static int removeDuplicatesFromASortedArray(int[] sortedArray) {

        if (sortedArray.length == 0)
            return 0;

        int j = 0;
        for (int i = 1; i < sortedArray.length; i++) {
            if (sortedArray[i] != sortedArray[j])
                sortedArray[++j] = sortedArray[i];
        }
        return  ++j;
    }
}
