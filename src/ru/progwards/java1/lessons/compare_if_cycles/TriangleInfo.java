package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleInfo {

    public static boolean isTriangle(int a, int b, int c) {
        return (a + b) > c && (a + c) > b && (b + c) > a;
    }

    public static boolean isRightTriangle(int a, int b, int c) {
        return (a * a) == ((b * b) + (c * c)) || (b * b) == ((a * a) + (c * c)) || (c * c) == ((a *a) + (b * b));
    }

    public static boolean isIsoscelesTriangle(int a, int b, int c) {
        return  ((a == b && a != c) || (b == c && b != a) || (a == c && c != b));
    }

    public static void main(String[] args) {
        System.out.println(isTriangle(5, 2, 6));
        System.out.println(isRightTriangle(4, 3, 5));
        System.out.println(isIsoscelesTriangle(3, 3, 1));
    }

}
