package ru.progwards.java1.lessons.abstractnum;

public class Test {
    public static void printInfo(Figure3D figure3d) {
        System.out.println(figure3d);
        System.out.println("объём фигуры    - " + figure3d.volume());
        System.out.println("*************************");
    }

    public static void main(String[] args) {
        Number number1 = new IntNumber(3);
        Number number2 = new DoubleNumber(3);
        Cube cube1 = new Cube(number1);
        Cube cube2 = new Cube(number2);

        printInfo(cube1);
        printInfo(cube2);

        Pyramid pyramid1 = new Pyramid(number1);
        Pyramid pyramid2 = new Pyramid(number2);

        printInfo(pyramid1);
        printInfo(pyramid2);

    }
}
