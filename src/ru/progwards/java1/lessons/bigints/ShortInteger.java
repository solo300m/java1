package ru.progwards.java1.lessons.bigints;

public class ShortInteger extends AbsInteger{
    //private short a;
    //public ShortInteger(){super();}
    public ShortInteger(short a){
        super(a);
        //this.a = a;
    }
    @Override
    public String toString(){
        return Short.toString((short) super.n1);
    }

}
