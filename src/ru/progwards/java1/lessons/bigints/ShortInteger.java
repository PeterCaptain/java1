package ru.progwards.java1.lessons.bigints;

public class ShortInteger extends AbsInteger {
    private final short num;

    ShortInteger(short num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return Short.toString(num);
    }

    @Override
    public int getInt() {
        return this.num;
    }
}
