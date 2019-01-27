package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] input = {5, 4, 5, 2, 2, 6, 6};
        System.out.println(solution(input));
    }

    public static int solution(int[] A) {
        int len = A.length;

        Arrays.sort(A);

        for (int i = 0; i < len - 1; i += 2) {
            if (A[i] != A[i + 1]) {
                return A[i];
            }
        }

        return A[len - 1];
    }
}
