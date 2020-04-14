package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
class p{
    public static void main(String[] args) {
       /* Collection<String> names = new ArrayList<>();
        names.add("Виктор");
        names.add("Ольга");
        names.add("Виктор");
        names.add("Виктор");
        names.add("Виктор");
        names.add("Ольга");
        names.add("Ольга");
        System.out.println(Finder.findSimilar(names));*/
       Collection<Integer> numbers = new ArrayList<>();
       for(int i = 1; i < 20; i++){
           numbers.add(i);
       }
        System.out.println(Finder.findSequence(numbers));
    }
}

public class Finder {
    public static Collection<Integer> findMinSumPair(Collection<Integer> numbers){
        List<Integer> list = new ArrayList<>();
        List<Integer> rez = new ArrayList<>(2);
        list.addAll(numbers);
        rez.add(0);
        rez.add(1);
        Integer sumTwo = list.get(0) + list.get(1);

        for(int i = 2; i < numbers.size(); i++){
            if(sumTwo > list.get(i) + list.get(i-1)){
                sumTwo = list.get(i) + list.get(i-1);
                rez.set(0,i-1);
                rez.set(1,i);
            }
        }
        return (Collection<Integer>) rez;
    }

    public static Collection<Integer> findLocalMax(Collection<Integer> numbers){
        Collection<Integer> rez = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.addAll(numbers);
        for(int i = 1; i < numbers.size()-1; i++){
            if((temp.get(i) > temp.get(i-1))&&(temp.get(i) > temp.get(i+1)))
                rez.add(temp.get(i));
        }
        return rez;
    }

    public static boolean findSequence(Collection<Integer> numbers){
        numbers = (List<Integer>) numbers;
        List<Integer> temp = new ArrayList<>();
        for(int i = 1; i <= numbers.size(); i++)
            temp.add(i);
        /*for(Integer s: temp)
            System.out.print(s+" ");*/
        boolean rez = true;
        for(int i = 0; i < numbers.size(); i++){
            for(int j = 0; j < temp.size(); j++){
                if(((List<Integer>) numbers).get(i).equals(temp.get(j)) == true) {
                    rez = true;
                    break;
                }
                else{
                    rez = false;
                }
            }
            if(rez == false)
                break;
        }
        return rez;
    }

    public static String findSimilar(Collection<String> names){
        class CountWord{
            private String name;
            private int count;
            public CountWord(String name, int count){
                this.name = name;
                this.count = count;
            }
            public String getName(){
                return name;
            }
            public int getCount(){
                return count;
            }
            public void setName(String name){
                this.name = name;
            }
            public void setCount(int f){
                this.count = f;
            }
        }

        List<String> str = new ArrayList<>();
        str.addAll(names);
        List<CountWord> arr = new ArrayList<>();

        arr.add(new CountWord(str.get(0),1));
        int arrS = 0;
        int arrCount = 1;
        for(int i = 1; i < names.size(); i++){
            if(str.get(i).equals(str.get(i-1))) {
                arrCount++;
                arr.get(arrS).setCount(arrCount);
                //System.out.println(arr.get(0).getName());
            }
            else{
                arr.add(new CountWord(str.get(i), 1));
                arrCount = 1;
                arrS++;
            }
        }
        /*for(int i = 0; i<arr.size(); i++)
            System.out.println(arr.get(i).getName()+" "+arr.get(i).getCount());*/
        int max = arr.get(0).getCount();
        int index = 0;
        for(int i=1; i< arr.size(); i++){
            if(max < arr.get(i).getCount()) {
                max = arr.get(i).getCount();
                index = i;
            }
        }
        String rez1 = "";
        rez1 = arr.get(index).getName() +":"+ arr.get(index).getCount();

        return rez1;
    }
}