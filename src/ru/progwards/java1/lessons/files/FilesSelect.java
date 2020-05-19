package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

class Proverca{
    public static void main(String[] args) {
        String in = "C:\\Users\\Сергей\\IdeaProjects\\Ekkel_Home_1\\tmp_dir11"; //"C:\\Users\\Сергей\\IdeaProjects\\Ekkel_Home_1\\tmp_dir"; C:\Users\51256\IdeaProjects\Ekkel\tmp_dir
        String out = "C:\\Users\\Сергей\\IdeaProjects\\Ekkel_Home_1\\tmp_dir\\tmp_dir2";
        List<String>kes = List.of("111","123","222","333");
        FilesSelect a = new FilesSelect();
        a.selectFiles(in,out,kes);
    }
}
public class FilesSelect {
    public void selectFiles(String inFolder, String outFolder, List<String> keys)  {
        final String pattern = "glob:**/*.txt";
        List<String>fileList = new ArrayList<>();
        Path dirIn = Paths.get(inFolder);
        Path dirOut = Paths.get(outFolder);
        if(!Files.exists(dirOut)){
            try {
                Files.createDirectory(dirOut);
            } catch (IOException e) {
                e.getMessage();
            }
        }
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher(pattern);

        try {
            Files.walkFileTree(dirIn, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
                    if(pathMatcher.matches(path)) {
                        String tmp = path.toString();
                        fileList.add(tmp);
                        //System.out.println(tmp);
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) {

                    return FileVisitResult.CONTINUE ;
                }
            });
        } catch (IOException e) {
            e.getMessage();
        }
        for(String s:fileList){
            Path tmp_path = Paths.get(s);
            String str_tmp = null;
            try {
                str_tmp = Files.readString(tmp_path);
            } catch (IOException e) {
                e.getMessage();
            }
            for(String key: keys){
                if(str_tmp.contains(key)){
                    String out_dir = outFolder+"\\"+key;
                    Path k = Paths.get(out_dir);
                    if(!Files.exists(k)) {
                        try {
                            Files.createDirectory(k);
                        } catch (IOException e) {
                            e.getMessage();
                        }
                    }
                    Path srcFile = tmp_path.resolve(tmp_path);
                    Path dstFile = k.resolve(tmp_path.getFileName().toString());
                    try {
                        Files.copy(srcFile,dstFile,StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        e.getMessage();
                    }
                }
            }
        }
    }
}