package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
class Pr{
    public static void main(String[] args) {
        try {
            CharFilter.filterFile("file_out.log",
                    "file_in2.txt",
                    " _");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
public class CharFilter {
    public static void filterFile(String inFileName,
                                  String outFileName,
                                  String filter) throws IOException {
        String inStr = "";
        String outStr = "";
        FileReader reader = new FileReader(inFileName);
        FileWriter writer = new FileWriter(outFileName);
        Scanner scann = new Scanner(reader);
        while(scann.hasNextLine()){
            String temp = scann.nextLine()+"\n";
            inStr += temp;
        }
        System.out.println(inStr);
        char[] arr = filter.toCharArray();
        for(int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
            if(arr[i]==' ') {
                inStr = inStr.replaceAll(" ", "");
                continue;
            }
            if(arr[i]=='.') {
                inStr = inStr.replaceAll(".", "");
                continue;
            }
            inStr = inStr.replaceAll(String.valueOf(arr[i]), "");
        }
        outStr = inStr;
        writer.write(outStr);
        System.out.println(outStr);
        reader.close();
        writer.close();
    }
}
