package etu1819.utils;

import java.io.File;
import java.net.URL;
    import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Vector;

import etu1819.annotation.Urls;
import etu1819.framework.Mapping;
import etu1819.framework.ModelView;

    public class Utils {
        static String context = "framework";

        // récupération d'une instance de méthode et son objet appelant
        
        public static ModelView getModelView(Mapping map) throws Exception{
            try{
                Class classe = Class.forName(map.getClassName());
                Method[] methods = classe.getDeclaredMethods();
                Method methode = null;
                for(Method courant: methods){
                    if (courant.getName().equals(map.getMethod())) methode = courant;
                }
                Object instance  = classe.cast(classe.newInstance());        
                String redirUrl = (String)methode.invoke(instance);
                return new ModelView(redirUrl);
            }
            catch(Exception e){
                throw e;
            }

        }

        public static HashMap<String, Mapping> getUrlsAnnotedMethods(Vector<Class<?>> classes){
            java.lang.reflect.Method[] methods;
            String valeurAnnotation,
                    nomClassse,
                    nomMehtode;
            Mapping mapping;
            HashMap<String, Mapping> res = new HashMap<String, Mapping>();
    
            for (Class<?> courante : classes) {
                nomClassse = courante.getName();
                methods = courante.getDeclaredMethods();
                for (java.lang.reflect.Method method : methods) {
                    Urls annotation = method.getAnnotation(Urls.class);
                    if(annotation != null){
                        valeurAnnotation = annotation.url();
                        nomMehtode = method.getName();
                        mapping = new Mapping(nomClassse, nomMehtode);
                        res.put(valeurAnnotation, mapping);
                    } 
                }
            }
            return res;
        }
 // recuperation de toutes les classes a partir d'un dossier de depart
 public static Vector<Class<?>> getClasses(Vector<Class<?>> classes ,  String name ) throws ClassNotFoundException {
    String packageName= name;
    if (classes == null) {
        classes = new Vector<Class<?>>();
    }

    // Get a File object for the package
    File directory = null;
    try {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null) {
            throw new ClassNotFoundException("Can't get class loader.");
        }
        String path = packageName.replace('.', '/');
        System.out.println("RESSOURCE: "+path);
        URL resource = classLoader.getResource(path);
        if (resource == null) {
            throw new ClassNotFoundException("No resource for " + path);
        }
        directory = new File(resource.getFile());
    } catch (NullPointerException x) {
        x.printStackTrace();
        throw new ClassNotFoundException(packageName + " (" + directory + ") does not appear to be a valid package");
    }

    if (directory.exists()) {
        // Get the list of the files contained in the package
        String[] files = directory.list();
        for (int i = 0; i < files.length; i++) {
            // we are only interested in .class files
            File file = new File(directory.getAbsolutePath() + File.separator + files[i]);
            System.out.println( " path : "+file.getAbsolutePath() );
            if (file.isDirectory()) {
                if(packageName.isEmpty()) {
                    //System.out.println("Aucun nom specifie");
                    getClasses(classes, file.getName());
                }
                else getClasses(classes, packageName + "." + file.getName());
            } else {
                if (files[i].endsWith(".class")) {
                    // removes the .class extension
                    System.out.println( "files : "+files[i] );
                    if(packageName.isEmpty()) classes.add(Class.forName(files[i].substring(0, files[i].length() - 6)));

                    else classes.add(Class.forName(packageName + '.' + files[i].substring(0, files[i].length() - 6)));
                }
            }
        }
    } else {
        throw new ClassNotFoundException(packageName + " does not appear to be a valid package");
    }
    return classes;
}


    public static String getPathFromURL(String url, String context) {
        String res;
        String[] spliting = url.split(context + "/"); // le but est de récupérer la partie qui vient après le contexte
        for (Object o: spliting){
            System.out.println("Spliting: "+o.toString());
        }

        if (spliting.length < 2)
            res = ""; // cas où on a uniquement le contexte dans l'URL
        else
            res = spliting[1];
        return res;
    }
}