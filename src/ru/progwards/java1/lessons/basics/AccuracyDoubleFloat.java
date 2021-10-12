package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {
    private static  final double PI = 3.14;
    private static final double EARTH_RADIUS = 6_371.2;

    public static double volumeBallDouble(double radius) {
        return 4.0 / 3 * PI * (radius * radius * radius);
    }

    public static float volumeBallFloat(float radius) {
        return (float) (4.0 / 3 * PI * (radius * radius * radius));
    }

    public static double calculateAccuracy(double radius) {
        return volumeBallDouble(radius) - volumeBallFloat((float)radius);
    }

    public static void main(String[] args) {
        System.out.println(calculateAccuracy( EARTH_RADIUS));
    }
}
