package ru.progwards.java1.lessons.maps;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
class myClass{
    public static void main(String[] args)  {
        UsageFrequency a = new UsageFrequency();
        a.processFile("wiki.test.tokens");//"wiki.test.tokens" "file_out.log"
        System.out.println(a.getLetters());
        System.out.println();
        System.out.println(a.getWords());
    }
}


public class UsageFrequency {
    List<String[]> list = new ArrayList<>();
    List<String> list1 = new ArrayList<>();
    public void processFile(String fileName)  {
        try(FileReader reader = new FileReader(fileName)) {
            Scanner scann = new Scanner(reader);
            while(scann.hasNext()){
                list.add(scann.nextLine().split("[\\s.,?\"';:\\-=@><_()/&$%!]"));//
            }
            //List<String>list1 = new ArrayList<>();
            for(String[] s:list){
                for (int i = 0; i < s.length; i++) {
                    if(!s[i].isEmpty()) {
                        list1.add(s[i]);
                    }
                }
            }

            /*for(String s: list1){
                System.out.print(s+" ");
            }
            System.out.println();*/

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Map<Character, Integer> getLetters(){
        HashMap<Character, Integer> mapChar = new HashMap<>();
        for(String s: list1 ){
            char[] arrCh = new char[s.length()];
            arrCh = s.toCharArray();
            for(int j = 0; j < arrCh.length; j++){
                if(/*Character.isLetter(arrCh[j])||*/Character.isLetterOrDigit(arrCh[j]) && mapChar.containsKey(arrCh[j])){
                    Integer count = mapChar.get(arrCh[j]);
                    count++;
                    mapChar.put(arrCh[j],count);
                }
                else if(/*Character.isLetter(arrCh[j])*/Character.isLetterOrDigit(arrCh[j]) && !mapChar.containsKey(arrCh[j])){
                    mapChar.put(arrCh[j],1);
                }
            }
        }
        return mapChar;
    }
    public Map<String, Integer> getWords(){
        Map<String, Integer> mapString = new HashMap<>();
        for(String s: list1 ) {
            String tmp = s.toString();
            if (tmp!=" " && mapString.containsKey(tmp)) {
                Integer count = mapString.get(tmp);
                count++;
                mapString.put(tmp, count);
            } else if(tmp!=" " && !mapString.containsKey(tmp)){
                mapString.put(tmp, 1);
            }
        }
        return mapString;
    }
}
