package ru.progwards.java1.lessons.interfaces;

import java.util.Objects;

enum AnimalKind {ANIMAL, COW, HAMSTER, DUCK}

enum FoodKind {UNKNOWN, HAY, CORN}

class Programm{
    public static void main(String[] args) {

    }
}

public class Animal implements FoodCompare, CompareWeight{
    private double weight;
    public Animal(double weight){
        this.weight = weight;
    }
    public AnimalKind getKind(){
        return AnimalKind.ANIMAL;
    }
    public FoodKind getFoodKind(){
        return FoodKind.UNKNOWN;
    }
    @Override
    public String toString(){
        return "I am "+getKind()+", eat "+getFoodKind();
    }
    public double getWeight(){
        return weight;
    }
    public double getFoodCoeff(){
        double foodCoeff = 0.02;
        return foodCoeff;
    }
    public double calculateFoodWeight(){
        return getWeight() * getFoodCoeff();
    }

    public double getFood1kgPrice(){
        switch (getFoodKind()){
            case HAY:return 20.0;
            case CORN:return 50.0;
            case UNKNOWN:return 0.0;
        }
        return 0.0;
    }

    public double getFoodPrice(){
        return calculateFoodWeight() * getFood1kgPrice();
    }
    public String toStringFull(){
        return "I am "+getKind()+", eat "+getFoodKind()+" "+calculateFoodWeight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Double.compare(animal.weight, weight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight);
    }

    @Override
    public int compareFoodPrice(Animal animal) {
        if((Double.compare(this.getFoodPrice(), animal.getFoodPrice())==1))
            return 1;
        else if((Double.compare(this.getFoodPrice(), animal.getFoodPrice())==0))
            return 0;
        else
            return -1;
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        Animal animal = (Animal)smthHasWeigt;
        if(Double.compare(this.getWeight(),animal.getWeight())==-1)
            return CompareResult.LESS;
        else if(Double.compare(this.getWeight(), animal.getWeight())==0)
            return CompareResult.EQUAL;
        else return CompareResult.GREATER;
    }
}

