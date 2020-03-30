package ru.progwards.java1.lessons.bigints;


import java.math.BigInteger;

class Pr{
    public static void main(String[] args) {
        ArrayInteger ai1 = new ArrayInteger(7);
        ai1.fromInt(new BigInteger("3049766"));
        System.out.println(ai1.toString(ai1));
        ArrayInteger ai2 = new ArrayInteger(5);
        ai2.fromInt(new BigInteger("33083"));
        System.out.println(ai2.toString(ai2));
        ai1.add(ai2);
        System.out.println(ai1.toInt());
        ArrayInteger ai3 = new ArrayInteger(8);
        ai3.fromInt(new BigInteger("922337203685477580778099"));
        System.out.println(ai3.toInt());
        ai1.add(ai3);
        System.out.println(ai1.toInt());
    }
}

public class ArrayInteger {
    private byte[]digits;
    BigInteger value1;
    public ArrayInteger(int n){
        digits = new byte[n];

    }
    void fromInt(BigInteger value){
        value1 = new BigInteger(value.toString());
        if(value.toString().length() != digits.length){
            digits = new byte[value.toString().length()];
        }
        for(int i=0; i<digits.length;i++){
            BigInteger step;
            step = value1.remainder(BigInteger.valueOf(10));
            value1 = value1.divide(BigInteger.valueOf(10));
            digits[i] = step.byteValueExact();
        }
    }
    BigInteger toInt(){
        String str = "";
        if(digits.length!=0){
            for(int i = digits.length-1; i>=0; i--){
                str += digits[i];
            }
            BigInteger toI = new BigInteger(str);
            return toI;
        }
        else return BigInteger.valueOf(0);
    }
    boolean add(ArrayInteger num){
        String thisObj = "";
        String otherObj = "";
        for(int i = this.digits.length-1; i>=0; i--){
            thisObj += this.digits[i];
        }

        for(int j = num.digits.length-1; j>=0; j--){
            otherObj += num.digits[j];
        }

        if(Double.parseDouble(thisObj) > Integer.MAX_VALUE
                ||Double.parseDouble(otherObj)>Integer.MAX_VALUE ){
            for(int i = 0; i < this.digits.length; i++){
                this.digits[i] = 0;
            }
            return false;
        }
        else {
            int sum = Integer.parseInt(thisObj) + Integer.parseInt(otherObj);
            
            if (Integer.toString(sum).length() > this.digits.length) {
                for (int i = 0; i < this.digits.length; i++) {
                    this.digits[i] = 0;
                }
                return false;
            } else {
                for (int i = 0; i < this.digits.length; i++) {
                    this.digits[i] = 0;
                }
                for (int i = 0; i < this.digits.length; i++) {
                    this.digits[i] = (byte) (sum % 10);
                    sum = sum / 10;
                }
                return true;
            }
        }
    }

    String toString(ArrayInteger a){
        String rez = "";
        for(byte str: a.digits){
            rez = rez + ","+str;
        }
        return rez;
    }
}
