package ru.progwards.java2.lessons.gc;

import java.util.Objects;

public class Element <T> { //класс для тестирования функционала
    String typeElem;
    T item;
    byte[]bytes;
    int startBlock;
    int endBlock;
    boolean free;

    public Element(){
        this.item = null;
        startBlock = 0;
        endBlock = 0;
        free = false;
        typeElem = "";
    }
    public Element(int start, int end){
        this.item = null;
        startBlock = start;
        endBlock =end;
        free = false;
        typeElem = "";
    }
    public Element(T item){
        this.item = item;
        startBlock = 0;
        endBlock = 0;
        free = false;
        typeElem = item.getClass().getSimpleName();
        switch (typeElem){
            case ("String"):{
                String tmp = (String) item;
                bytes = tmp.getBytes();
                break;
            }
            case ("int"):
            case ("Integer"):{
                Integer tmpInt = (int)item;
                String tmp = Integer.toString(tmpInt);
                bytes = tmp.getBytes();
                break;
            }
            case("double"):
            case ("Double"):{
                Double tmpInt = (double)item;
                String tmp = Double.toString(tmpInt);
                bytes = tmp.getBytes();
                break;
            }
            case("long"):
            case("Long"):{
                Long tmpInt = (long)item;
                String tmp = Long.toString(tmpInt);
                bytes = tmp.getBytes();
                break;
            }
            case("float"):
            case("Float"):{
                Float tmpInt = (float)item;
                String tmp = Float.toString(tmpInt);
                bytes = tmp.getBytes();
                break;
            }
            case("char"):
            case("Character"):{
                Character tmpInt = (char)item;
                String tmp = Character.toString(tmpInt);
                bytes = tmp.getBytes();
                break;
            }
        }
    }

    @Override
    public String toString() {
        //String arrayStr = new String(bytes);
        return "Element{" +"typeElem - "+typeElem+
                ", item=" + item +
                ", bytes=" + bytes +
                ", startBlock=" + startBlock +
                ", endBlock=" + endBlock +
                ", free= "+free+
                '}';
    }
    public int byteSize(){
        return bytes.length;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public String getTypeElem() {
        return typeElem;
    }

    public void setTypeElem(String typeElem) {
        this.typeElem = typeElem;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public boolean getFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public int getStartBlock() {
        return startBlock;
    }

    public void setStartBlock(int startBlock) {
        this.startBlock = startBlock;
    }

    public int getEndBlock() {
        return endBlock;
    }

    public void setEndBlock(int endBlock) {
        this.endBlock = endBlock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Element)) return false;
        Element<?> element = (Element<?>) o;
        return getStartBlock() == element.getStartBlock() &&
                getEndBlock() == element.getEndBlock();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStartBlock(), getEndBlock());
    }
}

class TestElement{
    public static void main(String[] args) {
        Element<String> str = new Element<>("Привет, Мир!");
        System.out.println(str);
        str.item = null;
        System.out.println(str);
        str.item = new String(str.bytes);
        System.out.println(str);
    }
}