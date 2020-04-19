package Sergey.Ekkel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

class prog{
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>();
        /*list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(5);
        List<Integer> list2 = new ArrayList<>();
        list2 = Collections.listAction(list1);
        for(int i = 0; i<list2.size(); i++)
            System.out.println(list2.get(i));*/
        for(int i = 10; i<20;i++){
            list1.add(i);
        }
        for(Integer s:list1)
            System.out.print(s+" ");
        System.out.println();
        ListIterator<Integer> list1It = list1.listIterator();
        Collections.iterator3(list1It);
        for(Integer s:list1)
            System.out.print(s+" ");
        Collection<Integer> numbers = new ArrayList<>();
        for(int i=0; i<5; i++)
            numbers.add(i);


    }
}
public class Collections {
// Первое тестовое задание блока 12
    public static List<Integer> listAction(List<Integer> list){
        list.remove(min(list));
        list.add(0,list.size());
        list.add(2,max(list));
        return list;
    }

    private static Integer max(List<Integer> list) {
        Integer max = list.get(0);
        for(int i = 0; i<list.size(); i++){
            if(list.get(i) > max)
                max = list.get(i);
        }
        return max;
    }
    private static Integer min(List<Integer> list) {
        Integer min = list.get(0);
        for(int i = 0; i<list.size(); i++){
            if(list.get(i) < min)
                min = list.get(i);
        }
        return min;
    }
// Второе тестовое задание блока 12
    public static List<Integer> filter(List<Integer> list){
        int filter = sumCollection(list) / 100;
        for(int i = list.size()-1; i >=0; i--){
            if(list.get(i) >= filter)
                list.remove(i);
        }
        return list;
    }
    private static Integer sumCollection(List<Integer> list){
        Integer rez = 0;
        for(Integer i:list)
            rez += i;
        return rez;
    }

//Третье тестовое задание блока 12

    public static void iterator3(ListIterator<Integer> iterator){
        while(iterator.hasNext()){
            Integer s = iterator.next();
            if(s%3 == 0) {

                iterator.set(iterator.previousIndex());

            }
        }

    }
}


