package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    int[] input = {0, 3};
	    input = solution(input, 3);
        System.out.println(Arrays.toString(input));
    }

    public static int[] solution(int[] A, int K) {
        int len = A.length;
        if (len <= 1) {
            return A;
        }

        if (K > len) {
            K %= len;
        }

        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            if (i + K < len) {
                result[i + K] = A[i];
            }
            else {
                result[i + K - len] = A[i];
            }
        }
        return result;
    }
}
