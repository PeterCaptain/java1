package ru.progwards.java1.lessons.compare_if_cycles;



public class CyclesGoldenFibo {

    public static boolean containsDigit(int number, int digit) {
        return number == digit;
    }

    public static int fiboNumber(int n) {
        int num1 = 0;
        int num2 = 1;
        int sum = 0;

        if (n == 1)
            sum = num2;

        else
            for (int i = 2; i <= n; i++) {
                sum = num1 + num2;
                num1 = num2;
                num2 = sum;
            }
        return sum;
    }

    public static boolean isGoldenTriangle(int a, int b, int c) {
        double level1 = 1.61703;
        double level2 = 1.61903;
        double base;
        double edge;

            edge = (double) a == b ? a : c;  // находим ребро треугольника

            if (edge != a && edge != b)    // находим основание треугольника
                    base = b;
                 else
                    base = c;

        return (Math.abs(edge / base)> level1 && Math.abs(edge / base) < level2);
    }

    public static void main(String[] args) {

        for (int i = 1; i <= 15; i++) {
            System.out.print( fiboNumber(i) + ", ");
        }
        System.out.println("\n");

            for (int j = 1; fiboNumber(j) < 100; j++) {
                for (int k = j + 1; fiboNumber(k) < 100; k++) {

                    if (isGoldenTriangle(fiboNumber(k), fiboNumber(k), fiboNumber(j))) {
                        System.out.println(fiboNumber(j) + ", " + fiboNumber(k));
                    }
                }
            }
    }
}
