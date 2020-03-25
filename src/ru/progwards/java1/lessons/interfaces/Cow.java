package ru.progwards.java1.lessons.interfaces;

public class Cow extends Animal {
    public Cow(double weight) {
        super(weight);
    }
    @Override
    public AnimalKind getKind(){
        return AnimalKind.COW;
    }
    @Override
    public FoodKind getFoodKind(){
        return FoodKind.HAY;
    }

    @Override
    public double getFoodCoeff(){
        double foodCoeff = 0.05;
        return foodCoeff;
    }
}
