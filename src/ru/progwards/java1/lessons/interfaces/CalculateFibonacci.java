package ru.progwards.java1.lessons.interfaces;

import ru.progwards.java1.lessons.compare_if_cycles.CyclesGoldenFibo;

public class CalculateFibonacci {
    private static CacheInfo lastFibo;

    public static int fiboNumber(int n) {
        lastFibo = new CacheInfo();

        if (n != lastFibo.n) {
            for (int i = 1; i <= n; i++) {
                lastFibo.fibo = CyclesGoldenFibo.fiboNumber(n);
            }
            lastFibo.n = n;
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
    }
}
