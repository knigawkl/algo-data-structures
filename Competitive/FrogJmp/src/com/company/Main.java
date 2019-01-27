package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(solution(10, 30, 20));
    }

    public static int solution(int X, int Y, int D) {
        if ((Y - X) % D == 0) {
            return (Y - X) / D;
        }
        return ((Y - X) / D ) + 1;
    }
}
