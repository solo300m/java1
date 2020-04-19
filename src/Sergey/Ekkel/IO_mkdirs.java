package Sergey.Ekkel;

import java.util.Scanner;

public class IO_mkdirs {
    public static void main(String[] args) {
        /*File f = new File("C:/Academy/Katalog1/Katalog1_1/Katalog1_1_1");
        if(f.mkdirs())
            System.out.println("Цепь каталогов создана");
        else
            System.out.println("Не удалось создать цепь каталогов");*/
        //Scan();
        //scanLines();
        System.out.println(invertWords("Не, удалось, создать. цепь. каталогов."));
    }
    public static void Scan(){
        String str = "Эта строка состоит из 5 слов";

        try(Scanner scann = new Scanner(str)){
            while(scann.hasNext()){
                if(scann.hasNextInt()){
                    int num = scann.nextInt();
                    System.out.println("Число " + num);
                }else {
                    String word = scann.next();
                    System.out.println("Слово " + word);
                }
            }

        }
    }
    public static void scanLines(){
        Scanner scann = new Scanner(System.in);
        String itogStr = "";
        String str = scann.nextLine();
        while(true){
            if(str.contains("/stop"))
                break;
            else if(str.contains("Привет")){
                System.out.println("Здравствуйте!");
            }
            else if(str.contains("как дела")){
                System.out.println("Хорошо");
            }else
                System.out.println(str);
            str = scann.nextLine();
        }
    }
    public static String invertWords(String sentence){
        sentence = sentence.replace(",","");
        sentence = sentence.replace(".","");
        String[] temp = sentence.split(" ");
        StringBuilder sB = new StringBuilder();
        for(int i = temp.length-1; i >= 0; i--){
            if(i != 0){
                sB.append(temp[i]+".");
            }
            else
                sB.append(temp[i]);
        }
        String rez = sB.toString();
        return rez;
    }
}
