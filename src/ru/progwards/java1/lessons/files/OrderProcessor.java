package ru.progwards.java1.lessons.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.ParseException;
import java.time.*;
import java.util.*;

class Baza{
    public static void main(String[] args) throws IOException, ParseException {
        //"C:\\Users\\Сергей\\IdeaProjects\\Ekkel_Home_1\\baza"  "C:\\Users\\51256\\IdeaProjects\\Ekkel\\baza"
        OrderProcessor cool = new OrderProcessor("C:\\Users\\Сергей\\IdeaProjects\\Ekkel_Home_1\\baza");
        String root = Paths.get("C:\\Users\\Сергей\\IdeaProjects\\Ekkel_Home_1\\baza").toString();

        Path d = Paths.get(root+"/"+"S01-P01X01-0001.csv");
        String newLastMod = "2020-01-01T13:00:00";
        LocalDateTime fff = LocalDateTime.parse(newLastMod);
        Instant gg = fff.toInstant(ZoneOffset.UTC);
        FileTime ft = FileTime.from(gg);
        Path dd = Files.setLastModifiedTime(d,ft);

        Path d1 = Paths.get(root+"/"+"S02-P01X01-0001.csv");
        String newLastMod1 = "2020-01-01T16:00:00";
        fff = LocalDateTime.parse(newLastMod1);
        gg = fff.toInstant(ZoneOffset.UTC);
        ft = FileTime.from(gg);
        Path dd1 = Files.setLastModifiedTime(d1,ft);

        Path d2 = Paths.get(root+"/"+"S02-P01X02-0003.csv");
        String newLastMod2 = "2020-01-05T13:12:12";
        fff = LocalDateTime.parse(newLastMod2);
        gg = fff.toInstant(ZoneOffset.UTC);
        ft = FileTime.from(gg);
        Path dd2 = Files.setLastModifiedTime(d2,ft);

        Path d3 = Paths.get(root+"/"+"S02-P01X03-000.csv");
        String newLastMod3 = "2020-01-10T16:15:15";
        fff = LocalDateTime.parse(newLastMod3);
        gg = fff.toInstant(ZoneOffset.UTC);
        ft = FileTime.from(gg);
        Path dd3 = Files.setLastModifiedTime(d3,ft);

        Path d4 = Paths.get(root+"/"+"S02-P01X03-0003.csv");
        String newLastMod4 = "2020-01-10T16:15:15";
        fff = LocalDateTime.parse(newLastMod4);
        gg = fff.toInstant(ZoneOffset.UTC);
        ft = FileTime.from(gg);
        Path dd4 = Files.setLastModifiedTime(d4,ft);

        Path d5 = Paths.get(root+"/"+"S02-P01X05-0002.csv");
        String newLastMod5 = "2020-01-16T17:16:16";
        fff = LocalDateTime.parse(newLastMod5);
        gg = fff.toInstant(ZoneOffset.UTC);
        ft = FileTime.from(gg);
        Path dd5 = Files.setLastModifiedTime(d5,ft);

        Path d6 = Paths.get(root+"/"+"S01-P01X02-0002.csv");
        String newLastMod6 = "2020-01-14T15:14:14";
        fff = LocalDateTime.parse(newLastMod6);
        gg = fff.toInstant(ZoneOffset.UTC);
        ft = FileTime.from(gg);
        Path dd6 = Files.setLastModifiedTime(d6,ft);

        Path d7 = Paths.get(root+"/"+"S02-P01X04-0002.csv");
        String newLastMod7 = "2020-01-16T17:16:16";
        fff = LocalDateTime.parse(newLastMod7);
        gg = fff.toInstant(ZoneOffset.UTC);
        ft = FileTime.from(gg);
        Path dd7 = Files.setLastModifiedTime(d7,ft);

        /*Path d8 = Paths.get(root+"/"+"S01-P01X0-0001.csv");
        String newLastMod8 = "2020-01-01T17:16:16";
        fff = LocalDateTime.parse(newLastMod8);
        gg = fff.toInstant(ZoneOffset.UTC);
        ft = FileTime.from(gg);
        Path dd8 = Files.setLastModifiedTime(d8,ft);*/


        int badFiles = cool.loadOrders(null,
                LocalDate.of(2020, Month.JANUARY, 16),
                "S01");
        System.out.println(badFiles);
        for(int i = 0; i < cool.listSale.size(); i++){
            System.out.println(cool.listSale.get(i).shopId+" "+cool.listSale.get(i).customerId+" "+cool.listSale.get(i).orderId+" "
                    +cool.listSale.get(i).datetime+" "+cool.listSale.get(i).sum);
            for(int j = 0; j < cool.listSale.get(i).items.size(); j++){
                System.out.println(cool.listSale.get(i).items.get(j).googsName+" "+cool.listSale.get(i).items.get(j).count+" "
                        +cool.listSale.get(i).items.get(j).price);
            }
        }
        /*cool = new OrderProcessor("C:\\Users\\51256\\IdeaProjects\\Ekkel\\baza");
        badFiles = cool.loadOrders(null,
                null, null);
        System.out.println(badFiles);*/
        cool = new OrderProcessor("C:\\Users\\Сергей\\IdeaProjects\\Ekkel_Home_1\\baza");
        badFiles = cool.loadOrders(null, null,null);
        System.out.println(badFiles);

        List<Order> shops = cool.process(null);
        for(int i = 0; i < shops.size(); i++){
            System.out.println(shops.get(i).orderId+" "+shops.get(i).sum+" "+
                    shops.get(i).datetime);
            for(int j = 0; j<shops.get(i).items.size(); j++){
                System.out.println(shops.get(i).items.get(j).googsName+" "+
                        shops.get(i).items.get(j).count+" "+
                        shops.get(i).items.get(j).price);
            }
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
        File fileTmp = new File(startPath);
        baza = Paths.get(fileTmp.getAbsolutePath());
        if(!Files.exists(baza)) {
            try {
                Files.createDirectory(baza);
            } catch (IOException e) {
                e.getMessage();
            }
        }

    }
    //функция проверяющая ошибки формата и данных
    private boolean[] borderFunc(Path path){
        boolean[] bool = new boolean[2];
        String []parsArr = path.getFileName().toString().split("[-,\\.]");
        if(parsArr.length != 4){
            bool[0]=false;
            bool[1]=true;
            return bool;
        }

        if(parsArr[0].length()!=3 || parsArr[1].length()!=6 || parsArr[2].length()!=4 || !parsArr[3].equals("csv")) {
            bool[0]=false;
            bool[1]=true;
            return bool;
        }
        for(String s:parsArr){
            char[]tmp = s.toCharArray();
            for(char ch:tmp){
                if(!Character.isLetterOrDigit(ch)) {
                    bool[0]=false;
                    bool[1]=false;
                    return bool;
                }
            }
        }

        String[] date1 = new String[0];
        try {
            date1 = Files.getAttribute(path, "lastModifiedTime").toString().split("[-,T,Z,:,\\.]");
            for(String s: date1){
                char[]tmpDate = s.toCharArray();
                for(char ch: tmpDate){
                    if(!Character.isDigit(ch)) {
                        bool[0]=false;
                        bool[1]=false;
                        return bool;
                    }
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }

        try {
            List<String> contentTmp = Files.readAllLines(path);
            for(String s: contentTmp){
                String[] controlContent = s.split(",");
                if(controlContent.length==3) {
                    char[] count = controlContent[1].trim().toCharArray();
                    for (char ch : count) {
                        if (!Character.isDigit(ch)){
                            bool[0]=false;
                            bool[1]=false;
                            return bool;
                        }
                    }
                    char[] price = controlContent[2].trim().toCharArray();
                    for (char ch : price) {
                        if (!Character.isDigit(ch)){
                            bool[0]=false;
                            bool[1]=false;
                            return bool;
                        }
                    }
                }

                else if(controlContent.length==1){
                    if(controlContent[0].isEmpty())
                        continue;
                    else
                    {
                        bool[0]=false;
                        bool[1]=false;
                        return bool;
                    }
                }
                else
                {
                    bool[0]=false;
                    bool[1]=false;
                    return bool;
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }

        bool[0]=true;
        bool[1]=true;
        return bool;
    }
    //функция, формирующая исходный массив
    private void operation(LocalDateTime date, Path path, String shopId){

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
                order.datetime = date.plusHours(3);
                order.customerId = file[2];
                order.orderId = file[1];
                order.shopId = file[0];

                for (String[] f : listArrFile) {
                    if(f.length == 3) {
                        OrderItem item = new OrderItem();
                        item.googsName = f[0];
                        item.count = Integer.parseInt(f[1].trim());
                        item.price = Double.parseDouble(f[2].trim());
                        double tmpSum = item.count * item.price;
                        order.sum += tmpSum;
                        order.items.add(item);
                    }
                }
                order.items.sort(new Comparator<OrderItem>() {
                    @Override
                    public int compare(OrderItem o1, OrderItem o2) {
                        return o1.googsName.compareTo(o2.googsName);
                    }
                });
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
            order.datetime = date.plusHours(3);
            order.customerId = file[2];
            order.orderId = file[1];
            order.shopId = file[0];

            for (String[] f : listArrFile) {
                if(f.length == 3) {
                    OrderItem item = new OrderItem();
                    item.googsName = f[0];
                    item.count = Integer.parseInt(f[1].trim());
                    item.price = Double.parseDouble(f[2].trim());
                    double tmpSum = item.count * item.price;
                    order.sum += tmpSum;
                    order.items.add(item);
                }
            }
            order.items.sort(new Comparator<OrderItem>() {
                @Override
                public int compare(OrderItem o1, OrderItem o2) {
                    return o1.googsName.compareTo(o2.googsName);
                }
            });
            listSale.add(order);
        }

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
        class GetMatcher{
            String shopId = "";
            PathMatcher pathMatcher;
            GetMatcher(String shopId){
                this.shopId = shopId;
                String pattern = "glob:**[a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][-]" +
                        "[a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][-]" +
                        "[0-9][0-9][0-9][0-9]{.csv}";
                String pattern2 = "glob:**{"+shopId+"}[-]" +
                        "[a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9]" +
                        "[-][0-9][0-9][0-9][0-9]{.csv}";
                if (shopId != null) {
                    this.pathMatcher = FileSystems.getDefault().getPathMatcher(pattern2);
                } else {
                    this.pathMatcher = FileSystems.getDefault().getPathMatcher(pattern);
                } /*[a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][-]" +
                        "[a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][-]" +
                        "[0-9][0-9][0-9][0-9]\\.csv"*/
            }
        }
        GetMatcher matcher = new GetMatcher(shopId);
        try {
            Files.walkFileTree(baza,new SimpleFileVisitor<Path>(){

                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attrs)  {
                    if (matcher.pathMatcher.matches(path)) {
                        boolean border[] = borderFunc(path);
                        ZonedDateTime date = null;
                        LocalDateTime dateFull = null;
                        if (border[0] == true && border[1] == true) {
                            //System.out.println(path.getFileName());
                            try {
                                String[] date1 = Files.getAttribute(path, "lastModifiedTime").toString().split("[-,T,Z,:,\\.]");
                                date = LocalDateTime.of(Integer.parseInt(date1[0]), Integer.parseInt(date1[1]),
                                        Integer.parseInt(date1[2]), Integer.parseInt(date1[3]), Integer.parseInt(date1[4]),
                                        Integer.parseInt(date1[5])).atZone(ZoneId.systemDefault());
                                //date = (LocalDateTime) Files.getAttribute(path, "lastModifiedTime");
                                dateFull = date.toLocalDateTime();

                            } catch (IOException e) {
                                e.getMessage();
                            }
                            if (start != null && finish != null) {

                                if (date.compareTo(start.atTime(00, 00, 00).atZone(ZoneId.systemDefault())) >= 0 &&
                                        date.compareTo(finish.atTime(23, 59, 59).atZone(ZoneId.systemDefault())) <= 0) {
                                    operation(dateFull, path, shopId);
                                }

                            } else if (start == null && finish != null) {

                                if (date.compareTo(finish.atTime(23, 59, 59).atZone(ZoneId.systemDefault())) <= 0) {
                                    operation(dateFull, path, shopId);
                                }

                            } else if (start != null && finish == null) {

                                if (date.compareTo(start.atTime(00, 00, 00).atZone(ZoneId.systemDefault())) >= 0) {
                                    operation(dateFull, path, shopId);
                                }

                            } else if (start == null && finish == null) {

                                operation(dateFull, path, shopId);

                            }
                        }
                        else if (border[0] == false && border[1] == false) {
                            try {
                                String[] date1 = Files.getAttribute(path, "lastModifiedTime").toString().split("[-,T,Z,:,\\.]");
                                date = LocalDateTime.of(Integer.parseInt(date1[0]), Integer.parseInt(date1[1]),
                                        Integer.parseInt(date1[2]), Integer.parseInt(date1[3]), Integer.parseInt(date1[4]),
                                        Integer.parseInt(date1[5])).atZone(ZoneId.systemDefault());

                            } catch (IOException e) {
                                e.getMessage();
                            }
                            if(start != null && finish != null){
                                if (date.compareTo(start.atTime(00, 00, 00).atZone(ZoneId.systemDefault())) >= 0 && date.compareTo(finish.atTime(23, 59, 59).atZone(ZoneId.systemDefault())) <= 0){
                                    countBad.setRez(1);
                                }
                            }else if(start != null && finish == null){
                                if (date.compareTo(start.atTime(00, 00, 00).atZone(ZoneId.systemDefault())) >= 0) {
                                    countBad.setRez(1);
                                }
                            }else if(start == null && finish != null){
                                if (date.compareTo(finish.atTime(23, 59, 59).atZone(ZoneId.systemDefault())) <= 0) {
                                    countBad.setRez(1);
                                }
                            }else if(start == null && finish == null){
                                countBad.setRez(1);
                            }

                        }
                    }
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