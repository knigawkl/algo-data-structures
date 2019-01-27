package com.company;

public class Main {
    /*
    You're given an array of ints. Every elem appears twice except for one.
    Find that single one.
    You should have linear runtime.
    Implement it without using extra memory.
     */
    public static void main(String[] args) {
	    int[] example = {1, 2, 2, 4, 4};
        System.out.println(singleNumber(example));
    }
    public static int singleNumber(int[] nums) {
        int result = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
