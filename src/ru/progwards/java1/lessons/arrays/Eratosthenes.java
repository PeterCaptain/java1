package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class Eratosthenes {
    private boolean[] sieve;

    public Eratosthenes(int N) {
        sieve = new boolean[N];
        for (int i = 2; i < N; i++) {
            sieve[i] = true;
        }
        sift();
    }

    private void sift() {
        for (int i = 2; i < sieve.length; i++) {
            if (!sieve[i]) {
            }
            for (int j = 2; j < sieve.length; j++) {
                if (j > i && j % i == 0) {
                    sieve[j] = false;
                }
            }
        }

    }

    public boolean isSimple(int n) {
        return sieve[n];
    }

    public static void main(String[] args) {
        Eratosthenes x = new Eratosthenes(120);
        System.out.println(Arrays.toString(x.sieve));
        System.out.println();
        System.out.println(x.isSimple(99));
        System.out.println(x.isSimple(119));
    }
}
