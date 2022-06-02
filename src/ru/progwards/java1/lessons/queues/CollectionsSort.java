package ru.progwards.java1.lessons.queues;

import java.util.*;

public class CollectionsSort {

    public static void mySort(Collection<Integer> data) {
        List<Integer> tempList = (ArrayList<Integer>) data;
        for (int i = 0; i < tempList.size() - 1; i++) {
            for (int j = i + 1; j < tempList.size(); j++) {
                if (tempList.get(i) > tempList.get(j)) {
                    Collections.swap(tempList, i, j);
                }
            }
        }
    }

    public static void minSort(Collection<Integer> data) {
        ArrayDeque<Integer> tempResult = new ArrayDeque<>();
        while (!data.isEmpty()) {
            int numMin = Collections.min(data);
            data.remove(numMin);
            tempResult.offer(numMin);
        }
        data.addAll(tempResult);
    }

    static void collSort(Collection<Integer> data) {
        Collections.sort((ArrayList<Integer>) data);
    }

    public static Collection<String> compareSort() {
        class Method {
             final String method;
             final Long time;

            Method(String method, Long time) {
                this.method = method;
                this.time = time;
            }
            // для тестирования
            @Override
            public String toString() {
                return method + " " + time;
            }
        }

        PriorityQueue<Method> compareMethods = new PriorityQueue<>(new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                if(o1.time.compareTo(o2.time) == 0) {
                    return o1.method.compareTo(o2.method); // сравнение по имени
                }
                return o1.time.compareTo(o2.time);         // сравнение по времени
            }
        });

        long start = System.currentTimeMillis();
        mySort(fillList());
        long mySortTime = System.currentTimeMillis() - start;
        compareMethods.offer(new Method("mySort", mySortTime));

        Collections.shuffle(fillList());
        start = System.currentTimeMillis();
        minSort(fillList());
        long minSortTime = System.currentTimeMillis() - start;
        compareMethods.offer(new Method("minSort", minSortTime));

        Collections.shuffle(fillList());
        start = System.currentTimeMillis();
        minSort(fillList());
        long collSortTime = System.currentTimeMillis() - start;
        compareMethods.offer(new Method("collSort", collSortTime));

        ArrayDeque<String> resultDeque = new ArrayDeque<>();

        while (!compareMethods.isEmpty()) {
            resultDeque.offer(compareMethods.poll().method);
        }
        return resultDeque;
    }

    private static List<Integer> fillList() {
        List<Integer> list = new ArrayList<>(10_000);
        int ITERATIONS = 10_000;
        int count = 0;
        Random rnd = new Random();
        while (count <= ITERATIONS) {
            list.add(rnd.nextInt());
            count++;
        }
        return list;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        Collections.addAll(list1, 2, 10, 8, 1, 3, 9, 7, 6, 5, 4);
        Collections.addAll(list2, 2, 10, 8, 1, 3, 9, 7, 6, 5, 4);
        Collections.addAll(list3, 2, 10, 8, 1, 3, 9, 7, 6, 5, 4);

        System.out.println(list1);
        mySort(list1);
        System.out.println(list1);
        System.out.println("****");
        System.out.println(list2);
        minSort(list2);
        System.out.println(list2);
        System.out.println("****");

        System.out.println(list3);
        collSort(list3);
        System.out.println(list3);

        System.out.println(compareSort());
    }
}
