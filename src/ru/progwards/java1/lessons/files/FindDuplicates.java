package ru.progwards.java1.lessons.files;
//"C:\\Users\\51256\\IdeaProjects\\Ekkel\\tmp_dir";   //"C:\\Users\\Сергей\\IdeaProjects\\Ekkel_Home_1\\tmp_dir"
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Test{
    public static void main(String[] args)  {
        String dir = "C:\\Users\\Сергей\\IdeaProjects\\Ekkel_Home_1\\tmp_dir"; //C:\Users\Сергей\IdeaProjects\Ekkel_Home_1\tmp_dir проблема
        FindDuplicates f = new FindDuplicates();
        List<List<String>> find;
        find = f.findDuplicates(dir);
        for(List<String> s: find){
            System.out.println(s);
        }

    }
}

public class FindDuplicates {
    public static String[] atribName = {"lastModifiedTime",
            /*"lastAccessTime","creationTime",*/"size"/*,"isRegularFile",
            "isDirectory","isSymbolicLink","isOther"*/};

    private List<String> getPathArrey(String startPath){
        Path dir = Paths.get(startPath);
        List<String> allPath = new ArrayList<String>();
        try {
            Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
                    String a = path.toString();
                    allPath.add(a);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) {
                    //System.out.println(file);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.getMessage();
        }
        return allPath;
    }

    public List<List<String>> findDuplicates(String startPath)  {
        //загружаем список путей к файлам в виде строк
        List<String> allPath = getPathArrey(startPath);

        List<List<String>> duplex = new ArrayList<List<String>>();

        for(int i = 0; i < allPath.size(); i++){
            Path masterPath = Paths.get(allPath.get(i));
            fileAtributs atr = new fileAtributs();
            //сформирован объект с именем файла и списком атрибутов
            atr.name = masterPath.getFileName();
            List<String> dupl = new ArrayList<>();
            for(int h = 0; h < atribName.length; h++) {
                try {
                    atr.atrib.add(Files.getAttribute(masterPath, atribName[h]));
                } catch (IOException e) {
                    e.getMessage();
                }
            }
            for(int j = i + 1; j < allPath.size(); j++){
                Path slavePath = Paths.get(allPath.get(j));
                fileAtributs atrSl = new fileAtributs();
                atrSl.name = masterPath.getFileName();
                for(int h = 0; h < atribName.length; h++) {
                    try {
                        atrSl.atrib.add(Files.getAttribute(slavePath, atribName[h]));
                    } catch (IOException e) {
                        e.getMessage();
                    }
                }
                if(atr.equals(atrSl)){
                    if(!dupl.contains(masterPath.toString()))
                        dupl.add(masterPath.toString());
                    if(!dupl.contains(slavePath.toString())) {
                        dupl.add(slavePath.toString());
                        //allPath.remove(j);
                    }
                }
            }
            if(!dupl.isEmpty())
                duplex.add(dupl);
        }
        for(List<String> s: duplex){
            String [] strArr = new String [s.size()];
            for(int i = 0; i < s.size(); i++){
                Path tmp1 = Paths.get(s.get(i));
                try {
                    strArr[i] = Files.readString(tmp1);
                } catch (IOException e) {
                    e.getMessage();
                }
            }

            for(int i = 1; i < strArr.length; i++){
                if(!strArr[0].equals(strArr[i])){
                    //s.remove(i);
                }
            }
            if(s.size()<=1)
                s.remove(0);
        }
        return duplex;
    }
    class fileAtributs {
        public List<Object> atrib = new ArrayList<>();
        public Path name;

        @Override
        public boolean equals(Object o) {
            boolean ravno = false;
            if(Objects.equals(name,((fileAtributs)o).name))
                ravno = true;
            else{
                ravno = false;
                return ravno;
            }
            for(int i = 0; i < atrib.size(); i++){
                if(Objects.equals(atrib.get(i), ((fileAtributs) o).atrib.get(i))){
                    ravno = true;
                }
                else{
                    ravno = false;
                    break;
                }
            }
            return ravno;
        }

        @Override
        public int hashCode() {
            return Objects.hash(atrib, name);
        }

    }

}