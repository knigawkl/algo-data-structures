package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        //given an array of integers, return indices of the two numbers such that they add up to a specific target
        //you may not use the same element twice
        //each input has exactly one solution
        int nums[] = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println("[" + result[0] + "," + result[1] + "]");
    }

    private static int[] twoSum(int[] nums, int target) {

        int[] arr = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer val = map.get(target - nums[i]);
            if (val == null) {
                map.put(nums[i], i);
            } else {
                arr[0] = val;
                arr[1] = i;
                break;
            }
        }
        return arr;
    }
    /*
    Map for num and its index. In the for loop, we check if the map has an element which is equal to the difference between the target and the current element
     */
}
