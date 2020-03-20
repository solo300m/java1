package ru.progwards.java1.lessons.bitsworld;

class Pr{
    public static void main(String[] args) {
        System.out.println(SumBits.sumBits(0b11111111));
    }
}

public class SumBits {
    public static int sumBits(int value){
        int sum = 0;
        while(value!=0){
            int s = value & 1;
            sum += s;
            value >>= 1;
        }
        return sum;
    }
}
