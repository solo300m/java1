package ru.progwards.java1.lessons.arrays;
class Prog{
    public static void main(String[] args) {
        int[]a = {12,3,-4,17,-33,245,0,55,-166,-44,99};
        ArraySort.sort(a);
        for(int s:a)
            System.out.print(s+" ");
    }
}

public class ArraySort {
    public static void sort(int[] a){
        for(int i=0; i < a.length; i++){
            for(int j=i+1; j < a.length; j++){
                if(a[j] < a[i]){
                    int ref = a[j];
                    a[j] = a[i];
                    a[i] = ref;
                }
            }
        }
    }
}
