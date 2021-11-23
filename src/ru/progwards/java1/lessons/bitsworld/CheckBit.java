package ru.progwards.java1.lessons.bitsworld;

public class CheckBit {

    public static int checkBit(byte value, int bitNumber) {
        if (bitNumber >= 0 && bitNumber < 8) {
            return value >> bitNumber & 0b1;
        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(checkBit((byte) 127, 0));
        System.out.println(checkBit((byte) 127, 1));
        System.out.println(checkBit((byte) 127, 2));
        System.out.println(checkBit((byte) 127, 3));
        System.out.println(checkBit((byte) 127, 4));
        System.out.println(checkBit((byte) 127, 5));
        System.out.println(checkBit((byte) 127, 6));
        System.out.println(checkBit((byte) 127, 7));

       // System.out.println(numberByteIsOk(100);

    }
}

