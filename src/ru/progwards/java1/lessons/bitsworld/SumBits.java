package ru.progwards.java1.lessons.bitsworld;

class Pr{
    public static void main(String[] args) {
        System.out.println(SumBits.sumBits((byte)0b11111111));
    }
}

public class SumBits {
    public static int sumBits(byte value){
        int sum = 0;
        //String ch = Integer.toBinaryString(value);
        for(int i = 0; i < 8; i++ ){
            int s = value & 1;
            sum += s;
            value >>= 1;
        }
        return sum;
    }
}
