package ru.progwards.java1.lessons.bigints;

public class ByteInteger extends AbsInteger{
    //private byte a;
    //public ByteInteger(){super();}
    public ByteInteger(byte a){
        super(a);
        //this.a = a;
    }
    @Override
    public String toString(){
        return Byte.toString((byte) super.n1);
    }

}
