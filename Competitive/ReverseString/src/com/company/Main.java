package com.company;

public class Main {

    public static void main(String[] args) {
        String example = "alamakota";
        System.out.println(reverseString(example));
    }

    public static String reverseString(String s) {
        int length = s.length();

        if (length <= 1)
            return s;

        String leftString = s.substring(0, length / 2);
        String rightString = s.substring(length / 2, length);

        return reverseString(rightString) + reverseString(leftString);
    }
}
