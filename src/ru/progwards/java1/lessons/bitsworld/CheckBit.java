package ru.progwards.java1.lessons.bitsworld;

class Pro{
    public static void main(String[] args) {
        System.out.println(CheckBit.checkBit((byte) 0b00010001, 4));
    }
}

public class CheckBit {
    public static int checkBit(byte value, int bitNumber){
        int bit = 0;
        value >>= bitNumber;
        bit = value & 1;

        return bit;
    }
}