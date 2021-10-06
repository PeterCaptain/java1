package ru.progwards.java1.lessons.basics;

public class Astronomy {
 private static final double PI = 3.14;

    public static Double sphereSquare(Double r) {
        return 4 * PI * Math.pow(r, 2);
    }

    public static Double earthSquare() {
       return sphereSquare(6_371.2);
    }

    public static Double mercurySquare() {
        return sphereSquare(2_439.7);
    }

    public static Double jupiterSquare() {
        return sphereSquare(71_492.0);
    }

    public static Double earthVsMercury() {
        return earthSquare() / mercurySquare();
    }

    public static Double earthVsJupiter() {
        return earthSquare() / jupiterSquare();
    }

}
