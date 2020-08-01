package ru.progwards.java2.lessons.generics;

public class Orange extends Fruit{
    public Orange(){
        name = "orange";
        count = 1;
        weight = 1.5f;
    }
    public Orange(String name){
        super.name = name;
        count = 1;
        weight = 1.5f;
    }
}
