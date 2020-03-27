package ru.progwards.java1.lessons.interfaces;

class Prog{
    public static void main(String[] args) {
        int[]a = {12,3,-4,17,-33,245,0,55,-166,-44,99};
        ArraySort[] elem = new ArraySort[a.length];
        for(int i=0; i<a.length; i++){
            ArraySort v = new ArraySort();
            elem[i] = v;
            elem[i].setElem(a[i]);
            System.out.print(elem[i].getElem()+" ");
        }
        System.out.println();
        for(ArraySort el: elem)
            System.out.print(el.getElem()+" ");
        System.out.println();

        ArraySort.sort(elem);
        for(ArraySort el: elem)
            System.out.print(el.getElem()+" ");
        System.out.println();
    }
}

public class ArraySort implements CompareWeight{
    private int elem;
    public ArraySort(){
        elem = 0;
    }
    public void setElem(int a){
        this.elem = a;
    }
    public int getElem(){
        return elem;
    }
    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        ArraySort ani = (ArraySort) smthHasWeigt;
        if(Double.compare(this.getElem(),ani.getElem())==-1)
            return CompareResult.LESS;
        else if(Double.compare(this.getElem(), ani.getElem())==0)
            return CompareResult.EQUAL;
        else return CompareResult.GREATER;
    }

    static public void sort(CompareWeight[] a) {
        for(int i=0; i < a.length; i++){
            for(int j=i+1; j < a.length; j++){
                if (a[i].compareWeight(a[j]) == CompareResult.GREATER) {
                    CompareWeight ref = a[j];
                    a[j] = a[i];
                    a[i] = ref;
                }
            }
        }
    }

}