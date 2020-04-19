package ru.progwards.java1.lessons.sets;

import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2){
        HashSet<Integer> rez = new HashSet<>(set1);
        rez.addAll(set2);
        return rez;
    }
    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2){
        HashSet<Integer> rez = new HashSet<>(set1);
        rez.retainAll(set2);
        return rez;
    }
    public static Set<Integer> difference(Set<Integer> set1, Set<Integer> set2){
        HashSet<Integer> rez = new HashSet<>(set1);
        rez.removeAll(set2);
        return rez;
    }
    public static Set<Integer> symDifference(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> rez = new HashSet<Integer>(set1);
        rez.addAll(set2);
        Set<Integer> tmp = new HashSet<Integer>(set1);
        tmp.retainAll(set2);
        rez.removeAll(tmp);
        return rez;
    }
}
