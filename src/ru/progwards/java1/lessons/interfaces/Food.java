package ru.progwards.java1.lessons.interfaces;

public class Food implements CompareWeight {
    private int weight;
    public Food(int weight){
        this.weight = weight;
    }
    public int getWeight(){
        return weight;
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        Food food = (Food)smthHasWeigt;
        if(Double.compare(this.getWeight(),food.getWeight())==-1)
            return CompareResult.LESS;
        else if(Double.compare(this.getWeight(),food.getWeight())==0)
            return CompareResult.EQUAL;
        else return CompareResult.GREATER;
    }

    public void sort(CompareWeight[] a){
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
