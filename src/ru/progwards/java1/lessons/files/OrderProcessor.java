package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

class Baza{
    public static void main(String[] args) {
        //"C:\\Users\\Сергей\\IdeaProjects\\Ekkel_Home_1\\baza"  "C:\\Users\\51256\\IdeaProjects\\Ekkel\\baza"
        OrderProcessor cool = new OrderProcessor("C:\\Users\\Сергей\\IdeaProjects\\Ekkel_Home_1\\baza");

        int badFiles = cool.loadOrders(null ,null,null);
        System.out.println(badFiles);
        for(Order s: cool.listSale){
            System.out.println(s.shopId+" "+s.customerId+" "+s.orderId+" "+s.datetime+" "+s.sum);
            for(int i = 0; i < s.items.size(); i++){
                System.out.println(s.items.get(i).googsName+" "+s.items.get(i).count+" "+s.items.get(i).price);
            }
        }
        List<Order> shops = cool.process("S03");
        for(int i = 0; i < shops.size(); i++){
            System.out.println(shops.get(i).orderId+" "+shops.get(i).sum);
        }
        Map<String,Double>shopsStat = cool.statisticsByShop();
        System.out.println(shopsStat);
        Map<String,Double>goodsStat = cool.statisticsByGoods();
        System.out.println(goodsStat);
        Map<LocalDate,Double> dateStat = cool.statisticsByDay();
        System.out.println(dateStat);
    }
}

