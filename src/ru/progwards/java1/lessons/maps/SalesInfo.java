package ru.progwards.java1.lessons.maps;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
class Program{
    public static void main(String[] args) {
        SalesInfo s1 = new SalesInfo();
        int r;
        r = s1.loadOrders("Data.csv");
        System.out.println(r);
        var saleGood = s1.getGoods();
        System.out.println(saleGood);
        var mapR = s1.getCustomers();
        System.out.println(mapR);
    }
}

public class SalesInfo {
    private List<dataSale> listCSV = new ArrayList<>();

    public int loadOrders(String fileName) {
        int rez = 0;
        try(FileReader reader = new FileReader(fileName)){
            Scanner scann = new Scanner(reader);
            while(scann.hasNext()){
                String[] tmp = scann.nextLine().split(",");
                if(tmp.length == 4 ){
                    char[] tmp2 = tmp[2].trim().toCharArray();
                    boolean chInt = true;
                    for(char s:tmp2){
                        if(!Character.isDigit(s)){
                            chInt = false;
                            break;
                        }
                    }
                    char[] tmp3 = tmp[3].trim().toCharArray();
                    boolean chDoub = true;
                    int signCount = 0;
                    for(char s: tmp3){
                        if(!Character.isDigit(s) && s == '.'){
                            chDoub = false;
                            signCount++;
                            if(signCount > 1)
                                break;
                        }
                        else if(Character.isDigit(s))
                            chDoub = true;
                        else if(!Character.isDigit(s) && s != '.'){
                            chDoub = false;
                            break;
                        }

                    }
                    if(chInt == true && chDoub == true && signCount <= 1 && !tmp[0].isEmpty() && !tmp[1].isEmpty()) {
                        String name = tmp[0].trim();
                        String good = tmp[1].trim();
                        int count = Integer.parseInt(tmp[2].trim());
                        double sumSale = Double.parseDouble(tmp[3].trim());
                        listCSV.add(new dataSale(name, good, count, sumSale));
                        rez++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(dataSale s: listCSV)
            System.out.println(s);
        return rez;
    }

    public Map<String, Double> getGoods(){
        Map<String, Double> mapGood = new TreeMap<>();
        for(dataSale s: listCSV){
            if(mapGood.containsKey(s.getGood())){
                double sum = mapGood.get(s.getGood()) + s.getSumSale();
                mapGood.put(s.getGood(),sum);
            }
            else{
                mapGood.put(s.getGood(), s.getSumSale());
            }
        }

        return mapGood;
    }

    Map<String, AbstractMap.SimpleEntry<Double, Integer>> getCustomers(){
        Map<String, AbstractMap.SimpleEntry<Double,Integer>> mapCust = new TreeMap<>();
        TreeMap<String,Double> saleName = new TreeMap<>();
        TreeMap<String,Integer> countName = new TreeMap<>();
        for(dataSale s: listCSV){
            if(saleName.containsKey(s.getName())){
                double sum = saleName.get(s.getName()) + s.getSumSale();
                saleName.put(s.getName(),sum);
            }
            else{
                saleName.put(s.getName(),s.getSumSale());
            }
            if(countName.containsKey(s.getName())){
                int count = countName.get(s.getName()) + s.getCount();
                countName.put(s.getName(),count);
            }
            else{
                countName.put(s.getName(),s.getCount());
            }
        }
        //System.out.println(saleName);
        //System.out.println(countName);
        for(var key:saleName.keySet())
            mapCust.put(key,new AbstractMap.SimpleEntry(saleName.get(key),countName.get(key)));
        //System.out.println(mapCust);
        return mapCust;
    }
    class dataSale{
        private String name;
        private String good;
        private Integer count;
        private Double sumSale;
        public dataSale(String name, String good,Integer count,Double sumSale){
            this.name = name;
            this.good = good;
            this.count = count;
            this.sumSale = sumSale;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGood() {
            return good;
        }

        public void setGood(String good) {
            this.good = good;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public Double getSumSale() {
            return sumSale;
        }

        public void setSumSale(Double sumSale) {
            this.sumSale = sumSale;
        }

        @Override
        public String toString() {
            return name + ", " + good + ", " + count + ", " + sumSale;
        }
    }
}