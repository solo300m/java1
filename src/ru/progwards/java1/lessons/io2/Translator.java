package ru.progwards.java1.lessons.io2;

class Programs{
    public static void main(String[] args) {
        String[] rus = {"привет", "мир", "меня зовут","сергей"};
        String[] engl = {"hello","world","my name is","sergey"};
        Translator tR = new Translator(rus,engl);
        System.out.println(tR.translate("привет мир"));
    }
}


public class Translator {
    private String[] inLang;
    private String[] outLang;
    public Translator(String[] inLang, String[] outLang){
        this.inLang = inLang;
        this.outLang = outLang;
    }
    public String translate(String sentence){
        String rez = "";
        StringBuilder sB = new StringBuilder();
        String[] sent = sentence.split(" ");
        for(int j = 0; j<sent.length; j++){
            for(int i = 0; i < inLang.length; i++){
                char[] up = sent[j].toCharArray();
                if(sent[j].toLowerCase().equals(inLang[i])){
                    String outStr = "";
                    if(Character.isUpperCase(up[0])){
                        char[] chOut = outLang[i].toCharArray();
                        chOut[0] = Character.toUpperCase(chOut[0]);
                        outStr = String.valueOf(chOut);
                        sB.append(outStr + " ");
                    }
                    else {
                        sB.append(outLang[i] + " ");
                    }
                }
            }
        }
        rez = sB.toString().trim();
        return rez;
    }
}
