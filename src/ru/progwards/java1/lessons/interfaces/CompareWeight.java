package ru.progwards.java1.lessons.interfaces;

public interface CompareWeight {

    public enum CompareResult{LESS, EQUAL, GREATER}
    public CompareResult compareWeight(CompareWeight smthHasWeigt);

    static void sort(CompareWeight[] a) {
        for(int i=0; i < a.length; i++){
            for(int j=i+1; j < a.length; j++){
                if (a[i].compareWeight(a[j]) == CompareResult.LESS) {
                    CompareWeight ref = a[j];
                    a[j] = a[i];
                    a[i] = ref;
                }
            }
        }
    }


}
