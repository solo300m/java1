package ru.progwards.java1.lessons.compare_if_cycles;

public class CyclesGoldenFibo {
    public static void main(String[] args) {
        for(int i = 1; i < 16; i++)
            System.out.print(fiboNumber(i)+" ");
        System.out.println();
        for(int i = 1; i < 100; i++){
            for(int j = 1; j<100; j++){
                for(int f = 1; f<100; f++){
                    if(isGoldenTriangle(i,j,f) == true)
                        System.out.println("Золотой треугольник - "+i+" "+j+" "+f);
                }
            }
        }

    }
    public static int fiboNumber(int n){
        if(n == 1 || n == 2) return 1;
        else {
            int start = 1;
            int prev = 1;
            int fibo = 0;
            for (int i = 3; i <= n; i++) {
                fibo = start + prev;
                prev = start;
                start = fibo;
            }
            return fibo;
        }
    }
    public static boolean isGoldenTriangle(int a, int b, int c){
        if(a==b && b!=c) {
            if (((double) a / (double) c) >= 1.61703 && ((double) a / (double) c) <= 1.61903)
                return true;
            else return false;
        }
        else if(a==c && b!=c) {
                if(((double) a / (double) b) >= 1.61703 && ((double) a / (double) b) <= 1.61903)
                    return true;
                else return false;
        }
        else if(b==c && a!=c) {
            if(((double) b / (double) a) >= 1.61703 && ((double) b / (double) a) <= 1.61903)
                return true;
            else return false;
        }
        else return false;
    }

}
