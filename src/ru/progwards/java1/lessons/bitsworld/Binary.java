package ru.progwards.java1.lessons.bitsworld;

public class Binary {
    private final byte num;

    public Binary(byte num) {
        this.num = num;
    }

    @Override
    public String toString() {
        String result = "";
        byte check = num;

        if (check == 0) {
            return check + ": 00000000";
        } else {
            for (int i = 0; i < 8; i++) {
                byte temp = (byte) (check >> i & 0b1);
                result = temp + result;
            }
            return check + ": " + result;
        }
    }

    public static void main(String[] args) {
        Binary binary = new Binary((byte) -127);
        System.out.println(binary);
    }

}