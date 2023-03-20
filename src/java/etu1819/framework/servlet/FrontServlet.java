package etu1819.framework.servlet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import etu1819.framework.Mapping;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

import model.Utilitaire;
/**
 *
 * @author gaiden
 */
public class FrontServlet extends HttpServlet {

  HashMap<String, Mapping> MappingUrls =new HashMap<>();

    public void init() throws ServletException {
        super.init();
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            URI uri = loader.getResource("").toURI();
            System.out.println(uri);
            File f = new File(uri);
            System.out.println(f.exists());
            Utilitaire.initHashMap(f, MappingUrls);
        } catch (Exception e) {
            // Handle exception
        }
        System.out.println("Hello World");
    }


  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    public void processRequest(HttpServletRequest request,  HttpServletResponse response)throws IOException{
        PrintWriter out = response.getWriter();
        ClassLoader loader;
      loader = Thread.currentThread().getContextClassLoader();
        String path;
      path = loader.getResource("/").getPath();
        out.println(path);

    }

}


