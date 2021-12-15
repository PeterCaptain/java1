package ru.progwards.java1.lessons.compare_if_cycles;


public class CyclesGoldenFibo {

    public static boolean containsDigit(int number, int digit) {
        String str1 = Integer.toString(number);
        String str2 = Integer.toString(digit);
        boolean isResult = false;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                System.out.println("Число " + number + " содержит цифру - " + str2.charAt(0));
                isResult = true;
            }
        }
        if (!isResult)
            System.out.println("Число " + number + " не содержит цифру - " + str2.charAt(0));
        return isResult;
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

        if (a == b) {   // находим основание треугольника
            base = c;
        }
        else if (b == c) {
            base = a;
        }
        else {
            base = b;
        }

        //base = ((double) TriangleSimpleInfo.maxSide(a, b, c));
       // edge = TriangleSimpleInfo.minSide(a, b, c);

        return (Math.abs(edge / base) > level1 && Math.abs(edge / base) < level2);
    }

    public static void main(String[] args) {
         int a = 0;
        for (int i = 1; i <= 15; i++) {
             a = fiboNumber(i);
            System.out.print(fiboNumber(i) + ", ");
        }
        System.out.println("\n");
        System.out.println("*********************");
        System.out.println(a);
        System.out.println("*********************");
        System.out.println("\n");

        for (int j = 1; fiboNumber(j) < 100; j++) {
            for (int k = j + 1; fiboNumber(k) < 100; k++) {

                if (isGoldenTriangle(fiboNumber(k), fiboNumber(k), fiboNumber(j))) {
                    System.out.println(fiboNumber(j) + ", " + fiboNumber(k));
                }
            }
        }
        System.out.println(isGoldenTriangle(55, 55, 34));


    }
}
