package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

public class MatrixIterator<T> implements Iterator<T> {

    private T[][] array;
    private int indexX;
    private int indexY;
    private Iterator<T> row;
    private Iterator<T> coll;

    MatrixIterator(T[][] array) {
        this.array = array;
        indexX = 0;
        indexY = 0;
        this.row = new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if(getIndexX()>array.length)
                    return false;
                else
                    return true;
            }

            @Override
            public T next() {
                return array[indexX++][getIndexY()];
            }
        };
        this.coll = new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if(getIndexY() > array[getIndexX()].length)
                    return false;
                else
                    return true;
            }

            @Override
            public T next() {
                return array[getIndexX()][indexY++];
            }
        };
    }

    @Override
    public boolean hasNext() {
        if(row.hasNext() == true && coll.hasNext() == true)
            return true;
        else
            return false;
    }

    @Override
    public T next() {
        if(row.hasNext()){
            if(coll.hasNext()){
                return array[getIndexX()][indexY++];
            }
            else
            {
                indexY = 0;
                return array[indexX++][getIndexY()];
            }
        }
        else
            return null;
    }
    public int getIndexX(){
        return indexX;
    }
    public  int getIndexY(){
        return indexY;
    }
}
