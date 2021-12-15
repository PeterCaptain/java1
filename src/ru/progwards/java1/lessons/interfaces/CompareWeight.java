package ru.progwards.java1.lessons.interfaces;

public interface CompareWeight  {
    public enum CompareResult {LESS, EQUAL, GREATER}

    public CompareResult compareWeight(CompareWeight smthHasWeigt);

    public static void sort(CompareWeight[] a) {
        CompareWeight temp;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i].compareWeight(a[j]) == CompareResult.GREATER) {
                    temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
    }
}
