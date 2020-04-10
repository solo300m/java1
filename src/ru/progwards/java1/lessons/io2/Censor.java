package ru.progwards.java1.lessons.io2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Prog{
    public static void main(String[] args) {
        String[] obscene = {"write", "count", "day", "storey", "two"};
        Censor Cs = new Censor();
        try {
            Censor.censorFile(null, obscene);
        } catch (Censor.CensorException e) {
            System.out.println(e);
        }
    }
}
public class Censor {
    public static void censorFile(String inoutFileName, String[] obscene) throws CensorException {
        try(FileReader reader = new FileReader(inoutFileName)){
            Scanner scann = new Scanner(reader);
            StringBuilder sB = new StringBuilder();
            String str1 = "";
            while (scann.hasNextLine()) {
                String str = scann.nextLine();
                String[] strArr = str.split(" ");

                for (String s : obscene) {
                    //
                    for (int i = 0; i < strArr.length; i++) {
                        //System.out.print(strArr[i]);
                        if (strArr[i].equals(s)) {
                            char[] chArr = strArr[i].toCharArray();
                            for (int f = 0; f < chArr.length; f++)
                                chArr[f] = '*';
                            strArr[i] = String.valueOf(chArr);
                        }
                    }
                }
                for (String s : strArr)
                    sB.append(s + " ");
                str1 = sB.toString();
                //System.out.println(str1);
            }
            reader.close();
            try(FileWriter writer = new FileWriter(inoutFileName)){
                writer.write(str1.trim());
                writer.close();
            }

        }catch(IOException e) {
            throw new CensorException(inoutFileName, "Не найден файл");
        }catch (NullPointerException ex){
            throw new CensorException(inoutFileName, "Не найден файл");
        }
    }

    public static class CensorException extends IOException {
        private String fileName;
        private String message;
        public CensorException(){}
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
