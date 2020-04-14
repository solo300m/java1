package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {
    private T[] array;
    private int index;

    ArrayIterator(T[] array) {
        this.array = array;
        index = 0;
    }
    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        if(getIndex() >= array.length)
            return false;
        else
            return true;
    }

    @Override
    public T next() {
        // TODO Auto-generated method stub
        T rez = array[index];
        index++;
        return rez;
    }
    public int getIndex(){
        return index;
    }
}

