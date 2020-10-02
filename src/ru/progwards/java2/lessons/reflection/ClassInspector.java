package ru.progwards.java2.lessons.reflection;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Path;

public class ClassInspector {
    String clazz;
    ClassInspector(String clazz){
        this.clazz = clazz;
    }

    public static void check(String clazz) throws ClassNotFoundException, IOException {
        Class claz = Class.forName(clazz);
        StringBuffer buff = new StringBuffer();
        String fileName = claz.getSimpleName()+".java";
        Path path = Path.of(fileName);
        File file = new File(String.valueOf(path));
        if(!file.exists())
            file.createNewFile();
        //Files.createFile(path);

        buff.append("class "+claz.getSimpleName()+" {\n");//Название класса____
        //___________Свойства_______________
        Field[] fl = claz.getDeclaredFields();
        String[][]tmpArr = new String[fl.length][3];
        for(int i = 0; i < tmpArr.length; i++){
            tmpArr[i][0] = String.valueOf(Modifier.toString(fl[i].getModifiers()));
            tmpArr[i][1] = String.valueOf(fl[i].getAnnotatedType());
            String[] typeS = tmpArr[i][1].split("\\.");
            if(typeS.length>1)
                tmpArr[i][1] = typeS[typeS.length-1];
            tmpArr[i][2] = String.valueOf(fl[i].getName());
            String b = "    "+tmpArr[i][0]+" "+tmpArr[i][1]+" "+tmpArr[i][2]+";\n";
            buff.append(b);
        }
        //___________Конструкторы______________

        Constructor[] constructors = claz.getDeclaredConstructors();
        String[][] constr = new String[constructors.length][3];
        for(int i = 0; i < constr.length; i++) {
            String[] tmp = String.valueOf(constructors[i].toString()).split(" ");

            if(tmp.length > 1 & !tmp[0].equals(" ")) {
                constr[i][0] = tmp[0];

                constr[i][2] = tmp[1].substring(tmp[1].indexOf("("));
                String[] param = constr[i][2].split(",");
                constr[i][2] = "(";
                for(int j = 0; j < param.length; j++){
                    if(param[j].contains(")"))
                        param[j] = param[j].replace(")","");
                    if(param[j].contains("("))
                        param[j] = param[j].replace("(","");
                    if(param[j].contains(".")){
                        String[]lexem = param[j].split("\\.");
                        constr[i][2] += lexem[lexem.length-1]+" arg"+j;
                        if(j != param.length-1)
                            constr[i][2] += ", ";
                        else
                            constr[i][2] += ")";
                    }
                    else if(param[j].equals("()")){
                        constr[i][2] += ")";
                        continue;
                    }
                    else {
                        if(!param[j].equals(""))
                            constr[i][2] += param[j]+" arg"+j;
                        if(j != param.length-1)
                            constr[i][2] += ", ";
                        else
                            constr[i][2] += ")";
                    }
                }

                tmp[1] = tmp[1].substring(0,tmp[1].indexOf("("));
                String[] s = tmp[1].split("\\.");
                constr[i][1] = s[s.length-1];
                String c = "    "+constr[i][0]+" "+constr[i][1]+constr[i][2]+" {}\n";
                buff.append(c);
            }
            else {
                constr[i][0] = " ";

                constr[i][2] = tmp[0].substring(tmp[0].indexOf("("));
                String[] param = constr[i][2].split(",");
                constr[i][2] = "";
                for(int j = 0; j < param.length; j++){
                    if(param[j].contains(")"))
                        param[j] = param[j].replace(")","");
                    if(param[j].contains("("))
                        param[j] = param[j].replace("(","");
                    if(param[j].contains(".")){
                        String[]lexem = param[j].split("\\.");
                        constr[i][2] = lexem[lexem.length-1]+" arg"+j;
                        if(j != param.length-1)
                            constr[i][2] += ", ";
                        else
                            constr[i][2] += ")";
                    }
                    else if(param[j].equals("()")){
                        constr[i][2] += ")";
                        continue;
                    }
                    else {
                        if(!param[j].equals(""))
                            constr[i][2] = param[j]+" arg"+j;
                        if(j != param.length-1)
                            constr[i][2] += ", ";
                        else
                            constr[i][2] += ")";
                    }
                }
                tmp[0] = tmp[0].substring(0, tmp[0].indexOf("("));
                String[] s = tmp[0].split("\\.");
                constr[i][1] = s[s.length - 1];
                String c = "    "+constr[i][0]+" "+constr[i][1]+constr[i][2]+" {}\n";
                buff.append(c);
            }

        }

        //___________Методы____________________

        Method[] methods = claz.getDeclaredMethods();
        String[][]method = new String[methods.length][3];
        for(int i = 0; i < methods.length; i++){
            String[]tmp = methods[i].toString().split(" ");
            method[i][0] = tmp[0];
            if(tmp[1].contains(".")){
                String[] strType = tmp[1].split("\\.");
                method[i][1] = strType[strType.length-1];
            }
            else
                method[i][1] = tmp[1];

            String setMetthod = tmp[2].substring(tmp[2].lastIndexOf(".", tmp[2].indexOf("(")))/* + tmp[2].substring(tmp[2].indexOf("("),tmp[2].lastIndexOf(")")+1)*/;
            setMetthod = setMetthod.replaceFirst(".", "");

            if(setMetthod.contains(",") & setMetthod.contains(".")) {
                String[]zapyataya = setMetthod.split(",");
                for(int j=0; j<zapyataya.length; j++){
                    if(j!=zapyataya.length-1)
                        zapyataya[j]+=" arg"+j;
                    else {
                        zapyataya[j] = zapyataya[j].replace(")", "");
                        zapyataya[j] += " arg"+j+")";
                    }

                }
                setMetthod = "";
                for(int j = 0; j < zapyataya.length; j++){
                    if(zapyataya[j].contains(".") && !zapyataya[j].contains("(") && !zapyataya[j].contains(")")){
                        String[] parsEnd = zapyataya[j].split("\\.");
                        zapyataya[j] = parsEnd[parsEnd.length-1];
                    }else if(zapyataya[j].contains("(") & zapyataya[j].contains(".")){
                        String[] parsEnd = zapyataya[j].split("\\.");
                        zapyataya[j] = parsEnd[0].substring(0,parsEnd[0].indexOf("(")+1) + parsEnd[parsEnd.length-1];
                    }else if(zapyataya[j].contains(".") & zapyataya[j].contains(")")){
                        String[] parsEnd = zapyataya[j].split("\\.");
                        zapyataya[j] = parsEnd[parsEnd.length-1];
                    }
                    if(j<zapyataya.length-1)
                        setMetthod += zapyataya[j]+",";
                    else
                        setMetthod += zapyataya[j];
                }

                method[i][2] = setMetthod;
            }
            else if(setMetthod.contains(",")){
                String[]zapyataya = setMetthod.split(",");
                setMetthod = "";
                for(int j=0; j<zapyataya.length; j++){
                    if(j!=zapyataya.length-1)
                        zapyataya[j]+=" arg"+j+",";
                    else {
                        zapyataya[j] = zapyataya[j].replace(")", "");
                        zapyataya[j] += " arg"+j+")";
                    }
                    setMetthod += zapyataya[j];
                }
                method[i][2] = setMetthod;
            }
            else {
                if((setMetthod.indexOf(")") - setMetthod.indexOf("(")) > 1){
                    method[i][2] = setMetthod.substring(0,setMetthod.indexOf("(")+1)+setMetthod.substring(setMetthod.indexOf("(")+1,setMetthod.indexOf(")"))+" arg"+i+")";
                }
                else
                    method[i][2] = setMetthod;
            }

            //System.out.println(method[i][2]);
            buff.append("    "+method[i][0]+" "+method[i][1]+" "+method[i][2]+" {}\n");

        }

        buff.append("}");
        /*String tmp = buff.toString();
        System.out.println(tmp);*/
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(buff.toString());
        bw.close();
    }
}
class Main{
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        ClassInspector.check("ru.progwards.java2.lessons.reflection.TestReflection");
    }
}