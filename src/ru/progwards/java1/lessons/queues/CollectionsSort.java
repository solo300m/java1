package ru.progwards.java1.lessons.queues;

import java.util.*;

class Prog1{
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        for(int i = 0; i < 100000; i++)
            data.add(i);
        Collections.shuffle(data);
        /*System.out.println(data);
        CollectionsSort.minSort(data);
        List<Integer> data1 = new ArrayList<>(List.of(1,2,3,4,5,6,7,8));
        Collections.shuffle(data1);
        CollectionsSort.collSort(data1);
        Collections.shuffle(data1);
        System.out.println(data1);
        CollectionsSort.mySort(data1);*/
        CollectionsSort a = new CollectionsSort(data);
        System.out.println(a.compareSort());
    }
}
public class CollectionsSort {
    public static Collection<Integer> data;
    public CollectionsSort(List<Integer> a){
        data = new ArrayList<>();
        this.data.addAll(a);
    }
    public Collection<Integer> getData(){
        return data;
    }

    public static void mySort(Collection<Integer> data){
        List<Integer> rez = new ArrayList<>();
        rez.addAll(data);
        for(int i=0; i < rez.size(); i++){
            for(int j=i+1; j < rez.size(); j++){
                if(rez.get(j) < rez.get(i)){
                    Integer ref = rez.get(j);
                    rez.set(j, rez.get(i));
                    rez.set(i, ref);
                }
            }
        }
        data = rez;
        //System.out.println(data);
    }
    public static void minSort(Collection<Integer> data){
        List<Integer> rez = new ArrayList<>();
        while(!data.isEmpty()) {
            Integer tmp = Collections.min(data);
            data.remove(tmp);
            rez.add(tmp);
        }
        data.addAll(rez);
        //System.out.println(data);
    }
    public static void collSort(Collection<Integer> data){
        List<Integer> rez = new ArrayList<>();
        if(!data.isEmpty()) {
            rez.addAll(data);
            Collections.sort(rez);
        }
        //System.out.println(rez);
    }
    public static Collection<String> compareSort(){
        List<String> rez = new ArrayList<>();
        List<AnalisSpeed> array = new ArrayList<>();
        AnalisSpeed mySort = new AnalisSpeed("mySort");
        AnalisSpeed minSort = new AnalisSpeed("minSort");
        AnalisSpeed collSort = new AnalisSpeed("collSort");
        array.add(mySort);
        array.add(minSort);
        array.add(collSort);

        long start = System.currentTimeMillis();
        CollectionsSort.collSort(CollectionsSort.data);
        long timeProces = System.currentTimeMillis() - start;
        array.get(array.indexOf(collSort)).setSpeed(timeProces);
        Collections.shuffle((List<?>) CollectionsSort.data);

        start = System.currentTimeMillis();
        CollectionsSort.mySort(CollectionsSort.data);
        timeProces = System.currentTimeMillis() - start;
        array.get(array.indexOf(mySort)).setSpeed(timeProces);
        Collections.shuffle((List<?>) CollectionsSort.data);

        start = System.currentTimeMillis();
        CollectionsSort.minSort(CollectionsSort.data);
        timeProces = System.currentTimeMillis() - start;
        array.get(array.indexOf(minSort)).setSpeed(timeProces);

        //System.out.println(this.data);




        Collections.sort(array, new Comparator<AnalisSpeed>() {
            @Override
            public int compare(AnalisSpeed o1, AnalisSpeed o2) {
                if(Long.compare(o1.getSpeed(),o2.getSpeed()) == 0){
                    return o1.getNameMetod().compareTo(o2.getNameMetod());
                }
                else
                    return Long.compare(o1.getSpeed(),o2.getSpeed());
            }
        });
        //System.out.println(array);
        for(AnalisSpeed s:array)
            rez.add(s.getNameMetod());
        return rez;
    }

}