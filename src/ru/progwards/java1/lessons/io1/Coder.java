package ru.progwards.java1.lessons.io1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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


           /* Coder.codeFile("file_out.log",
                    "file_in2.txt",
                    m,"log.txt");*/

    }
}

public class Coder {
    public static void codeFile (String inFileName,
                                String outFileName,
                                char[] code,
                                String logName) throws IOException{
        try {
            FileWriter logFile = new FileWriter(logName, true);
            try {
                FileReader reader = new FileReader(inFileName);
                FileWriter writer = new FileWriter(outFileName, true);

                try {
                    int simbol = reader.read();
                    while (simbol != -1) {
                        writer.write(code[simbol]);
                        simbol = reader.read();
                    }
                } catch (RuntimeException e) {
                    String str = e.getMessage();
                    logFile.write(str);
                } finally {
                    reader.close();
                    writer.close();
                    logFile.close();
                }
            } catch (FileNotFoundException e) {
                String str = e.getMessage();
                logFile.write(str);
            }
        }catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}