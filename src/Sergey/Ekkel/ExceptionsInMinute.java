package Sergey.Ekkel;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class ExceptionsInMinute {
    public static void main(String[] args) {
        /*Object objectNull = null;
        try{
            objectNull.toString();
        }catch(Exception e){
            System.out.println("Произошло исключение...");
        }
        try {
            System.out.println("В try будет исключение");
            int e = 1 / 2;
            //objectNull.toString();
            //System.out.println((new int [5])[5]);
        }catch(ArithmeticException e) {
            System.out.println("Произошло деление на 0");
        }
        catch(NullPointerException e){
            System.out.println("Обращение к объекту по ссылке null");
        }
        catch(IndexOutOfBoundsException|NegativeArraySizeException e){
            System.out.println("Исключение IndexOutOfBoundsException или NegativeArraySizeException");
            System.out.println(e.getMessage());
            System.out.println(e);
        }
        finally{
            System.out.println("finally выполняется всегда");
        }*/
        Integer a = null;
        Integer b = ExceptionsInMinute.sqr(a);
        System.out.println(b);
        ExceptionsInMinute aa = new ExceptionsInMinute();
        System.out.println(aa.test(null));
        aa.streams();
        try {
            aa.fWriter();
        } catch (IOException e) {
            System.out.println(e);
        }
        aa.fReader();

        /*for(int i = 0; i<10; i++){
            log("Все хорошо, процесс идет по плану");
            log("Потоки символов сейчас зальют экраны...");
            log("И все это запишется в лог - файл.");
            log("это итерация - "+i);
        }*/
        byte[]bArr = {1,1,2,3,5,8,13,21,34,55,89};
        bWriter(bArr);
        bReader("file1.bin");
        /*try {
            outResset();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }*/
        try {
            System.out.println(aa.lineCount("file_out.log"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    static public Integer sqr(Integer n){
        Integer rez = 0;
        try{
            rez = n*n;
        }
        catch(NullPointerException e){
            System.out.println("Введен параметр - null");
            return -1;
        }
        return rez;
    }

    public String test(String filename) {
        Object objectNull = filename;
        try {
            objectNull.toString();
            return "File processing";
        }
        catch (Exception e){
            //System.out.println(e+"Файл не найден");
            return "java.io.IOException File not found";
        }
    }
    public void streams(){
        System.out.println("Что такое System.out?");
        PrintStream pS = System.out;
        pS.println("Это поток для стандартного вывода.");
        System.err.println("Что такое System.out?");
        PrintStream pE = System.err;
        pE.println("Это поток для стандартного вывода.");
    }
    public void fWriter() throws IOException {
        FileWriter fileWriter = new FileWriter("File1.txt");
        fileWriter.write("Это файл создан мной.\n");
        fileWriter.write("Теперь он будет жить на диске\n");
        fileWriter.write("или на флешке\n");
        fileWriter.close();
    }
    public void fReader() {
        try {
            FileReader reader = new FileReader("File1.txt");
            try{
                Scanner scan = new Scanner(reader);
                while(scan.hasNextLine()){
                    String str = scan.nextLine();
                    System.out.println(str);
                }
            } finally {
                reader.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    /*public FileReader fileLine(String filename) throws IOException {
        FileReader reader = new FileReader(filename);
        return reader;
    }

    private int lineCount(String filename) {
        int count = 0;
        FileReader reader = null;
        try {
            reader = fileLine(filename);
            Scanner scanner = new Scanner(reader);

            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                count += 1;
            }
        } catch (IOException e) {
            System.out.println("файл не найден");
        }

        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("файл не найден");
        }

        return count;
    }*/
    private int lineCount(String filename) throws IOException {
        int count = 0;
        try {
            FileReader reader = new FileReader(filename);

            try {
                Scanner scanner = new Scanner(reader);

                while (scanner.hasNextLine()) {
                    String str = scanner.nextLine();
                    count += 1;
                }

            } finally {
                reader.close();
            }
        } catch (IOException e) {
            throw new IOException("файл не найден");

        }
        return count;
    }


    public static boolean log(String msg){
        return log(msg,true);
    }
    public static boolean log(String msg, boolean toConsole){
        if(toConsole)
            System.out.println(msg);
        try{
            FileWriter logFile = new FileWriter("logfile.txt", true);
            try{
                logFile.write(msg + "\n");
            }finally {
                logFile.close();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    public static void bWriter(byte[] byteArr){
        try{
            FileOutputStream bFile = new FileOutputStream("file1.bin");
            try{
                bFile.write(byteArr);
            }finally {
                bFile.close();
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void bReader(String filename){
        try{
            FileInputStream bFile = new FileInputStream(filename);
            try{
                byte[] b = bFile.readAllBytes();
                System.out.println(Arrays.toString(b));
            } finally {
                bFile.close();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void outResset() throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream("file_out.log",true));

        System.setOut(out);

        System.out.println("Теперь вывод перенаправлен");
        System.out.println("в файл file_out.log");
    }

}
