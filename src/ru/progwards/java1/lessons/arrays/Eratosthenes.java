package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;
class Progr{
    public static void main(String[] args) {
        Eratosthenes d = new Eratosthenes(45);
        for(int i = 0; i<=45;i++){
            if(d.isSimple(i))
                System.out.print(i+" ");
        }
        System.out.println();
    }
}
public class Eratosthenes {
    private boolean[] sieve;
    public Eratosthenes(int N){
        sieve = new boolean[N+1];
        Arrays.fill(sieve,true);
        sift();
    }
    // да я действительно изначально не понял суть алгоритма Эратосфена
    // пришлось покопать теоретическую базу:)
    // спасибо, что заметили ошибку
    private void sift(){
        for(int i = 2; i < sieve.length; i++){
            if(sieve[i]){
                for(int j = 2; i*j < sieve.length; j++)
                    sieve[i*j] = false;
            }
        }
    }
    public boolean isSimple(int n){
        return sieve[n];
    }
}