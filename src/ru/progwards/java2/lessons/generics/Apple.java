package ru.progwards.java2.lessons.generics;

public class Apple extends Fruit {
    public Apple(){
        super.name = "apple";
        super.count = 1;
        super.weight = 1.0f;
    }
    public Apple(String name){
        super.name = name;
        super.count = 1;
        super.weight = 1.0f;
    }
}
