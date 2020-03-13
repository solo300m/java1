package ru.progwards.java1.lessons.basics;

public class ReverseDigits {
    public static void main(String[] args) {
        System.out.println(reverseDigits(123456789));
    }
    /*public static int reverseDigits(int number){
        Integer rez = number;
        String rev = rez.toString();
        StringBuffer buffer = new StringBuffer(rev);
        rev = buffer.reverse().toString();
        rez = Integer.parseInt(rev);
        return rez;
    }*/
    public static int reverseDigits(int number){
        Integer iter = number;
        String ch = iter.toString();
        int i = ch.length();
        String rever = "";
        do{
            int t = iter % 10;
            iter = iter / 10;
            rever += t;
            i--;
        }while(i!=0);
        int a = Integer.parseInt(rever);
        return a;
    }
}
