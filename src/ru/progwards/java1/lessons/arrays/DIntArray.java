package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

class Pro{
    public static void main(String[] args) {
        int[] a1 = {1,23,45,65,-2,3,0};
        DIntArray arrNew = new DIntArray(a1);
        for(int i = 0; i<arrNew.length(); i++)
            System.out.print(arrNew.at(i)+" ");
        System.out.println();
        arrNew.add(55);
        for(int i = 0; i<arrNew.length(); i++)
            System.out.print(arrNew.at(i)+" ");
        System.out.println();
        arrNew.atInsert(3,777);
        for(int i = 0; i<arrNew.length(); i++)
            System.out.print(arrNew.at(i)+" ");
        System.out.println();
        arrNew.atDelete(3);
        for(int i = 0; i<arrNew.length(); i++)
            System.out.print(arrNew.at(i)+" ");
        System.out.println();
    }
}

public class DIntArray {
    private int [] arr;
    public DIntArray(){}
    public DIntArray(int[]a){
        arr = Arrays.copyOf(a,a.length);
    }

    public int length(){
        return arr.length;
    }
    public void add(int num){
        int [] arr2 = new int [arr.length+1];
        for(int i = 0; i<arr.length; i++)
            arr2[i] = arr[i];
        arr2[arr2.length-1]=num;
        arr = arr2;
    }
    public void atInsert(int pos, int num){
        int [] arr3 = new int [arr.length+1];
        for(int i = 0; i<pos; i++)
            arr3[i] = arr[i];
        arr3[pos]=num;
        for(int i = pos+1; i<arr3.length; i++)
            arr3[i] = arr[i-1];
        arr = arr3;
    }
    public void atDelete(int pos){
        int [] arr2 = new int [arr.length-1];
        for(int i = 0; i<pos; i++)
            arr2[i] = arr[i];
        for(int i = pos; i<arr2.length; i++)
            arr2[i] = arr[i+1];
        arr = arr2;
    }
    public int at(int pos){
        if(pos<arr.length)
            return arr[pos];
        else return 0;
    }
}
