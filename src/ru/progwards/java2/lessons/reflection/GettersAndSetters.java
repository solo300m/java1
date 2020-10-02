package ru.progwards.java2.lessons.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class GettersAndSetters {

    public static void check(String clazz) throws ClassNotFoundException{
        Class claz = Class.forName(clazz);
        Field[] fields = claz.getDeclaredFields();
        Method[] methods = claz.getDeclaredMethods();
        for(Field f:fields) {
            String[]fildTmp = f.toString().split(" ");
            String typeP = " ";
            String returnP = "";
            String nameS = "";

            if(fildTmp.length == 3) {
                typeP = fildTmp[0];
                if(fildTmp[1].contains(".")){
                    String[] tmp = fildTmp[1].split("\\.");
                    returnP = tmp[tmp.length-1];
                }
                else
                    returnP = fildTmp[1];

                String[]pars = fildTmp[2].split("\\.");
                nameS = pars[pars.length-1];

            }else if(fildTmp.length == 2){
                if(fildTmp[0].contains(".")){
                    String[] tmp = fildTmp[0].split("\\.");
                    returnP = tmp[tmp.length-1];
                }
                else
                    returnP = fildTmp[0];
                String[]pars = fildTmp[1].split("\\.");
                nameS = pars[pars.length-1];
            }
            //_________Пoиск getters_____________
            boolean getters = false;
            for(int i = 0; i < methods.length; i++){
                if(methods[i].toString().contains("void") && methods[i].toString().toLowerCase().contains(nameS)){
                    getters = true;
                    break;
                }
            }
            //________Поиск setters__________
            boolean setters = false;
            for(int i = 0; i < methods.length; i++){
                if(methods[i].toString().contains(returnP) && methods[i].toString().toLowerCase().contains(nameS) &&
                        methods[i].toString().contains(returnP)){
                    setters = true;
                    break;
                }
            }
            if(getters == false){
                if(typeP.equals(" "))
                    typeP = "public";
                String upFirst = nameS.substring(0,1).toUpperCase()+nameS.substring(1);
                System.out.println(typeP+" "+returnP+" get"+upFirst+"() {}");
            }
            if(setters == false){
                if(typeP.equals(" "))
                    typeP = "public";
                String upFirst = nameS.substring(0,1).toUpperCase()+nameS.substring(1);
                System.out.println(typeP+" void set"+upFirst+"("+returnP+" "+nameS+") {}");
            }
        }
    }

}

class Main2{
    public static void main(String[] args) throws ClassNotFoundException {
        GettersAndSetters.check("ru.progwards.java2.lessons.reflection.TestReflection");
    }
}