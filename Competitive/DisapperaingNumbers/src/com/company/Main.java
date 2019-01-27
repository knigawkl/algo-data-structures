package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /*
    Given an array of integers, where 1 <= a[i] <= n == size of the array, some elems appear twice and some once
    Find all the elements og [1, n] inclusive that do not appear in this array
    Do this without extra space and in O(n) runtime
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0)
                nums[val] = -nums[val];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                list.add(i + 1);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 5, 7, 8};
        System.out.println(findDisappearedNumbers(input));
    }
}