public class OrderProcessor {
    public List<Order> listSale;
    public Path baza;
    public OrderProcessor(String startPath)  {
        //"C:\\Users\\Сергей\\IdeaProjects\\Ekkel_Home_1\\baza"
        listSale = new ArrayList<>();
        baza = Paths.get(startPath);
        if(!Files.exists(baza)) {
            try {
                Files.createDirectory(baza);
            } catch (IOException e) {
                e.getMessage();
            }
        }

    }
    //функция проверяющая ошибки формата и данных
    private boolean borderFunc(Path path){
        System.out.println("#traceout 1н");
        String []parsArr = path.getFileName().toString().split("[-,\\.]");
        if(parsArr.length != 4)
            return false;
        if(parsArr[0].length()!=3 && parsArr[1].length()!=6 && parsArr[2].length()!=4 && parsArr[3]!="csv")
            return false;
        for(String s:parsArr){
            char[]tmp = s.toCharArray();
            for(char ch:tmp){
                if(!Character.isLetterOrDigit(ch))
                    return false;
            }
        }
        try {
            List<String> contentTmp = Files.readAllLines(path);
            for(String s: contentTmp){
                String[] controlContent = s.split(",");
                if(controlContent.length==3) {
                    char[] count = controlContent[1].trim().toCharArray();
                    for (char ch : count) {
                        if (!Character.isDigit(ch))
                            return false;
                    }
                    char[] price = controlContent[2].trim().toCharArray();
                    for (char ch : price) {
                        if (!Character.isDigit(ch))
                            return false;
                    }
                }
                else
                    return false;
            }
        } catch (IOException e) {
            e.getMessage();
        }
        System.out.println("#traceout 1к");
        return true;
    }
    //функция, формирующая исходный массив
    private void operation(LocalDateTime date, Path path, String shopId){
        System.out.println("#traceout 2н");
        String[] file = path.getFileName().toString().split("[-,\\.]");
        if (shopId != null) {
            if (file[0].compareTo(shopId)==0) {
                List<String> listStrFile = null;
                try {
                    listStrFile = Files.readAllLines(path);
                } catch (IOException e) {
                    e.getMessage();
                }
                List<String[]> listArrFile = new ArrayList<>();
                for (String s : listStrFile) {
                    String[] tmp = s.split(",");
                    listArrFile.add(tmp);
                }
                Order order = new Order();
                order.datetime = date;
                order.customerId = file[2];
                order.orderId = file[1];
                order.shopId = file[0];

                for (String[] f : listArrFile) {
                    if(f.length == 3) {
                        OrderItem item = new OrderItem();
                        item.googsName = f[0];
                        item.count = Integer.parseInt(f[1].trim());
                        item.price = Double.parseDouble(f[2].trim());
                        order.sum += item.price;
                        order.items.add(item);
                    }
                }
                listSale.add(order);
            }
        } else {
            List<String> listStrFile = null;
            try {
                listStrFile = Files.readAllLines(path);
            } catch (IOException e) {
                e.getMessage();
            }
            List<String[]> listArrFile = new ArrayList<>();
            for (String s : listStrFile) {
                String[] tmp = s.split(",");
                listArrFile.add(tmp);
            }
            Order order = new Order();
            order.datetime = date;
            order.customerId = file[2];
            order.orderId = file[1];
            order.shopId = file[0];

            for (String[] f : listArrFile) {
                if(f.length == 3) {
                    OrderItem item = new OrderItem();
                    item.googsName = f[0];
                    item.count = Integer.parseInt(f[1].trim());
                    item.price = Double.parseDouble(f[2].trim());
                    order.sum += item.price;
                    order.items.add(item);
                }
            }
            listSale.add(order);
        }
        System.out.println("#traceout 2к");
    }
    public int loadOrders(LocalDate start, LocalDate finish, String shopId) {

        class rezClass {
            private int rez;
            rezClass(){
                rez = 0;
            }
            public int getRez(){
                return rez;
            }
            public void setRez(int plus){
                rez += plus;
            }
        }
        rezClass countBad = new rezClass();
        try {
            Files.walkFileTree(baza,new SimpleFileVisitor<Path>(){

                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attrs)  {
                    System.out.println("#traceout Начало");
                    boolean border = borderFunc(path);
                    if(border) {
                        LocalDateTime date = null;
                        try {
                            String[] date1 = Files.getAttribute(path, "lastModifiedTime").toString().split("[-,T,:,\\.]");
                            date = LocalDateTime.of(Integer.parseInt(date1[0]),Integer.parseInt(date1[1]),
                                    Integer.parseInt(date1[2]),Integer.parseInt(date1[3]),Integer.parseInt(date1[4]),
                                    Integer.parseInt(date1[5]));
                            //date = (LocalDateTime) Files.getAttribute(path, "lastModifiedTime");
                        } catch (IOException e) {
                            e.getMessage();
                        }
                        if (start != null && finish != null) {
                            if (date.compareTo(start.atTime(00, 00, 00)) >= 0 && date.compareTo(finish.atTime(23, 59, 59)) <= 0) {
                                operation(date,path,shopId);
                            }
                        } else if (start == null && finish != null) {
                            if (date.compareTo(finish.atTime(23, 59, 59)) <= 0) {
                                operation(date,path,shopId);
                            }
                        } else if (start != null && finish == null) {
                            if (date.compareTo(start.atTime(00, 00, 00)) >= 0) {
                                operation(date,path,shopId);
                            }
                        } else if (start == null && finish == null) {
                            operation(date,path,shopId);
                        }
                    }
                    else{
                        countBad.setRez(1);
                    }
                    System.out.println("#traceout Конец");
                    return FileVisitResult.CONTINUE;

                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) {
                    return FileVisitResult.CONTINUE;
                }

            });

        } catch (IOException e) {

            e.getMessage();
        }
        int r = countBad.getRez();

        return r;

    }

    public List<Order> process(String shopId) {
        List<Order> shops = new ArrayList<>();
        if(shopId != null) {
            for (Order or : listSale) {
                if (or.shopId.compareTo(shopId)==0) {
                    shops.add(or);
                }
            }
            /*if (shops.isEmpty()) {
                int a = loadOrders(null, null, shopId);
            }
            for (Order or : listSale) {
                if (or.shopId.compareTo(shopId)==0) {
                    shops.add(or);
                }
            }*/
            shops.sort(new Comparator<Order>() {
                @Override
                public int compare(Order o1, Order o2) {
                    return o1.datetime.compareTo(o2.datetime);
                }
            });
            return shops;
        }
        else{
            //int a = loadOrders(null, null, null);
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
                if(byGoods.containsKey(i.googsName)){
                    double tmpSum = byGoods.get(i.googsName)+i.price;
                    byGoods.put(i.googsName,tmpSum);
                }
                else{
                    byGoods.put(i.googsName,i.price);
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