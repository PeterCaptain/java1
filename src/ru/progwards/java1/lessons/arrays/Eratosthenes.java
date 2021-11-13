package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class Eratosthenes {
    private final boolean[] sieve;

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
                continue;
            }
            for (int j = 2; j * i < sieve.length; j++) {
                    sieve[j * i] = false;
                }
            }
        }

    public boolean isSimple(int n) {
        if (n >= sieve.length) {
            System.out.print("Число " + n + " - вне области вычислений.\nВведите число в диапазоне  2..." + (n - 1) + ".  ");
            return false;
        }
        else if (!sieve[n]) {
            System.out.print("Число " + n + " - составное.  ");
        }
        else {
            System.out.print("Число " + n + " - простое.  ");
        }
        return sieve[n];
    }

    //test
    public static void main(String[] args) {
        Eratosthenes x = new Eratosthenes(200);
        System.out.println(Arrays.toString(x.sieve));
        System.out.println();
        System.out.println(x.isSimple(29));
        System.out.println();
        System.out.println(x.isSimple(30));
        System.out.println();
        System.out.println(x.isSimple(300));
    }
}
