package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;
class MyProg{
    public static void main(String[] args) {
        Collection<Integer> fff = Creator.fillEven(15);
        for(Integer s: fff)
            System.out.print(s+" ");
        System.out.println();
        Collection<Integer> ff2 = Creator.fillOdd(15);
        for(Integer s: ff2)
            System.out.print(s+" ");
        System.out.println();
        Collection<Integer> ff3 = Creator.fill3(3);
        for(Integer s: ff3)
            System.out.print(s+" ");
        System.out.println();
    }
}

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
        for (int i = n*3*2; i >= 1; i--) {
            if(i % 2 != 0)
                coll.add(i);
        }
        return coll;
    }

    public static Collection<Integer> fill3(int n){
        Collection<Integer> coll = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            if(i == 0){
                coll.add(0);
                coll.add(0);
                coll.add(0);
            }
            else if(i == 1){
                coll.add(1);
                coll.add(1);
                coll.add(1);
            }
            else {
                for (int j = 0; j < 3; j++ ) {
                    if(j == 0)
                        coll.add(i);
                    else if(j == 1)
                        coll.add(i*i);
                    else if(j == 2)
                        coll.add(i*i*i);
                }
            }
        }
        return coll;
    }
}
