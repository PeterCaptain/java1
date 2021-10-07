package ru.progwards.java1.lessons.basics;

public class ReverseDigits {

    public static int reverseDigits(int number) {
        int firstOrder = (number % 10) * 100;
        int secondOrder = (number / 10) % 10 *10;
        int thirdOrder = number / 100;
        return firstOrder + secondOrder + thirdOrder;
    }

}
