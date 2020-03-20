package ru.progwards.java1.lessons.bitsworld;
class Programm1{
    public static void main(String[] args) {
        Binary b = new Binary((byte) 0);
        System.out.println(b);
    }
}

public class Binary {
    private byte num;
    public Binary(byte num){
        this.num = num;
    }

    @Override
    public String toString() {
        if (num < 0) {
            String s1 = Integer.toBinaryString(num);
            String subS = s1.substring(24);
            return subS;
        }
        else if (num >= 0) {
            String s = Integer.toBinaryString(num);
            if (s.length() < 8) {
                String tayl = "";
                for (int i = 0; i < (8 - s.length()); i++) {
                    tayl += "0";
                }
                s = tayl + s;
            }
            return s;
        }
        return "";
    }
}
