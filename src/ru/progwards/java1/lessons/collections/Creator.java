package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class MyProg{
    public static void main(String[] args) {
        Collection<Integer> fff = Creator.fillEven(12);
        for(Integer s: fff)
            System.out.print(s+" ");
        System.out.println();
        Collection<Integer> ff2 = Creator.fillOdd(19);
        for(Integer s: ff2)
            System.out.print(s+" ");
        System.out.println();
        Collection<Integer> ff3 = Creator.fill3(4);
        for(Integer s: ff3)
            System.out.print(s+" ");
        System.out.println();
    }
}

public class Creator {
    public static Collection<Integer> fillEven(int n){
        Collection<Integer> coll = new ArrayList<>();
        int j = 2;
        for(int i = 0; i < n; i++){
            coll.add(j);
            j+=2;
        }
        return coll;
    }

    public static Collection<Integer> fillOdd(int n){
        List<Integer> coll = new ArrayList<>();
        for(int i = 1; i<n*2; i++) {
            int j = i;
            if(j % 2 != 0)
               coll.add(i);
        }
        Collection<Integer> rez = new ArrayList<>();
        for(int i = coll.size()-1; i>= 0; i--) {
            rez.add(coll.get(i));
        }
        return rez;
    }

    public static Collection<Integer> fill3(int n){
        Collection<Integer> coll = new ArrayList<>();
        for(int index = 0; index < n*3; index += 3){
            for(int i = 0; i < 3; i++){
                if(i == 0)
                    coll.add(index);
                else if(i == 1)
                    coll.add(index*index);
                else if(i == 2)
                    coll.add(index*index*index);
            }
        }
        return coll;
    }
}
