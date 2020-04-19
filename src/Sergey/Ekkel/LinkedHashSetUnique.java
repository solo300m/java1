package Sergey.Ekkel;

import java.util.*;

public class LinkedHashSetUnique {
    public static void main(String[] args) {
        /*Set<String> strSet = new LinkedHashSet<>();
        for(int i = 0; i < 5; i++){
            strSet.add("добавим");
            strSet.add("в");
            strSet.add("цикле");
            strSet.add("в");
            strSet.add("множество");
            strSet.add("слова");
            strSet.add("но");
            strSet.add("одинаковых");
            strSet.add("не");
            strSet.add("встретим");
            strSet.add("даже");
            strSet.add("два");
        }
        System.out.println(strSet);*/
        /*Integer[]arr = {1,2,3,4,5,4,3,2,1};
        List<Integer> arrList = new ArrayList(Arrays.asList(arr));
        Set<Integer> arrSet = new HashSet<>(arrList);
        Set<Integer> intSet1 = Set.of(1,2,3,4,5);
        Set<Integer> intSet2 = Set.of(3,4,5,6,7,8,9);
        Set<Integer> meetSet = MeetOfSets.meetOfSets(intSet1, intSet2);
        Set<Integer> unionSet = MeetOfSets.unionOfSets(intSet1,intSet2);
        System.out.println(intSet1);
        System.out.println(intSet2);
        System.out.println(meetSet);
        System.out.println(arrSet);
        System.out.println(unionSet);*/
        String str = "Объект класса String";
        System.out.println(str instanceof String);
        System.out.println(str instanceof Object);

    }
    static class MeetOfSets{
        public static HashSet meetOfSets(final Set set1, final Set set2){
            HashSet result = new HashSet(set1);
            result.retainAll(set2);
            return result;
        }
        public static HashSet unionOfSets(final Set set1, final Set set2){
            HashSet result = new HashSet(set1);
            result.addAll(set2);
            return result;
        }
    }

}
