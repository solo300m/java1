package Sergey.Ekkel;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileClass {
    final static String HOME_DIR = "C:\\Users\\Сергей\\IdeaProjects\\Ekkel_Home_1";

    public static void main(String[] args) throws IOException {
        /*File f = new File("Java.iml");//C:\Users\Сергей\IdeaProjects\Ekkel_Home_1\Java.iml
        System.out.println(f.getAbsolutePath());
        boolean d = f.createNewFile();*/
        /*System.out.println(f.getParent());
        System.out.println(f.getPath());
        System.out.println(f.getName());*/
        //Path p = Paths.get("C:\\Users\\Сергей\\IdeaProjects\\Ekkel_Home_1\\Java.iml");
        /*System.out.println(p.getParent());
        System.out.println(p.getRoot());
        System.out.println(p.getName(1));
        System.out.println(p.toUri());
        System.out.println(p.toFile());
        System.out.println(p.subpath(1,4));
        System.out.println(p.resolve("Сергей/IdeaProjects"));
        System.out.println(p.resolve(".."));
        System.out.println(p.resolve("C:\\Users\\Сергей\\IdeaProjects\\Ekkel_Home_1\\Java.iml"));
        System.out.println(p.resolve(".."));
        System.out.println(p.toAbsolutePath());*/
        /*System.out.println(Files.exists(p));
        System.out.println(Files.notExists(p));
        System.out.println(Files.isReadable(p));
        System.out.println(Files.isWritable(p));
        System.out.println(Files.isDirectory(p));
        System.out.println(Files.isRegularFile(p));
        System.out.println(Files.isHidden(p));
        System.out.println(Files.isExecutable(p));*/
        /*Path dir1 = Paths.get(HOME_DIR);
        String prefix = "progwards_";
        String suffix = ".tmp";
        Path tmpFile = Files.createTempFile(dir1,prefix,suffix);
        Path delFile = Paths.get("C:\\Users\\Сергей\\IdeaProjects\\Ekkel_Home_1\\progwards_15759653590258920237.tmp");
        System.out.println("Создан временный файл "+tmpFile);
        Files.deleteIfExists(delFile);*/

       /* Path newDir = dir1.resolve("tmp_dir");
        System.out.println("Создаем каталог: "+newDir);
        Files.createDirectory(newDir);
        Path newFile = newDir.resolve("tmp_file.txt");
        System.out.println("Создаем файл: "+newFile);
        Files.createFile(newFile);*/

        /*try{
            Path srcFile = dir1.resolve("Java.iml");
            Path dstFile = dir1.resolve("Javacopy.iml");
            Files.copy(srcFile,dstFile, StandardCopyOption.REPLACE_EXISTING);*/
            /*Path srcDir = dir1.resolve(".idea");
            Path dstDir = dir1.resolve("idea_copy");
            Files.copy(srcDir,dstDir, StandardCopyOption.REPLACE_EXISTING);

        } catch (Exception e) {
            e.printStackTrace();
        }*/
        //replaceF("???");
        //probaFile();
        //directoryOnly();
        //filterFname();
        //filterEndName();
        //myFileTree();
        matcherFileTree();
    }
    //17 модуль задача 2
    static boolean replaceF(String name){
        try{
            File f = new File(name);
            if(f.isFile()) {
                Path p = Paths.get(f.getAbsolutePath());
                String fileStr = Files.readString(p);
                String tmp = fileStr.replaceAll("F", "f");
                Path path = Files.writeString(p, tmp);

                if(path!=null)
                    return true;
                else
                    return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    static void probaFile(){
        File f = new File("C:\\Users\\Сергей\\IdeaProjects\\Ekkel_Home_1\\");
        File[] listF = f.listFiles();
        for (File d: listF){
            System.out.println(
                    String.format("%-17s",d.getName())+
                            (d.isHidden()?"скрытый ": "")+
                            (d.isDirectory()? "каталог ":d.length()+" байт")
            );
        }
    }
    static void directoryOnly(){
        File f = new File("C:\\Users\\Сергей\\IdeaProjects\\Ekkel_Home_1\\");
        File[] listF = f.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory();
            }
        });
        for (File d: listF){
            System.out.println(
                    String.format("%-17s",d.getName())+
                            (d.isHidden()?"скрытый ": "")+
                            (d.isDirectory()? "каталог ":d.length()+" байт")
            );
        }
    }
    static void filterFname(){
        File f = new File("C:\\Users\\Сергей\\IdeaProjects\\Ekkel_Home_1\\");
        File[] listF = f.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().toUpperCase().startsWith("FILE");
            }
        });
        for (File d: listF){
            System.out.println(
                    String.format("%-17s",d.getName())+
                            (d.isHidden()?"скрытый ": "")+
                            (d.isDirectory()? "каталог ":d.length()+" байт")
            );
        }
    }
    static void filterEndName(){
        File f = new File("C:\\Users\\Сергей\\IdeaProjects\\Ekkel_Home_1\\");
        File[] listF = f.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().toUpperCase().endsWith(".TXT");
            }
        });
        for (File d: listF){
            System.out.println(
                    String.format("%-17s",d.getName())+
                            (d.isHidden()?"скрытый ": "")+
                            (d.isDirectory()? "каталог ":d.length()+" байт")
            );
        }
    }
    static void myFileTree() throws IOException {
        Files.walkFileTree(Paths.get("C:\\Users\\Сергей\\IdeaProjects\\Ekkel_Home_1\\"),
                new SimpleFileVisitor<Path>(){
                    @Override
                    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
                        System.out.println(path);
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult visitFileFailed(Path file, IOException exc) {
                        return FileVisitResult.CONTINUE;
                    }
                });
    }

    static void matcherFileTree() throws IOException {
        final String pattern = "glob:**/*.{txt,log,iml}";
        final Path dir = Paths.get("C:\\Users\\Сергей\\IdeaProjects\\Ekkel_Home_1\\");
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher(pattern);
        Files.walkFileTree(dir, /*Collections.emptySet(),1,*/ new SimpleFileVisitor<Path>(){
                    @Override//Paths.get("C:\\Users\\Сергей\\IdeaProjects\\Ekkel_Home_1\\)
                    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
                        if(pathMatcher.matches(dir.relativize(path)))//pathMatcher.matches(path)
                            System.out.println(path);
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult visitFileFailed(Path file, IOException exc) {
                        return FileVisitResult.CONTINUE;
                    }
                });
    }
}
