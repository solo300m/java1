package Sergey.Ekkel;

import java.io.IOException;
import java.io.RandomAccessFile;
class Prog{
    public static void main(String[] args) {
        System.out.println(StringBuilderFunctions.setStars("???????"));
    }
}
public class StringBuilderFunctions {
    public static String setStars(String filename){
        String rez = "";
        try (RandomAccessFile sBf = new RandomAccessFile(filename, "rw")) {
            StringBuilder str = new StringBuilder();
            long pos = 9;
            int l = 1;
            int offset = 0;
            while(pos < sBf.length()){
                sBf.seek(pos);
                byte[] data = new byte[l];
                sBf.read(data, offset, l );
                String text = new String(data, offset, l, "windows-1251");
                sBf.seek(pos);
                sBf.write('*');
                pos += 10;
                str.append(text);
            }
            rez = str.toString();

        } catch (IOException e) {
            e.getClass();
        }
        return rez;
    }


}
