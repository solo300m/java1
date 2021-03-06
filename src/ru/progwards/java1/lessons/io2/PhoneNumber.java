package ru.progwards.java1.lessons.io2;
class Pr{
    public static void main(String[] args) {
        System.out.println(PhoneNumber.format("7(775)192871311"));
    }
}
public class PhoneNumber {
    public static String format(String phone) throws ArrayIndexOutOfBoundsException{
        String fonNumber = "";
        char[]fonNum = new char[11];
        String temp = "";
        StringBuffer sB = new StringBuffer();

            int i = 0;
            for(char c:phone.toCharArray()){
                if(Character.isDigit(c)) {
                    fonNum[i] = c;
                    i++;
                }
            }
            sB.append('+');
            for(int j = 0; j < fonNum.length; j++) {
                if(fonNum[0] != '7' && j==0) {
                    sB.append('7');
                    sB.append('(');
                }
                else if(fonNum[0] == '7' && j == 0){
                    sB.append(fonNum[0]);
                    sB.append('(');
                }
                else if(j == 4) {
                    sB.append(')');
                    sB.append(fonNum[j]);
                }
                else if(j == 7) {
                    sB.append('-');
                    sB.append(fonNum[j]);
                }
                else
                    sB.append(fonNum[j]);
            }
            fonNumber = sB.toString();

        return fonNumber;
    }
}
