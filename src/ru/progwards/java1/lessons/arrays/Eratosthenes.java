package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;
class Programm{
    public static void main(String[] args) {
        Eratosthenes er = new Eratosthenes(20);
        boolean[] s = er.getArr();
        for(int i = 0; i < s.length;i++)
            System.out.print(s[i]+" ");
        System.out.println(" ");
        for(int i = 0; i < s.length; i++){
            if(er.isSimple(i)==true)
                System.out.println("простое число - "+i);
        }
    }
}
public class Eratosthenes {
    private boolean [] sieve;
    public Eratosthenes(int N){
        sieve = new boolean[N];
        Arrays.fill(sieve,true);
        sift();
    }
    public boolean[] getArr(){
        return sieve;
    }
    private void sift() {
        boolean[] s = getArr();
        for(int i = 2; i < s.length; i++){
            for(int j = i+1; j < s.length; j++){
                if(s[j] != false) {
                    if (j % i == 0) {
                        s[j] = false;
                    }
                }
            }
        }
    }
    public boolean isSimple(int n){
        boolean[] s = getArr();
        return s[n];
    }
}
