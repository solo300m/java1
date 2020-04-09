package ru.progwards.java1.lessons.io2;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class Prog{
    public static void main(String[] args) {
        String[] obscene = {"Java", "Oracle", "Sun", "Microsystems"};
        try {
            Censor.censorFile("file1.bin", obscene);
        } catch (Censor.CensorException e) {
            System.out.println(e.getMessage());
        }
    }
}
public class Censor {
    public static void censorFile(String inoutFileName, String[] obscene) throws CensorException {
        try(FileReader reader = new FileReader(inoutFileName)){
            Scanner scann = new Scanner(reader);
            StringBuilder sB = new StringBuilder();
            while(scann.hasNextLine()){
                String str = scann.nextLine();
                String[]strArr = str.split("\\s* |\\)");

                for(String s:obscene){
                    System.out.print(s);
                    for(int i=0; i<strArr.length; i++){
                        if(strArr[i].equals(s)){
                            char[] chArr = strArr[i].toCharArray();
                            for(int f = 0;f<chArr.length;f++)
                                chArr[f]='*';
                            strArr[i] = String.valueOf(chArr);
                        }
                    }
                }
                for(String s:strArr)
                    sB.append(s+" ");
                String str1 = sB.toString();
                System.out.println(str1);
            }

        } catch (IOException e) {
            throw new CensorException(inoutFileName,"Не найден файл");
        }

    }
    public static class CensorException extends Exception{
        private String fileName;
        private String message;
        public CensorException(String fileName, String message){
            super(message);
            this.fileName = fileName;
            this.message = message;
        }

        @Override
        public String toString(){
            return "<"+fileName+">:<"+super.getMessage() +">";
        }
    }
}
