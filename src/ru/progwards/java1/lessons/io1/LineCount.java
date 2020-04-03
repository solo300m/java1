package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
class Programm{
    public static void main(String[] args) {
        System.out.println(LineCount.calcEmpty("file_out.log"));
    }
}
public class LineCount {

    public static int calcEmpty(String fileName){
        int count = 0;
        try {
            FileReader reader = new FileReader(fileName);
            try{
                Scanner scann = new Scanner(reader);
                while(scann.hasNextLine()){
                    if(scann.nextLine().isEmpty())
                        count++;
                }
            }finally {
                reader.close();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
}
