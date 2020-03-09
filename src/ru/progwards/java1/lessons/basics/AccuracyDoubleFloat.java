package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {
    final static double R_EARTH_D = 6371.2;
    //final static double R_EARTH_F11 = 6371.2F;
    final static double PI = 3.14;
    public static void main(String[] args) {
        System.out.println("Объем земли равен = "+volumeBallDouble(R_EARTH_D));
        System.out.println("Объем земли равен = "+volumeBallFloat((float) R_EARTH_D));
        System.out.println("Разница между функцией double и float = "+calculateAccuracy(R_EARTH_D));
    }
    public static double volumeBallDouble(double radius){
        return (4.0/3.0)*PI*(Math.pow(radius,3));
    }
    public static float volumeBallFloat(float radius){
        return (4.0f/3.0f)*(float)PI*(float) (Math.pow(radius,3));
    }
    public static double calculateAccuracy(double radius){
        return volumeBallDouble(radius)-volumeBallFloat((float) radius);
    }
}
