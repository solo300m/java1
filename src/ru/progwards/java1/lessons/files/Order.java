package ru.progwards.java1.lessons.files;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    public String shopId;
    public String orderId;
    public String customerId;
    public LocalDateTime datetime;
    public List<OrderItem> items;
    public double sum;
    public Order(){
        shopId = "";
        orderId = "";
        customerId = "";
        datetime = LocalDateTime.now();
        items = new ArrayList<>();
        sum = 0.0;
    }
}