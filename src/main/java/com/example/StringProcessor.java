package com.example;

public class StringProcessor {

    // Задание 1
    public String repeat(String s, int n) {
        if (n < 0) throw new IllegalArgumentException("N must be non-negative");
        if (s == null) throw new IllegalArgumentException("s must not be null");
        return s.repeat(n);
    }

    // Задание 2
    public int countOccurrences(String str, String substr) {
        if (substr == null || substr.isEmpty()) throw new IllegalArgumentException("Substring error");
        if (str == null) return 0;
        int count = 0;
        int idx = 0;
        while ((idx = str.indexOf(substr, idx)) != -1) {
            count++;
            idx += 1; 
        }
        return count;
    }

    // Задание 3
    public String replaceDigits(String s) {
        if (s == null) throw new IllegalArgumentException("s must not be null");
        StringBuilder sb = new StringBuilder(s.length());
        for (char c : s.toCharArray()) {
            switch (c) {
                case '1' -> sb.append("один");
                case '2' -> sb.append("два");
                case '3' -> sb.append("три");
                default  -> sb.append(c);
            }
        }
        return sb.toString();
    }
    // Задание 4
    public void removeEverySecond(StringBuilder sb) {
        if (sb == null) {
            throw new IllegalArgumentException("StringBuilder must not be null");
        }
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (i % 2 != 0) {
                sb.deleteCharAt(i);
            }
        }
    }
}