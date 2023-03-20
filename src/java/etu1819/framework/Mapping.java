package etu1819.framework;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import etu1819.framework.servlet.FrontServlet;

/**
 *
 * @author gaiden
 */

public class Mapping {
 
    
    String className;
    String method;

    
    public Mapping(String className, String method) {
        setClassName(className);
        setMethod(method);
    }

    
    
    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

}


