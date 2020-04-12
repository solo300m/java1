package ru.progwards.java1.lessons.io2;

class Programs{
    public static void main(String[] args) {
        String[] rus = {"привет", "мир", "меня зовут","сергей"};
        String[] engl = {"hello","world","my name is","sergey"};
        Translator tR = new Translator(new String[]{"make", "love", "not", "war"},new String[]{"твори", "любовь", "не", "войну"});
        System.out.println(tR.translate("Make Love, not war, i am Sergey."));
    }
}


public class Translator<pivate> {
    private String[] inLang;
    private String[] outLang;
    public Translator(String[] inLang, String[] outLang){
        this.inLang = inLang;
        this.outLang = outLang;
    }
    public String translate(String sentence){
        String rez = "";
        StringBuilder sB = new StringBuilder();
        StringBuilder buffer = new StringBuilder();

        //поиск тире в средине словосочетания
        int[] tire = new int[sentence.length()];
        int x = 0;
        int y = 0;
        while(y < sentence.length()){
            x = sentence.indexOf('-', x);
            sentence = sentence.replace('-',' ');
            tire[y] = x;
            y++;
        }

        String[] strArr = sentence.split(" ");

        //Массив strArr освобожден от тире следующий этап вычистить и запомнить знаки препинания
        //Очистка от знаков препинания и запоминание их позиций в строке
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
        }

        for (int j = 0; j < strArr.length; j++) {
            int noCopyFlag = 0;
            for (int i = 0; i < inLang.length; i++) {
                char[] up = strArr[j].toCharArray();
                if (strArr[j].toLowerCase().equals(inLang[i])) {
                    noCopyFlag = 1;
                    String outStr = "";
                    if (Character.isUpperCase(up[0])) {
                        char[] chOut = outLang[i].toCharArray();
                        chOut[0] = Character.toUpperCase(chOut[0]);
                        outStr = String.valueOf(chOut);
                        sB.append(outStr + " ");
                    } else {
                        sB.append(outLang[i] + " ");
                    }
                }
            }
            if(noCopyFlag == 0)
            sB.append(strArr[j] + " ");
        }
        rez = sB.toString().trim();
        strArr = rez.split(" ");

        // расстановка знаков препинания
        startPos = 0;
        endPos = 2;
        for (int i = 0; i<strArr.length; i++){
            if(simbols[startPos] == 0) {
                buffer.append(strArr[i]);
            }
            else {
                buffer.append(simbols[startPos]);
                buffer.append(strArr[i]);
            }
            if(simbols[endPos] != 0){
                buffer.append(simbols[endPos]);
                buffer.append(" ");
            }else
                buffer.append(" ");
            startPos = (i+1)*3;
            endPos = startPos+2;
        }
        //расстановка тире если есть в исходном тексте
        for(int i = 0; i<tire.length; i++) {
            if(tire[i] != -1 && tire[i] != 0)
                buffer.replace(tire[i], tire[i] + 1, "-");
        }
        rez = buffer.toString();
        rez = rez.trim();
        return rez;
    }

}
