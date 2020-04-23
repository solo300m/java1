package ru.progwards.java1.lessons.queues;

import java.util.Comparator;
import java.util.PriorityQueue;

class r{
    public static void main(String[] args) {
        OrderQueue d = new OrderQueue();
        Order a1 = new Order(21991.0);
        Order a2 = new Order(14271.0);
        Order a3 = new Order(16795.0);
        Order a4 = new Order(4188.0);
        Order a5 = new Order(23062.0);
        Order a6 = new Order(9991.0);
        Order a7 = new Order(19436.0);
        Order a8 = new Order(25402.0);
        Order a9 = new Order(20148.0);
        Order a10 = new Order(7031.0);
        Order a11 = new Order(3892.0);
        Order a12 = new Order(27538.0);
        Order a13 = new Order(23106.0);
        Order a14 = new Order(26914.0);
        Order a15 = new Order(6773.0);
        Order a16 = new Order(18395.0);
        Order a17 = new Order(6276.0);
        Order a18 = new Order(21513.0);
        Order a19 = new Order(26709.0);
        Order a20 = new Order(15522.0);
        Order a21 = new Order(8854.0);
        d.add(a1);
        d.add(a2);
        d.add(a3);
        d.add(a4);
        d.add(a5);
        d.add(a6);
        d.add(a7);
        d.add(a8);
        d.add(a9);
        d.add(a10);
        d.add(a11);
        d.add(a12);
        d.add(a13);
        d.add(a14);
        d.add(a15);
        d.add(a16);
        d.add(a17);
        d.add(a18);
        d.add(a19);
        d.add(a20);
        d.add(a21);

        for(int i = 0; i<21;i++) {
            Order ord = new Order();
            ord = d.get();
            System.out.println(ord);
        }
        /*for(Order s: d.myDec) {
            Order ord = new Order();
            ord = s;
            System.out.println(ord);
        }*/
    }
}

public class OrderQueue {
    Comparator<Order> comp1 = new Comparator<Order>() {
        @Override
        public int compare(Order o1, Order o2) {
            if(Integer.compare(o1.getPriority(),o2.getPriority()) != 0)
                return Integer.compare(o1.getPriority(), o2.getPriority());
            else {
                return Integer.compare(o1.getNum(),o2.getNum());
            }
        }
    };
    public PriorityQueue<Order> myDec = new PriorityQueue<>(comp1);

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