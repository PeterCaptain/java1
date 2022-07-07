package ru.progwards.java1.lessons.maps;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FiboMapCache {
    private final Map<Integer, BigDecimal> fiboCache;
    private boolean cacheOn;

    public FiboMapCache(boolean cacheOn) {
        this.cacheOn = cacheOn;
        fiboCache = new HashMap<>();
    }

    public BigDecimal fiboNumber(int n) {
        if (cacheOn) {
            if (fiboCache.containsKey(n)) {
                return fiboCache.get(n);
            } else {
                BigDecimal absentNumber = getFiboNum(n);
                fiboCache.put(n, absentNumber);
            }
        }
        return getFiboNum(n);
    }

    private static BigDecimal getFiboNum(int n) {
        BigDecimal num1 = new BigDecimal("0");
        BigDecimal num2 = new BigDecimal("1");
        BigDecimal fiboNum = new BigDecimal("0");

        if (n == 1)
            fiboNum = num2;
        else {
            for (int i = 2; i <= n; i++) {
                fiboNum = num1.add(num2);
                num1 = num2;
                num2 = fiboNum;
            }
        }
        return fiboNum;
    }

    public void clearCahe() {
        fiboCache.clear();
    }

    public void changeStatus() {
        cacheOn = !cacheOn;
    }

    public static void test() {
        FiboMapCache testResult = new FiboMapCache(false);
        long start = System.currentTimeMillis();
        for (int i = 0; i <= 1000; i++) {
            testResult.fiboNumber(i);
        }
        System.out.println("fiboNumber cacheOn = " + testResult.cacheOn + " время выполнения : " + (System.currentTimeMillis() - start));

        testResult.clearCahe();
        testResult.changeStatus();
        start = System.currentTimeMillis();
        for (int i = 0; i <= 1000; i++) {
            testResult.fiboNumber(i);
        }
        System.out.println("fiboNumber cacheOn = " + testResult.cacheOn + " время выполнения : " + (System.currentTimeMillis() - start));

    }

    public static void main(String[] args) {
        test();
    }
}
