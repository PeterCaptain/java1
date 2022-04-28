package ru.progwards.java1.lessons.collections;

import java.util.*;

public class Creator {

    public static Collection<Integer> fillEven(int n) {
        List<Integer> arrayList = new ArrayList<>();
        int number = 2;

        for (int i = 0; i < n; i++) {
            arrayList.add(number); // добавляем в конец списка
            number = number + 2;
        }
        return arrayList;
    }

    public static Collection<Integer> fillOdd(int n) {
        LinkedList<Integer> stack = new LinkedList<>();
        int number = 1;

        for (int i = 0; i < n; i++) {
            stack.push(number); // добавляем в начало списка
            number = number + 2;
        }
        return stack;
    }

    public static Collection<Integer> fill3(int n) {
        List<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = i * 3;
            arrayList.add(x); // добавляем в конец списка последовательно три числа
            arrayList.add(x * x);
            arrayList.add(x * x * x);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        Creator creator = new Creator();
//        System.out.println(Arrays.toString(fillEven(20).toArray()));
//        System.out.println(Arrays.toString(fillOdd(20).toArray()));
        System.out.println(Arrays.toString(fill3(3).toArray()));
    }
}
