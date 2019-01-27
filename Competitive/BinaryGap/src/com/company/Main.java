package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(solution(2));
        System.out.println(solution(9));
        System.out.println(solution(15));
        System.out.println(solution(1041));
        System.out.println(solution(32));
    }

    public static int solution(int N) {

        int previousOne = -1;
        int counter = 0;
        String binaryInput = Integer.toBinaryString(N);
        char[] binaryInputArrayed = binaryInput.toCharArray();
        for (int i = 0; i < binaryInputArrayed.length; i++) {
            if (binaryInputArrayed[i] == '1' && previousOne == -1) {
                previousOne = i;
            }
            else if (binaryInputArrayed[i] == '1') {
                int newCounter = i - previousOne - 1;
                if (newCounter > counter) {
                    counter = newCounter;
                }
                previousOne = i;
            }
        }
        return counter;
    }
}
