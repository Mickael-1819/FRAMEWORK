/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import etu1819.framework.Mapping;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author gaiden
 */

public class Utilitaire {
    public static String getURLWithContextPath(HttpServletRequest request) {
   return request.getPathInfo();
}


    public static void initHashMap(File f, HashMap<String, Mapping> mappingUrls)throws Exception{
        ArrayList<Class> tab;
        tab = Utilitaire.getALlAnnotedClasse(f);
        for (Class classhuu : tab){
            ArrayList<Method> methods;
            methods = Utilitaire.getAllMethodAnnoted(classhuu);
            for (Method method : methods) {
                if (method.getAnnotations()[0] instanceof Test){
                    Mapping m = new Mapping(classhuu.getName(),method.getName());
                    String key;
                    key = ((Test)(method.getAnnotations()[0])).url();
                    mappingUrls.putIfAbsent(key, m);
                }
            }
        }
    }


    public static ArrayList<Class> getALlAnnotedClasse(File f)throws Exception{
        ArrayList<Class> allclass= new ArrayList<>();
        ArrayList<String> allClasseName;
        allClasseName = Utilitaire.getAllCLassName(f,new ArrayList<>(),"");
        for (String s : allClasseName) {
            Class c = Class.forName(s);
                allclass.add(c);
        }
        return allclass;
    }


    public static ArrayList<String>getAllCLassName(File f,ArrayList<String> tab,String pack){
        File[] files = f.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                String nomfile = file.getName().split("\\.")[0];
                tab.add(pack.concat(nomfile));
            } else {
                String dossier = pack + file.getName() + ".";
                getAllCLassName(file, tab, dossier);
            }
        }
        return tab;
    }

    public static ArrayList<Method> getAllMethodAnnoted(Class classe){
        Method[] methods= classe.getDeclaredMethods();
        ArrayList<Method> rep = new ArrayList<>();
        for (Method method : methods){
            if (method.getAnnotations().length>0){
                rep.add(method);
            }
        }
        return rep;
    }

    public static ArrayList<Field> getAllAnnotedAttribut(Class classe){
        Field[] fields = classe.getDeclaredFields();
        ArrayList<Field> rep = new ArrayList<>();
        for (Field field : fields) {
            if (field.getAnnotations().length!=0){
                rep.add(field);
            }
        }
        return rep;
    }


    public static String getURL(HttpServletRequest request){
        String url =request.getRequestURI();
        String[] tab = url.split("/");
        String rep ="";
        for(int i=2;i<tab.length;i++){
            if(i==2){
                if (i== tab.length-1) {
                    rep = "/" + rep.concat(tab[i]);
                }else {
                    rep = "/" + rep.concat(tab[i]).concat("/");
                }
            }
            else{
                if (i== tab.length-1){
                    rep= rep.concat(tab[i]);
                }else {
                    rep=rep.concat(tab[i]).concat("/");
                }

            }
        }
        return rep;
    }

}
