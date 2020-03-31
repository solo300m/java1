package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;

class Program{
    public static void main(String[] args) {
        AbsInteger i1 = new IntInteger(5);
        AbsInteger i2 = new IntInteger(15);
        AbsInteger sh1 = new ShortInteger((short) 32759);
        AbsInteger b1 = new ByteInteger((byte) 10);
        System.out.println(i1);
        System.out.println(sh1);
        System.out.println(b1);
        System.out.println(AbsInteger.add(sh1,b1).n1);
        System.out.println(AbsInteger.add(sh1,b1).getClass().toString());

    }
}
public abstract class AbsInteger {
    public int n1;
    public AbsInteger(int a){
        this.n1 = a;
    }
    static AbsInteger add(AbsInteger num1, AbsInteger num2){
        if(AbsInteger.substrClass(num1,"IntInteger") == true
                & (AbsInteger.substrClass(num2,"IntInteger") == true
                |AbsInteger.substrClass(num2,"ShortInteger") == true
                |AbsInteger.substrClass(num2,"ByteInteger") == true )){
            BigInteger temp = BigInteger.valueOf((long)(num1.n1+num2.n1));
            if(temp.longValue() >= Integer.MIN_VALUE && temp.longValue() <= Integer.MAX_VALUE){
                AbsInteger rez = new IntInteger(0);
                rez.n1 =  num1.n1 + num2.n1;
                return rez;
            }
            else{
                System.out.println("Переполнение максимального типа IntInteger");
                return new IntInteger(0);
            }
        }
        else if(AbsInteger.substrClass(num2,"IntInteger") == true
                & (AbsInteger.substrClass(num1,"IntInteger") == true
                |AbsInteger.substrClass(num1,"ShortInteger") == true
                |AbsInteger.substrClass(num1,"ByteInteger") == true )){
            BigInteger temp = BigInteger.valueOf((long)(num1.n1+num2.n1));
            if(temp.longValue() >= Integer.MIN_VALUE && temp.longValue() <= Integer.MAX_VALUE){
                AbsInteger rez = new IntInteger(0);
                rez.n1 =  num1.n1 + num2.n1;
                return rez;
            }
            else{
                System.out.println("Переполнение максимального типа IntInteger");
                return new IntInteger(0);
            }
        }
        else if(AbsInteger.substrClass(num1,"ShortInteger") == true
                & (AbsInteger.substrClass(num2,"ShortInteger") == true
                |AbsInteger.substrClass(num2,"ByteInteger") == true )) {
            BigInteger temp = BigInteger.valueOf((long)(num1.n1+num2.n1));
            if(temp.longValue() >= Short.MIN_VALUE && temp.longValue() <= Short.MAX_VALUE){
                AbsInteger rez = new ShortInteger((short) 0);
                rez.n1 =  num1.n1 + num2.n1;
                return rez;
            }
            else if(temp.longValue() >= Integer.MIN_VALUE && temp.longValue() <= Integer.MAX_VALUE){
                AbsInteger rez = new IntInteger(0);
                rez.n1 =  num1.n1 + num2.n1;
                return rez;
            }
            else{
                System.out.println("Переполнение максимального типа IntInteger");
                return new IntInteger(0);
            }
        }
        else if(AbsInteger.substrClass(num2,"ShortInteger") == true
                & (AbsInteger.substrClass(num1,"ShortInteger") == true
                |AbsInteger.substrClass(num1,"ByteInteger") == true )) {
            BigInteger temp = BigInteger.valueOf((long)(num1.n1+num2.n1));
            if(temp.longValue() >= Short.MIN_VALUE && temp.longValue() <= Short.MAX_VALUE){
                AbsInteger rez = new ShortInteger((short) 0);
                rez.n1 =  num1.n1 + num2.n1;
                return rez;
            }
            else if(temp.longValue() >= Integer.MIN_VALUE && temp.longValue() <= Integer.MAX_VALUE){
                AbsInteger rez = new IntInteger(0);
                rez.n1 =  num1.n1 + num2.n1;
                return rez;
            }
            else{
                System.out.println("Переполнение максимального типа IntInteger");
                return new IntInteger(0);
            }
        }
        else if(AbsInteger.substrClass(num1,"ByteInteger") == true
                & AbsInteger.substrClass(num2,"ByteInteger") == true ) {
            BigInteger temp = BigInteger.valueOf((long)(num1.n1+num2.n1));
            if(temp.longValue() >= Byte.MIN_VALUE && temp.longValue() <= Byte.MAX_VALUE){
                AbsInteger rez = new ByteInteger((byte) 0);
                rez.n1 =  num1.n1 + num2.n1;
                return rez;
            }
            else if(temp.longValue() >= Short.MIN_VALUE && temp.longValue() <= Short.MAX_VALUE){
                AbsInteger rez = new ShortInteger((short) 0);
                rez.n1 =  num1.n1 + num2.n1;
                return rez;
            }
            else if(temp.longValue() >= Integer.MIN_VALUE && temp.longValue() <= Integer.MAX_VALUE){
                AbsInteger rez = new IntInteger(0);
                rez.n1 =  num1.n1 + num2.n1;
                return rez;
            }
            else{
                System.out.println("Переполнение максимального типа IntInteger");
                return new IntInteger(0);
            }

        }
        else {
            AbsInteger rez = new IntInteger(0);
            System.out.println("С исходными данными что то не так.");
            return rez;
        }

    }

    static boolean substrClass(AbsInteger num, String type){
        String num1str = "";
        num1str = num.getClass().toString();
        boolean rez = (num1str.contains(type));
        return rez;
    }

    public abstract String toString();
}
