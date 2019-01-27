package com.company;

public class LinearSearch {
    public static void main(String[] args) {
        int[] input = {1, 4, 54, 7, 8};
        int result = search(input, 54);
        System.out.println(result);
    }

    private static int search(int[] input, int searchedValue) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == searchedValue) {
                return i;
            }
        }
        return -1;
    }
}
