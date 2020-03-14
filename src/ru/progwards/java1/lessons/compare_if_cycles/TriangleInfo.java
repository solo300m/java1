package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleInfo {
    public static void main(String[] args) {
        System.out.println(isTriangle(3,5,8));
        System.out.println(isRightTriangle(5,5,6));
        System.out.println(isIsoscelesTriangle(4,4,5));
    }

    public static boolean isTriangle(int a, int b, int c){
        if(a < (b+c) && (b < (a+c) && c < (a+b))) return true;
        else return false;
    }
    public static boolean isRightTriangle(int a, int b, int c){
        double gip = 0;
        double kat1 = 0;
        double kat2 = 0;
        if(a>b && a>c){
            gip = a;
            kat1 = b;
            kat2 = c;
            if((a*a) == (b*b+c*c)) return true;
            else return false;
        }
        else if(b>a && b>c){
            gip = b;
            kat1 = a;
            kat2 = c;
            if((b*b) == (a*a+c*c)) return true;
            else return false;
        }
        else if(c>a && c>b){
            gip = c;
            kat1 = a;
            kat2 = b;
            if((c*c) == (a*a+b*b)) return true;
            else return false;
        }
        else return false;
    }
    public static boolean isIsoscelesTriangle(int a, int b, int c){
        if(a == b && b == c) return true;
        else if(a == b && b != c) return true;
        else if(a == c && c != b) return true;
        else if(c == b && b != a) return true;
        else return false;
    }
}
