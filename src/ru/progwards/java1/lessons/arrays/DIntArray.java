package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class DIntArray {
    private int[] array = {};

    public void add(int num) {
        int[] arrayCopy = new int[array.length + 1];
        System.arraycopy(array, 0, arrayCopy, 0, array.length);
        arrayCopy[arrayCopy.length - 1] = num;
        this.array = arrayCopy;
    }

    public void atInsert(int pos, int num) {
        int[] arrayCopy = new int[array.length + 1];
        System.arraycopy(array, 0, arrayCopy, 0, pos );
        System.arraycopy(array, pos, arrayCopy, pos + 1, array.length-pos);
        arrayCopy[pos] = num;
        array = arrayCopy;
    }

    public void atDelete(int pos) {
        int[] arrayCopy = new int[array.length - 1];
        System.arraycopy(array, 0, arrayCopy, 0, pos );
        System.arraycopy(array, pos + 1, arrayCopy, pos, arrayCopy.length - pos);
        array = arrayCopy;
    }

    public int at(int pos) {
        return array[pos];
    }

    public  void print() {
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        DIntArray x = new DIntArray();
        x.print();
        x.add(0);
        x.add(1);
        x.add(2);
        x.add(3);
        x.add(5);
        x.add(6);
        x.print();
        x.atInsert(4, 4);
        x.print();
        x.atDelete(0);
        x.print();
        x.at(4);
        System.out.println(x.at(4));
    }

}
