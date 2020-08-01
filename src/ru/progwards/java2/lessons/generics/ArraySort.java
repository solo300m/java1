package ru.progwards.java2.lessons.generics;

public class ArraySort<T extends Comparable>  {
    public T[] array;
    public ArraySort(int i){
        this.array = (T[])new Object[i];
    }
    public ArraySort(T...args){
        this.array = args;
    }
    public void add(T arg){
        T[] tmp = (T[])new Object[array.length+1];
        tmp = array.clone();
        tmp[tmp.length-1] = arg;
        array = null;
        array = (T[])new Object[tmp.length];
        array = tmp.clone();
        tmp=null;
    }
    public void sort(){
        T hight;
        for(int i = 0;i < array.length; i++){
            for(int j = i+1; j < array.length; j++){
                if(array[i].compareTo(array[j]) >= 1){
                    hight = array[i];
                    array[i] = array[j];
                    array[j] = hight;
                }
            }
        }
    }
    public T get(int i){
        return array[i];
    }
}
class test{
    public static void main(String[] args) {
        ArraySort<Integer> int1 = new ArraySort<>(1,5,4,9,11,-1,-3,-11);
        int1.sort();
        for(int i = 0; i < int1.array.length; i++){
            System.out.print(int1.get(i)+" ");
        }

    }
}
