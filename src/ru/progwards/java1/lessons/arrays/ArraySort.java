package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class ArraySort {

    public static void sort(int[] a) {
        int temp;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
    }

    // test
    public static void main(String[] args) {
        int[] x = {11, 5, 1, 15, 75, 34, 91, 69, 34, 34};
        System.out.println(Arrays.toString(x));
        sort(x);
        System.out.println(Arrays.toString(x));

    }
}

