package ru.progwards.java2.lessons.reflection;

public class TestReflection {
    private String name;
    private int count;
    private double sale;
    private TestReflection(){}
    public TestReflection(String name){
        this.name = name;
    }
    public TestReflection(String name, int count, double sale){
        this();
        this.count=count;
        this.sale = sale;
    }

    /*public String getName() {
        return name;
    }

    public void setName(int f, String name, int r) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale, int f) {
        this.sale = sale;
    }*/

    @Override
    public String toString() {
        return "name = '" + name + '\''+", count = " + count +", sale=" + sale;
    }
}