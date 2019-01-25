package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*
        1, 11, 21, 1211, 111221, ...

        Given an integer n, generate the nth sequence .
        The sequence of integers will be represented as a string.
         */
        Scanner in = new Scanner(System.in);
        System.out.println("Please input an int:");
        int a = in.nextInt();
        System.out.println(countAndSay(a));

    }

    private static String countAndSay(int a) {

        StringBuilder curr = new StringBuilder("1");
        StringBuilder prev;
        int count;
        char say;
        for (int i = 1; i < a; i++) {
            prev = curr;
            curr = new StringBuilder();
            count = 1;
            say = prev.charAt(0);
            for (int j = 1, len = prev.length(); j < len; j++) {
                if (prev.charAt(j) != say) {
                    curr.append(count).append(say);
                    count = 1;
                    say = prev.charAt(j);
                } else {
                    count++;
                }
            }
            curr.append(count).append(say);
        }
        return curr.toString();
    }
}
