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
            FileWriter logFile = new FileWriter(logName, true);
            try {
                FileReader reader = new FileReader(inFileName);
                FileWriter writer = new FileWriter(outFileName);

                try {
                    BufferedReader br = new BufferedReader(reader);
                    int simbol = br.read();
                    while (simbol != -1) {
                        try {
                            simbol = code[simbol];
                            writer.write(simbol);
                            simbol = br.read();
                        } catch (Exception ex) {
                            String str = ex.getMessage();
                            logFile.write(str);
                        } finally {
                            reader.close();
                            writer.close();
                            logFile.close();
                        }
                    }
                } catch (FileNotFoundException e) {
                    String str2 = e.getMessage();
                    logFile.write(str2);
                } catch (IOException e2) {
                    String str2 = e2.getMessage();
                    logFile.write(str2);
                }
            } catch (FileNotFoundException e) {
                String str2 = e.getMessage();
                logFile.write(str2);
            } catch (IOException e) {
                String str2 = e.getMessage();
                logFile.write(str2);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}