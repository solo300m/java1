package ru.progwards.java1.lessons.queues;
class Proba{
    public static void main(String[] args) {
       /* Order a = new Order(120);
        Order b = new Order(121);
        Order c = new Order(122);
        Order d = new Order(123);
        System.out.println(a.getNum()+" "+b.getNum()+" "+c.getNum()+" "+d.getNum()+" ");*/
    }
}

public class Order {
    private double sum;
    private static int coun;
    private int num;
    private int priority;
    public Order(double sum){
        this.sum = sum;
        coun++;
        this.num = coun;
        if(this.sum <= 10000)
            this.priority =  3;
        else if(this.sum > 10000 && this.sum <= 20000)
            this.priority = 2;
        else if(this.sum > 20000)
            this.priority = 1;
    }
    public double getSum(){
        return sum;
    }
    public int getNum(){
        return num;
    }
    public int getPriority(){
        return priority;
    }
}