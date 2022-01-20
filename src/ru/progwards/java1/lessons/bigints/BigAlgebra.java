package ru.progwards.java1.lessons.bigints;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class BigAlgebra {
    // возведение в степень (бинарное возведение справа - налево)
    static BigDecimal fastPow(BigDecimal num, int pow) {
        BigDecimal numInPow = BigDecimal.ONE;
    /* возведение в положительную степень (блок кода так же используется и при подсчете отрицательных значений pow)
       поэтому pow используем в значении по модулю
    */
        if (pow != 0) {
            int absPow = Math.abs(pow);
            while (absPow > 0) {
                if ((absPow & 0b1) != 0) {
                    numInPow = numInPow.multiply(num);
                }
                num = num.multiply(num);
                absPow >>= 1;
            }
        }
    // возведение в отрицательную степень
        if (pow < 0) {
    // метод вернёт значение если pow < 0. Требуемую точность вычислений можно определить под конкретные условия задачи.
            return BigDecimal.ONE.divide(numInPow, 5, RoundingMode.HALF_UP);
        }
    // метод вернёт значение если pow >= 0
        return numInPow;
    }

    // вариант алгоритма вычисления n-го числа Фибоначчи в BigInteger
    static BigInteger fibonacci(int n) {
        BigInteger num1 = BigInteger.ZERO;
        BigInteger num2 = BigInteger.ONE;
        BigInteger sum = BigInteger.ZERO;

        if (n <= 0) {
            return sum;
        } else if (n == 1) {
            return num2;
        } else {
            for (int i = 2; i <= n; i++) {
                sum = num1.add(num2);
                num1 = num2;
                num2 = sum;
            }
        }
        return sum;
    }

    // Test
    public static void main(String[] args) {
        System.out.println("__________________________________________________");

        System.out.println("Тест метода \"static BigInteger fibonacci(int n)\"\n");

        System.out.printf("Значение %d-го числа послед-ти Фибоначчи = %d%n", 1, fibonacci(1));
        System.out.printf("Значение %d-го числа послед-ти Фибоначчи = %d%n", 2, fibonacci(2));
        System.out.printf("Значение %d-го числа послед-ти Фибоначчи = %d%n", 3, fibonacci(3));
        System.out.printf("Значение %d-го числа послед-ти Фибоначчи = %d%n", 4, fibonacci(4));
        System.out.printf("Значение %d-го числа послед-ти Фибоначчи = %d%n", 18, fibonacci(18));
        System.out.println("__________________________________________________\n");

        System.out.println("Тест метода \"static BigDecimal fastPow(BigDecimal num, int pow)\"\n");

        BigDecimal a = new BigDecimal("2");
        System.out.printf("Число %d^%d = ", 2, -4);
        System.out.println(fastPow(a, -4));
        System.out.printf("Число %d^%d = ", 2, -2);
        System.out.println(fastPow(a, -2));
        System.out.printf("Число %d^%d = ", 2, 5);
        System.out.println(fastPow(a, 5));
        System.out.printf("Число %d^%d = ", 2, 15);
        System.out.println(fastPow(a, 15));
        System.out.printf("Число %d^%d = ", 2, 0);
        System.out.println(fastPow(a, 0));
        System.out.println("__________________________________________________\n");
    }
}
