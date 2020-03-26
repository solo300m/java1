package ru.progwards.java1.lessons.interfaces;

public interface CompareWeight {
    public enum CompareResult{LESS, EQUAL, GREATER}
    public CompareResult compareWeight(CompareWeight smthHasWeigt);
    //С заданной сигнатурой в интерфейсе можно реализовать статический метод,
    //но только вместе с телом. Я вычитал в литературе, что начиная с Java9
    //такая возможность появилась. А иначе, если реализовывать тело метода в
    //основном классе надо менять сигнатуру, убирая static вообще.
    //Или я чего то недопонял??? Прошу прокомментировать.
    //Тест меня с таким решением не пропустил. Вношу изменения.
    public void sort(CompareWeight[] a);
    /*public static void sort(CompareWeight[] a) {
        for(int i=0; i < a.length; i++){
            for(int j=i+1; j < a.length; j++){
                if (a[i].compareWeight(a[j]) == CompareResult.GREATER) {
                    CompareWeight ref = a[j];
                    a[j] = a[i];
                    a[i] = ref;
                }
            }
        }
    }*/

}