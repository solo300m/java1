package ru.progwards.java1.lessons.sets;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;
class Pro{
    public static void main(String[] args) throws IOException {
        String process;
        process = LettersInFile.process("file_out.log");
        System.out.println(process);
    }
}

public class LettersInFile  {
    public static String process(String fileName) throws IOException {
        String rez = "";
        TreeSet<Character> temp = new TreeSet<>();
        try(FileReader reader = new FileReader(fileName)){
            Scanner scann = new Scanner(reader);
            while(scann.hasNext()){
                String str = scann.nextLine();
                char[] charStr = str.toCharArray();
                for(int i = 0; i < charStr.length; i++){
                    temp.add(charStr[i]);
                }
            }
        }
        for(Character s:temp)
            if(Character.isLetter(s))
                rez += s;
        return rez;
    }

}
