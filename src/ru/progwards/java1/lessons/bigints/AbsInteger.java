package ru.progwards.java1.lessons.bigints;
class Program{
    public static void main(String[] args) {
        AbsInteger i1 = new IntInteger(5);
        AbsInteger sh1 = new ShortInteger((short) 12);
        AbsInteger b1 = new ByteInteger((byte) 10);
        System.out.println(i1);
        System.out.println(sh1);
        System.out.println(b1);
        System.out.println(AbsInteger.add(i1,sh1).n1);
    }
}
public abstract class AbsInteger {
    public int n1;
    public AbsInteger(int a){
        this.n1 = a;
    }
    static AbsInteger add(AbsInteger num1, AbsInteger num2){
        AbsInteger rez = new IntInteger(0);
        rez.n1 =  num1.n1 + num2.n1;
        return rez;
    }
    public abstract String toString();
}
