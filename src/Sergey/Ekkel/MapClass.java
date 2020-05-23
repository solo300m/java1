package Sergey.Ekkel;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class p2{
    public static void main(String[] args) {
        /*Map<Integer, String> map = new HashMap<>();
        map.put(1,"Число 1");
        map.put(2,"Число 2");
        map.put(5,"Число 5");
        map.put(10,"Число 10");
        map.put(12,"Число 12");
        int d = MapClass.fillHoles(map,15);
        System.out.println(d);
        System.out.println(map);*/
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1,"Число "+1);
        map.put(15,"Число "+15);
        MapClass.checkAndAdd(map,1,"Zero");
        MapClass.checkAndAdd(map,20,"Число 20");
        System.out.println(map);
    }
}
public class MapClass {
    //15 модуль 1 тест
    HashMap<Integer, String> a2map(int[] akey, String[] aval){
        HashMap<Integer, String> dick = new HashMap<>();
        if(akey.length == aval.length){
            for(int i = 0; i<akey.length; i++)
                dick.put(akey[i], aval[i]);
        }
        return dick;
    }
    //15 модуль 2 тест
     static int fillHoles(Map<Integer, String> map, int size){
        int rez = 0;
        for(int i = 1; i <= size; i++){
            if(!map.containsKey(i)){
                map.put(i,"Число "+i);
                rez++;
            }
        }
        return rez;
    }

    //15 модуль 3 тест
    static void checkAndAdd(TreeMap<Integer, String> map, Integer key, String value){
        if(map.size() > 0) {
            Integer first = map.firstKey();
            Integer last = map.lastKey();
            //System.out.println(first+" "+last);
            if (!map.containsKey(key) && key > first && key < last) {
                map.put(key, value);
            }
        }
    }

}
