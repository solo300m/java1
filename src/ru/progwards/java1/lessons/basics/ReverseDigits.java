package ru.progwards.java1.lessons.basics;

public class ReverseDigits {
    public static void main(String[] args) {
        System.out.println(reverseDigits(123456789));
    }
    public static int reverseDigits(int number){
        Integer rez = number;
        String rev = rez.toString();
        StringBuffer buffer = new StringBuffer(rev);
        rev = buffer.reverse().toString();
        rez = Integer.parseInt(rev);
        return rez;
    }
}
