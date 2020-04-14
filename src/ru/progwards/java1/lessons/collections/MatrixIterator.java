package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

class pro{
    public static void main(String[] args) {
        Integer [][] arr = new Integer[3][4];
        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[0][2] = 3;
        arr[0][3] = 4;
        arr[1][0] = 5;
        arr[1][1] = 6;
        arr[1][2] = 7;
        arr[1][3] = 8;
        arr[2][0] = 9;
        arr[2][1] = 10;
        arr[2][2] = 11;
        arr[2][3] = 12;
        for(int i = 0; i<3; i++){
            for (int j = 0; j < 4; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        MatrixIterator<Integer> iter = new MatrixIterator<Integer>(arr);
        while (iter.hasNext()){
            Integer intObj = iter.next();
        }
    }
}

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
                return array[indexX++][getIndexY()];
            }
            else
            {
                indexY = 0;
                return array[getIndexX()][indexY++];
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
