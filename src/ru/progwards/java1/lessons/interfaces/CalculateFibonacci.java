package ru.progwards.java1.lessons.interfaces;

class Programms{
    public static void main(String[] args) {
        System.out.println(CalculateFibonacci.fiboNumber(6));
        System.out.println(CalculateFibonacci.getLastFibo().fibo);
        System.out.println(CalculateFibonacci.fiboNumber(16));
        System.out.println(CalculateFibonacci.getLastFibo().fibo);
        CalculateFibonacci.clearLastFibo();
        System.out.println(CalculateFibonacci.getLastFibo().fibo);
    }
}

public class CalculateFibonacci {

    private static CacheInfo lastFibo;

    public static int fiboNumber(int n){
        if(lastFibo == null) lastFibo = new CalculateFibonacci.CacheInfo();
        else if(lastFibo!=null && lastFibo.n == n) return lastFibo.fibo;
        if (n == 1 || n == 2){
            lastFibo.n = n;
            lastFibo.fibo = 1;
            return 1;
        }
        else {
            int start = 1;
            int prev = 1;
            int fibo = 0;
            for (int i = 3; i <= n; i++) {
                fibo = start + prev;
                prev = start;
                start = fibo;
            }
            lastFibo.n = n;
            lastFibo.fibo = fibo;
            return fibo;
        }
    }

    public static CacheInfo getLastFibo(){
        if(lastFibo == null) return lastFibo = new CalculateFibonacci.CacheInfo();
        else return lastFibo;
    }

    public static void clearLastFibo(){
        lastFibo.n = 0;
        lastFibo.fibo = 0;
    }

    public static class CacheInfo{
        public int n;
        public int fibo;

    }
}
