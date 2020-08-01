package ru.progwards.java2.lessons.generics;

import java.util.Arrays;


public class DynamicArray <T extends Comparable<T>>{
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private Object[] array;
    private int countFool;
    public DynamicArray(){
        this.array = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        countFool = 0;
    }

    public DynamicArray(T...args){
        this.array = Arrays.copyOf(args,args.length*2);//(T[]) Array.newInstance(args.getClass().getComponentType(),args.length*2);
        /*for(int i = 0; i<args.length; i++){
            array[i] = args[i];
        }*/
        countFool = args.length;
    }
    public int getCountFool(){
        return countFool;
    }

    @SuppressWarnings("unchecked")
    public T getIndex(int i){
        return (T) array[i];
    }
    @SuppressWarnings("unchecked")
    public int lengthArray(){
        return array.length;
    }
    public void add(T data){
        if(countFool != 0 && countFool == array.length ){
            Object[] tmp = Arrays.copyOf(array,array.length*2);
            this.array = null;
            this.array = Arrays.copyOf(tmp,tmp.length);
            array[countFool] = data;
            countFool++;
        }
        else if(countFool != 0 && countFool < array.length){
            array[countFool] = data;
            countFool++;
        }
        else if(countFool == 0 && array.length == 0){
            array = new Object[2];
            array[0] = data;
            countFool++;
        }
    }
    public void insert(int position, T data){
        if(position < countFool && position >=0){
            Object[]tmp = Arrays.copyOfRange(array,0,position);
            tmp = Arrays.copyOf(tmp,array.length+1);
            tmp[position] = data;
            for(int i = position+1; i < array.length;i++){
                tmp[i]=array[i-1];
            }
            array = Arrays.copyOf(tmp,array.length);
            countFool++;
            if(countFool == array.length)
                array = Arrays.copyOf(array,array.length*2);
        }else if(position >= countFool && array.length > position){
            array[countFool] = data;
            countFool++;
            if(countFool == array.length)
                array = Arrays.copyOf(array,array.length*2);
        }
    }
    public int size(){
        return countFool;
    }
    public void remove(int pos){
        if(pos > 0 && pos <= size()){
            Object[]tmp = Arrays.copyOfRange(array,0,pos);
            tmp = Arrays.copyOf(tmp,array.length-1);
            for(int i = pos+1; i < size(); i++){
                tmp[i-1] = array[i];
            }
            array = Arrays.copyOf(tmp,array.length-1);
            countFool--;
        }
        else if(pos == 0 && size()!=0){
            array = Arrays.copyOfRange(array,1,array.length-1);
            countFool--;
        }
    }
    public T get(int pos){
        if(pos >=0 && pos < size()) {
            return (T) array[pos];
        }
        return null;
    }

}
class test2{
    public static void main(String[] args) {
        //DynamicArray<Integer>int2 = new DynamicArray<Integer>(1,2,3,4,5,6,7);
        DynamicArray<Integer>int2 = new DynamicArray<Integer>();
        int2.add(2);
        int2.add(5);
        int2.add(6);
        int2.add(3);
        int2.add(8);
        int2.insert(2,77);
        int2.insert(6,13);
        int2.insert(2,77);
        for(int i = 0; i<int2.size(); i++){
            System.out.print(int2.getIndex(i)+" ");
        }
        System.out.println();
        System.out.println(int2.size());
        System.out.println(" number of next position "+int2.getCountFool());
        int2.remove(1);
        for(int i = 0; i<int2.size(); i++){
            System.out.print(int2.getIndex(i)+" ");
        }
        System.out.println();
        System.out.println(int2.size());
        System.out.println(" number of next position "+int2.getCountFool());
        int2.remove(0);
        for(int i = 0; i<int2.size(); i++){
            System.out.print(int2.getIndex(i)+" ");
        }
        System.out.println();
        System.out.println(int2.size());
        System.out.println(" number of next position "+int2.getCountFool());
        System.out.println(int2.get(3));
    }
}
