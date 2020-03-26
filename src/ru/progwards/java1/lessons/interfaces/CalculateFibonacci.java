package ru.progwards.java1.lessons.interfaces;

class Programms{
    public static void main(String[] args) {
        System.out.println(CalculateFibonacci.fiboNumber(6));
        System.out.println(CalculateFibonacci.getLastFibo().fibo);
        System.out.println(CalculateFibonacci.fiboNumber(16));
        System.out.println(CalculateFibonacci.getLastFibo().fibo);
        CalculateFibonacci.clearLastFibo();
        System.out.println(CalculateFibonacci.getLastFibo());
    }
}

public class CalculateFibonacci {

    private static CacheInfo lastFibo = null;

    public static int fiboNumber(int n){
        if(lastFibo == null) lastFibo = new CalculateFibonacci.CacheInfo();
        else if(lastFibo!=null && lastFibo.n == n) return lastFibo.fibo;
        //lastFibo = new CalculateFibonacci.CacheInfo();
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
        //if(lastFibo == null) return null;
        /*else*/ return lastFibo;
    }

    public static void clearLastFibo(){
        lastFibo = null;
    }

    public static class CacheInfo{
        public int n;
        public int fibo;
        public CacheInfo(){
            this.n = 0;
            this.fibo = 0;
        }

    }
}
