package ru.progwards.java1.lessons.bigints;

import java.math.BigDecimal;
import java.math.BigInteger;

class Prog11{
    public static void main(String[] args) {
        BigAlgebra class1 = new BigAlgebra();
        BigDecimal a = class1.fastPow(new BigDecimal("5"),5);
        BigInteger b = class1.fibonacci(6);
        System.out.println(a+" "+b);
    }
}

public class BigAlgebra {
    /*public static BigDecimal fastPow(BigDecimal num, int pow) {
        BigDecimal rez = new BigDecimal("1");
        for (int i = 0; i < pow; i++) {
            rez = rez.multiply(num);
        }
        return rez;
    }*/
    public static BigDecimal fastPow(BigDecimal num, int pow) {
        BigDecimal rez = new BigDecimal("0");
        rez = num;
        int i = 2;
        for(; i<=pow; i*=2){
            rez = rez.multiply(rez);
        }
        i=i/2;
        for(int j=0; j<pow-i ;j++) {
            rez = rez.multiply(num);
        }
        return rez;

    }

    public static BigInteger fibonacci(int n) {
        if (n == 1 || n == 2) return new BigInteger("1");
        else {
            BigInteger start = new BigInteger("1");
            BigInteger prev = new BigInteger("1");
            BigInteger fibo = new BigInteger("0");
            for (int i = 3; i <= n; i++) {
                fibo = start.add(prev);
                prev = start;
                start = fibo;
            }
            return fibo;
        }
    }
}
