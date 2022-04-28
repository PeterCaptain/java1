package ru.progwards.java1.lessons.collections;

import java.util.*;

public class Finder {

    public static Collection<Integer> findMinSumPair(Collection<Integer> numbers) {
        List<Integer> arrayList = (ArrayList<Integer>) (numbers);
        int sumIndex = 0;
        int sum_min = arrayList.get(0) + arrayList.get(1);

        for (int i = 1; i < arrayList.size() - 1; i++) {
            int sum_2 = arrayList.get(i) + arrayList.get(i + 1);
            sum_min = Math.min(sum_min, sum_2);
            sumIndex = (sum_min < sum_2) ? sumIndex : i;
        }
        arrayList.clear();
        arrayList.add(sumIndex);
        arrayList.add(sumIndex + 1);
        return arrayList;
    }

    public static Collection<Integer> findLocalMax(Collection<Integer> numbers) {
        List<Integer> arrayList = (ArrayList<Integer>) (numbers);
        List<Integer> resultArrayList = new ArrayList<>();
        for (int i = 1; i < arrayList.size() - 1; i++) {
            if (arrayList.get(i - 1) < arrayList.get(i) && arrayList.get(i) > arrayList.get(i + 1)) {
                resultArrayList.add(arrayList.get(i));
            }
        }
        return resultArrayList;
    }

    public static boolean findSequence(Collection<Integer> numbers) {
        Collections.sort((ArrayList<Integer>) numbers);
        int count = 1;

        for (Integer num : numbers) {
            if (num != count) {
                return false;
            }
            count++;
        }
        return true;
    }
/*
Метод определяет максимальное кол-во повторяющихся подряд элементов коллекции.
При этом,
 */
    public static String findSimilar(Collection<String> names) {
        List<String> list = (ArrayList<String>) names;
        int indexStart = 0;
        int indexElement = 0;
        int maxRepeat = 0;

        while (indexStart < list.size() - 1) { // исключаю последний элемент из проверки
            String word_1 = list.get(indexStart);
            int countRepeat = 1;
            for (int j = indexStart + 1; j < list.size(); j++) { // исключаю первый элемент из проверки
                String word_2 = list.get(j);
                if (word_1.equals(word_2)) {
                    countRepeat++;
                } else {
                    break;
                }
            }
            if (maxRepeat < countRepeat) {
                maxRepeat = countRepeat;
                indexElement = indexStart;
            }
            indexStart = indexStart + countRepeat;
        }

        return  list.get(indexElement) + ':' + maxRepeat;
    }


    public static void main(String[] args) {
        Collection<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

        Collection<Integer> list2 = new ArrayList<>();
        list2.add(10);
        list2.add(2);
        list2.add(9);
        list2.add(4);
        list2.add(8);
        list2.add(6);
        list2.add(7);
        list2.add(5);
        list2.add(3);
        list2.add(1);

        Collection<String> list3 = new ArrayList<>();
        list3.add("вася");
        list3.add("петя");
        list3.add("петя");
        list3.add("саша");
        list3.add("вова");
        list3.add("вова");
        list3.add("вова");
        list3.add("юра");
        list3.add("макс");
        list3.add("макс");
        list3.add("макс");
        list3.add("макс");
        list3.add("иван");
        list3.add("иван");
        list3.add("иван");

        System.out.println(Arrays.toString(findMinSumPair(list).toArray()));
        System.out.println(findSequence(list2));
        System.out.println(findSimilar(list3));

    }
}
