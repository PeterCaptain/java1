package ru.progwards.java1.lessons.basics;

public class Astronomy {
    private static final double PI = 3.14;
    private static final double EARTH_RADIUS = 6_371.2;
    private static final double MERCURY_RADIUS = 2_439.7;
    private static final double JUPITER_RADIUS = 71_492;

    public static Double sphereSquare(Double r) {
        return 4 * PI * Math.pow(r, 2);
    }

    public static Double earthSquare() {
       return sphereSquare(EARTH_RADIUS);
    }

    public static Double mercurySquare() {
        return sphereSquare(MERCURY_RADIUS);
    }

    public static Double jupiterSquare() {
        return sphereSquare(JUPITER_RADIUS);
    }

    public static Double earthVsMercury() {
        return earthSquare() / mercurySquare();
    }

    public static Double earthVsJupiter() {
        return earthSquare() / jupiterSquare();
    }

}
