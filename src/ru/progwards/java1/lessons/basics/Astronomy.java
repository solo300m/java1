package ru.progwards.java1.lessons.basics;

public class Astronomy {
    final static double PI = 3.14;
    final static double R_EARTH = 6371.2;
    final static double R_MERCURY = 2439.7;
    final static double R_JUPITER = 71492.0;
    public static void main(String[] args) {
        System.out.printf("Площадь поверхности Земли равна = %f кв.км.\n",earthSquare());
        System.out.printf("Площадь поверхности Меркурия равна = %f кв.км.\n",mercurySquare());
        System.out.printf("Площадь поверхности Юпитера равна = %f кв.км.\n",jupiterSquare());
        System.out.println("Отношение площади Земли к площади Меркурия равно = "+earthVsMercury());
        System.out.println("Отношение площади Земли к площади Юпитера равно = "+earthVsJupiter());
    }
    public static Double sphereSquare(Double r){
        return 4*PI*Math.pow(r,2);
    }
    public static Double earthSquare(){
        return sphereSquare(R_EARTH);
    }
    public static Double mercurySquare(){
        return sphereSquare( R_MERCURY);
    }
    public static Double jupiterSquare(){
        return sphereSquare(R_JUPITER);
    }
    public static Double earthVsMercury(){
        return earthSquare()/mercurySquare();
    }
    public static Double earthVsJupiter(){
        return earthSquare()/jupiterSquare();
    }
}
