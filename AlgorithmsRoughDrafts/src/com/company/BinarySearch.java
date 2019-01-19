package com.company;

public class BinarySearch {
    public static void main(String[] args) {
        int[] input = {1, 3, 46, 83, 4632, 452333};
        int result = search(input, 46);
        System.out.println(result);
    }

    public static int search(int[] input, int searchedValue) {
        int leftPointer = 0;
        int rightPointer = input.length - 1;
        int middlePointer;

        while(rightPointer - leftPointer >= 0) {
            middlePointer = (leftPointer + rightPointer) / 2;
            if (input[middlePointer] < searchedValue) {
                leftPointer = middlePointer + 1;
            }
            else if (input[middlePointer] > searchedValue) {
                rightPointer = middlePointer - 1;
            }
            else {
                return middlePointer;
            }
        }
        return -1;
    }
}
