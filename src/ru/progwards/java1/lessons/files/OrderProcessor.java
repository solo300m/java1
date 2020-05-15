package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class OrderProcessor {
    public List<Order> listSale;
    public Path baza;
    public OrderProcessor(String startPath) throws IOException {
        //"C:\\Users\\Сергей\\IdeaProjects\\Ekkel_Home_1\\baza"
        listSale = new ArrayList<>();
        baza = Paths.get(startPath);
        if(!Files.exists(baza))
            Files.createDirectory(baza);

    }
    public int loadOrders(LocalDate start, LocalDate finish, String shopId) throws IOException {
        Files.walkFileTree(baza,new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
                LocalDateTime date = (LocalDateTime) Files.getAttribute(path,"lastModifiedTime");
                if(date.compareTo(start.atTime(00,00,00)) >= 0 && date.compareTo(finish.atTime(23,59,59)) <= 0) {
                    String[] file = path.getFileName().toString().split("[-,\\.]");
                    if (file[0] == shopId){
                        List<String> listStrFile = Files.readAllLines(path);
                        List<String[]>listArrFile = new ArrayList<>();
                        for(String s: listStrFile){
                            String[] tmp = s.split(",");
                            listArrFile.add(tmp);
                        }
                        Order order = new Order();
                        order.datetime = date;
                        order.customerId = file[2];
                        order.orderId = file[1];
                        order.shopId = file[0];

                        for(String[] f: listArrFile){
                            OrderItem item = new OrderItem();
                            item.goodsName = f[0];
                            item.count = Integer.parseInt(f[1]);
                            item.price = Double.parseDouble(f[2]);
                            order.sum += item.price;
                            order.items.add(item);
                        }
                        listSale.add(order);
                    }
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        });
        return 0;
    }

    public List<Order> process(String shopId) throws IOException {
        List<Order> shops = new ArrayList<>();
        if(shopId != null) {
            for (Order or : listSale) {
                if (or.shopId == shopId) {
                    shops.add(or);
                }
            }
            if (shops.isEmpty()) {
                int a = loadOrders(null, null, shopId);
            }
            for (Order or : listSale) {
                if (or.shopId == shopId) {
                    shops.add(or);
                }
            }
            shops.sort(new Comparator<Order>() {
                @Override
                public int compare(Order o1, Order o2) {
                    return o1.datetime.compareTo(o2.datetime);
                }
            });
            return shops;
        }
        else{
            int a = loadOrders(null, null, null);
            for (Order or : listSale) {
                shops.add(or);
            }
            shops.sort(new Comparator<Order>() {
                @Override
                public int compare(Order o1, Order o2) {
                    return o1.datetime.compareTo(o2.datetime);
                }
            });
            return shops;
        }
    }

    public Map<String, Double> statisticsByShop(){
        Map<String,Double>byShops = new TreeMap<>();
        for(Order or:listSale) {
            if(byShops.containsKey(or.shopId)) {
                double tmpSum = byShops.get(or.shopId)+or.sum;
                byShops.put(or.shopId, tmpSum);
            }
            else{
                byShops.put(or.shopId, or.sum);
            }
        }
        return byShops;
    }

    public Map<String, Double> statisticsByGoods(){
        Map<String,Double>byGoods = new TreeMap<>();
        for(Order o: listSale){
            for(OrderItem i: o.items){
                if(byGoods.containsKey(i.goodsName)){
                    double tmpSum = byGoods.get(i.goodsName)+i.price;
                    byGoods.put(i.goodsName,tmpSum);
                }
                else{
                    byGoods.put(i.goodsName,i.price);
                }
            }
        }
        return byGoods;
    }
    public Map<LocalDate, Double> statisticsByDay(){
        Map<LocalDate, Double>byDays = new TreeMap<>();
        for(Order o: listSale){
            if(byDays.containsKey(o.datetime.toLocalDate())){
                double tmpSum = byDays.get(o.datetime.toLocalDate())+o.sum;
                byDays.put(o.datetime.toLocalDate(),tmpSum);
            }
            else{
                byDays.put(o.datetime.toLocalDate(),o.sum);
            }
        }
        return byDays;
    }
}