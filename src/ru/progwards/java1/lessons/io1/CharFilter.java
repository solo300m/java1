package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
class Pr{
    public static void main(String[] args) {
        try {
            CharFilter.filterFile("file_out.log",
                    "file_in2.txt",
                    " _.");
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
        //System.out.println(inStr);
        char[] arr = filter.toCharArray();
        char[] inArr = inStr.toCharArray();
        String countDell = "";
        for(int i = 0; i<arr.length; i++){
           for(int j = 0; j<inArr.length; j++){
               if(inArr[j] == arr[i]){
                   inArr[j]=' ';
                   countDell = countDell + j + ",";
               }
           }
        }
        String[] cDell = countDell.split(",");
        int[]cDin = new int[cDell.length];
        for(int i = 0; i < cDell.length; i++){
            cDin[i] = Integer.parseInt(cDell[i]);
        }
        Arrays.sort(cDin);
        inStr = String.valueOf(inArr);
        int begin = 0;
        int end = 0;
        for(int i = 0; i<cDin.length; i++){
            end = cDin[i];
            outStr += inStr.subSequence(begin,end);
            begin = end+1;
        }
        outStr += inStr.subSequence(begin,inStr.length());

        writer.write(outStr);
        System.out.println(outStr);
        reader.close();
        writer.close();
    }
}
