package Sergey.Ekkel;

import java.util.TreeSet;

public class TreeSetWithCustomComporator {
    public static void main(String[] args) {
        /*Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o2, Integer o1) {
                return Integer.compare(o2,o1);
            }
        };
        Comparator<Integer> unComp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o2, Integer o1) {
                return o2.compareTo(o1);
            }
        };
        TreeSet<Integer> treeSet = new TreeSet<>(unComp);
        treeSet.addAll(List.of(3,5,-1,-3,-5,-4,4,-5,5,5,1,2,-2));
        SortedSet<Integer> subSet = treeSet.subSet(-2,5);
        SortedSet<Integer> sS = treeSet.tailSet(2);
        SortedSet<Integer> headSet = treeSet.headSet(2);

        System.out.println(treeSet);
        System.out.println(subSet);
        System.out.println(sS);
        System.out.println( headSet);*/
        TreeSet<GeoPoint> treeSet = new TreeSet<>();
        GeoPoint Moscow = new GeoPoint(55.751091,37.6135763,"Moscow");
        GeoPoint Paris = new GeoPoint(55.203056, 12.155686, "Paris");
        treeSet.add(Moscow);
        treeSet.add(Paris);
        System.out.println(treeSet);

    }
    public static class GeoPoint implements Comparable<GeoPoint>{
        double lat = 0;
        double lon = 0;
        String name;

        @Override
        public String toString() {
            return this.name +
                    ": lat=" + lat +
                    ", lon=" + lon +
                    '}';
        }

        public GeoPoint(double lat, double lon, String name){
            this.lat = lat;
            this.lon = lon;
            this.name = name;
        }

        @Override
        public int compareTo(GeoPoint o) {
            return Double.compare(o.lon,this.lon);
        }
    }

}
