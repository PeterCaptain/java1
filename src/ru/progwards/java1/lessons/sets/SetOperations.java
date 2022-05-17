package ru.progwards.java1.lessons.sets;

import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> unionSet = new HashSet<>(set1);          // создаю копию set1
        unionSet.addAll(set2);
        return unionSet;
    }

    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> intersectionSet = new HashSet<>(set1);   // создаю копию set1
        intersectionSet.retainAll(set2);
        return intersectionSet;
    }

    public static Set<Integer> difference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> differenceSet = new HashSet<>(set1);     // создаю копию set1
        differenceSet.removeAll(set2);
        return differenceSet;
    }

    public static Set<Integer> symDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> unionSet = new HashSet<>(union(set1, set2));
        Set<Integer> intersectionSet = new HashSet<>(intersection(set1, set2));
        return difference(unionSet, intersectionSet);
    }
}
