package ru.progwards.java1.lessons.io1;

import java.io.*;
class pro{
    public static void main(String[] args) {
        Coder a = new Coder();
        char[] m = {'а','A','б','Б','в','В','г','Г','д','Д','е','Е','ё','Ё',
                'ж','Ж','з','З','и','И','к','К','л','Л','м','М','н','Н','о','О','п',
                'П','р','Р','с','С','т','Т','у','У','ф','Ф','х','Х','ц','Ц','ч','Ч',
                'ш','Ш','щ','Щ','ы','Ы','ь','ъ','э','Э','ю','Ю','я','Я','й','Й'};
        for(char s:m){
            System.out.print(s+" ");
        }
        System.out.println();
        Coder.codeFile("file_out.log",
                "file_in.txt",
                m,"log.txt");
    }
}

public class Coder {
    public static void codeFile(String inFileName,
                                String outFileName,
                                char[] code,
                                String logName) {

        try {
            FileReader reader = new FileReader(inFileName);
            FileWriter writer = new FileWriter(outFileName);

            try {
                //Scanner scann = new Scanner(reader);
                String strOut = "";
                String strIn = "";
                char ch;

                int rang = 0;
                BufferedReader br = new BufferedReader(reader);
                int simbol = br.read();
                char[]temp = new char[100];
                while (simbol != -1) {
                    ch = (char) simbol;
                    if (rang < temp.length) {
                        temp[rang] = ch;
                        rang++;
                        simbol = br.read();
                    } else {
                        char[]temp2 = new char[temp.length + 100];
                        for(int i = 0; i<temp.length;i++)
                            temp2[i] = temp[i];
                        temp = temp2;
                        temp[rang] = ch;
                        rang++;
                        simbol = br.read();
                    }
                }
                for(char s:temp)
                    System.out.print(s);

                String[]str_temp = new String[rang+1];
                    for (int i = 0; i < str_temp.length; i++) {
                        for(int j = 0; j<code.length; j++){
                            if(code[j] == temp[i]) {
                                temp[i] = '0';
                                str_temp[i] = String.valueOf(j);
                            }
                        }
                        if(temp[i] != '0')
                            str_temp[i] = String.valueOf(temp[i]);
                        strIn += str_temp[i]/*+" "*/;
                    }

                strOut = strIn;
                writer.write(strOut);
            } finally {
                reader.close();
                writer.close();
            }
        } catch (FileNotFoundException e) {
            String msg = e.getMessage();
            try {
                FileWriter logFile = new FileWriter(logName,true);
                try{
                    logFile.write(msg +"\n");
                } finally {
                    logFile.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            String msg = e.getMessage();
            try {
                FileWriter logFile = new FileWriter(logName,true);
                try{
                    logFile.write(msg +"\n");
                } finally {
                    logFile.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /*public char[] getCharArr(String inFileName) {
        //char key = 0b01001011_10001011;
        char key = 8;
        char[] arr = new char[0];
        try {
            FileReader reader = new FileReader(inFileName);
            try {
                Scanner scann = new Scanner(reader);
                int arrLength = 0;
                int arrPosition = 0;
                while (scann.hasNextLine()) {
                    String str = scann.nextLine();
                    char[] temp = str.toCharArray();
                    arrLength = arrLength + temp.length+1;
                    char[] buff = new char[arrLength];
                    if (arr.length != 0) {
                        for (int i = 0; i < arr.length; i++) {
                            buff[arrPosition] = arr[i];
                            arrPosition++;
                        }
                        for (int i = 0; i < temp.length; i++) {
                            char coding = (char) (temp[i]^key);
                            buff[arrPosition] = coding;
                            arrPosition++;
                        }
                        buff[buff.length-1] = (char)('\n'^key);
                        arr = buff;
                        arrPosition = 0;
                    } else {
                        for (int i = 0; i < temp.length; i++) {
                            char coding = (char) (temp[i]^key);
                            buff[arrPosition] = coding;
                            arrPosition++;
                        }
                        buff[buff.length-1] = (char)('\n'^key);
                        arr = buff;
                        arrPosition = 0;
                    }
                }
            } finally {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return arr;
    }*/
}
