package ru.progwards.java1.lessons.interfaces;

public class Hamster extends Animal {
    public Hamster(double weight){
        super(weight);
    }
    @Override
    public AnimalKind getKind(){
        return AnimalKind.HAMSTER;
    }
    @Override
    public FoodKind getFoodKind(){
        return FoodKind.CORN;
    }
    @Override
    public double getFoodCoeff(){
        double foodCoeff = 0.03;
        return foodCoeff;
    }
}
