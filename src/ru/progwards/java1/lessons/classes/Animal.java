package ru.progwards.java1.lessons.classes;
enum AnimalKind {ANIMAL, COW, HAMSTER, DUCK}
enum FoodKind {UNKNOWN, HAY, CORN}
class Programm{
    public static void main(String[] args) {
        Animal an1 = new Animal(100);
        Cow co1 = new Cow(300);
        Hamster ha1 = new Hamster(12);
        Duck du1 = new Duck(5);
        System.out.println(an1);
        System.out.println(co1);
        System.out.println(ha1);
        System.out.println(du1);
        System.out.println("___________________");
        System.out.println(co1.toStringFull());
        System.out.println(ha1.toStringFull());
        System.out.println(du1.toStringFull());
    }
}

public class Animal {
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

    public String toStringFull(){
        return "I am "+getKind()+", eat "+getFoodKind()+" "+calculateFoodWeight();
    }
}
