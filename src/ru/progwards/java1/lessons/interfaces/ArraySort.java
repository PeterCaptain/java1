package ru.progwards.java1.lessons.interfaces;

public class ArraySort {

    public static void sort(CompareWeight[] a) {
        CompareWeight temp;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i].compareWeight(a[j]) == CompareWeight.CompareResult.GREATER) {
                    temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Food food = new Food(7);
    }
}
