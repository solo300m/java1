package ru.progwards.java1.lessons.maps;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

class P{
    public static void main(String[] args) {

        FiboMapCache.test();
    }
}
public class FiboMapCache {
    private Map<Integer, BigDecimal> fiboCache = new HashMap<>();
    private boolean cacheOn;
    public FiboMapCache(boolean cacheOn){
        this.cacheOn = cacheOn;
    }
    public BigDecimal fiboNumber(int n){
        BigDecimal tmp = new BigDecimal(1);
        BigDecimal tmp2 = new BigDecimal(1);
        if(fiboCache == null)
            fiboCache = new HashMap<>();
        if(cacheOn == true) {
            if (fiboCache.containsKey(n))
                return fiboCache.get(n);
            else if (n >= 3 && fiboCache.containsKey(n)) {
                tmp = fiboCache.get(n);
                return tmp;
            } else if (n < 3) {
                return tmp;
            } else if (n >= 3 && !fiboCache.containsKey(n)) {
                BigDecimal start = new BigDecimal(1);
                BigDecimal end = new BigDecimal(1);
                BigDecimal fibo = new BigDecimal(0);
                for (int i = 3; i <= n; i++) {
                    fibo = start.add(end);
                    start = end;
                    end = fibo;
                }
                tmp = fibo;
                fiboCache.put(n, tmp);
                return tmp;
            }
        }
        else{
            if (n < 3) {
                return tmp;
            }
            else {
                BigDecimal start = new BigDecimal(1);
                BigDecimal end = new BigDecimal(1);
                BigDecimal fibo = new BigDecimal(0);
                for (int i = 3; i <= n; i++) {
                    fibo = start.add(end);
                    start = end;
                    end = fibo;
                }
                tmp = fibo;
                return tmp;
            }
        }
        return tmp;
    }
    public void clearCahe(){
        fiboCache = null;
    }
    public static void test(){
        FiboMapCache a = new FiboMapCache(true);
        FiboMapCache b = new FiboMapCache(false);


        long start = System.currentTimeMillis();
        for(int i = 1; i <=1000; i++){

            a.fiboNumber(i);

        }
        System.out.println("fiboNumber cacheOn= "+a.cacheOn+" время выполнения "
                +(System.currentTimeMillis() - start));

        long start2 = System.currentTimeMillis();
        for(int i = 1; i <=1000; i++){

            b.fiboNumber(i);

        }
        System.out.println("fiboNumber cacheOn= "+b.cacheOn+" время выполнения "
                +(System.currentTimeMillis() - start2));
    }

    public Map<Integer, BigDecimal> getFiboCache() {
        return fiboCache;
    }
   /* public BigDecimal fiboNumber(int n){
        BigDecimal tmp = new BigDecimal(1);
        BigDecimal tmp2 = new BigDecimal(1);
        if(fiboCache == null)
            fiboCache = new HashMap<>();
        if(cacheOn == true) {
            if (fiboCache.containsKey(n))
                return fiboCache.get(n);
            else if (n >= 3 && fiboCache.containsKey(n - 1) && fiboCache.containsKey(n - 2)) {
                tmp = fiboCache.get(n - 2);
                tmp2 = fiboCache.get(n - 1);
                tmp = tmp.add(tmp2);
                fiboCache.put(n, tmp);
                return tmp;
            } else if (n < 3) {
                return tmp;
            } else if (n >= 3 && (!fiboCache.containsKey(n - 1) || !fiboCache.containsKey(n - 2))) {
                BigDecimal start = new BigDecimal(1);
                BigDecimal end = new BigDecimal(1);
                BigDecimal fibo = new BigDecimal(0);
                for (int i = 3; i <= n; i++) {
                    fibo = start.add(end);
                    start = end;
                    end = fibo;
                }
                tmp = fibo;
                fiboCache.put(n, tmp);
                return tmp;
            }
        }
        else{
            if (n < 3) {

                return tmp;
            }
            else {
                BigDecimal start = new BigDecimal(1);
                BigDecimal end = new BigDecimal(1);
                BigDecimal fibo = new BigDecimal(0);
                for (int i = 3; i <= n; i++) {
                    fibo = start.add(end);
                    start = end;
                    end = fibo;
                }
                tmp = fibo;
                return tmp;
            }
        }
        return tmp;
    }*/
}
