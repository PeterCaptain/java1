package ru.progwards.java1.lessons.bitsworld;

public class SumBits {
    public static int sumBits(byte value) {
        int result = 0;

        if (value != 0) {
            for (int i = 0; i < 8; i++) {
                int check = value >> i & 0b1;

                if (check == 1) {
                    result += check;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(sumBits((byte) -93));
        System.out.println(sumBits((byte) 93));
        System.out.println(sumBits((byte) 255));
        System.out.println(sumBits((byte) 256));
        System.out.println(sumBits((byte) 140));
        System.out.println(sumBits((byte) 0));
    }
}
