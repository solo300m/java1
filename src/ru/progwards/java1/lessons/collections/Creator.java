package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;

public class Creator {
    public static Collection<Integer> fillEven(int n){
        Collection<Integer> coll = new ArrayList<>();
        for(int i = 2; i < n; i+=2){
            coll.add(i);
        }
        return coll;
    }

    public static Collection<Integer> fillOdd(int n){
        Collection<Integer> coll = new ArrayList<>();
        for (int i = n*3; i >= 1; i--) {
            if(i % 2 != 0)
                coll.add(i);
        }
        return coll;
    }

    public static Collection<Integer> fill3(int n){
        Collection<Integer> coll = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = i; j <= (j*j*j); j*=j){
                coll.add(j);
            }
        }
        return coll;
    }
}
