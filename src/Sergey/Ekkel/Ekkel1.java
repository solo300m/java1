package Sergey.Ekkel;

import java.util.Random;

public class Ekkel1 {
    public static void main(String[] args){
        //ArrayPrint(60);
        //Sravnenie(25);
        //InfinitiCircle();
        //foreach();
        //toCharArray("An African Swallow");
        //System.out.println(test(10,2,6));
        //foreach_2();
        //test_ob();
        System.out.println(fractional(11111.53));
    }
    public static void ArrayPrint(int count){
        for(int i=1; i< count+1; i++) {
            if (i % 10 == 1) System.out.println();
            if(i / 10 == 0) System.out.print(i+"  ");
            else System.out.print(i + " ");
        }
    }
    public static void Sravnenie(int count){
        int a,b;
        a = (int)(Math.round(Math.random()*100));
        b=0;
        for(int i = 1; i < count; i++){
            b = (int)(Math.round(Math.random()*100));
            if(a > b) System.out.println(i+" Число "+a+" больше числа "+b);
            else if(a < b) System.out.println(i+" Число "+a+" меньше числа "+b);
            else System.out.println(i+" Число "+a+" равно числу "+b);
            a = b;
        }
    }
    public static void InfinitiCircle(){
        int a,b;
        a = (int)(Math.round(Math.random()*100));
        b=0;
        int i = 0;
        while (i != 100){
            b = (int)(Math.round(Math.random()*100));
            if(a > b) System.out.println(i+" Число "+a+" больше числа "+b);
            else if(a < b) System.out.println(i+" Число "+a+" меньше числа "+b);
            else System.out.println(i+" Число "+a+" равно числу "+b);
            a = b;
            i++;
        }
    }
    public static void foreach(){
        Random rand = new Random();
        double f[] = new double[10];
        for(int i = 0; i < 10; i++){
            f[i] = rand.nextDouble();
        }
        for(double d:f)
            System.out.println(d);
    }
    public static void toCharArray(String str){
        for(char c:str.toCharArray())
            System.out.print(c + " ");
    }
    public static int test(int testval, int begin, int end){
        if(testval >= begin && testval <= end)
            return 1;
        else if(testval < begin)
            return -1;
        else return 0;
    }
    public static void foreach_2(){
        for(int i : Range.range(10))
            System.out.print(i+" ");
        System.out.println();
        for(int i: Range.range(5,10))
            System.out.print(i+" ");
        System.out.println();
        for(int i:Range.range(5,20,3))
            System.out.print(i+" ");
        System.out.println();
    }
    public static void test_ob(){
        Integer int1 = 5;
        Integer int2 = Integer.valueOf("5");
        Double dob1 = Double.valueOf("5");
        int i1 = int1.intValue();
        int i2 = int1;
        String str1 = "999";
        String str2 = "000555";
        String str3 = "000.555";
        Short s1 = Short.valueOf(str1);
        int ii1 = Integer.valueOf(str2);
        int ii2 = Integer.parseInt(str2);
        double d1 = Double.valueOf(str3);
        double d2 = Double.parseDouble(str3);
        String str4 = Integer.toString(123456789);
        Integer intObj1 = 987654321;
        String str5 = intObj1.toString();

        System.out.println(s1+" "+ii1+" "+ii2+" "+d1+" "+d2);
        System.out.println(str4+" "+str5);

        System.out.println(int1);
        System.out.println(int2);
        System.out.println(dob1);
        System.out.println(i1);
        System.out.println(i2);
    }
    public static double fractional(double num){
        double res = (Math.round((num % 1)*100))/100.0;
        return res;
    }
}
