package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleSimpleInfo {

    public static int maxSide(int a, int b, int c) {
        return Math.max(c, (Math.max(a, b)));    // находим большее из трех и возвращаем
        // return c > (a > b ? a : b) ? c : (a > b ? a : b);
    }

    public static int minSide(int a, int b, int c) {
        return Math.min(c, (Math.min(a, b)));   // находим меньшее из трех и возвращаем
        // return c < (a < b ? a : b) ? c : (a < b ? a : b);
    }

    public static boolean isEquilateralTriangle(int a, int b, int c) {
        return a == b && b == c;               // возвращаем  значение если а == b == c, то true, иначе false
    }

}
