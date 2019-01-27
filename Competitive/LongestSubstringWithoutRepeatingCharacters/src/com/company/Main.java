package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        String testString = "aaaasdfg";
        System.out.println(countLengthOfLongestSubstring(testString));
    }

    private static int countLengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i)
        {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
