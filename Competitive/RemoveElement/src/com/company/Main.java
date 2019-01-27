package com.company;

public class Main {

    public static void main(String[] args) {

        //given an array and a value, remove all elements equal to that value and return the new length
        int[] array = {1, 2, 3, 4, 5, 1};
        int item = 1;
        System.out.println(removeElement(array, item));
    }

    private static int removeElement(int[] array, int item) {

        if (array.length == 0)
            return 0;

        int slow = 0;
        for (int fast = 0; fast < array.length; fast++)
            if (array[fast] != item)
                array[slow++] = array[fast];

        return slow;
    }
}
