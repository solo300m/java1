package ru.progwards.java2.lessons.generics;

import java.util.ArrayList;
import java.util.List;


public class FruitBox <T extends Fruit> extends Fruit {
    List<T> boxFruit;
    String name;

    public FruitBox(String name){
        boxFruit = new ArrayList<>();
        this.name = name;
    }
    public void add(T data){
        if(this.name.equals(data.name))
            boxFruit.add(data);
    }
    public float getWeight(){
        float weightAll = 0.0f;
        for(T s:boxFruit){
            weightAll += s.count * s.weight;
        }
        return weightAll;
    }
    public void moveTo(FruitBox<T>box){
        if(this.name.equals(box.name)){
            box.boxFruit.addAll(this.boxFruit);
            this.boxFruit.clear();
        }
        else{
            throw new UnsupportedOperationException("Попытка смешать разные фрукты "+"\""+
                    this.name+"\" и \""+box.name+"\"");
        }
    }
    public int compareTo(FruitBox o) {
        if(Float.compare(this.getWeight(),o.getWeight()) < 0)
            return -1;
        else if (Float.compare(this.getWeight(),o.getWeight()) == 0)
            return 0;
        else
            return 1;
    }
}
class Test3{
    public static void main(String[] args) {
        FruitBox<Apple>box1 = new FruitBox<Apple>("apple");
        box1.add(new Apple());
        box1.add(new Apple());
        box1.add(new Apple());
        box1.add(new Apple());
        box1.add(new Apple());
        FruitBox<Orange>box2 = new FruitBox<>("orange");
        box2.add(new Orange());
        box2.add(new Orange());
        box2.add(new Orange());
        box2.add(new Orange());
        box2.add(new Orange());

        System.out.println(box1.getWeight());
        System.out.println(box2.getWeight());
        FruitBox<Apple>box3 = new FruitBox<>("apple");
        box3.add(new Apple("apple"));
        box3.add(new Apple("apple"));
        System.out.println(box3.getWeight());
        box1.moveTo(box3);
        System.out.println(box1.getWeight());
        System.out.println(box2.getWeight());
        System.out.println(box3.getWeight());
        System.out.println(box1.compareTo(box2));
        System.out.println(box2.compareTo(box3));
        System.out.println(box3.compareTo(box1));
    }
}
