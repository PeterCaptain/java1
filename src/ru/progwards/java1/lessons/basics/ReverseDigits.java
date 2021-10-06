package ru.progwards.java1.lessons.basics;

public class ReverseDigits {

    public static int reverseDigits(int number) {
        String input = Integer.toString(number);
        StringBuilder temp = new StringBuilder(input);
        String output = String.valueOf(temp.reverse());
        return Integer.parseInt(output);
    }

}
