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
            Censor.censorFile("file1.bin", obscene);
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
                //System.out.println(Arrays.toString(strArr));

                char[] simbols = new char[strArr.length*3];
                int startPos = 0;
                int endPos = 2;
                for(int i = 0; i<strArr.length; i++){
                    char[] word = strArr[i].toCharArray();
                    StringBuilder local = new StringBuilder();
                    for(int j = 0; j<word.length; j++) {
                        if(j == 0) {
                            if (Character.isLetter(word[j]) == false) {
                                simbols[startPos] = word[j];
                            } else if (Character.isLetter(word[j]) == true)
                                local.append(word[j]);
                        }
                        if(j != 0 && j != word.length-1)
                            local.append(word[j]);
                        if(j == word.length - 1 && word.length-1 != 0) {
                            if (Character.isLetter(word[word.length - 1]) == false) {
                                simbols[endPos] = word[word.length - 1];
                            } else if (Character.isLetter(word[word.length - 1]) == true) {
                                local.append(word[j]);
                            }
                        }
                    }
                    startPos = (i + 1) * 3;
                    endPos = startPos + 2;
                    strArr[i] = local.toString();
                    //System.out.println(strArr[i]);
                }

                for (int i = 0; i < strArr.length; i++) {
                    for (String s : obscene) {
                        if (strArr[i].equals(s)) {
                            char[] chArr = strArr[i].toCharArray();
                            for (int f = 0; f < chArr.length; f++)
                                chArr[f] = '*';
                            strArr[i] = String.valueOf(chArr);
                        }
                    }

                }
                startPos = 0;
                endPos = 2;
                for (int i = 0; i<strArr.length; i++){
                    if(simbols[startPos] == 0) {
                        sB.append(strArr[i]);
                    }
                    else {
                        sB.append(simbols[startPos]);
                        sB.append(strArr[i]);
                    }
                    if(simbols[endPos] != 0){
                        sB.append(simbols[endPos]);
                        sB.append(" ");
                    }else
                        sB.append(" ");
                    startPos = (i+1)*3;
                    endPos = startPos+2;
                }
                str1 = sB.toString();

            }
            reader.close();
            try(FileWriter writer = new FileWriter(inoutFileName)){
                writer.write(str1.trim());
                writer.close();
            }

        }catch(IOException e) {
            throw new CensorException();
        }catch (NullPointerException ex){
            throw new CensorException();
        }
    }

    public static class CensorException extends IOException {
        private String fileName;
        private String message;
        public CensorException(){}
        public CensorException(String fileName){
            super();
            this.fileName = fileName;
            this.message = super.getMessage();
        }

        @Override
        public String toString(){
            return fileName+":"+ message;
        }
    }
}
