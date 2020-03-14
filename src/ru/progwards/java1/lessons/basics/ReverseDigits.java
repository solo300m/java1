package ru.progwards.java1.lessons.basics;

public class ReverseDigits {
    public static void main(String[] args) {
        System.out.println(reverseDigits(123456789));
    }
    //Первый вариант
    /*public static int reverseDigits(int number){
        Integer rez = number;
        String rev = rez.toString();
        StringBuffer buffer = new StringBuffer(rev);
        rev = buffer.reverse().toString();
        rez = Integer.parseInt(rev);
        return rez;
    }*/
    //Второй вариант
    /*public static int reverseDigits(int number){
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
    }*/
    //Третий вариант
    public static int reverseDigits(int number){
        Integer iter = number;
        int i = iter.toString().length();
        //для получения счетчика я конвертацию в строку все таки оставил
        int revers = 0;
        do{
            int t = iter % 10;
            iter = iter / 10;
            revers = revers * 10 + t;
            i--;
        }while(i!=0);
        return revers;
    }
}
