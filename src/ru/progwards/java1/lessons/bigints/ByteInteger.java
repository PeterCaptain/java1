package ru.progwards.java1.lessons.bigints;

public class ByteInteger extends AbsInteger {
    private final byte num;

    ByteInteger(byte num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return Byte.toString(num);
    }

    @Override
    public int getInt() {
        return this.num;
    }

    // Test
    public static void main(String[] args) {
        ByteInteger a = new ByteInteger((byte) 1);
        ShortInteger b = new ShortInteger((short) 5_010);
        IntInteger c = new IntInteger(60_325);
        ShortInteger d = new ShortInteger((short) 10_234);
        IntInteger e = new IntInteger(2);

        System.out.println(add(a, add(b, d)));
        System.out.println(add(a, add(b, d)).getClass());
        System.out.println(add(b, add(a, c)));
        System.out.println(add(b, add(a, c)).getClass());
        System.out.println(add(a, e));
        System.out.println(add(a, e).getClass());
    }
}
