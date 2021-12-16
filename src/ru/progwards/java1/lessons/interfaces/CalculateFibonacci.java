package ru.progwards.java1.lessons.interfaces;

public class CalculateFibonacci {
    private static CacheInfo lastFibo;

    public static int fiboNumber(int n) {
        lastFibo = new CacheInfo();

        if (n != lastFibo.n) {

            int num1 = 0;
            int num2 = 1;
            int sum = 0;

            if (n == 1)
                sum = num2;

            else
                for (int j = 2; j <= n; j++) {
                    sum = num1 + num2;
                    num1 = num2;
                    num2 = sum;
                }
            lastFibo.n = n;
            lastFibo.fibo = sum;
        }
        return lastFibo.fibo;
    }

    public static class CacheInfo {
        public int n; // Число, для которого расчитываем Фибоначи
        public int fibo; // Результат расчета

        public static CacheInfo getLastFibo() {
            return lastFibo;
        }

        public static void clearLastFibo() {
            lastFibo = null;
        }
    }

    // test

    public static void main(String[] args) {
        System.out.println(fiboNumber(12));
        System.out.println("***");
        System.out.println(CacheInfo.getLastFibo().n);
        System.out.println(CacheInfo.getLastFibo().fibo);
        System.out.println("*****************");
        System.out.println();

        System.out.println(fiboNumber(15));
        System.out.println("***");
        System.out.println(CacheInfo.getLastFibo().n);
        System.out.println(CacheInfo.getLastFibo().fibo);
        System.out.println("*****************");
        System.out.println();

        CacheInfo.clearLastFibo();

        System.out.println(fiboNumber(10));
        System.out.println("***");
        System.out.println(CacheInfo.getLastFibo().n);
        System.out.println(CacheInfo.getLastFibo().fibo);
        System.out.println("*****************");

        CacheInfo.clearLastFibo();

        System.out.println(fiboNumber(8));
        System.out.println("***");
        System.out.println(CacheInfo.getLastFibo().n);
        System.out.println(CacheInfo.getLastFibo().fibo);
        System.out.println("*****************");

    }
}
