package Sergey.Ekkel;

import java.math.BigDecimal;
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
        //System.out.println(fractional(11111.53));
        //System.out.println(addAsStrings(2,1));
        //System.out.println(factorial(5));
        //System.out.println(true&&false||true);
        //array();
       // int [] a = {12,23,34,45};
        //System.out.println(sumArrayItems(a));
        /*int[] a1 = {12, 5, 0, 58, 36};
        int[] a2 = Arrays.copyOf(a1, a1.length);
        Arrays.sort(a2);
        System.out.println(Arrays.equals(a1, a2));*/
        //System.out.println(intToGrade(1));
        /*byte s = 111;
        System.out.println(Integer.toBinaryString(s));
        //s&=1;
        s>>=1;
        System.out.println(Integer.toBinaryString(s));
        s>>=1;
        System.out.println(Integer.toBinaryString(s));*/
        class Rectangle {
            Rectangle(BigDecimal a, BigDecimal b) {
                this.aa = a;
                this.bb = b;
            }
            public BigDecimal aa;
            public BigDecimal bb;
            BigDecimal getAa(){
                return aa;
            }
            BigDecimal getBb(){
                return bb;
            }
        }
        BigDecimal a = new BigDecimal("3");
        BigDecimal b = new BigDecimal("2");
        BigDecimal a1 = new BigDecimal("2");
        BigDecimal b1 = new BigDecimal("3");

        Rectangle p1 = new Rectangle(a, b);
        Rectangle p2 = new Rectangle(a1,b1);
        BigDecimal area1;
        area1 = p1.getAa().multiply(p1.getBb());
        BigDecimal area2;
        area2 = p2.getAa().multiply(p2.getBb());
        int rez = (area1.compareTo(area2));
        System.out.println(area1+" "+area2);
        System.out.println(rez);


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
    public static int addAsStrings(int n1, int n2){
        Integer n11 = n1;
        Integer n21 = n2;
        String str1 = n11.toString();
        String str2 = n21.toString();
        str1 = str1 + str2;
        return Integer.parseInt(str1);
    }
    public static long factorial(long n) {
        if (n == 0L) return 1L;
        else {
            long rez = 1L;
            for (int i = 2; i <= n; i++)
                rez = rez * i;
            return rez;
        }
    }
    public static void array(){
        int[][] a = new int[3][3];
        int item = a[1][2];
        System.out.println(item);
        //int a1[],b[],c[];
        //int aa[][] = {a1,b,c}; нельзя вставлять в двумерный массив неинициализированные одномерные
        int[] b = new int[10];
        int a3[][][];
        a3 = new int[2][2][2];



    }
    public static int sumArrayItems(int[] a){
        int summ = 0;
        for(int i=0; i<a.length;i++)
            summ += a[i];
        return summ;
    }
    enum Grade{VERYBAD,BAD,SATISFACTORILY,GOOD,EXCELLENT,NOTDEFINED}
    static Grade intToGrade(int grade){
        switch(grade){
            case 1:return Grade.VERYBAD;
            case 2:return Grade.BAD;
            case 3:return Grade.SATISFACTORILY;
            case 4:return Grade.GOOD;
            case 5:return Grade.EXCELLENT;
            default: return Grade.NOTDEFINED;
        }
    }


}
