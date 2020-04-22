package ru.progwards.java1.lessons.queues;

import java.util.Comparator;
import java.util.PriorityQueue;

public class OrderQueue {
    private PriorityQueue<Order> myDec;
    public OrderQueue(){
        myDec = new PriorityQueue<>(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                if(Integer.compare(o1.getPriority(),o1.getPriority()) == 0)
                    return Integer.compare(o1.getNum(),o2.getNum());
                else
                    return Integer.compare(o1.getPriority(), o2.getPriority());
            }
        });
    }

    public void add(Order order){
        if(order != null) {
            myDec.offer(order);
        }
    }
    public Order get(){
        if(!myDec.isEmpty())
            return myDec.poll();
        else
            return null;
    }
}