package ru.progwards.java1.lessons.queues;

import java.util.ArrayDeque;

public class StackCalc {
    ArrayDeque<Double> calcStack;
    public StackCalc(){
        calcStack = new ArrayDeque<>();
    }

    public void push(double value){
        calcStack.push(value);
    }
    public double pop(){
        if(!calcStack.isEmpty())
            return calcStack.pop();
        else return 0.0;
    }
    public void add(){
        if(!calcStack.isEmpty() && calcStack.size() >= 2) {
            Double a = calcStack.pop();
            Double b = calcStack.pop();
            calcStack.push(a + b );
        }
    }
    public void sub(){
        if(!calcStack.isEmpty() && calcStack.size() >= 2) {
            Double a = calcStack.pop();
            Double b = calcStack.pop();
            calcStack.push(b - a );
        }
    }
    public void mul(){
        if(!calcStack.isEmpty() && calcStack.size() >= 2) {
            Double a = calcStack.pop();
            Double b = calcStack.pop();
            calcStack.push(a * b );
        }
    }
    public void div(){
        if(!calcStack.isEmpty() && calcStack.size() >= 2) {
            if(calcStack.element() != 0) {
                Double a = calcStack.pop();
                Double b = calcStack.pop();
                calcStack.push(b/a);
            }
        }
    }
    public double element(){
        return calcStack.element();
    }

}
