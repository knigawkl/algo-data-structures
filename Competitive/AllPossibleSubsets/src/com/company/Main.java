package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    /*
    Given a set of distinct integers, nums, return all possible createSubsets
    The solution set must not contain duplicate createSubsets
     */
    public static List<List<Integer>> createSubsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer>  tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] example = {1, 5, 8};
        System.out.println(createSubsets(example));

    }
}
