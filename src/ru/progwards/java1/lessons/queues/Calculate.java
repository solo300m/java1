package ru.progwards.java1.lessons.queues;

class Calculator{
    public static void main(String[] args) {
        System.out.println(Calculate.calculation1());
        System.out.println(Calculate.calculation2());

    }
}

public class Calculate {
    //2.2*(3+12.1)
    public static double calculation1(){
        StackCalc stac1 = new StackCalc();

        stac1.push(2.2);

        stac1.push(3.0);

        stac1.push(12.1);

        stac1.add();

        stac1.mul();

        return stac1.pop();
    }
    //(737.22+24)/(55.6-12.1)+(19-3.33)*(87+2*(13.001-9.2))
    public static double calculation2(){
        StackCalc stac1 = new StackCalc();
        stac1.push(13.001);
        stac1.push(9.2);
        stac1.sub();
        stac1.push(2.0);
        stac1.mul();
        stac1.push(87.0);
        stac1.add();
        stac1.push(19.0);
        stac1.push(3.33);
        stac1.sub();
        stac1.mul();
        stac1.push(737.22);
        stac1.push(24);
        stac1.add();
        stac1.push(55.6);
        stac1.push(12.1);
        stac1.sub();
        stac1.div();
        stac1.add();
        return stac1.pop();

    }

}
